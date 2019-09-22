package com.yuy.androidutilsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.appbar.CollapsingToolbarLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CollapsingToolbarLayout collapsingToolbarLayout;

    private Button btn_core, btn_sub, btn_ui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initListener();

        collapsingToolbarLayout.setTitle("AndroidUtils");
    }

    private void initListener() {
        btn_sub.setOnClickListener(this);
        btn_core.setOnClickListener(this);
        btn_ui.setOnClickListener(this);


    }

    private void initView() {
        collapsingToolbarLayout = findViewById(R.id.launcherMainCtl);
        btn_core = findViewById(R.id.btn_core);
        btn_sub = findViewById(R.id.btn_sub);
        btn_ui = findViewById(R.id.btn_ui);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_core:
                Intent intent1 = new Intent(MainActivity.this, CoreActivity.class);
                startActivity(intent1);


                break;
            case R.id.btn_sub:
//                Intent intent2 = new Intent(MainActivity.this, UIActivity.class);
//                startActivity(intent2);

                break;
            case R.id.btn_ui:
                Intent intent = new Intent(MainActivity.this, UIActivity.class);
                startActivity(intent);

                default:break;
        }

    }


}
