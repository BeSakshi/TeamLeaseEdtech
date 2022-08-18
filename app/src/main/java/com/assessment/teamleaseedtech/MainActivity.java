package com.assessment.teamleaseedtech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.assessment.teamleaseedtech.adapter.EmployeeAdapter;
import com.assessment.teamleaseedtech.model.EmployeeParams;
import com.assessment.teamleaseedtech.retofitservice.RestService;
import com.assessment.teamleaseedtech.retofitservice.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    EmployeeAdapter recyclerViewAdapter;
    List<EmployeeParams.EmployeeData> employeeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.employeeRecyclerView);
        showData();
    }

    private void showData() {
        RestService retrofitAPI = RetrofitInstance.getApiService();
        Call<EmployeeParams> call = retrofitAPI.getEmployeeList();
        call.enqueue(new Callback<EmployeeParams>() {
            @Override
            public void onResponse(Call<EmployeeParams> call, Response<EmployeeParams> response) {
                EmployeeParams responseFromAPI = response.body();
                if (responseFromAPI != null) {
                    employeeList = responseFromAPI.getEmployee();
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    recyclerViewAdapter = new EmployeeAdapter(employeeList, MainActivity.this);
                    recyclerView.setAdapter(recyclerViewAdapter);
                }
            }

            @Override
            public void onFailure(Call<EmployeeParams> call, Throwable t) {
                //Toast.makeText(MainActivity.this, ""+t, Toast.LENGTH_SHORT).show();
            }
        });
    }

}