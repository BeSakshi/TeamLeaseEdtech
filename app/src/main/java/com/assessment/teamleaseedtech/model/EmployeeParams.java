package com.assessment.teamleaseedtech.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EmployeeParams {

    @SerializedName("data")
    private List<EmployeeData> mData;

    @SerializedName("message")
    private String mMessage;

    @SerializedName("status")
    private String mStatus;

    public class EmployeeData {
        @SerializedName("id")
        private String id;

        @SerializedName("employee_name")
        private String employee_name;

        @SerializedName("employee_salary")
        private String employee_salary;

        @SerializedName("employee_age")
        private String employee_age;

        @SerializedName("profile_image")
        private String profile_image;


        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return employee_name;
        }

        public void setName(String employee_name) {
            this.employee_name = employee_name;
        }

        public String getSalary() {
            return employee_salary;
        }

        public void setSalary(String employee_salary) {
            this.employee_salary = employee_salary;
        }

        public String getAge() {
            return employee_age;
        }

        public void setAge(String employee_age) {
            this.employee_age = employee_age;
        }

        public String getImage() {
            return profile_image;
        }

        public void setImage(String profile_image) {
            this.profile_image = profile_image;
        }

    }

    public List<EmployeeData> getEmployee() {
        return mData;
    }

    public void setEmployee(List<EmployeeData> data) {
        mData = data;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }
}
