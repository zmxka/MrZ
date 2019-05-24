package com.example.mrz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import org.example.entity.Fruit;

import java.util.ArrayList;
import java.util.List;

import cn.example.adapter.ListViewAdapter;

public class ListViewActivity extends BaseActive {

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        initList();
        ListViewAdapter adapter = new ListViewAdapter(this,R.layout.litsview_item,fruitList);
        ListView listView = (ListView) findViewById(R.id.ListView);
        listView.setAdapter(adapter);
    }

    private void initList() {
        for (int i = 0; i < 50; i++) {
            Fruit fruit = new Fruit("appale",R.drawable.ic_launcher_foreground);
            fruitList.add(fruit);
        }
    }
}
