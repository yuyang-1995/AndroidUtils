package com.yuy.androidutils.uiutils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yuy.androidutils.R;
import com.yuy.androidutils.uiutils.poputils.DensityUtils;
import com.yuy.androidutils.uiutils.poputils.YPopupWindow;

/**
 * Author: yuyang
 * Date:2019/9/21 15:03
 * Description:
 * Version:
 */
public class YPopWindowUtils implements YPopupWindow.ViewInterface {

    private static YPopupWindow popupWindow;
    private static String mText1;
    private static String mText2;

    @Override
    public void getChildView(View view, int layoutResId) {
        //获得PopupWindow布局里的View
        if (layoutResId == R.layout.popup_item) {
            TextView textView1 = view.findViewById(R.id.popup_text1);
            TextView textView2 = view.findViewById(R.id.popup_text2);
            textView1.setText(mText1);
            textView2.setText(mText2);
        }
    }


    //向下弹出
    public synchronized void showDownPop(Context context, View view, String titletext, String contenttext, int dpX, int dpY) {
        if (popupWindow != null && popupWindow.isShowing()) return;
        mText1=titletext;
        mText2=contenttext;
        popupWindow = new YPopupWindow.Builder(context)
                .setView(R.layout.popup_item)
                .setWidthAndHeight(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                .setBackGroundLevel(0.6f)
                .setAnimationStyle(R.style.AnimDown)
                .setOutsideTouchable(true)
                .setViewOnclickListener(this)
                .create();

        popupWindow.showAsDropDown(view, DensityUtils.dip2px(context, dpX),dpY);

    }



}
