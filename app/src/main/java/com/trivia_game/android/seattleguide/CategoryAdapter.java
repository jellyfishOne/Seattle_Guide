package com.trivia_game.android.seattleguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by JuanRenteria on 8/23/17.
 */

public class CategoryAdapter extends FragmentPagerAdapter{

    private Context mContext;

    /**
     * Create a new CategoryAdapter object
     *
     * @param fm is the fragment manager that will keep each fragment's state in
     *           the adapter accross swipes
     */
    public CategoryAdapter(Context context, FragmentManager fm){
        super(fm);
        mContext = context;
    }

    /**
     * Return the Fragment that should be displayed for the given page number
     */
    @Override
    public Fragment getItem(int position){
        if(position == 0){
            return new FoodFragment();
        } else if(position == 1){
            return new TouristyFragment();
        } else if(position == 2){
            return new BeersFragment();
        } else {
            return new HikingFragment();
        }
    }

    /**
     * Return the total number of pages
     */
    @Override
    public int getCount(){
        return 4;
    }

    /**
     * Return the title that should be displayed for the given Fragment
     * @param position is the position of the current Fragment
     */
    @Override
    public CharSequence getPageTitle(int position){
        if(position == 0){
            return mContext.getString(R.string.category_food);
        } else if(position == 1){
            return mContext.getString(R.string.category_attractions);
        } else if(position == 2){
            return mContext.getString(R.string.category_beers);
        } else{
            return mContext.getString(R.string.category_hiking);
        }
    }

}
