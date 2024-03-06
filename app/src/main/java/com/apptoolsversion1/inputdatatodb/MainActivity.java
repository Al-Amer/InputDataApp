package com.apptoolsversion1.inputdatatodb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private StudentAdapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recyclerview);
        swipeRefreshLayout = findViewById(R.id.swipe_to_refresh);
        adapter = new StudentAdapter(StudentRepository.getInstance().getStudents());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(adapter);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                adapter.setList(StudentRepository.getInstance().getStudents());
                adapter.notifyDataSetChanged();

                swipeRefreshLayout.setRefreshing(false);
            }
        });


        }
}