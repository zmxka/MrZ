package com.example.mrz;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends BaseActive {


    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resorteSaveInstanceState(savedInstanceState);
        addButtonClickLister();
        msgBack();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String data = "活动被回收保留的值";
        outState.putString("key",data);
    }

    //恢复上次活动回收时的状态
    private void resorteSaveInstanceState(Bundle savedInstanceState){
        if (savedInstanceState != null){
            String data = savedInstanceState.getString("key");
            Toast.makeText(this,data,Toast.LENGTH_LONG).show();
        }
    }
    //绑定按钮点击事件
    private void addButtonClickLister(){
        Button button = (Button) findViewById(R.id.button_1);
        Button button2 = (Button) findViewById(R.id.button_2);
        Button button3 = (Button) findViewById(R.id.button_3);
        Button button4 = (Button) findViewById(R.id.button_4);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);

    }
    //接收传递的参数
    private void msgBack() {
        Intent intent = getIntent();
        String data = intent.getStringExtra("pass_data");
        if (data != null) {
            Toast.makeText(MainActivity.this, data, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String reData = data.getStringExtra("data_return");
                    Toast.makeText(this, "123", Toast.LENGTH_LONG).show();
                }
            default:
                break;
        }
    }


    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.button_1:
                intent = new Intent(MainActivity.this, FirstActivity.class);
                startActivity(intent);
                break;
            case R.id.button_2:
                intent = new Intent(MainActivity.this, RouterActivity.class);
                startActivityForResult(intent, 1);
                break;
            case R.id.button_3:
                intent = new Intent(this,LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.button_4:
                intent = new Intent(this,ListViewActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
