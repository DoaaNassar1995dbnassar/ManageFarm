package co.neprass.managefarm.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.neprass.managefarm.Activity.CropFragment;
import co.neprass.managefarm.Activity.LoginFragment;
import co.neprass.managefarm.Activity.SplashActivity;
import co.neprass.managefarm.R;


public class CropInPagerFragment extends Fragment {

    View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_crop_in_pager, container, false);
        final ViewPager viewPager = getActivity().findViewById(R.id.pager);
        view.findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int s = viewPager.getCurrentItem() + 1;
                viewPager.setCurrentItem(s);
            }
        });
        view.findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent refresh = new Intent(getActivity(), CropFragment.class);
                startActivity(refresh);
            }
        });
        // Inflate the layout for this fragment
        return view ;
    }
}