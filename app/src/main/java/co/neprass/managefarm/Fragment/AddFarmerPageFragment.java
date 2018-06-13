package co.neprass.managefarm.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.neprass.managefarm.Adapter.ViewPagerAdapter;
import co.neprass.managefarm.R;
import me.relex.circleindicator.CircleIndicator;


public class AddFarmerPageFragment extends Fragment {


    View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_add_farmer_page, container, false);
        CircleIndicator indicator = (CircleIndicator) view.findViewById(R.id.indicator);


        ViewPager viewPager = view.findViewById(R.id.pager);
        viewPager.setAdapter(new ViewPagerAdapter(getChildFragmentManager()));
        indicator.setViewPager(viewPager);





        return view;
    }

}
