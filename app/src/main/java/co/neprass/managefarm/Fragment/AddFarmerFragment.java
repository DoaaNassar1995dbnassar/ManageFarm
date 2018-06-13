package co.neprass.managefarm.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.neprass.managefarm.R;
import co.neprass.managefarm.view.FontTextViewRegular;


public class AddFarmerFragment extends Fragment {

    View view;
    FontTextViewRegular crop, visit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_add_frarmer, container, false);
        crop = view.findViewById(R.id.crop);
        visit = view.findViewById(R.id.visit);


        Fragment fragment = new ShowCropFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.farmListContainer, fragment).commit();

        crop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment = new ShowCropFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.farmListContainer, fragment).commit();
                crop.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                visit.setBackgroundColor(getResources().getColor(R.color.white));

            }
        });

        visit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment = new LocalFarmFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.farmListContainer, fragment).commit();
                crop.setBackgroundColor(getResources().getColor(R.color.white));
                visit.setBackgroundColor(getResources().getColor(R.color.colorAccent));

            }
        });

        // Inflate the layout for this fragment
        return view;
    }

}
