package com.example.mrz;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button_1);
        button.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(this);

        msgBack();
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
                break;
            default:
                break;
        }
    }
}
