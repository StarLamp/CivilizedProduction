package com.example.administrator.civilizedproduction.model;

import java.util.Date;
import java.util.UUID;

public class Crime {

    private String mExpalin;
    private String mDepartmentName;
    private String mUrlPicture;
    private String mTitle;
    private int mark;
    private UUID mId;

    public String getmExpalin() {
        return mExpalin;
    }

    public void setmExpalin(String mExpalin) {
        this.mExpalin = mExpalin;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmUrlPicture() {
        return mUrlPicture;
    }

    public void setmUrlPicture(String mUrlPicture) {
        this.mUrlPicture = mUrlPicture;
    }
    public UUID getmId() {
        return mId;
    }

    public void setmId(UUID mId) {
        this.mId = mId;
    }


    public String getmDepartmentName() {
        return mDepartmentName;
    }

    public void setmDepartmentName(String mDepartmentName) {
        this.mDepartmentName = mDepartmentName;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Crime(){
        //生成唯一的标识量
        mId =UUID.randomUUID();
    }

}
