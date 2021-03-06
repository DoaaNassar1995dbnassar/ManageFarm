package co.neprass.managefarm.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import co.neprass.managefarm.Adapter.MaterialAdapter;
import co.neprass.managefarm.Adapter.ShowCropAdapter;
import co.neprass.managefarm.Interface.CustomItemClickListener;
import co.neprass.managefarm.Objects.AddFarmObject;
import co.neprass.managefarm.R;

public class ShowCropFragment extends Fragment {


    View view;
    RecyclerView recyclerView;
    ShowCropAdapter showCropAdapter;
    List<AddFarmObject> farmList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        farmList = new ArrayList<>();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_show_crop, container, false);
        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        farmList.add(new AddFarmObject("name","","","","",""));
        farmList.add(new AddFarmObject("name","","","","",""));
        farmList.add(new AddFarmObject("name","","","","",""));
        farmList.add(new AddFarmObject("name","","","","",""));
        farmList.add(new AddFarmObject("name","","","","",""));
        farmList.add(new AddFarmObject("name","","","","",""));
        farmList.add(new AddFarmObject("name","","","","",""));
        farmList.add(new AddFarmObject("name","","","","",""));

        showCropAdapter = new ShowCropAdapter(getActivity(), farmList, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

            }
        }, new ShowCropAdapter.MyRecyclerViewListener() {
            @Override
            public void Delete(View v, int position) {
//                YesNoDialog(getActivity(), position);
            }




        });

        recyclerView.setAdapter(showCropAdapter);
        showCropAdapter.notifyDataSetChanged();

        return view;
    }

}
