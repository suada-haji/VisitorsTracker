package com.haji.suada.visitorstracker.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.haji.suada.visitorstracker.model.data.Visitor;
import com.haji.suada.visitorstracker.model.db.DataRepository;

import java.util.List;

import javax.inject.Inject;

public class VisitorViewModel extends ViewModel {
    private final DataRepository repository;

    @Inject
    VisitorViewModel(DataRepository dataRepository) {
        this.repository = dataRepository;
    }

    public void insert(Visitor visitor) {
        repository.insertVisitor(visitor);
    }

    public LiveData<List<Visitor>> getVisitors() {
        return repository.getVisitorLiveData();
    }

    public void delete(Visitor visitor) {
        repository.deleteVisitor(visitor);
    }
}
