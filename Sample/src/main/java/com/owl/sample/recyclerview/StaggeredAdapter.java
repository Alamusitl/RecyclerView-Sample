package com.owl.sample.recyclerview;

import android.content.Context;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alamusi on 2017/5/11.
 */
public class StaggeredAdapter extends SimpleAdapter {

    private List<Integer> mHeights;

    public StaggeredAdapter(Context context, List<String> dataList) {
        super(context, dataList);
        mHeights = new ArrayList<>();
        for (int i = 0; i < dataList.size(); i++) {
            mHeights.add((int) (100 + Math.random() * 300));
        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
        lp.height = mHeights.get(position);
        holder.itemView.setLayoutParams(lp);
        holder.mTextView.setText(mDataList.get(position));
        setUpItemEvent(holder);
    }
}
