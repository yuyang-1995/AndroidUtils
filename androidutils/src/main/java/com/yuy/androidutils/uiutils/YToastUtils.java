package com.yuy.androidutils.uiutils;

import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.yuy.androidutils.R;

/**
 * Author: yuyang
 * Date:2019/9/21 14:00
 * Description:
 * Version:
 */
public class YToastUtils extends Toast{

    public YToastUtils(Context context) {
        super(context);
    }

    public static class Builder{
        private Context context;
        private String message;
        private boolean isSuccess = true;

        public Builder(Context context){
            this.context = context;
        }

        /**
         * 设置toast的内容
         *
         * @param message
         * @return
         */
        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        /**
         * 是否是显示成功的toast，true:成功 false:失败
         *
         * @param isSuccess
         * @return
         */
        public Builder setSuccess(boolean isSuccess) {
            this.isSuccess = isSuccess;
            return this;
        }

        public YToastUtils create(){
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            View view = layoutInflater.inflate(R.layout.dialog_toast,null);

            YToastUtils yuYToast = new YToastUtils(context);
            TextView msgText = view.findViewById(R.id.t_text);
            ImageView imageView = view.findViewById(R.id.t_image);
            if (!TextUtils.isEmpty(message)){
                msgText.setText(message);
            }

            if (isSuccess){
                imageView.setImageResource(R.drawable.ic_success);
            }else {
                imageView.setImageResource(R.drawable.ic_failure);
            }

            yuYToast.setView(view);
            //设置时间
            yuYToast.setDuration(Toast.LENGTH_SHORT);
            //设置重心
            yuYToast.setGravity(Gravity.BOTTOM, 0, 0);

            return yuYToast;
        }
    }

}
