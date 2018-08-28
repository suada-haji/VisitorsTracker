package com.haji.suada.visitorstracker.model.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Visitor {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "visitor_name")
    private String visitorName;
    @ColumnInfo(name = "phone_number")
    private String phoneNumber;
    @ColumnInfo(name = "visiting_who")
    private String visitingWho;

    public Visitor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getVisitingWho() {
        return visitingWho;
    }

    public void setVisitingWho(String visitingWho) {
        this.visitingWho = visitingWho;
    }
}
