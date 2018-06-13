package co.neprass.managefarm.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import org.michaelbel.bottomsheet.BottomSheet;

import java.util.ArrayList;
import java.util.List;

import co.neprass.managefarm.Adapter.SheetAdapter;
import co.neprass.managefarm.AdapterList.SEXListAdapter;
import co.neprass.managefarm.Interface.CustomItemClickListener;
import co.neprass.managefarm.R;
import co.neprass.managefarm.Unit.MyCustomAnimation;
import co.neprass.managefarm.Unit.UIUtils;
import co.neprass.managefarm.view.FontEditTextViewRegular;
import co.neprass.managefarm.view.FontTextViewRegular;


public class WorkerFragment extends Fragment {

    View view ;

    FontTextViewRegular SEXText ;
    ArrayList <String> sexArrayList ;
    LinearLayout sexLinear ;
    ListView sexList ;
    int height ,sexNum ;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sexArrayList = new ArrayList<>();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_worker, container, false);
        bindView();
        setData();
        final ViewPager viewPager = getActivity().findViewById(R.id.pager);
        view.findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int s = viewPager.getCurrentItem() + 1;
                viewPager.setCurrentItem(s);
            }
        });



        SEXText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final SEXListAdapter adapter = new SEXListAdapter(getActivity(), sexArrayList);

                adapter.notifyDataSetChanged();
                sexList.setAdapter(adapter);
                UIUtils.setListViewHeightBasedOnItems(sexList);
                SpinnerAnimation(sexLinear);


            }
        });

        sexList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sexNum = position + 1;
                SEXText.setText(sexArrayList.get(position));
                SpinnerAnimation(sexLinear);

            }
        });
        // Inflate the layout for this fragment
        return view ;
    }

    public  void bindView (){
        SEXText = view.findViewById(R.id.sex);
        sexLinear = view.findViewById(R.id.sexLinear);
        sexList = view.findViewById(R.id.listSEX);

    }


    public void setData(){
        sexArrayList.clear();
        sexArrayList.add("ذكر");
        sexArrayList.add("أنثى");
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

}
