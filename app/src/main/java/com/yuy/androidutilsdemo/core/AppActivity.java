package com.yuy.androidutilsdemo.core;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.yuy.androidutilsdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AppActivity extends AppCompatActivity {

    @BindView(R.id.appAboutTv)
    TextView appAboutTv;
    @BindView(R.id.appInstallAppBtn)
    Button appInstallAppBtn;
    @BindView(R.id.appUninstallAppBtn)
    Button appUninstallAppBtn;
    @BindView(R.id.appLaunchAppBtn)
    Button appLaunchAppBtn;
    @BindView(R.id.appRelaunchAppBtn)
    Button appRelaunchAppBtn;
    @BindView(R.id.appLaunchAppDetailsSettingsBtn)
    Button appLaunchAppDetailsSettingsBtn;
    @BindView(R.id.appExitAppBtn)
    Button appExitAppBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.appAboutTv, R.id.appInstallAppBtn, R.id.appUninstallAppBtn, R.id.appLaunchAppBtn, R.id.appRelaunchAppBtn, R.id.appLaunchAppDetailsSettingsBtn, R.id.appExitAppBtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.appAboutTv:

                break;
            case R.id.appInstallAppBtn:

                break;
            case R.id.appUninstallAppBtn:
                break;
            case R.id.appLaunchAppBtn:
                break;
            case R.id.appRelaunchAppBtn:
                break;
            case R.id.appLaunchAppDetailsSettingsBtn:
                break;
            case R.id.appExitAppBtn:
                break;
        }
    }
}
