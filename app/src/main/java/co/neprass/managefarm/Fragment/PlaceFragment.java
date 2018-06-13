package co.neprass.managefarm.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

import co.neprass.managefarm.AdapterList.SEXListAdapter;
import co.neprass.managefarm.ApplicationClass;
import co.neprass.managefarm.R;
import co.neprass.managefarm.SQLDatabase;
import co.neprass.managefarm.Unit.MyCustomAnimation;
import co.neprass.managefarm.Unit.UIUtils;
import co.neprass.managefarm.view.FontTextViewRegular;


public class PlaceFragment extends Fragment {

    View view;
    FontTextViewRegular owner, type;
    int ownerNum, typeNum;
    LinearLayout ownerLinear, typeLinear;
    ListView ownerList, typeList;
    int height;
    ArrayList<String> ownerArrayList, typeArrayList;
    SQLDatabase database ;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ownerArrayList = new ArrayList<>();
        typeArrayList = new ArrayList<>();
        database = ApplicationClass.getInstance().getData();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_place, container, false);
        bindView();
        setData();

        final ViewPager viewPager = getActivity().findViewById(R.id.viewpager);
        view.findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int s = viewPager.getCurrentItem() + 1;
                viewPager.setCurrentItem(s);
            }
        });

        type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("duaa","bbbbbb");

                final SEXListAdapter adapter = new SEXListAdapter(getActivity(), typeArrayList);

                adapter.notifyDataSetChanged();
                typeList.setAdapter(adapter);
                UIUtils.setListViewHeightBasedOnItems(typeList);
                SpinnerAnimation(typeLinear);
                SpinnerAnimationClose(ownerLinear);


            }
        });

        typeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                typeNum = position + 1;
                type.setText(typeArrayList.get(position));
                SpinnerAnimationClose(typeLinear);
            }
        });

        owner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final SEXListAdapter adapter = new SEXListAdapter(getActivity(), ownerArrayList);

                adapter.notifyDataSetChanged();
                ownerList.setAdapter(adapter);
                UIUtils.setListViewHeightBasedOnItems(ownerList);
                SpinnerAnimation(ownerLinear);
                SpinnerAnimationClose(typeLinear);

            }
        });

        ownerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ownerNum = position + 1;
                owner.setText(ownerArrayList.get(position));
                SpinnerAnimationClose(ownerLinear);

            }
        });


        // Inflate the layout for this fragment
        return view;
    }

    public void bindView() {

        owner = view.findViewById(R.id.owner);
        type = view.findViewById(R.id.type);

        ownerLinear = view.findViewById(R.id.ownerLinear);
        typeLinear = view.findViewById(R.id.typeLinear);

        typeList = view.findViewById(R.id.listType);
        ownerList = view.findViewById(R.id.listOwner);

    }

    public void SpinnerAnimation(LinearLayout view2) {
        if (view2.getVisibility() == View.VISIBLE) {
            MyCustomAnimation a = new MyCustomAnimation(view2, 1000, MyCustomAnimation.COLLAPSE);
            height = a.getHeight();
            view2.startAnimation(a);
//            imageView.setBackgroundResource(R.drawable.ic_arrow_drop_down_black_24dp);
        } else {
            MyCustomAnimation a = new MyCustomAnimation(view2, 1000, MyCustomAnimation.EXPAND);
            a.setHeight(height);
            view2.startAnimation(a);
//            imageView.setBackgroundResource(R.drawable.ic_arrow_drop_up_black_24dp);

        }
    }

    public void SpinnerAnimationClose(LinearLayout view2) {
        if (view2.getVisibility() == View.VISIBLE) {
            MyCustomAnimation a = new MyCustomAnimation(view2, 1000, MyCustomAnimation.COLLAPSE);
            height = a.getHeight();
            view2.startAnimation(a);
//            imageView.setBackgroundResource(R.drawable.ic_arrow_drop_down_black_24dp);
        }

    }


    public void setData() {
        database.insertOwnerBuilding("خاص", "");
        database.insertOwnerBuilding("عام", "");

        ownerArrayList.clear();
        ownerArrayList.addAll(database.getOwnerBuilding());

        database.insertTypeBuilding("مزارع أبقار","");
        database.insertTypeBuilding("مزارع دواجن","");

        typeArrayList.clear();
        typeArrayList.addAll(database.getTypeBuilding());

    }

}
