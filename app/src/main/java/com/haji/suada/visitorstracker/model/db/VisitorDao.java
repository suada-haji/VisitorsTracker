package com.haji.suada.visitorstracker.model.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.haji.suada.visitorstracker.model.data.Visitor;

import java.util.List;

@Dao
public interface VisitorDao {
    @Query("SELECT * FROM visitor")
    LiveData<List<Visitor>> getAllVisitors();

    @Insert
    void insertVisitor(Visitor visitor);

    @Delete
    void deleteVisitor(Visitor visitor);

}
