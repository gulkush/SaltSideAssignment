package com.softkoki.saltsideassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.softkoki.saltsideassignment.adapter.MyRVAdapter;
import com.softkoki.saltsideassignment.model.MyImage;
import com.softkoki.saltsideassignment.service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressBar pb;
    MyRVAdapter adapter;
    List<MyImage> images = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        pb = (ProgressBar)findViewById(R.id.pb);
        adapter = new MyRVAdapter(images);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        fetchData();



    }

    private void fetchData() {
        pb.setVisibility(View.VISIBLE);
        Call<List<MyImage>> call = new DataService(getBaseContext()).getAPI().getData();
        call.enqueue(new Callback<List<MyImage>>() {
            @Override
            public void onResponse(Call<List<MyImage>> call, Response<List<MyImage>> response) {
                pb.setVisibility(View.GONE);
                images.clear();
                images.addAll(response.body());
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, String.valueOf(images.size()), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<MyImage>> call, Throwable t) {
                pb.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "onFailure: " + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
