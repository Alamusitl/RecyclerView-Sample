package com.owl.sample.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class StaggeredGridLayoutActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private List<String> mDataList;

    private StaggeredAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        intiView();

        mAdapter = new StaggeredAdapter(this, mDataList);
        mRecyclerView.setAdapter(mAdapter);
        // 设置RecyclerView的布局管理
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mAdapter.setOnItemClickListener(new SimpleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }

            @Override
            public void onItemLongClick(View view, int position) {
                mAdapter.deleteData(position);
            }
        });

        // 设置RecyclerView的Item间分割线
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, mLinearLayoutManager.getOrientation()));
    }

    private void initData() {
        mDataList = new ArrayList<>();
        for (int i = 'A'; i < 'z'; i++) {
            mDataList.add("" + (char) i);
        }
    }

    private void intiView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_add:
                mAdapter.addData(1);
                break;
            case R.id.action_delete:
                mAdapter.deleteData(1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
