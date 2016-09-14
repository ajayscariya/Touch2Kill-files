package com.wTouch2KiLL.ui.navigationwidget;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.Toolbar;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Patterns;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import android.widget.AutoCompleteTextView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.wTouch2KiLL.C0866R;
import com.wTouch2KiLL.Factory;
import com.wTouch2KiLL.MainNavigationActivity;
import com.wTouch2KiLL.configuration.UrlBarMenuButton;
import com.wTouch2KiLL.storage.DatabaseOpenHelper;
import com.wTouch2KiLL.suggestions.LocalSuggestionItem;
import com.wTouch2KiLL.suggestions.RemoteSuggestionItem;
import com.wTouch2KiLL.suggestions.SuggestionItem;
import com.wTouch2KiLL.suggestions.SuggestionsClient;
import java.util.ArrayList;
import java.util.Collection;
import mf.javax.xml.XMLConstants;
import mf.org.apache.xml.serialize.LineSeparator;

public class TopNavigationWidget extends NavigationWidget {
    protected OnClickListener _refreshOnclickListener;

    /* renamed from: com.wTouch2KiLL.ui.navigationwidget.TopNavigationWidget.10 */
    class AnonymousClass10 implements Runnable {
        final /* synthetic */ Context val$context;
        final /* synthetic */ ArrayList val$localSuggestions;
        final /* synthetic */ ArrayList val$remoteSuggestions;

        /* renamed from: com.wTouch2KiLL.ui.navigationwidget.TopNavigationWidget.10.1 */
        class C09681 implements OnClickListener {
            final /* synthetic */ SuggestionItem val$suggestionItem;

            C09681(SuggestionItem suggestionItem) {
                this.val$suggestionItem = suggestionItem;
            }

            public void onClick(View v) {
                TopNavigationWidget.this.urlTextBox.setText(this.val$suggestionItem.getAutocompleteText());
                TopNavigationWidget.this.hideSuggestionsView();
                TopNavigationWidget.this._forceGoToUrl(TopNavigationWidget.this.urlTextBox);
            }
        }

        /* renamed from: com.wTouch2KiLL.ui.navigationwidget.TopNavigationWidget.10.2 */
        class C09692 implements OnClickListener {
            final /* synthetic */ SuggestionItem val$suggestionItem;

            C09692(SuggestionItem suggestionItem) {
                this.val$suggestionItem = suggestionItem;
            }

            public void onClick(View v) {
                TopNavigationWidget.this.urlTextBox.setText(this.val$suggestionItem.getAutocompleteText());
                TopNavigationWidget.this.urlTextBox.setSelection(TopNavigationWidget.this.urlTextBox.getText().length());
                TopNavigationWidget.this.requestSuggestions();
            }
        }

        AnonymousClass10(ArrayList arrayList, ArrayList arrayList2, Context context) {
            this.val$localSuggestions = arrayList;
            this.val$remoteSuggestions = arrayList2;
            this.val$context = context;
        }

        public void run() {
            TopNavigationWidget.this.suggestionsView.removeAllViews();
            int localSuggIndex = 0;
            int remoteSuggIndex = 0;
            for (int i = 0; i < 6; i++) {
                SuggestionItem suggestionItem = TopNavigationWidget.this._getNextSuggestion(this.val$localSuggestions, localSuggIndex, this.val$remoteSuggestions, remoteSuggIndex, i);
                if (suggestionItem == null) {
                    break;
                }
                ViewGroup suggestionItemView = (ViewGroup) ((LayoutInflater) this.val$context.getSystemService("layout_inflater")).inflate(C0866R.layout.suggestions_item, null);
                TextView textView = (TextView) suggestionItemView.findViewById(C0866R.id.suggestionText);
                ImageView suggestionImage = (ImageView) suggestionItemView.findViewById(C0866R.id.suggestionImage);
                if (suggestionItem instanceof LocalSuggestionItem) {
                    localSuggIndex++;
                    LocalSuggestionItem localSuggestionItem = (LocalSuggestionItem) suggestionItem;
                    String text = localSuggestionItem.getTitle() + LineSeparator.Web + localSuggestionItem.getUrl();
                    SpannableStringBuilder sb = new SpannableStringBuilder(text);
                    sb.setSpan(new ForegroundColorSpan(Color.rgb(0, 0, MotionEventCompat.ACTION_MASK)), localSuggestionItem.getTitle().length(), text.length(), 18);
                    textView.setText(sb);
                } else if (suggestionItem instanceof RemoteSuggestionItem) {
                    remoteSuggIndex++;
                    textView.setText(((RemoteSuggestionItem) suggestionItem).getAutocompleteText());
                } else {
                }
                textView.setOnClickListener(new C09681(suggestionItem));
                suggestionImage.setOnClickListener(new C09692(suggestionItem));
                TopNavigationWidget.this.suggestionsView.addView(suggestionItemView);
            }
            TopNavigationWidget.this.suggestionsViewScroll.setVisibility(0);
            TopNavigationWidget.this.suggestionsView.setVisibility(0);
            TopNavigationWidget.this._suggestionsVisible = true;
        }
    }

