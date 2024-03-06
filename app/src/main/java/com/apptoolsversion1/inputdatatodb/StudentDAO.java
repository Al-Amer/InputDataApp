package com.apptoolsversion1.inputdatatodb;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Index;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface StudentDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert (Student student);

    @Delete
    void delete (Student student);

    @Query("SELECT * FROM Student")
    List<Student> getAllStudents();

}
