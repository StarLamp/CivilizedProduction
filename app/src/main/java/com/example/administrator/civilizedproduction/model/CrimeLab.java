package com.example.administrator.civilizedproduction.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

public class CrimeLab {
    private static CrimeLab sCrimeLab;
    private Context mAppContext;
    private ArrayList<Crime> mCrimes;

    private  CrimeLab(Context appContext){
        mAppContext = appContext;
        mCrimes = new ArrayList<Crime>();
        for (int i =0 ;i<100;i++){
            Crime c = new Crime();
            c.setMark(i%2);
            c.setmDepartmentName("hello world");
            c.setmExpalin("very good");
            c.setmUrlPicture("");
            mCrimes.add(c);
        }
    }
    public static  CrimeLab get(Context c){
        if (sCrimeLab ==null){
            new CrimeLab(c.getApplicationContext()).getmCrimes();
        }
        return sCrimeLab;
    }

    public ArrayList<Crime> getmCrimes() {
        return mCrimes;
    }




    public Crime getCrime(UUID id){
        for (Crime c : mCrimes){
            if (c.getmId().equals(id)){
                return c;
            }
        }
        return null;
    }

}
