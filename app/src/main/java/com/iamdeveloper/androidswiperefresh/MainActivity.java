package com.iamdeveloper.androidswiperefresh;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private SwipeRefreshLayout mSwipe;
    private ListView listView;
    private ArrayList<String> list;
    private ArrayAdapter<String> adapter;
    private int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listview);
        mSwipe = (SwipeRefreshLayout) findViewById(R.id.swipe);
        list = new ArrayList<>();

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,list);

        listView.setAdapter(adapter);
        mSwipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                (new Handler()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        while ( i < 20){
                            i++;
                            list.add("data : " + i);
                            adapter.notifyDataSetChanged();
                        }
                        mSwipe.setRefreshing(false);
                    }
                },5000);
            }
        });







    }




}
