package co.neprass.managefarm.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import co.neprass.managefarm.Fragment.ApplicationFragment;
import co.neprass.managefarm.Fragment.CropInPagerFragment;
import co.neprass.managefarm.Fragment.MaterialFragment;
import co.neprass.managefarm.Fragment.ShowFragment;
import co.neprass.managefarm.Fragment.WorkerFragment;

/**
 * Created by AL-Qema on 31/05/18.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 5;
    Fragment fragment ;

    public ViewPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                fragment = new ShowFragment();
                return fragment;
            case 1:
                fragment = new MaterialFragment();
                return fragment;
            case 2:
                fragment = new WorkerFragment();
                return fragment;
            case 3:
                fragment = new CropInPagerFragment();
                return fragment;
            case 4:
                fragment = new ApplicationFragment();
                return fragment;
            default:
                return null;
        }
    }
}