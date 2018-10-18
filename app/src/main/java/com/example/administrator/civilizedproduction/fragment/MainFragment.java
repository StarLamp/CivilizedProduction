package com.example.administrator.civilizedproduction.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.administrator.civilizedproduction.R;
import com.example.administrator.civilizedproduction.model.Crime;
import com.example.administrator.civilizedproduction.model.CrimeLab;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends ListFragment {

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main,container,false);
        init();
        ArrayList<Crime> mCrimes = CrimeLab.get(getContext()).getmCrimes();
        CrimeAdapter crimeAdapter = new CrimeAdapter(mCrimes);
        setListAdapter(crimeAdapter);
        return v;

    }
    protected void init(){
        ImageButton CrameButton = (ImageButton)getView().findViewById(R.id.takeCarme);
        CrameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    private class CrimeAdapter extends ArrayAdapter<Crime>{
        public CrimeAdapter(ArrayList<Crime> crimes){
            super(getActivity(),0,crimes);
        }


        @Override
        public View getView(int position,  View convertView,  ViewGroup parent) {
            //如果没有生成view，创建一个新的view
            if (convertView==null){
                convertView = getActivity().getLayoutInflater()
                        .inflate(R.layout.fragment_main,null);
            }
            //设置视图显示列表
            Crime c = getItem(position);
            TextView expalinTextView = (TextView) convertView.findViewById(R.id.crime_explain);
            expalinTextView.setText(c.getmExpalin());
            TextView departTextView =(TextView) convertView.findViewById(R.id.crime_department);
            departTextView.setText(c.getmDepartmentName());
            TextView markTextView = (TextView)convertView.findViewById(R.id.crime_mark);
            markTextView.setText(c.getMark());
            return convertView;
        }
    }
}
