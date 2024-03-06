package com.apptoolsversion1.inputdatatodb;

import android.os.AsyncTask;

import androidx.room.Room;

import java.security.AccessController;
import java.util.List;

public class StudentRepository {

    private static StudentRepository  repository = new StudentRepository();
    private static StudentDB studentDB;


    public StudentRepository() {
        initDB();
    }
    public static StudentRepository getInstance(){
        return repository;
    }

    private void initDB() {
        studentDB = Room.databaseBuilder(DatabaseDebugApplication.getContext(),
                StudentDB.class, "StudentDatabase").build();
    }

    public List<Student> getStudents(){
        try {
            return new DataBaseOperation().execute().get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    class DataBaseOperation extends AsyncTask<Void,Void,List<Student>> {

        @Override
        protected List<Student> doInBackground(Void... voids) {
            return studentDB.studentDAO().getAllStudents();
        }
    }
}
