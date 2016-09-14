package com.wTouch2KiLL.browser;

import android.app.Activity;
import android.text.format.DateFormat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.wTouch2KiLL.C0866R;
import com.wTouch2KiLL.browser.DownloadsItem.Status;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DownloadsItemAdapter extends ArrayAdapter<DownloadsItem> {
    private Activity context;
    private List<DownloadsItem> itemList;
    private int resource;

    private static class ViewHolder {
        TextView date;
        TextView description;
        TextView name;
        ProgressBar progressBar;

        private ViewHolder() {
        }
    }

    public DownloadsItemAdapter(Activity context, int resource, List<DownloadsItem> itemList) {
        super(context, resource, itemList);
        this.itemList = itemList;
        this.context = context;
        this.resource = resource;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        View rowView = convertView;
        if (rowView == null) {
            rowView = this.context.getLayoutInflater().inflate(this.resource, null, true);
            holder = new ViewHolder();
            holder.name = (TextView) rowView.findViewById(C0866R.id.nameDI);
            holder.description = (TextView) rowView.findViewById(C0866R.id.descriptionDI);
            holder.progressBar = (ProgressBar) rowView.findViewById(C0866R.id.progressBarDI);
            holder.date = (TextView) rowView.findViewById(C0866R.id.time);
            rowView.setTag(holder);
        } else {
            holder = (ViewHolder) rowView.getTag();
        }
        DownloadsItem item = (DownloadsItem) this.itemList.get(position);
        holder.name.setText(item.getName());
        holder.description.setText(item.getDescription());
        if (item.getDate() == null || item.getDate().longValue() == 0) {
            holder.date.setVisibility(8);
        } else {
            if (isSameDay(new Date(), new Date(item.getDate().longValue()))) {
                holder.date.setText(DateFormat.format("HH:mm", item.getDate().longValue()));
            } else {
                holder.date.setText(DateFormat.format("dd MMM", item.getDate().longValue()));
            }
            holder.date.setVisibility(0);
        }
        if (item.getStatus() == Status.InProgress) {
            holder.progressBar.setProgress(item.getProgress().intValue());
            holder.progressBar.setVisibility(0);
            holder.description.setVisibility(8);
        } else if (item.getStatus() == Status.Ok) {
            holder.progressBar.setVisibility(8);
            holder.description.setVisibility(0);
        } else if (item.getStatus() == Status.Fail) {
            holder.progressBar.setVisibility(8);
            holder.description.setVisibility(0);
        }
        return rowView;
    }

    public static boolean isSameDay(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            throw new IllegalArgumentException("The dates must not be null");
        }
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        return isSameDay(cal1, cal2);
    }

    public static boolean isSameDay(Calendar cal1, Calendar cal2) {
        if (cal1 == null || cal2 == null) {
            throw new IllegalArgumentException("The dates must not be null");
        } else if (cal1.get(0) == cal2.get(0) && cal1.get(1) == cal2.get(1) && cal1.get(6) == cal2.get(6)) {
            return true;
        } else {
            return false;
        }
    }
}
