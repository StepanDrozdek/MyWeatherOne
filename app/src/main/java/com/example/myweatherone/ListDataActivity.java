package com.example.myweatherone;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import static com.android.volley.VolleyLog.TAG;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListDataActivity extends AppCompatActivity {
    DatabaseHelper mDatabaseHelper;

    private ListView mListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);
        mListView = (ListView) findViewById(R.id.listView);
        mDatabaseHelper = new DatabaseHelper(this);

        populateListView();
    }

    private void populateListView() {

        Log.d(TAG, "populateListView: Displaying data in the ListView.");

        //get the data and append to a list
        Cursor data = mDatabaseHelper.getData();
        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>(2);

        while (data.moveToNext()) {

            HashMap<String, String> map;
            map = new HashMap<String, String>();

            map.put("line1", data.getString(1));
            map.put("line2", data.getString(2) + " C°  ,  " + data.getString(3) + " %  ,  " + data.getString(5));
            list.add(map);
        }

        String[] from = {"line1", "line2"};

        // the to array specifies the TextViews from the xml layout
        // on which we want to display the values defined in the from array
        int[] to = {android.R.id.text1, android.R.id.text2};

        //create the list adapter and set the adapter
        SimpleAdapter adapter = new SimpleAdapter(this, list, android.R.layout.simple_list_item_2, from, to);
        mListView.setAdapter(adapter);
    }
}