    /* renamed from: com.wTouch2KiLL.ui.navigationwidget.TopNavigationWidget.1 */
    class C09701 implements Runnable {
        final /* synthetic */ String val$text;

        C09701(String str) {
            this.val$text = str;
        }

        public void run() {
            TopNavigationWidget.this.suggestionsClient.getSuggestionsAsync(this.val$text);
        }
    }

    /* renamed from: com.wTouch2KiLL.ui.navigationwidget.TopNavigationWidget.2 */
    class C09712 implements Runnable {
        C09712() {
        }

        public void run() {
            if (TopNavigationWidget.this.suggestionsView != null) {
                TopNavigationWidget.this.suggestionsView.setVisibility(8);
                TopNavigationWidget.this.suggestionsView.removeAllViews();
            }
            if (TopNavigationWidget.this.suggestionsViewScroll != null) {
                TopNavigationWidget.this.suggestionsViewScroll.setVisibility(8);
            }
            TopNavigationWidget.this._suggestionsVisible = false;
        }
    }

    /* renamed from: com.wTouch2KiLL.ui.navigationwidget.TopNavigationWidget.3 */
    class C09723 implements OnClickListener {
        C09723() {
        }

        public void onClick(View v) {
            TopNavigationWidget.this.urlTextBox.setText(XMLConstants.NULL_NS_URI);
        }
    }

    /* renamed from: com.wTouch2KiLL.ui.navigationwidget.TopNavigationWidget.4 */
    class C09734 implements OnClickListener {
        C09734() {
        }

        public void onClick(View v) {
            TopNavigationWidget.this.focusChangeListener.onFocusChange(v, true);
        }
    }

    /* renamed from: com.wTouch2KiLL.ui.navigationwidget.TopNavigationWidget.5 */
    class C09745 implements Runnable {
        final /* synthetic */ MainNavigationActivity val$mainActivity;

        C09745(MainNavigationActivity mainNavigationActivity) {
            this.val$mainActivity = mainNavigationActivity;
        }

        public void run() {
            this.val$mainActivity.setSupportActionBar(TopNavigationWidget.this.urlBar);
        }
    }

    /* renamed from: com.wTouch2KiLL.ui.navigationwidget.TopNavigationWidget.6 */
    class C09756 implements AnimationListener {
        final /* synthetic */ boolean val$toShowUrlBar;

        C09756(boolean z) {
            this.val$toShowUrlBar = z;
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            if (this.val$toShowUrlBar) {
                TopNavigationWidget.this.show();
            } else {
                TopNavigationWidget.this.hide();
            }
        }
    }

    /* renamed from: com.wTouch2KiLL.ui.navigationwidget.TopNavigationWidget.7 */
    class C09767 extends Animation {
        final /* synthetic */ boolean val$toShowUrlBar;

        C09767(boolean z) {
            this.val$toShowUrlBar = z;
        }

