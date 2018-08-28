package com.haji.suada.visitorstracker.model.db;

import android.arch.lifecycle.LiveData;

import com.haji.suada.visitorstracker.model.data.Visitor;

import java.util.List;

import javax.inject.Inject;

public class DataRepository {

    private final LiveData<List<Visitor>> visitorLiveData;
    private VisitorDao visitorDao;

    @Inject
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
