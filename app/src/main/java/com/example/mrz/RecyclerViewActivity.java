package com.example.mrz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.example.entity.Fruit;

import java.util.ArrayList;
import java.util.List;

import cn.example.adapter.RecycleViewAdapter;

public class RecyclerViewActivity extends BaseActive {


    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initList();
        RecycleViewAdapter adapter = new RecycleViewAdapter(fruitList);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.RecycleView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }


    private void initList() {
        for (int i = 0; i < 50; i++) {
            Fruit fruit = new Fruit("appale",R.drawable.ic_launcher_foreground);
            fruitList.add(fruit);
        }
    }

}
