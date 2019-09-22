package com.yuy.androidutils.uiutils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.yuy.androidutils.R;
import com.yuy.androidutils.uiutils.adapter.Pick1Adapter;
import com.yuy.androidutils.uiutils.adapter.Pick2Adapter;
import com.yuy.androidutils.uiutils.adapter.Pick3Adapter;
import com.yuy.androidutils.uiutils.poputils.DensityUtils;

import java.util.List;

/**
 * Author: yuyang
 * Date:2019/9/21 15:30
 * Description: 协议对选择对话框，图片对话框， 列表选择对话框, recycler选择弹窗
 * Version:
 */
public class YAlertDialogUtils {


    private static Pick1Adapter pick1Adapter;
    private static Pick2Adapter pick2Adapter;
    private static Pick3Adapter pick3Adapter;

    /**
     *
     * @param context  上下文
     * @param str_tvTitle    标题
     * @param str_tvContent  内容
     * @param str_btnCancle   取消按钮文本
     * @param str_btnSure     确认按钮文本
     * @param touchOutside    外部监听
     * @param cancleListener  取消监听
     * @param sureListener    确认监听
     * @return
     */
    public synchronized static AlertDialog showDialog(Context context,
                                                      String str_tvTitle,
                                                      String str_tvContent,
                                                      String str_btnCancle,
                                                      String str_btnSure,
                                                      boolean touchOutside,
                                                      DialogInterface.OnClickListener cancleListener,
                                                      DialogInterface.OnClickListener sureListener){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        AlertDialog alertDialog = builder.create();
        alertDialog.setCanceledOnTouchOutside(touchOutside);
        alertDialog.setCancelable(false);

        //自定义Dialog View
        View view = View.inflate(context, R.layout.alert_dialog,null);

        //标题
        TextView tv_title = view.findViewById(R.id.tv_alert_title);
        //内容
        TextView tv_content = view.findViewById(R.id.tv_alert_content);
        //取消按钮
        Button btn_cancel = view.findViewById(R.id.btn_alert_cancel);
        //确定按钮
        Button btn_ok = view.findViewById(R.id.btn_alert_ok);
        //线
        View line_view = view.findViewById(R.id.v_alert_line);


        if (TextUtils.isEmpty(str_tvTitle)){
            tv_title.setVisibility(View.GONE);
        }else {
            tv_title.setText(str_tvTitle);
        }

        tv_content.setText(TextUtils.isEmpty(str_tvContent) ? "" : str_tvContent);

        if (TextUtils.isEmpty(str_btnCancle)){
            btn_cancel.setVisibility(View.GONE);
            line_view.setVisibility(View.GONE);
        }else {
            btn_cancel.setText(str_btnCancle);
        }

        btn_ok.setText(TextUtils.isEmpty(str_btnSure) ? "确认" : str_btnSure);
        final AlertDialog finalDialog = alertDialog;
        final DialogInterface.OnClickListener finalCancleListener = cancleListener;
        final DialogInterface.OnClickListener finalSureListener = sureListener;
        //按钮点击事件
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finalCancleListener.onClick(finalDialog, DialogInterface.BUTTON_NEGATIVE);
            }
        });

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finalSureListener.onClick(finalDialog, DialogInterface.BUTTON_POSITIVE);
            }
        });

        //设置背景透明，去四个角
        Window alertDailogWindow = alertDialog.getWindow();
        alertDailogWindow.setBackgroundDrawableResource(android.R.color.transparent);
        alertDialog.show();
        alertDailogWindow.setLayout(DensityUtils.dip2px(context, 290), LinearLayout.LayoutParams.WRAP_CONTENT);
        alertDialog.setContentView(view);
        return alertDialog;
    }


    /**
     * 协议Dialog
     * @param context        上下文
     * @param str_title      顶部标题
     * @param str_webUrl     网页url
     * @param str_btn        按钮的文字
     * @param str_check      checkBox文字
     * @param iStouchOutSide 点击外部取消
     * @param cancleListener 确定按钮的点击事件
     * @param sureListener   取消按钮的点击事件
     * @param checkListener  checkbox的点击事件
     * @return
     */
    public synchronized static AlertDialog showProtocolDialog(Context context,
                                                              String str_title,
                                                              String str_webUrl,
                                                              String str_btn,
                                                              String str_check,
                                                              boolean iStouchOutSide,
                                                              DialogInterface.OnClickListener cancleListener,
                                                              DialogInterface.OnClickListener sureListener,
                                                              DialogInterface.OnMultiChoiceClickListener checkListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(iStouchOutSide);
        dialog.setCancelable(false);

        // 是否包含标题，设置Title
        if (TextUtils.isEmpty(str_title)) {
            str_title = "提示";
        }
        View view = View.inflate(context, R.layout.alert_dialog_protocol, null);
        //提示框title
        TextView tvTitle = view.findViewById(R.id.alert_tv_title);
        //网页webView
        WebView webView = view.findViewById(R.id.alert_wv);
        //按钮
        final Button button = view.findViewById(R.id.alert_btn);
        //CheckBox的说明文字
        TextView tvCheck = view.findViewById(R.id.alert_tv_check);
        //finish按钮
        ImageView imageView = view.findViewById(R.id.alert_iv_finish);
        //协议选中框
        CheckBox checkBox = view.findViewById(R.id.alert_cb);

        tvTitle.setText(str_title);
        button.setText(TextUtils.isEmpty(str_btn) ? "确定" : str_btn);
        tvCheck.setText(TextUtils.isEmpty(str_check) ? "" : str_check);
        webView.setWebViewClient(new WebViewClient());
        webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        //设置webView里字体大小
        WebSettings settings = webView.getSettings();
        settings.setTextZoom(55);
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        webView.loadUrl(str_webUrl);
        final AlertDialog dialogFinal = dialog;
        final DialogInterface.OnClickListener finalSureListener = sureListener;
        final DialogInterface.OnClickListener finalCancleListener = cancleListener;
        final DialogInterface.OnMultiChoiceClickListener finalCheckListener = checkListener;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalSureListener.onClick(dialogFinal, DialogInterface.BUTTON_POSITIVE);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalCancleListener.onClick(dialogFinal, DialogInterface.BUTTON_NEGATIVE);
            }
        });
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                finalCheckListener.onClick(dialogFinal, 0, isChecked);
                if (isChecked) {
                    button.setEnabled(true);
                } else {
                    button.setEnabled(false);
                }
            }
        });
        //设置背景透明,去四个角
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.show();
        dialog.getWindow().setLayout(DensityUtils.dip2px(context, 290), LinearLayout.LayoutParams.WRAP_CONTENT);
