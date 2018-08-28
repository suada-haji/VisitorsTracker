package com.haji.suada.visitorstracker.model.db;

import android.arch.lifecycle.LiveData;

import com.haji.suada.visitorstracker.model.data.Visitor;

import java.util.List;

public class DataRepository {

    private final LiveData<List<Visitor>> visitorLiveData;
    private VisitorDao visitorDao;

    DataRepository(AppDatabase database) {
        visitorDao = database.visitorDao();
        visitorLiveData = database.visitorDao().getAllVisitors();
    }

    public void insertVisitor(Visitor visitor) {
        visitorDao.insertVisitor(visitor);
    }

    public void deleteVisitor(Visitor visitor) {
        visitorDao.deleteVisitor(visitor);
    }

    public LiveData<List<Visitor>> getVisitorLiveData() {
        return visitorLiveData;
    }
}
