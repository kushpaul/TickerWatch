package com.example.kushpaul.tickerwatch;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.util.Pair;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PagerActivity extends AppCompatActivity {
    private ArrayList<Pair<String,Fragment>> list = new ArrayList<Pair<String,Fragment>>();
    @BindView(R.id.activity_advance_view_pager_tablayout)
    TabLayout tablayout;

    @BindView(R.id.activity_advance_view_pager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance_view_pager);
        ButterKnife.bind(this);
        list.add(new Pair<String, Fragment>("News",new RedFragment()));
        list.add(new Pair<String, Fragment>("More",new GreenFragment()));
        list.add(new Pair<String, Fragment>("More+",new BlueFragment()));
        ViewFragmentStateAdapter adapter = new ViewFragmentStateAdapter(this.getSupportFragmentManager(),list);
        viewPager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewPager);
    }
}

