package com.apptoolsversion1.inputdatatodb;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = Student.class, version = 1)
public abstract class StudentDB extends RoomDatabase {
    public abstract StudentDAO studentDAO();
}