        protected void applyTransformation(float interpolatedTime, Transformation t) {
            int newMargin;
            if (this.val$toShowUrlBar) {
                newMargin = (int) (((float) TopNavigationWidget.this._defaultTopBrowserMargin) * interpolatedTime);
            } else {
                newMargin = (int) (((float) TopNavigationWidget.this._defaultTopBrowserMargin) - (((float) TopNavigationWidget.this._defaultTopBrowserMargin) * interpolatedTime));
            }
            LayoutParams params = (LayoutParams) TopNavigationWidget.this._browser.getLayoutParams();
            params.setMargins(TopNavigationWidget.this._defaultLeftBrowserMargin, newMargin, TopNavigationWidget.this._defaultRightBrowserMargin, TopNavigationWidget.this._defaultBottomBrowserMargin);
            TopNavigationWidget.this._browser.setLayoutParams(params);
        }
    }

    /* renamed from: com.wTouch2KiLL.ui.navigationwidget.TopNavigationWidget.8 */
    class C09778 extends Animation {
        final /* synthetic */ int val$newMarginDp;
        final /* synthetic */ int val$oldMarginDp;

        C09778(int i, int i2) {
            this.val$oldMarginDp = i;
            this.val$newMarginDp = i2;
        }

        protected void applyTransformation(float interpolatedTime, Transformation t) {
            LayoutParams params = (LayoutParams) TopNavigationWidget.this.searchBackground.getLayoutParams();
            params.setMargins(params.leftMargin, params.topMargin, TopNavigationWidget.this.dpToPx((int) (((float) this.val$oldMarginDp) + (((float) ((this.val$newMarginDp - this.val$oldMarginDp) * (this.val$oldMarginDp < this.val$oldMarginDp ? -1 : 1))) * interpolatedTime))), params.bottomMargin);
            TopNavigationWidget.this.searchBackground.setLayoutParams(params);
        }
    }

    /* renamed from: com.wTouch2KiLL.ui.navigationwidget.TopNavigationWidget.9 */
    class C09789 implements OnClickListener {
        C09789() {
        }

        public void onClick(View v) {
            TopNavigationWidget.this.hideAdditionalMenu();
            Factory.getInstance().getTabsController().getSelectedTab().getWebView().reload();
        }
    }

    public void requestSuggestions() {
        String text = this.urlTextBox.getText().toString();
        this.handler.removeCallbacksAndMessages(null);
        if (text == null || text.length() <= 0 || text.length() >= 30 || Patterns.WEB_URL.matcher(text).matches()) {
            hideSuggestionsView();
        } else {
            this.handler.postDelayed(new C09701(text), 300);
        }
    }

    public void hideSuggestionsView() {
        Factory.getInstance().getMainNavigationActivity().runOnUiThread(new C09712());
    }

    public TopNavigationWidget(ViewGroup parent, String defaultUrl, View browser, Collection<UrlBarMenuButton> urlBarMenuButtons) {
        super(parent, defaultUrl, browser, urlBarMenuButtons);
        this._refreshOnclickListener = new C09789();
        this._parent = parent;
        this._progressBarContainer = (RelativeLayout) parent.findViewById(C0866R.id.progressbarPanel);
        this._defaultUrl = defaultUrl;
        this._browser = browser;
        createWidgetLayout();
        this.suggestionsClient = new SuggestionsClient(Factory.getInstance().getMainNavigationActivity());
        this.suggestionsClient.setListener(this);
        this.refreshImage = C0866R.drawable.ic_refresh_white_24dp;
        this.stopImage = C0866R.drawable.ic_close_white_24dp;
        this.urlBarButton = C0866R.layout.url_bar_top_menu_button;
        this.urlBarCheckBox = C0866R.layout.url_bar_top_menu_checkbox;
        this.urlBarIcon = C0866R.layout.url_bar_top_icon;
        this.suggestionsView = (ViewGroup) this._parent.findViewById(C0866R.id.suggestions);
        this.frameUrlBar = (FrameLayout) this._parent.findViewById(C0866R.id.frameNWtop);
        this.suggestionsViewScroll = (ViewGroup) this._parent.findViewById(C0866R.id.suggestionsScroll);
        this.overlay = (ViewGroup) this._parent.findViewById(C0866R.id.menuOverlay);
        this.overlayScroll = (ViewGroup) this._parent.findViewById(C0866R.id.menuOverlayScroll);
        this.urlTextBox = (AutoCompleteTextView) this._parent.findViewById(C0866R.id.urlTextbox);
        this.searchBackground = (LinearLayout) this._parent.findViewById(C0866R.id.search_background);
        this.stopRefreshButton = (ImageButton) this._parent.findViewById(C0866R.id.stopRefreshButton);
        this.searchBtn = (ImageView) this.searchBackground.findViewById(C0866R.id.search_icon);
        this.clearTextButton = (ImageButton) this._parent.findViewById(C0866R.id.clearText);
        this.clearTextButton.setOnClickListener(new C09723());
        this.urlTextBox.addTextChangedListener(this.urlBarTextChangeListener);
        this.urlTextBox.setOnFocusChangeListener(this.focusChangeListener);
        this.urlTextBox.setOnClickListener(new C09734());
        initEventHandlers();
    }

