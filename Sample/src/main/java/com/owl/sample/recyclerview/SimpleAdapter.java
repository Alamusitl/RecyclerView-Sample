package com.owl.sample.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Alamusi on 2017/5/11.
 */

public class SimpleAdapter extends RecyclerView.Adapter<MyViewHolder> {

    protected List<String> mDataList;
    private LayoutInflater mLayoutInflater;
    private OnItemClickListener mOnItemClickListener;

    public SimpleAdapter(Context context, List<String> dataList) {
        mDataList = dataList;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_single_text_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.mTextView.setText(mDataList.get(position));
        setUpItemEvent(holder);
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public void addData(int pos) {
        mDataList.add(pos, "Insert One");
        notifyItemInserted(pos);
    }

    public void deleteData(int pos) {
        mDataList.remove(pos);
        notifyItemRemoved(pos);
    }

    public void setUpItemEvent(final MyViewHolder holder) {
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClick(v, holder.getAdapterPosition());
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mOnItemClickListener.onItemLongClick(v, holder.getAdapterPosition());
                    return false;
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {

    TextView mTextView;

    public MyViewHolder(View itemView) {
        super(itemView);

        mTextView = (TextView) itemView.findViewById(R.id.id_tv);
    }
}
