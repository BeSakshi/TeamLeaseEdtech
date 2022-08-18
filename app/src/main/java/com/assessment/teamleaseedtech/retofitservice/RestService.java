package com.assessment.teamleaseedtech.retofitservice;

import com.assessment.teamleaseedtech.model.EmployeeParams;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestService {
    @GET("/employees")
    Call<EmployeeParams> getEmployeeList();
}
