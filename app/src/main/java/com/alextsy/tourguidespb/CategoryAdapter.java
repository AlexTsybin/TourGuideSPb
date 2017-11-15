package com.alextsy.tourguidespb;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by os_mac on 29.10.17.
 */

public class CategoryAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ParksFragment();
            case 1:
                return new TheatersFragment();
            case 2:
                return new PlacesFragment();
            case 3:
                return new CafesFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.category_parks);
            case 1:
                return mContext.getString(R.string.category_theaters);
            case 2:
                return mContext.getString(R.string.category_places);
            case 3:
                return mContext.getString(R.string.category_cafes);
            default:
                return null;
        }
    }

}
