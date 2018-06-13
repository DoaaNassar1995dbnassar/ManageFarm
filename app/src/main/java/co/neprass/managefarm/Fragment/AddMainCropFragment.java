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
import es.dmoral.toasty.Toasty;

public class AddMainCropFragment extends Fragment {


    View view;
    FontTextViewRegular contracting, city, sector, owner, typeCompany;
    int contractingNum, cityNum, sectorNum, ownerNum, typeCompanyNum;
    LinearLayout contractingLinear, ownerLinear, typeCompanyLinear, cityLinear, sectorLinear ,companyLinear ,userLinear;
    ListView contractingList, ownerList, typeCompanyList, cityList, sectorList;
    int height;
    ArrayList<String> contractingArrayList, ownerArrayList ,typeCompanyArrayList ,cityArrayList ,sectorArrayList;
    SQLDatabase database;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contractingArrayList = new ArrayList<>();
        ownerArrayList  = new ArrayList<>();
        typeCompanyArrayList = new ArrayList<>();
        cityArrayList = new ArrayList<>();
        sectorArrayList  = new ArrayList<>();

        database = ApplicationClass.getInstance().getData();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_add_main_crop, container, false);
        bindView();
        setData();
        // Inflate the layout for this fragment
        final ViewPager viewPager = getActivity().findViewById(R.id.viewpager);
        view.findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int s = viewPager.getCurrentItem() + 1;
                viewPager.setCurrentItem(s);
            }
        });


        contracting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final SEXListAdapter adapter = new SEXListAdapter(getActivity(), contractingArrayList);

                adapter.notifyDataSetChanged();
                contractingList.setAdapter(adapter);
                UIUtils.setListViewHeightBasedOnItems(contractingList);
                SpinnerAnimation(contractingLinear);
                SpinnerAnimationClose(sectorLinear);
                SpinnerAnimationClose(ownerLinear);
                SpinnerAnimationClose(typeCompanyLinear);
                SpinnerAnimationClose(cityLinear);

            }
        });

        contractingList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                contractingNum = position + 1;
                Log.d("dddddddddd", "ss");
                contracting.setText(contractingArrayList.get(position));
                SpinnerAnimationClose(contractingLinear);
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
                SpinnerAnimationClose(sectorLinear);
                SpinnerAnimationClose(contractingLinear);
                SpinnerAnimationClose(typeCompanyLinear);
                SpinnerAnimationClose(cityLinear);

            }
        });

        ownerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ownerNum = position + 1;
                owner.setText(ownerArrayList.get(position));
                SpinnerAnimationClose(ownerLinear);
                if (position == 0){
                    SpinnerAnimation(userLinear);
                    SpinnerAnimationClose(companyLinear);

                }else {
                    SpinnerAnimation(companyLinear);
                    SpinnerAnimationClose(userLinear);

                }
            }
        });

        city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final SEXListAdapter adapter = new SEXListAdapter(getActivity(), cityArrayList);

                adapter.notifyDataSetChanged();
                cityList.setAdapter(adapter);
                UIUtils.setListViewHeightBasedOnItems(cityList);
                SpinnerAnimation(cityLinear);
                SpinnerAnimationClose(sectorLinear);
                SpinnerAnimationClose(ownerLinear);
                SpinnerAnimationClose(typeCompanyLinear);
                SpinnerAnimationClose(contractingLinear);

            }
        });

        cityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cityNum = position + 1;
                city.setText(cityArrayList.get(position));
                SpinnerAnimationClose(cityLinear);
                sectorArrayList =database.getSector(cityNum+"");


            }
        });

        sector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cityNum !=0) {
                    final SEXListAdapter adapter = new SEXListAdapter(getActivity(), sectorArrayList);

                    adapter.notifyDataSetChanged();
                    sectorList.setAdapter(adapter);
                    UIUtils.setListViewHeightBasedOnItems(sectorList);
                    SpinnerAnimation(sectorLinear);
                    SpinnerAnimationClose(cityLinear);
                    SpinnerAnimationClose(ownerLinear);
                    SpinnerAnimationClose(typeCompanyLinear);
                    SpinnerAnimationClose(contractingLinear);
                }
                else{
                    Toasty.warning(getActivity() ,"يجب إضافة المحافظة أولا").show();
                }

            }
        });

        sectorList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sectorNum = position + 1;
                sector.setText(sectorArrayList.get(position));
                SpinnerAnimationClose(sectorLinear);
            }
        });


        typeCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("duaa","bbbbbb");

                final SEXListAdapter adapter = new SEXListAdapter(getActivity(), typeCompanyArrayList);

                adapter.notifyDataSetChanged();
                typeCompanyList.setAdapter(adapter);
                UIUtils.setListViewHeightBasedOnItems(typeCompanyList);
                SpinnerAnimation(typeCompanyLinear);
                SpinnerAnimationClose(sectorLinear);
                SpinnerAnimationClose(ownerLinear);
                SpinnerAnimationClose(contractingLinear);
                SpinnerAnimationClose(cityLinear);

            }
        });

        typeCompanyList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                typeCompanyNum = position + 1;
                typeCompany.setText(typeCompanyArrayList.get(position));
                SpinnerAnimationClose(typeCompanyLinear);
            }
        });

        return view;
    }

    public void bindView(){

        contracting = view.findViewById(R.id.contracting);
        city = view.findViewById(R.id.city);
        sector = view.findViewById(R.id.sector);
        owner = view.findViewById(R.id.owner);
        typeCompany = view.findViewById(R.id.typeCompany);

        contractingLinear = view.findViewById(R.id.contractingLinear);
        sectorLinear = view.findViewById(R.id.sectorLinear);
        cityLinear = view.findViewById(R.id.cityLinear);
        ownerLinear = view.findViewById(R.id.ownerLinear);
        typeCompanyLinear = view.findViewById(R.id.typeCompanyLinear);

        contractingList = view.findViewById(R.id.listContracting);
        sectorList = view.findViewById(R.id.listSector);
        cityList = view.findViewById(R.id.listCity);
        ownerList = view.findViewById(R.id.listOwner);
        typeCompanyList = view.findViewById(R.id.listTypeCompany);

        companyLinear = view.findViewById(R.id.company);
        userLinear = view.findViewById(R.id.user);



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

        ////qua

        ownerArrayList.clear();
        ownerArrayList.add("فرد");
        ownerArrayList.add("مؤسسة");

        contractingArrayList.clear();
        contractingArrayList.add("ملك");
        contractingArrayList.add("مؤسسة");

        typeCompanyArrayList.clear();
        typeCompanyArrayList.add("جمعية");
        typeCompanyArrayList.add("حكومية");

        cityArrayList.clear();
        cityArrayList.addAll(database.getCity());

    }
}
