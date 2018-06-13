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


public class IrrigationFragment extends Fragment {

    View view;
    FontTextViewRegular typeCompany;
    int typeCompanyNum;
    LinearLayout typeCompanyLinear;
    ListView typeCompanyList;
    int height;
    ArrayList<String> typeCompanyArrayList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        typeCompanyArrayList = new ArrayList<>();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_irrigation, container, false);
        bindView();
        seData();
        final ViewPager viewPager = getActivity().findViewById(R.id.viewpager);
        view.findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int s = viewPager.getCurrentItem() + 1;
                viewPager.setCurrentItem(s);
            }
        });

        typeCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final SEXListAdapter adapter = new SEXListAdapter(getActivity(), typeCompanyArrayList);
                adapter.notifyDataSetChanged();
                typeCompanyList.setAdapter(adapter);
                UIUtils.setListViewHeightBasedOnItems(typeCompanyList);
                SpinnerAnimation(typeCompanyLinear);


            }
        });

        typeCompanyList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                typeCompanyNum = position + 1;
                typeCompany.setText(typeCompanyArrayList.get(position));
                SpinnerAnimation(typeCompanyLinear);
            }
        });



        // Inflate the layout for this fragment
        return view;
    }

    public void bindView() {

        typeCompany = view.findViewById(R.id.typeCompany);
        typeCompanyLinear = view.findViewById(R.id.typeCompanyLinear);
        typeCompanyList = view.findViewById(R.id.listTypeCompany);
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

    public void seData(){
        typeCompanyArrayList.clear();
        typeCompanyArrayList.add("حيازة");
        typeCompanyArrayList.add("أرض");
    }
}
