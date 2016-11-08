package com.example.shanu.toolbar;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.UUID;

public class ViewPagerActivity extends AppCompatActivity {
    ViewPager mViewPager;
    public static final String TO_DO_ID = "unique id for each task";
    private List<TO_DO> mto_do_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        final int list_positon=getIntent().getIntExtra(TO_DO_ID,-1);
        mto_do_list = Data_source.get(this).getTo_do();

       mViewPager=(ViewPager)findViewById(R.id.detail_view_pager);
        FragmentManager fm = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fm)
        {

            @Override
            public int getCount() {
              return   mto_do_list.size();
            }

            @Override
            public Fragment getItem(int position) {
                TO_DO to_do=mto_do_list.get(position);
                return DetailFragment.newInstance(position);


            }
        });
         mViewPager.setCurrentItem(list_positon);


    }
}

