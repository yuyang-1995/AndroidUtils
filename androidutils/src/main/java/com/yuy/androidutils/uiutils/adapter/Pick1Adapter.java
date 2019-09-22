package com.yuy.androidutils.uiutils.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yuy.androidutils.R;
import com.yuy.androidutils.uiutils.entity.PickEntity;

import java.util.List;

/**
 * Author: yuyang
 * Date:2019/9/21 15:37
 * Description:
 * Version:
 */
public class Pick1Adapter extends BaseQuickAdapter<PickEntity.RestbodyBean.Higher1LevelBean, BaseViewHolder> {

    public Pick1Adapter(@Nullable List<PickEntity.RestbodyBean.Higher1LevelBean> data) {
        super(R.layout.item_pick, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, PickEntity.RestbodyBean.Higher1LevelBean data) {
        //将每一个需要赋值的id和对应的数据绑定
        helper.setText(R.id.cb_item_pick, data.getName());
        if(data.isChecked()){
            helper.setChecked(R.id.cb_item_pick,true);
        }else {
            helper.setChecked(R.id.cb_item_pick,false);
        }

        //设置title的点击监听
        helper.addOnClickListener(R.id.cb_item_pick);
    }
}