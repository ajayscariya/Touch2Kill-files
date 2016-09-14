package com.wTouch2KiLL;

import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat.LayoutParams;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.common.ConnectionResult;
import com.wTouch2KiLL.browser.DownloadsItem;
import com.wTouch2KiLL.browser.DownloadsItem.Status;
import com.wTouch2KiLL.browser.DownloadsItemAdapter;
import com.wTouch2KiLL.storage.DatabaseOpenHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import mf.org.apache.xerces.impl.dv.xs.DurationDV;
import mf.org.apache.xerces.impl.xs.SchemaSymbols;

public class DownloadsListActivity extends AppCompatActivity {
    public static final int DOWNLOAD_COMPLETE = 101;
    public static final String DOWNLOAD_LIST_MSG;
    public static final int DOWNLOAD_START = 100;
    private static final Object lock;
    private final int IDM_DELETE;
    private DatabaseOpenHelper _dbHelper;
    BroadcastReceiver activityReceiver;
    Comparator<DownloadsItem> comparator;
    DownloadManager downloadManager;
    private DownloadsItemAdapter downloadsItemAdapter;
    private List<DownloadsItem> itemList;
    private Timer myTimer;

    /* renamed from: com.wTouch2KiLL.DownloadsListActivity.1 */
    class C08461 implements OnItemClickListener {
        C08461() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            MimeTypeMap myMime = MimeTypeMap.getSingleton();
            Intent newIntent = new Intent("android.intent.action.VIEW");
            newIntent.setDataAndType(Uri.parse("file://" + ((DownloadsItem) DownloadsListActivity.this.itemList.get(position)).getFile_path()), myMime.getMimeTypeFromExtension(DownloadsListActivity.this.fileExt(((DownloadsItem) DownloadsListActivity.this.itemList.get(position)).getFile_path())));
            newIntent.setFlags(268435456);
            try {
                DownloadsListActivity.this.startActivity(newIntent);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(DownloadsListActivity.this, C0866R.string.no_handler, 1).show();
            }
        }
    }

    /* renamed from: com.wTouch2KiLL.DownloadsListActivity.2 */
    class C08472 implements Comparator<DownloadsItem> {
        C08472() {
        }

        public int compare(DownloadsItem lhs, DownloadsItem rhs) {
            if (lhs.getStatus() == Status.InProgress && rhs.getStatus() == Status.InProgress) {
                return Long.valueOf(lhs.getId_d()).compareTo(Long.valueOf(rhs.getId_d())) * -1;
            }
            if (lhs.getStatus() == Status.InProgress) {
                return -1;
            }
            if (rhs.getStatus() == Status.InProgress) {
                return 1;
            }
            return Long.valueOf(lhs.getId_d()).compareTo(Long.valueOf(rhs.getId_d())) * -1;
        }
    }

    /* renamed from: com.wTouch2KiLL.DownloadsListActivity.3 */
    class C08483 extends BroadcastReceiver {
        C08483() {
        }

        public void onReceive(Context context, Intent intent) {
            int type = intent.getIntExtra("type", 0);
            if (type == DownloadsListActivity.DOWNLOAD_START) {
                synchronized (DownloadsListActivity.lock) {
                    if (DownloadsListActivity.this.myTimer == null) {
                        DownloadsListActivity.this.myTimer = new Timer();
                        DownloadsListActivity.this.myTimer.schedule(new ProgressTask(null), 0, 100);
                    }
                    DownloadsListActivity.this.itemList.add((DownloadsItem) intent.getSerializableExtra("item"));
                    Collections.sort(DownloadsListActivity.this.itemList, DownloadsListActivity.this.comparator);
                    DownloadsListActivity.this.downloadsItemAdapter.notifyDataSetChanged();
                }
            }
            if (type == DownloadsListActivity.DOWNLOAD_COMPLETE) {
                synchronized (DownloadsListActivity.lock) {
                    DownloadsListActivity.this.itemList.clear();
                    DownloadsListActivity.this.itemList.addAll(DownloadsListActivity.this.getItemList());
                    DownloadsListActivity.this.downloadsItemAdapter.notifyDataSetChanged();
                }
            }
        }
    }

    private class ProgressTask extends TimerTask {

        /* renamed from: com.wTouch2KiLL.DownloadsListActivity.ProgressTask.1 */
        class C08491 implements Runnable {
            C08491() {
            }

            public void run() {
                DownloadsListActivity.this.downloadsItemAdapter.notifyDataSetChanged();
            }
        }

        private ProgressTask() {
        }

        public void run() {
            if ((DownloadsListActivity.this.itemList.size() == 0 || !((DownloadsItem) DownloadsListActivity.this.itemList.get(0)).getStatus().equals(Status.InProgress)) && DownloadsListActivity.this.myTimer != null) {
                DownloadsListActivity.this.myTimer.cancel();
                DownloadsListActivity.this.myTimer = null;
                return;
            }
            synchronized (DownloadsListActivity.lock) {
                for (DownloadsItem item : DownloadsListActivity.this.itemList) {
                    if (item.getStatus() != Status.InProgress) {
                        break;
                    }
                    Query q = new Query();
                    q.setFilterById(new long[]{item.getId_d()});
                    Cursor cursor = DownloadsListActivity.this.downloadManager.query(q);
                    if (cursor.moveToFirst()) {
                        cursor.moveToFirst();
                        int bytes_downloaded = cursor.getInt(cursor.getColumnIndex("bytes_so_far"));
                        int bytes_total = cursor.getInt(cursor.getColumnIndex("total_size"));
                        cursor.close();
                        item.setProgress(Integer.valueOf((bytes_downloaded * DownloadsListActivity.DOWNLOAD_START) / bytes_total));
                    } else {
                        item.setStatus(Status.Fail);
                        item.setDescription(Status.Fail.toString());
                        item.setDate(Long.valueOf(System.currentTimeMillis()));
                        item.setFile_path(null);
                    }
                    DownloadsListActivity.this.runOnUiThread(new C08491());
                    cursor.close();
                }
            }
        }
    }

    public DownloadsListActivity() {
        this.IDM_DELETE = 1;
        this.comparator = new C08472();
        this.activityReceiver = new C08483();
    }

    static {
        DOWNLOAD_LIST_MSG = DownloadsListActivity.class.toString();
        lock = new Object();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0866R.layout.activity_downloads_list);
        ListView downloadsList = (ListView) findViewById(C0866R.id.downloadsList);
        TextView textIsEmptyList = new TextView(this);
        textIsEmptyList.setLayoutParams(new LayoutParams(-1, -1));
        textIsEmptyList.setGravity(17);
        textIsEmptyList.setText(getResources().getString(C0866R.string.text_list_is_empty));
        ((ViewGroup) downloadsList.getParent()).addView(textIsEmptyList);
        downloadsList.setEmptyView(textIsEmptyList);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        setTitle(C0866R.string.downloads_list);
        this.downloadsItemAdapter = new DownloadsItemAdapter(this, C0866R.layout.downloads_item, this.itemList);
        registerForContextMenu(downloadsList);
        this.downloadManager = (DownloadManager) getSystemService("download");
        this.itemList = getItemList();
        registerReceiver(this.activityReceiver, new IntentFilter(DOWNLOAD_LIST_MSG));
        this.downloadsItemAdapter = new DownloadsItemAdapter(this, C0866R.layout.downloads_item, this.itemList);
        downloadsList.setOnItemClickListener(new C08461());
        downloadsList.setAdapter(this.downloadsItemAdapter);
        this.myTimer = new Timer();
        this.myTimer.schedule(new ProgressTask(), 0, 100);
    }

    private String fileExt(String url) {
        if (url == null) {
            return null;
        }
        if (url.contains("?")) {
            url = url.substring(0, url.indexOf("?"));
        }
        if (url.lastIndexOf(".") == -1) {
            return null;
        }
        String ext = url.substring(url.lastIndexOf(".") + 1);
        if (ext.contains("%")) {
            ext = ext.substring(0, ext.indexOf("%"));
        }
        if (ext.contains("/")) {
            ext = ext.substring(0, ext.indexOf("/"));
        }
        return ext.toLowerCase();
    }

    public void delete(int position) {
        long id = ((DownloadsItem) this.itemList.get(position)).getId_d();
        SQLiteDatabase db = this._dbHelper.getWritableDatabase();
        db.delete("downloadsList", "id_d = " + id, null);
        db.close();
        this.itemList.remove(position);
        this.downloadsItemAdapter.notifyDataSetChanged();
    }

    public void delete() {
        this.itemList.clear();
        SQLiteDatabase db = this._dbHelper.getWritableDatabase();
        db.delete("downloadsList", null, null);
        db.close();
    }

    public List<DownloadsItem> getItemList() {
        this._dbHelper = new DatabaseOpenHelper(this);
        List<DownloadsItem> itemList = new ArrayList();
        SQLiteDatabase db = this._dbHelper.getWritableDatabase();
        Cursor c = db.query("downloadsList", null, null, null, null, null, null);
        if (c.moveToFirst()) {
            int nameColIndex = c.getColumnIndex("name");
            int descriptionColIndex = c.getColumnIndex("description");
            int id_dColIndex = c.getColumnIndex("id_d");
            int link_dColIndex = c.getColumnIndex("link_d");
            int file_pathColIndex = c.getColumnIndex("file_path");
            int dateColIndex = c.getColumnIndex(SchemaSymbols.ATTVAL_DATE);
            do {
                DownloadsItem downloadsItem = new DownloadsItem(c.getString(nameColIndex));
                downloadsItem.setDescription(c.getString(descriptionColIndex));
                downloadsItem.setFile_path(c.getString(file_pathColIndex));
                downloadsItem.setId_d(c.getLong(id_dColIndex));
                downloadsItem.setLink_d(c.getString(link_dColIndex));
                downloadsItem.setDate(Long.valueOf(c.getLong(dateColIndex)));
                Query q = new Query();
                q.setFilterById(new long[]{downloadsItem.getId_d()});
                Cursor cursor = this.downloadManager.query(q);
                if (cursor.moveToFirst()) {
                    int columnIndex = cursor.getColumnIndex(NotificationCompatApi21.CATEGORY_STATUS);
                    int columnIndexDate = cursor.getColumnIndex("last_modified_timestamp");
                    int status = cursor.getInt(columnIndex);
                    int bytes_total = cursor.getInt(cursor.getColumnIndex("total_size"));
                    switch (status) {
                        case DurationDV.DAYTIMEDURATION_TYPE /*2*/:
                            downloadsItem.setStatus(Status.InProgress);
                            downloadsItem.setProgress(Integer.valueOf((cursor.getInt(cursor.getColumnIndex("bytes_so_far")) * DOWNLOAD_START) / bytes_total));
                            break;
                        case ConnectionResult.INTERNAL_ERROR /*8*/:
                            downloadsItem.setStatus(Status.Ok);
                            if (downloadsItem.getDate() == null || downloadsItem.getDate().longValue() == 0) {
                                downloadsItem.setDate(Long.valueOf(cursor.getLong(columnIndexDate)));
                                break;
                            }
                        case ConnectionResult.API_UNAVAILABLE /*16*/:
                            downloadsItem.setStatus(Status.Fail);
                            if (downloadsItem.getDate() == null || downloadsItem.getDate().longValue() == 0) {
                                downloadsItem.setDate(Long.valueOf(cursor.getLong(columnIndexDate)));
                                break;
                            }
                    }
                }
                itemList.add(downloadsItem);
                cursor.close();
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        Collections.sort(itemList, this.comparator);
        return itemList;
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        try {
            menu.setHeaderTitle(((DownloadsItem) this.itemList.get(((AdapterContextMenuInfo) menuInfo).position)).getName());
            menu.add(0, 1, 0, C0866R.string.delete);
        } catch (ClassCastException e) {
            Log.e("onCreateContextMenu", "bad menuInfo", e);
        }
    }

    public boolean onContextItemSelected(MenuItem item) {
        int index = ((AdapterContextMenuInfo) item.getMenuInfo()).position;
        switch (item.getItemId()) {
            case MainNavigationActivity.REQUEST_CODE /*1*/:
                synchronized (lock) {
                    delete(index);
                    break;
                }
                break;
        }
        return true;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0866R.menu.downloads_activity_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 16908332:
                finish();
                return true;
            case C0866R.id.delete_all_item /*2131427543*/:
                delete();
                this.downloadsItemAdapter.notifyDataSetChanged();
                return true;
            default:
                return false;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.activityReceiver);
    }

    protected void onStop() {
        super.onStop();
    }
}
