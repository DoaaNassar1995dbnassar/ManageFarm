package co.neprass.managefarm.Activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;

import co.neprass.managefarm.Adapter.AdapterPagerCrop;
import co.neprass.managefarm.Adapter.ViewPagerAdapter;
import co.neprass.managefarm.R;
import me.relex.circleindicator.CircleIndicator;


public class CropFragment extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_crop);
        CircleIndicator indicator = (CircleIndicator)findViewById(R.id.indicator);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        viewPager.setAdapter(new AdapterPagerCrop(getSupportFragmentManager()));
        indicator.setViewPager(viewPager);

    }

}