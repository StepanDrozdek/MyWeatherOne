package com.example.myweatherone;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {
    private final View mWindow;
    private Context mContext;
    private Bitmap image;

    public CustomInfoWindowAdapter(Context context, Bitmap image_from_url) {
        mContext = context;
        mWindow = LayoutInflater.from(context).inflate(R.layout.custom_info_window, null);
        image = image_from_url;
    }

    private void rendowWindowText(Marker marker, View view) {

        String title = marker.getTitle();
        TextView tvTitle = (TextView) view.findViewById(R.id.title);

        if (!title.equals("")) {
            tvTitle.setTextColor(Color.BLACK);
            tvTitle.setGravity(Gravity.CENTER);
            tvTitle.setTypeface(null, Typeface.BOLD);
            tvTitle.setText(title);
        }

        String snippet = marker.getSnippet();
        TextView tvSnippet = (TextView) view.findViewById(R.id.snippet);

        if (!snippet.equals("")) {
            tvSnippet.setTextColor(Color.BLACK);
            tvSnippet.setText(snippet);
        }

        ImageView image_in_snippet = (ImageView) view.findViewById(R.id.image_in_snippet);
        image_in_snippet.setImageBitmap(image);
    }

    @Override
    public View getInfoWindow(Marker marker) {
        rendowWindowText(marker, mWindow);
        return mWindow;
    }

    @Override
    public View getInfoContents(Marker marker) {
        rendowWindowText(marker, mWindow);
        return mWindow;
    }
}
