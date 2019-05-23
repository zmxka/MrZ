package com.example.mrz;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RouterActivity extends BaseActive {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_router);

        Button button = (Button) findViewById(R.id.button_display);
        Button button1 = (Button) findViewById(R.id.button_hide);
        Button button2 = (Button) findViewById(R.id.button_web);
        Button button3 = (Button) findViewById(R.id.button_pass);
        Button button4 = (Button) findViewById(R.id.button_back);
        button.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.button_display:
                intent = new Intent(RouterActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.button_hide:
                intent = new Intent("com.example.Hide");
                intent.addCategory("com.example.MY");
                startActivity(intent);
                break;
            case R.id.button_web:
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://github.com/zmxka/MrZ"));
                startActivity(intent);
                break;
            case R.id.button_pass:
                String data = "来自RouterActive的参数";
                intent = new Intent(RouterActivity.this, MainActivity.class);
                intent.putExtra("pass_data", data);
                startActivity(intent);
                break;
            case R.id.button_back:
                intent = new Intent();
                intent.putExtra("data_return", "返回参数到上一个活动");
                setResult(RESULT_OK, intent);
                finish();
                break;
            default:
                break;
        }
    }
}
