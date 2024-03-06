package com.apptoolsversion1.inputdatatodb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    private List<Student> studentList;

    public StudentAdapter(List<Student> list){
        studentList = list ;
    }

    public void setList(List<Student> list){
        studentList = list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view, null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int index) {
        viewHolder.name.setText(studentList.get(index).getName());
        viewHolder.major.setText(studentList.get(index).getMajor());
    }

    @Override
    public int getItemCount() {
        return ( studentList == null ) ? 0 : studentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView name, major;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            major = itemView.findViewById(R.id.major);
        }
    }


}
