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

public class IrrigationSourcesFragment extends Fragment {

    View view ;
    FontTextViewRegular application;
    int applicationNum ;
    LinearLayout applicationLinear;
    ListView applicationList;
    int height;
    ArrayList<String> applicationArrayList;
    SQLDatabase database;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = ApplicationClass.getInstance().getData();
        applicationArrayList = new ArrayList<>();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_irrigation_sources, container, false);
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

        application.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final SEXListAdapter adapter = new SEXListAdapter(getActivity(), applicationArrayList);

                adapter.notifyDataSetChanged();
                applicationList.setAdapter(adapter);
                UIUtils.setListViewHeightBasedOnItems(applicationList);
                SpinnerAnimation(applicationLinear);


            }
        });

        applicationList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                applicationNum = position + 1;
                Log.d("dddddddddd", "ss");
                application.setText(applicationArrayList.get(position));
                SpinnerAnimationClose(applicationLinear);
            }
        });

        // Inflate the layout for this fragment
        return view ;
    }

    public void bindView(){
        application = view.findViewById(R.id.application);
        applicationLinear = view.findViewById(R.id.applicationLinear);
        applicationList = view.findViewById(R.id.listApplication);
    }

    public void SpinnerAnimation(LinearLayout view2) {
        if (view2.getVisibility() == View.VISIBLE) {
            MyCustomAnimation a = new MyCustomAnimation(view2, 800, MyCustomAnimation.COLLAPSE);
            height = a.getHeight();
            view2.startAnimation(a);
//            imageView.setBackgroundResource(R.drawable.ic_arrow_drop_down_black_24dp);
        } else {
            MyCustomAnimation a = new MyCustomAnimation(view2, 800, MyCustomAnimation.EXPAND);
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


        database.insertApplicationIRR("بئر","");
        database.insertApplicationIRR("خزان علوي","");
        database.insertApplicationIRR("مياه أرضية","");

        applicationArrayList.clear();
        applicationArrayList.addAll(database.getApplicationIRR());

    }

}
