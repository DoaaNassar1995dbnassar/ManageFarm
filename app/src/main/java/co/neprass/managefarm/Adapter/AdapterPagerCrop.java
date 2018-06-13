package co.neprass.managefarm.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import co.neprass.managefarm.Fragment.AddAnimalFragment;
import co.neprass.managefarm.Fragment.AddMainCropFragment;
import co.neprass.managefarm.Fragment.BeeFragment;
import co.neprass.managefarm.Fragment.ChickenFragment;
import co.neprass.managefarm.Fragment.CropInPagerFragment;
import co.neprass.managefarm.Fragment.FieldsCropFragment;
import co.neprass.managefarm.Fragment.IrrigationFragment;
import co.neprass.managefarm.Fragment.IrrigationSourcesFragment;
import co.neprass.managefarm.Fragment.MaterialFragment;
import co.neprass.managefarm.Fragment.OtherFragment;
import co.neprass.managefarm.Fragment.PlaceFragment;
import co.neprass.managefarm.Fragment.ShowFragment;
import co.neprass.managefarm.Fragment.TreeFragment;
import co.neprass.managefarm.Fragment.VegetableFragment;
import co.neprass.managefarm.Fragment.WorkerFragment;




public class AdapterPagerCrop extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 11;
    Fragment fragment ;

    public AdapterPagerCrop(FragmentManager fragmentManager) {
        super(fragmentManager);
    }


    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                fragment = new AddMainCropFragment();
                return fragment;
            case 1:
                fragment = new IrrigationFragment();
                return fragment;
            case 2:
                fragment = new PlaceFragment();
                return fragment;
            case 3:
                fragment = new IrrigationSourcesFragment();
                return fragment;
            case 4:
                fragment = new FieldsCropFragment();
                return fragment;
            case 5:
                fragment = new VegetableFragment();
                return fragment;
            case 6:
                fragment = new TreeFragment();
                return fragment;
            case 7:
                fragment = new AddAnimalFragment();
                return fragment;
            case 8:
                fragment = new ChickenFragment();
                return fragment;
            case 9:
                fragment = new OtherFragment();
                return fragment;
            case 10:
                fragment = new BeeFragment();
                return fragment;
            default:
                return null;
        }
    }
}