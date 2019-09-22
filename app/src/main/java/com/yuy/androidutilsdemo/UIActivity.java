package com.yuy.androidutilsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.yuy.androidutils.uiutils.YAlertDialogUtils;
import com.yuy.androidutils.uiutils.YLoadingDialogUtils;
import com.yuy.androidutils.uiutils.YPopWindowUtils;
import com.yuy.androidutils.uiutils.YToastUtils;
import com.yuy.androidutils.uiutils.entity.PickEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class UIActivity extends AppCompatActivity {

    private YPopWindowUtils yuYPopWindow;
    private YLoadingDialogUtils yuYLoadingDialog;
    private YToastUtils yuYToast;

    private String webUrl = "https://github.com/yuyang-1995";
    private List<PickEntity.RestbodyBean.Higher1LevelBean> list1 = new ArrayList<>();
    private List<PickEntity.RestbodyBean.Higher2LevelBean> list2 = new ArrayList<>();
    private List<PickEntity.RestbodyBean.Higher3LevelBean> list3 = new ArrayList<>();
    private List arrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        list1.add(new PickEntity.RestbodyBean.Higher1LevelBean(111, "aaaaaa"));
        list1.add(new PickEntity.RestbodyBean.Higher1LevelBean(111, "22222"));
        list1.add(new PickEntity.RestbodyBean.Higher1LevelBean(111, "333333"));
        list1.add(new PickEntity.RestbodyBean.Higher1LevelBean(111, "44444"));
        list2.add(new PickEntity.RestbodyBean.Higher2LevelBean(111, "bbbbb"));
        list3.add(new PickEntity.RestbodyBean.Higher3LevelBean(111, "vvvvvvvvv"));
    }


    @OnClick({R.id.button1,R.id.button2,R.id.button3,R.id.button4,R.id.button5
            ,R.id.button6,R.id.button7,R.id.button8,R.id.button9,R.id.button10,R.id.button11})
    void OnViewClicked(View view){
        switch (view.getId()){
            case R.id.button1:
                showLoading(null);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        hideLoadingDialog();
                    }
                },1000);
                break;

            case R.id.button2:
                showLoading("正在校验信息正在校验信息正在校验信息");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        hideLoadingDialog();
                    }
                },1000);
                break;
            case R.id.button3:
                showToastSuccess("加载成功");
                break;
            case R.id.button4:
                showToastFailure("加载Failure");
                break;
            case R.id.button5:
                showDialog1();
                break;
            case R.id.button6:
                showDialog2();
                break;
            case R.id.button7:
                showXieYiDialog();
                break;
            case R.id.button8:
                showImageDialog();
                break;
            case R.id.button9:
                Button button9 = findViewById(R.id.button9);
                if (yuYPopWindow == null) {
                    yuYPopWindow = new YPopWindowUtils();
                }
                yuYPopWindow.showDownPop(
                        this,
                        button9,
                        "我是中国人",
                        "我是中国人，我爱我的祖国，祝祖国繁荣昌盛",
                        40,
                        0);
                break;
            case R.id.button10:
                showPickDialogTwo();
                break;
            case R.id.button11:
                showPickDialogThree();
                break;


            default:break;
        }
    }


    void showPickDialogThree(){
        for (int i = 0; i < list1.size(); i++) {
            list1.get(i).setChecked(false);
        }
        for (int i = 0; i < list2.size(); i++) {
            list2.get(i).setChecked(false);
        }
        for (int i = 0; i < list3.size(); i++) {
            list3.get(i).setChecked(false);
        }
        YAlertDialogUtils.showDialogPickThree(this,
                "选择",
                "aa", "bb", "cc",
                2, 1, 3,
                list1, list2, list3,
                "完成", true,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(UIActivity.this, "确定", Toast.LENGTH_SHORT).show();
                        arrayList = new ArrayList();
                        for (int i = 0; i < list1.size(); i++) {
                            if (list1.get(i).isChecked()) {
                                arrayList.add(list1.get(i).getName());
                            }
                        }
                        for (int i = 0; i < list2.size(); i++) {
                            if (list2.get(i).isChecked()) {
                                arrayList.add(list2.get(i).getName());
                            }
                        }
                        for (int i = 0; i < list3.size(); i++) {
                            if (list3.get(i).isChecked()) {
                                arrayList.add(list3.get(i).getName());
                            }
                        }
                        String aaa = "";
                        for (int i = 0; i < arrayList.size(); i++) {
                            String bbb = arrayList.get(i).toString();
                            aaa += " " + bbb;
                        }
                        Log.d("mmm", aaa);
                        Toast.makeText(UIActivity.this, aaa, Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                }, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (list1.get(which).isChecked()) {
                            list1.get(which).setChecked(false);
                        } else {
                            list1.get(which).setChecked(true);
                        }
                        Toast.makeText(UIActivity.this, list1.get(which).getId() + list1.get(which).getName(), Toast.LENGTH_SHORT).show();
                    }
                }, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (list2.get(which).isChecked()) {
                            list2.get(which).setChecked(false);
                        } else {
                            list2.get(which).setChecked(true);
                        }
                        Toast.makeText(UIActivity.this, list2.get(which).getId() + list2.get(which).getName(), Toast.LENGTH_SHORT).show();
                    }
                }, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (list3.get(which).isChecked()) {
                            list3.get(which).setChecked(false);
                        } else {
                            list3.get(which).setChecked(true);
                        }
                        Toast.makeText(UIActivity.this, list3.get(which).getId() + list3.get(which).getName(), Toast.LENGTH_SHORT).show();
                    }
                }, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int checkedId, boolean isChecked) {
                        Toast.makeText(UIActivity.this, "nnn", Toast.LENGTH_SHORT).show();
                    }
                });
    }


    void showPickDialogTwo(){
        for (int i=0; i < list1.size(); i++){
            list1.get(i).setChecked(false);
        }
        for (int i=0; i <list2.size(); i++){
            list2.get(i).setChecked(false);
        }

        YAlertDialogUtils.showDialogPickTwo(this,
                "选择",
                "aa", "bb",
                2, 1,
                list1, list2,
                "完成", true,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(UIActivity.this, "确定", Toast.LENGTH_SHORT).show();
                        arrayList = new ArrayList();
                        for (int i = 0; i < list1.size(); i++) {
                            if (list1.get(i).isChecked()) {
                                arrayList.add(list1.get(i).getName());
                            }
                        }
                        for (int i = 0; i < list2.size(); i++) {
                            if (list2.get(i).isChecked()) {
                                arrayList.add(list2.get(i).getName());
                            }
                        }
                        String aaa = "";
                        for (int i = 0; i < arrayList.size(); i++) {
                            String bbb = arrayList.get(i).toString();
                            aaa += " " + bbb;
                        }
                        Log.d("mmm", aaa);
                        Toast.makeText(UIActivity.this, aaa, Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                }, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (list1.get(which).isChecked()) {
                            list1.get(which).setChecked(false);
                        } else {
                            list1.get(which).setChecked(true);
                        }
                        Toast.makeText(UIActivity.this, list1.get(which).getId() + list1.get(which).getName(), Toast.LENGTH_SHORT).show();
                    }
                }, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (list2.get(which).isChecked()) {
                            list2.get(which).setChecked(false);
                        } else {
                            list2.get(which).setChecked(true);
                        }
                        Toast.makeText(UIActivity.this, list2.get(which).getId() + list2.get(which).getName(), Toast.LENGTH_SHORT).show();
                    }
                }, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int checkedId, boolean isChecked) {
                        Toast.makeText(UIActivity.this, "nnn", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    //图片Dialog
    void showImageDialog(){

        YAlertDialogUtils.showImageDialog(this,
                "http://img0.imgtn.bdimg.com/it/u=3295048120,2386838883&fm=214&gp=0.jpg",
                false,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(UIActivity.this, "取消", Toast.LENGTH_SHORT).show();
                        dialogInterface.dismiss();
                    }
                },
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(UIActivity.this, "确定", Toast.LENGTH_SHORT).show();
                        dialogInterface.dismiss();
                    }}
        ); }


    //协议Dialog
    private void showXieYiDialog() {
        final boolean[] misChecked = {false};
        YAlertDialogUtils.showProtocolDialog(UIActivity.this,
                "个人协议",
                webUrl,
                "我知道了",
                "我已阅读并同意伤处条款，下次不再提示",
                false,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(UIActivity.this, "取消", Toast.LENGTH_SHORT).show();
                        dialogInterface.dismiss();
                    }
                },
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (misChecked[0]){
                            Toast.makeText(UIActivity.this,"checkbox选中了--我知道了",Toast.LENGTH_SHORT).show();
                        }
                        dialogInterface.dismiss();
                    }
                },
                new DialogInterface.OnMultiChoiceClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean isChecked) {
                        if (isChecked){
                            misChecked[0] = true;
                        }else {
                            misChecked[0] = false;
                        }
                    }
                }

        );

    }

    private void showDialog2() {
        YAlertDialogUtils.showDialog( this,
                "标题",
                "我是中国人，我爱我的祖国。祝祖国繁荣富强",
                "取消",
                "确定",
                false,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(UIActivity.this, "取消", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                },
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(UIActivity.this, "确定", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
    }

    private void showDialog1() {
        YAlertDialogUtils.showDialog(this,
                "标题",
                "我是中国人，我爱我的祖国",
                null,
                "确定",
                false,
                null,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(UIActivity.this, "确定", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
    }


    private void showToastFailure(String msg){
        if (yuYToast == null){
            YToastUtils.Builder builder = new YToastUtils.Builder(this)
                    .setSuccess(false)
                    .setMessage(msg);

            yuYToast = builder.create();
        }else {
            yuYToast.cancel();
            YToastUtils.Builder builder = new YToastUtils.Builder(this)
                    .setSuccess(false)
                    .setMessage(msg);
            yuYToast = builder.create();
        }
        yuYToast.show();
    }

    private void showToastSuccess(String msg){
        if(yuYToast == null){
            YToastUtils.Builder builder = new YToastUtils.Builder(this)
                    .setMessage(msg)
                    .setSuccess(true);
            yuYToast = builder.create();
        }else {

            yuYToast.cancel();
            YToastUtils.Builder builder=new YToastUtils.Builder(this)
                    .setMessage(msg)
                    .setSuccess(true);
            yuYToast = builder.create();
        }

        yuYToast.show();
    }

    //
    private void hideLoadingDialog() {
        if (yuYLoadingDialog!=null && yuYLoadingDialog.isShowing()){
            yuYLoadingDialog.dismiss();
            yuYLoadingDialog = null;
        }
    }


    //带加载信息的loading
    private void showLoading(String msg) {
        if (yuYLoadingDialog == null){
            YLoadingDialogUtils.Builder builder = new YLoadingDialogUtils.Builder(this)
                    .setMessage(TextUtils.isEmpty(msg) ? "加载中..." : msg)
                    .setCancelable(false)
                    .setCancelOutside(false);
            yuYLoadingDialog = builder.create();
        }else {
            yuYLoadingDialog.dismiss();
            YLoadingDialogUtils.Builder builder = new YLoadingDialogUtils.Builder(this)
                    .setMessage(msg)
                    .setCancelable(false)
                    .setCancelOutside(false);
            yuYLoadingDialog = builder.create();
        }
        yuYLoadingDialog.show();
    }
}
