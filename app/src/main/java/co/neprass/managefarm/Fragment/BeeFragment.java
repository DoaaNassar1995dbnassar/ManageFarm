package co.neprass.managefarm.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.neprass.managefarm.R;

public class BeeFragment extends Fragment {

    View view ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_bee, container, false);

        final ViewPager viewPager = getActivity().findViewById(R.id.viewpager);
//        view.findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int s = viewPager.getCurrentItem() + 1;
//                viewPager.setCurrentItem(s);
//            }
//        });

        // Inflate the layout for this fragment
        return view ;
    }


}