//        dialog.getWindow().setWindowAnimations(R.style.AnimMM);
        dialog.setContentView(view);

        return dialog;
    }


    /**
     *
     * @param context          上下文
     * @param imageUrl         图片url
     * @param touchOutside     点击外部取消
     * @param cancleListener   取消按钮监听
     * @param sureListener     确定按钮监听
     * @return
     */
    public synchronized static AlertDialog showImageDialog(Context context,
                                                           String imageUrl,
                                                           boolean touchOutside,
                                                           DialogInterface.OnClickListener cancleListener,
                                                           DialogInterface.OnClickListener sureListener){

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        AlertDialog alertDialog = builder.create();
        alertDialog.setCanceledOnTouchOutside(touchOutside);
        alertDialog.setCancelable(false);

        View view = View.inflate(context, R.layout.alert_dialog_image, null);
        ImageView iv_sure = view.findViewById(R.id.iv_alert_image_sure);
        ImageView iv_cancle = view.findViewById(R.id.iv_alert_image_cancle);

        if (!TextUtils.isEmpty(imageUrl)){
            Glide.with(context).load(imageUrl).into(iv_sure);
        }

        final AlertDialog dialogFinal = alertDialog;
        final DialogInterface.OnClickListener finalSureListener = sureListener;
        final DialogInterface.OnClickListener finalCancleListener = cancleListener;
        iv_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalSureListener.onClick(dialogFinal, DialogInterface.BUTTON_POSITIVE);
            }
        });
        iv_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalCancleListener.onClick(dialogFinal, DialogInterface.BUTTON_NEGATIVE);
            }
        });
        //设置背景透明,去四个角
        alertDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        alertDialog.show();
        alertDialog.getWindow().setLayout(DensityUtils.dip2px(context, 290), LinearLayout.LayoutParams.WRAP_CONTENT);

        alertDialog.setContentView(view);
        return alertDialog;

    }

    public synchronized static AlertDialog showDialogPickTwo(Context context,
                                                             String title,
                                                             String rb1,
                                                             String rb2,
                                                             int managerNum1,
                                                             int managerNum2,
                                                             final List list1,
                                                             final List list2,
                                                             String btnText,
                                                             boolean touchOutside,
                                                             DialogInterface.OnClickListener cancleListener,
                                                             DialogInterface.OnClickListener sureListener,
                                                             DialogInterface.OnClickListener rv1Listener,
                                                             DialogInterface.OnClickListener rv2Listener,
                                                             DialogInterface.OnMultiChoiceClickListener radioGroupListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(touchOutside);
        dialog.setCancelable(false);

        // 是否包含标题，设置Title
        if (TextUtils.isEmpty(title)) {
            title = "请选择";
        }
        View view = View.inflate(context, R.layout.alert_dialog_pick_two, null);
        //提示框title
        TextView tvTitle = view.findViewById(R.id.tv_pick_title);
        //关闭按钮
        ImageView ivClose=view.findViewById(R.id.iv_pick_close);
        //完成按钮
        final Button btnFinish = view.findViewById(R.id.btn_finish);
        //radioGroup
        RadioGroup radioGroup=view.findViewById(R.id.rg_pick);
        //radioButton
        RadioButton radioButton1=view.findViewById(R.id.rb_first);
        RadioButton radioButton2=view.findViewById(R.id.rb_second);
        //recyclerView
        final RecyclerView recyclerView1=view.findViewById(R.id.rv_pick1);
        final RecyclerView recyclerView2=view.findViewById(R.id.rv_pick2);

        tvTitle.setText(title);
        radioButton1.setText(rb1);
        radioButton1.setChecked(true);
        radioButton2.setText(rb2);
        btnFinish.setText(btnText);

        final AlertDialog dialogFinal = dialog;
        final DialogInterface.OnClickListener finalSureListener = sureListener;
        final DialogInterface.OnClickListener finalCancleListener = cancleListener;
        final DialogInterface.OnClickListener finalRv1Listener = rv1Listener;
        final DialogInterface.OnClickListener finalRv2Listener = rv2Listener;
        final DialogInterface.OnMultiChoiceClickListener finalRgListener = radioGroupListener;
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalSureListener.onClick(dialogFinal, DialogInterface.BUTTON_POSITIVE);
            }
        });

        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalCancleListener.onClick(dialogFinal, DialogInterface.BUTTON_NEGATIVE);
            }
        });

        GridLayoutManager manager1 = new GridLayoutManager(context, managerNum1);
        GridLayoutManager manager2 = new GridLayoutManager(context, managerNum2);
        recyclerView1.setLayoutManager(manager1);
        pick1Adapter = new Pick1Adapter(list1);
        recyclerView1.setAdapter(pick1Adapter);
        recyclerView1.addOnItemTouchListener(new OnItemChildClickListener() {
            @Override
            public void onSimpleItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (view.getId() == R.id.cb_item_pick) {
                    finalRv1Listener.onClick(dialogFinal,position);
                }
            }
        });
        recyclerView2.setLayoutManager(manager2);
        pick2Adapter = new Pick2Adapter(list2);
        recyclerView2.setAdapter(pick2Adapter);
        recyclerView2.addOnItemTouchListener(new OnItemChildClickListener() {
            @Override
            public void onSimpleItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (view.getId() == R.id.cb_item_pick) {
                    finalRv2Listener.onClick(dialogFinal,position);
                }
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                finalRgListener.onClick(dialogFinal,checkedId,true);
                if (checkedId == R.id.rb_first) {
                    recyclerView1.setVisibility(View.VISIBLE);
                    recyclerView2.setVisibility(View.GONE);
                    pick1Adapter.setNewData(list1);
                    pick1Adapter.notifyDataSetChanged();
                }else if(checkedId == R.id.rb_second){
                    recyclerView1.setVisibility(View.GONE);
                    recyclerView2.setVisibility(View.VISIBLE);
                    pick2Adapter.setNewData(list2);
                    pick2Adapter.notifyDataSetChanged();
                }

            }
        });

        //设置背景透明,去四个角
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.show();
        dialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        dialog.setContentView(view);
        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        return dialog;
    }


    /**
     *
     * @param context       上下文
     * @param title         标题
     * @param rb1           radiobutton1的文字
     * @param rb2           radiobutton2的文字
     * @param rb3           radiobutton3的文字
     * @param managerNum1   recyclerView1一行展示的个数
     * @param managerNum2   recyclerView2一行展示的个数
     * @param managerNum3   recyclerView3一行展示的个数
     * @param list1         recyclerView1的列表数据
     * @param list2         recyclerView2的列表数据
     * @param list3         recyclerView3的列表数据
     * @param btnText       按钮文字
     * @param touchOutside  按外部是否可以取消弹窗
     * @param cancleListener 取消按钮监听
     * @param sureListener   完成按钮监听
     * @param rv1Listener    recyclerView1的按钮监听
     * @param rv2Listener    recyclerView2的按钮监听
     * @param rv3Listener    recyclerView3的按钮监听
     * @param radioGroupListener  radioGroup的按钮监听
     * @return
     */
    public synchronized static AlertDialog showDialogPickThree(Context context,
                                                               String title,
                                                               String rb1,
                                                               String rb2,
                                                               String rb3,
                                                               int managerNum1,
                                                               int managerNum2,
                                                               int managerNum3,
                                                               final List list1,
                                                               final List list2,
                                                               final List list3,
                                                               String btnText,
                                                               boolean touchOutside,
                                                               DialogInterface.OnClickListener cancleListener,
                                                               DialogInterface.OnClickListener sureListener,
                                                               DialogInterface.OnClickListener rv1Listener,
                                                               DialogInterface.OnClickListener rv2Listener,
                                                               DialogInterface.OnClickListener rv3Listener,
                                                               DialogInterface.OnMultiChoiceClickListener radioGroupListener){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(touchOutside);
        dialog.setCancelable(false);

        // 是否包含标题，设置Title
        if (TextUtils.isEmpty(title)) {
            title = "请选择";
        }
        View view = View.inflate(context, R.layout.alert_dialog_pick_three, null);
        //提示框title
        TextView tvTitle = view.findViewById(R.id.tv_pick_title);
        //关闭按钮
        ImageView ivClose=view.findViewById(R.id.iv_pick_close);
        //完成按钮
        final Button btnFinish = view.findViewById(R.id.btn_finish);
        //radioGroup
        RadioGroup radioGroup=view.findViewById(R.id.rg_pick);
        //radioButton
        RadioButton radioButton1=view.findViewById(R.id.rb_first);
        RadioButton radioButton2=view.findViewById(R.id.rb_second);
        RadioButton radioButton3=view.findViewById(R.id.rb_third);
        //recyclerView
        final RecyclerView recyclerView1=view.findViewById(R.id.rv_pick1);
        final RecyclerView recyclerView2=view.findViewById(R.id.rv_pick2);
        final RecyclerView recyclerView3=view.findViewById(R.id.rv_pick3);

        tvTitle.setText(title);
        radioButton1.setText(rb1);
        radioButton1.setChecked(true);
        radioButton2.setText(rb2);
        if(TextUtils.isEmpty(rb3)){
            radioButton3.setVisibility(View.GONE);
        }else {
            radioButton3.setText(rb3);
        }
        btnFinish.setText(btnText);

        final AlertDialog dialogFinal = dialog;
        final DialogInterface.OnClickListener finalSureListener = sureListener;
        final DialogInterface.OnClickListener finalCancleListener = cancleListener;
        final DialogInterface.OnClickListener finalRv1Listener = rv1Listener;
        final DialogInterface.OnClickListener finalRv2Listener = rv2Listener;
        final DialogInterface.OnClickListener finalRv3Listener = rv3Listener;
        final DialogInterface.OnMultiChoiceClickListener finalRgListener = radioGroupListener;
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalSureListener.onClick(dialogFinal, DialogInterface.BUTTON_POSITIVE);
            }
        });
        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalCancleListener.onClick(dialogFinal, DialogInterface.BUTTON_NEGATIVE);
            }
        });

        GridLayoutManager manager1 = new GridLayoutManager(context, managerNum1);
        GridLayoutManager manager2 = new GridLayoutManager(context, managerNum2);
        GridLayoutManager manager3 = new GridLayoutManager(context, managerNum3);
        recyclerView1.setLayoutManager(manager1);
        pick1Adapter = new Pick1Adapter(list1);
        recyclerView1.setAdapter(pick1Adapter);
        recyclerView1.addOnItemTouchListener(new OnItemChildClickListener() {
            @Override
            public void onSimpleItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (view.getId() == R.id.cb_item_pick) {
                    finalRv1Listener.onClick(dialogFinal,position);
                }
            }
        });
        recyclerView2.setLayoutManager(manager2);
        pick2Adapter = new Pick2Adapter(list2);
        recyclerView2.setAdapter(pick2Adapter);
        recyclerView2.addOnItemTouchListener(new OnItemChildClickListener() {
            @Override
            public void onSimpleItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (view.getId() == R.id.cb_item_pick) {
                    finalRv2Listener.onClick(dialogFinal,position);
                }
            }
        });
        recyclerView3.setLayoutManager(manager3);
        pick3Adapter = new Pick3Adapter(list3);
        recyclerView3.setAdapter(pick3Adapter);
        recyclerView3.addOnItemTouchListener(new OnItemChildClickListener() {
            @Override
            public void onSimpleItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (view.getId() == R.id.cb_item_pick) {
                    finalRv3Listener.onClick(dialogFinal,position);
                }
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                finalRgListener.onClick(dialogFinal,checkedId,true);
                if (checkedId == R.id.rb_first) {
                    recyclerView1.setVisibility(View.VISIBLE);
                    recyclerView2.setVisibility(View.GONE);
                    recyclerView3.setVisibility(View.GONE);
                    pick1Adapter.setNewData(list1);
                    pick1Adapter.notifyDataSetChanged();
                }else if(checkedId == R.id.rb_second){
                    recyclerView1.setVisibility(View.GONE);
                    recyclerView2.setVisibility(View.VISIBLE);
                    recyclerView3.setVisibility(View.GONE);
                    pick2Adapter.setNewData(list2);
                    pick2Adapter.notifyDataSetChanged();
                }else if(checkedId == R.id.rb_third){
                    recyclerView1.setVisibility(View.GONE);
                    recyclerView2.setVisibility(View.GONE);
                    recyclerView3.setVisibility(View.VISIBLE);
                    pick3Adapter.setNewData(list3);
                    pick3Adapter.notifyDataSetChanged();
                }

            }
        });

        //设置背景透明,去四个角
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.show();
        dialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        dialog.setContentView(view);

        Window window = dialog.getWindow();
        window.setGravity(Gravity.CENTER);
        return dialog;
    }

}
