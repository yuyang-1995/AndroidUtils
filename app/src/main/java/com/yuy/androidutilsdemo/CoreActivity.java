package com.yuy.androidutilsdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CoreActivity extends AppCompatActivity {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.coreUtilActivityBtn)
    Button coreUtilActivityBtn;
    @BindView(R.id.coreUtilAdaptScreenBtn)
    Button coreUtilAdaptScreenBtn;
    @BindView(R.id.coreUtilApiBtn)
    Button coreUtilApiBtn;
    @BindView(R.id.coreUtilAppBtn)
    Button coreUtilAppBtn;
    @BindView(R.id.coreUtilBarBtn)
    Button coreUtilBarBtn;
    @BindView(R.id.coreUtilBrightnessBtn)
    Button coreUtilBrightnessBtn;
    @BindView(R.id.coreUtilBusBtn)
    Button coreUtilBusBtn;
    @BindView(R.id.coreUtilCleanBtn)
    Button coreUtilCleanBtn;
    @BindView(R.id.coreUtilClickBtn)
    Button coreUtilClickBtn;
    @BindView(R.id.coreUtilCrashBtn)
    Button coreUtilCrashBtn;
    @BindView(R.id.coreUtilDeviceBtn)
    Button coreUtilDeviceBtn;
    @BindView(R.id.coreUtilFlashlightBtn)
    Button coreUtilFlashlightBtn;
    @BindView(R.id.coreUtilFragmentBtn)
    Button coreUtilFragmentBtn;
    @BindView(R.id.coreUtilImageBtn)
    Button coreUtilImageBtn;
    @BindView(R.id.coreUtilKeyboardBtn)
    Button coreUtilKeyboardBtn;
    @BindView(R.id.coreUtilLanguageBtn)
    Button coreUtilLanguageBtn;
    @BindView(R.id.coreUtilLogBtn)
    Button coreUtilLogBtn;
    @BindView(R.id.coreUtilMessengerBtn)
    Button coreUtilMessengerBtn;
    @BindView(R.id.coreUtilMetaDataBtn)
    Button coreUtilMetaDataBtn;
    @BindView(R.id.coreUtilNetworkBtn)
    Button coreUtilNetworkBtn;
    @BindView(R.id.coreUtilPathBtn)
    Button coreUtilPathBtn;
    @BindView(R.id.coreUtilPermissionBtn)
    Button coreUtilPermissionBtn;
    @BindView(R.id.coreUtilPhoneBtn)
    Button coreUtilPhoneBtn;
    @BindView(R.id.coreUtilProcessBtn)
    Button coreUtilProcessBtn;
    @BindView(R.id.coreUtilReflectBtn)
    Button coreUtilReflectBtn;
    @BindView(R.id.coreUtilResourceBtn)
    Button coreUtilResourceBtn;
    @BindView(R.id.coreUtilRomBtn)
    Button coreUtilRomBtn;
    @BindView(R.id.coreUtilScreenBtn)
    Button coreUtilScreenBtn;
    @BindView(R.id.coreUtilSdcardBtn)
    Button coreUtilSdcardBtn;
    @BindView(R.id.coreUtilSnackbarBtn)
    Button coreUtilSnackbarBtn;
    @BindView(R.id.coreUtilSpStaticBtn)
    Button coreUtilSpStaticBtn;
    @BindView(R.id.coreUtilSpanBtn)
    Button coreUtilSpanBtn;
    @BindView(R.id.coreUtilToastBtn)
    Button coreUtilToastBtn;
    @BindView(R.id.coreUtilVibrateBtn)
    Button coreUtilVibrateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_core);
        ButterKnife.bind(this);
    }




    @OnClick({R.id.back, R.id.coreUtilActivityBtn, R.id.coreUtilAdaptScreenBtn, R.id.coreUtilApiBtn, R.id.coreUtilAppBtn, R.id.coreUtilBarBtn, R.id.coreUtilBrightnessBtn, R.id.coreUtilBusBtn, R.id.coreUtilCleanBtn, R.id.coreUtilClickBtn, R.id.coreUtilCrashBtn, R.id.coreUtilDeviceBtn, R.id.coreUtilFlashlightBtn, R.id.coreUtilFragmentBtn, R.id.coreUtilImageBtn, R.id.coreUtilKeyboardBtn, R.id.coreUtilLanguageBtn, R.id.coreUtilLogBtn, R.id.coreUtilMessengerBtn, R.id.coreUtilMetaDataBtn, R.id.coreUtilNetworkBtn, R.id.coreUtilPathBtn, R.id.coreUtilPermissionBtn, R.id.coreUtilPhoneBtn, R.id.coreUtilProcessBtn, R.id.coreUtilReflectBtn, R.id.coreUtilResourceBtn, R.id.coreUtilRomBtn, R.id.coreUtilScreenBtn, R.id.coreUtilSdcardBtn, R.id.coreUtilSnackbarBtn, R.id.coreUtilSpStaticBtn, R.id.coreUtilSpanBtn, R.id.coreUtilToastBtn, R.id.coreUtilVibrateBtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                Intent intent = new Intent(CoreActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.coreUtilActivityBtn:

                break;
            case R.id.coreUtilAdaptScreenBtn:
                break;
            case R.id.coreUtilApiBtn:
                break;
            case R.id.coreUtilAppBtn:


                break;
            case R.id.coreUtilBarBtn:
                break;
            case R.id.coreUtilBrightnessBtn:
                break;
            case R.id.coreUtilBusBtn:
                break;
            case R.id.coreUtilCleanBtn:
                break;
            case R.id.coreUtilClickBtn:
                break;
            case R.id.coreUtilCrashBtn:
                break;
            case R.id.coreUtilDeviceBtn:
                break;
            case R.id.coreUtilFlashlightBtn:
                break;
            case R.id.coreUtilFragmentBtn:
                break;
            case R.id.coreUtilImageBtn:
                break;
            case R.id.coreUtilKeyboardBtn:
                break;
            case R.id.coreUtilLanguageBtn:
                break;
            case R.id.coreUtilLogBtn:
                break;
            case R.id.coreUtilMessengerBtn:
                break;
            case R.id.coreUtilMetaDataBtn:
                break;
            case R.id.coreUtilNetworkBtn:
                break;
            case R.id.coreUtilPathBtn:
                break;
            case R.id.coreUtilPermissionBtn:
                break;
            case R.id.coreUtilPhoneBtn:
                break;
            case R.id.coreUtilProcessBtn:
                break;
            case R.id.coreUtilReflectBtn:
                break;
            case R.id.coreUtilResourceBtn:
                break;
            case R.id.coreUtilRomBtn:
                break;
            case R.id.coreUtilScreenBtn:
                break;
            case R.id.coreUtilSdcardBtn:
                break;
            case R.id.coreUtilSnackbarBtn:
                break;
            case R.id.coreUtilSpStaticBtn:
                break;
            case R.id.coreUtilSpanBtn:
                break;
            case R.id.coreUtilToastBtn:
                break;
            case R.id.coreUtilVibrateBtn:
                break;
        }
    }
}