    public void createWidgetLayout() {
        Context context = this._parent.getContext();
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(C0866R.layout.navigation_bar_top, this._parent, true);
        this.urlBar = (Toolbar) this._parent.findViewById(C0866R.id.topNavigationRow);
        this.urlBar.bringToFront();
        this.urlBar.inflateMenu(C0866R.menu.webapp_menu);
        MainNavigationActivity mainActivity = Factory.getInstance().getMainNavigationActivity();
        mainActivity.runOnUiThread(new C09745(mainActivity));
        this._defaultTopBrowserMargin = (int) TypedValue.applyDimension(1, 50.0f, context.getResources().getDisplayMetrics());
        this._defaultBottomBrowserMargin = 0;
        show();
    }

    public void hide() {
        if (this._parent.findViewById(C0866R.id.topNavigationRow) != null) {
            this._parent.findViewById(C0866R.id.topNavigationRow).setVisibility(8);
            ((LayoutParams) this._browser.getLayoutParams()).setMargins(0, 0, 0, 0);
            ((LayoutParams) this._progressBarContainer.getLayoutParams()).setMargins(0, 0, 0, 0);
            this._visible = false;
        }
    }

    public void show() {
        if (this._parent.findViewById(C0866R.id.topNavigationRow) != null) {
            this._parent.findViewById(C0866R.id.topNavigationRow).setVisibility(0);
            ((LayoutParams) this._browser.getLayoutParams()).setMargins(this._defaultLeftBrowserMargin, this._defaultTopBrowserMargin, this._defaultRightBrowserMargin, this._defaultBottomBrowserMargin);
            ((LayoutParams) this._progressBarContainer.getLayoutParams()).setMargins(this._defaultLeftBrowserMargin, this._defaultTopBrowserMargin, this._defaultRightBrowserMargin, this._defaultBottomBrowserMargin);
            this._visible = true;
        }
    }

    public void changeVisibilityAnimated(boolean toShowUrlBar) {
        if (this._parent.findViewById(C0866R.id.topNavigationRow) == null) {
            return;
        }
        if (!this._visible || !toShowUrlBar) {
            if (this._visible || toShowUrlBar) {
                Animation animation = AnimationUtils.loadAnimation(this._parent.getContext(), toShowUrlBar ? C0866R.anim.slide_down : C0866R.anim.slide_up);
                animation.setAnimationListener(new C09756(toShowUrlBar));
                animation.setDuration(300);
                this._parent.findViewById(C0866R.id.topNavigationRow).startAnimation(animation);
                Animation a = new C09767(toShowUrlBar);
                a.setDuration(300);
                this._parent.startAnimation(a);
            }
        }
    }

    public void hideAnimated() {
        changeVisibilityAnimated(false);
    }

    public void showAnimated() {
        changeVisibilityAnimated(true);
    }

    public void hideAdditionalMenu() {
        if (this._menuVisible) {
            this._menuVisible = false;
            ViewGroup.LayoutParams params = this.overlay.getLayoutParams();
            params.height = -2;
            this.overlay.setLayoutParams(params);
            this.overlay.startAnimation(this.slideUp);
        }
    }

