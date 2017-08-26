package com.trivia_game.android.seattleguide;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        //find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        //Create an adapter that knows which fragment should be shown on each page
        CategoryAdapter adapter = new CategoryAdapter(this, getSupportFragmentManager());

        //set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        //find the tab layout that shows the tabls
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        //connect the tab layout with the view pager. This will
        // 1. Update the tab layout when the view pager is swiper
        // 2. Update the view pager when a tab is selected
        // 3. Set the tab layout's tab name when the view pager's adapter's titles
        //    by calling onPageTitle()
        tabLayout.setupWithViewPager(viewPager);
    }
}
