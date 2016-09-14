package com.wTouch2KiLL.suggestions;

import com.wTouch2KiLL.MainNavigationActivity;
import com.wTouch2KiLL.server.BaseServerClient;
import com.wTouch2KiLL.server.BaseServerClient.OnRequestDoneListener;
import java.io.StringReader;
import java.net.URLEncoder;
import java.util.ArrayList;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import mf.javax.xml.XMLConstants;
import org.xml.sax.InputSource;

public class SuggestionsClient extends BaseServerClient {
    public static final int TAG = 99999;
    private SuggestionsListener listener;

    /* renamed from: com.wTouch2KiLL.suggestions.SuggestionsClient.1 */
    class C14801 implements OnRequestDoneListener {
        final /* synthetic */ String val$search;

        C14801(String str) {
            this.val$search = str;
        }

        public void onRequestDone(String requestUrl, int tag, String response) {
            if (tag == SuggestionsClient.TAG && response != null) {
                ArrayList<RemoteSuggestionItem> results;
                try {
                    results = SuggestionsClient.this.tryGetSuggestsFromXml(response);
                } catch (Exception e) {
                    results = new ArrayList();
                }
                SuggestionsClient.this.listener.onReceiveSuggestions(results, this.val$search);
            }
        }
    }

    public SuggestionsClient(MainNavigationActivity activity) {
        super(activity);
    }

    public void setListener(SuggestionsListener listener) {
        this.listener = listener;
    }

    public void getSuggestionsAsync(String search) {
        if (search != null && search != XMLConstants.NULL_NS_URI) {
            sendRequestAsync("http://google.com/complete/search?output=toolbar&q=" + URLEncoder.encode(search), Integer.valueOf(TAG), new C14801(search));
        }
    }

    private ArrayList<RemoteSuggestionItem> tryGetSuggestsFromXml(String xml) {
        try {
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            SuggestionsHandler handler = new SuggestionsHandler();
            parser.parse(new InputSource(new StringReader(xml)), handler);
            return handler.getResult();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }
}