    protected void showAdditionalMenu() {
        if (!this._menuVisible) {
            this._menuVisible = true;
            this.overlayScroll.setVisibility(0);
            this.overlay.setVisibility(0);
            this.overlay.startAnimation(this.slideDown);
            FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) this.overlay.getLayoutParams();
            params.height = 12;
            this.overlay.setLayoutParams(params);
        }
    }

    protected void toggleAdditionalMenu() {
        if (this._menuVisible) {
            hideAdditionalMenu();
        } else {
            showAdditionalMenu();
        }
    }

    public void changeUrlBarRightMarginAnimated(int oldMarginDp, int newMarginDp) {
        Animation a = new C09778(oldMarginDp, newMarginDp);
        a.setDuration(100);
        this._parent.startAnimation(a);
    }

    protected void extendUrlInput() {
        changeUrlBarRightMarginAnimated(pxToDp(((LayoutParams) this.searchBackground.getLayoutParams()).rightMargin), 45);
    }

    protected void shortenUrlInput() {
        changeUrlBarRightMarginAnimated(pxToDp(((LayoutParams) this.searchBackground.getLayoutParams()).rightMargin), 75);
    }

    public boolean isMenuVisible() {
        return this._menuVisible;
    }

    public boolean isSuggestionsVisible() {
        return this._suggestionsVisible;
    }

    private ArrayList<LocalSuggestionItem> getLocalSuggestions(String text) {
        Cursor cursor = this._history.getHistoryItemsGroupedByUrl(text);
        ArrayList<LocalSuggestionItem> localItems = new ArrayList();
        try {
            if (cursor.moveToFirst()) {
                do {
                    String title = cursor.getString(cursor.getColumnIndex(DatabaseOpenHelper.HISTORY_ROW_TITLE));
                    String url = cursor.getString(cursor.getColumnIndex(DatabaseOpenHelper.HISTORY_ROW_URL));
                    if (!isHomePageUrl(url)) {
                        localItems.add(new LocalSuggestionItem(title, url));
                    }
                } while (cursor.moveToNext());
            }
            cursor.close();
            return localItems;
        } catch (Exception e) {
            return new ArrayList();
        }
    }

    private SuggestionItem _getNextSuggestion(ArrayList<LocalSuggestionItem> localSuggestions, int localSuggIndex, ArrayList<RemoteSuggestionItem> remoteSuggestions, int remoteSuggIndex, int currentGlobalIndex) {
        if (currentGlobalIndex <= 2) {
            if (remoteSuggIndex < remoteSuggestions.size()) {
                return (SuggestionItem) remoteSuggestions.get(remoteSuggIndex);
            }
            if (localSuggIndex < localSuggestions.size()) {
                return (SuggestionItem) localSuggestions.get(localSuggIndex);
            }
        } else if (localSuggIndex < localSuggestions.size()) {
            return (SuggestionItem) localSuggestions.get(localSuggIndex);
        } else {
            if (remoteSuggIndex < remoteSuggestions.size()) {
                return (SuggestionItem) remoteSuggestions.get(remoteSuggIndex);
            }
        }
        return null;
    }

    public synchronized void onReceiveSuggestions(ArrayList<RemoteSuggestionItem> remoteSuggestions, String initialSearch) {
        Factory.getInstance().getMainNavigationActivity().runOnUiThread(new AnonymousClass10(getLocalSuggestions(initialSearch), remoteSuggestions, this._parent.getContext()));
    }

    public void setLayoutParams(LayoutParams params1) {
        this.frameUrlBar.setLayoutParams(params1);
        ((LayoutParams) this._browser.getLayoutParams()).setMargins(0, params1.height, 0, 0);
        ((LayoutParams) this._progressBarContainer.getLayoutParams()).setMargins(0, params1.height, 0, 0);
    }

    public ViewGroup.LayoutParams getLayoutParams() {
        return this.frameUrlBar.getLayoutParams();
    }

    public Toolbar getUrlBar() {
        return this.urlBar;
    }
}
