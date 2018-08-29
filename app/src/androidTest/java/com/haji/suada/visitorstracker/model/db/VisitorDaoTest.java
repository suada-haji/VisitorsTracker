package com.haji.suada.visitorstracker.model.db;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.persistence.room.Room;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.haji.suada.visitorstracker.LiveDataTestUtil;
import com.haji.suada.visitorstracker.TestDataGenerator;
import com.haji.suada.visitorstracker.model.data.Visitor;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class VisitorDaoTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private AppDatabase mDatabase;

    private VisitorDao visitorDao;

    @Before
    public void setUp() throws Exception {
        mDatabase = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(),
                AppDatabase.class)
                .allowMainThreadQueries()
                .build();
        visitorDao = mDatabase.visitorDao();
    }

    @After
    public void tearDown() throws Exception {
        mDatabase.close();
    }

    @Test
    public void onFetchingVisitors_shouldGetEmptyList_IfTable_IsEmpty() throws InterruptedException {
        List<Visitor> noteList = LiveDataTestUtil.getValue(visitorDao.getAllVisitors());
        assertTrue(noteList.isEmpty());
    }
    @Test
    public void onInsertingVisitor_checkIf_RowCountIsCorrect() throws InterruptedException {
        List<Visitor> visitors = TestDataGenerator.generateVisitorList(4);
        visitors.forEach(visitor -> {
            visitorDao.insertVisitor(visitor);
        });

        assertEquals(4, LiveDataTestUtil.getValue(visitorDao.getAllVisitors()).size());
    }
}