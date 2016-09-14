package com.silvermob.sdk.utils;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import java.net.URL;

public class ImageDownloader extends AsyncTask<String, Void, Drawable> {
    ImageView bmImage;

    public ImageDownloader(ImageView bmImage) {
        this.bmImage = bmImage;
    }

    protected Drawable doInBackground(String... urls) {
        Drawable mIcon = null;
        try {
            mIcon = Drawable.createFromStream(new URL(urls[0]).openStream(), "appnex-banner");
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
        }
        return mIcon;
    }

    protected void onPostExecute(Drawable result) {
        this.bmImage.setImageDrawable(result);
    }
}
