package com.haji.suada.visitorstracker.model.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.haji.suada.visitorstracker.model.data.Visitor;

@Database(entities = Visitor.class, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract VisitorDao visitorDao();
}
