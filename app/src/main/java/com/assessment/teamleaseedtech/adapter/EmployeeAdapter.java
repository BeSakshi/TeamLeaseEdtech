package com.assessment.teamleaseedtech.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.assessment.teamleaseedtech.R;
import com.assessment.teamleaseedtech.model.EmployeeParams;


import java.util.List;
import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {
    private final List<EmployeeParams.EmployeeData> employeeLists;
    private final Context context;

    public EmployeeAdapter(List<EmployeeParams.EmployeeData> employeeLists, Context context) {
        this.employeeLists = employeeLists;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.employee_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        EmployeeParams.EmployeeData employeeList = Objects.requireNonNull(employeeLists.get(position));
        holder.name.setText(employeeList.getName());
        holder.salary.setText(employeeList.getSalary());
        holder.age.setText(employeeList.getAge());
        holder.id.setText(employeeList.getId());
    }

    @Override
    public int getItemCount() {
        return employeeLists.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public TextView salary,age,id;
        CircleImageView imageView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            salary = itemView.findViewById(R.id.salary);
            age = itemView.findViewById(R.id.age);
            id = itemView.findViewById(R.id.id);
            imageView = itemView.findViewById(R.id.profile_image);

        }

    }
}
