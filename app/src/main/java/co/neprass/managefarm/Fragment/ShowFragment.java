package co.neprass.managefarm.Fragment;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.ListView;

import org.michaelbel.bottomsheet.BottomSheet;

import java.util.ArrayList;
import java.util.List;

import co.neprass.managefarm.Adapter.SheetAdapter;
import co.neprass.managefarm.AdapterList.SEXListAdapter;
import co.neprass.managefarm.ApplicationClass;
import co.neprass.managefarm.Interface.CustomItemClickListener;
import co.neprass.managefarm.SQLDatabase;
import co.neprass.managefarm.Unit.MyCustomAnimation;
import co.neprass.managefarm.R;
import co.neprass.managefarm.Unit.UIUtils;
import co.neprass.managefarm.view.FontEditTextViewRegular;
import co.neprass.managefarm.view.FontTextViewRegular;
import es.dmoral.toasty.Toasty;


public class ShowFragment extends Fragment {


    View view;
    FontEditTextViewRegular idNumber, name1, name2, name3, name4, address, mobile;
    View view_sheet;
    FontTextViewRegular sheet_cancel, sheet_ok, sheet_title, date;
    RecyclerView sheet_recyclerView;
    SheetAdapter sheetAdapter;
    BottomSheet bottomSheet;
    FontTextViewRegular SEXText, city, sector, social, qualification;
    int socialNum, cityNum, sectorNum, qualificationNum, sexNum;
    LinearLayout sexLinear, socialLinear, qualificationLinear, cityLinear, sectorLinear;
    ListView sexList, socialList, qualificationList, cityList, sectorList;
    int height;
    ArrayList<String> sexArrayList, qualificationArrayList ,socialArrayList ,cityArrayList ,sectorArrayList;
    SQLDatabase database;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        sexArrayList = new ArrayList<>();
        qualificationArrayList = new ArrayList<>();
        socialArrayList = new ArrayList<>();
        cityArrayList = new ArrayList<>();
        sectorArrayList = new ArrayList<>();
        database = ApplicationClass.getInstance().getData();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_show, container, false);
        bindView();
        setData();

        final ViewPager viewPager = getActivity().findViewById(R.id.pager);

        view.findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Validate()) {
                    int s = viewPager.getCurrentItem() + 1;
                    viewPager.setCurrentItem(s);

                } else {
                    Toasty.warning(getActivity(), "يجب تعبئة جميع البيانات ").show();
                }
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
                SpinnerAnimationClose(sectorLinear);
                SpinnerAnimationClose(socialLinear);
                SpinnerAnimationClose(qualificationLinear);
                SpinnerAnimationClose(cityLinear);

            }
        });

        sexList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sexNum = position + 1;
                Log.d("dddddddddd", "ss");
                SEXText.setText(sexArrayList.get(position));
                SpinnerAnimationClose(sexLinear);
            }
        });



        qualification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final SEXListAdapter adapter = new SEXListAdapter(getActivity(), qualificationArrayList);

                adapter.notifyDataSetChanged();
                qualificationList.setAdapter(adapter);
                UIUtils.setListViewHeightBasedOnItems(qualificationList);
                SpinnerAnimation(qualificationLinear);
                SpinnerAnimationClose(sectorLinear);
                SpinnerAnimationClose(socialLinear);
                SpinnerAnimationClose(sexLinear);
                SpinnerAnimationClose(cityLinear);
            }
        });

        qualificationList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                qualificationNum = position + 1;
                qualification.setText(qualificationArrayList.get(position));
                SpinnerAnimationClose(qualificationLinear);
            }
        });

        social.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final SEXListAdapter adapter = new SEXListAdapter(getActivity(), socialArrayList);

                adapter.notifyDataSetChanged();
                socialList.setAdapter(adapter);
                UIUtils.setListViewHeightBasedOnItems(socialList);
                SpinnerAnimation(socialLinear);
                SpinnerAnimationClose(sectorLinear);
                SpinnerAnimationClose(qualificationLinear);
                SpinnerAnimationClose(sexLinear);
                SpinnerAnimationClose(cityLinear);

            }
        });

        socialList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                socialNum = position + 1;
                social.setText(socialArrayList.get(position));
                SpinnerAnimationClose(socialLinear);
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
                SpinnerAnimationClose(qualificationLinear);
                SpinnerAnimationClose(sexLinear);
                SpinnerAnimationClose(socialLinear);

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
                    SpinnerAnimationClose(qualificationLinear);
                    SpinnerAnimationClose(sexLinear);
                    SpinnerAnimationClose(socialLinear);
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

        date.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                dateDialog(getActivity());
            }
        });


        return view;
    }

    public void bindView() {

        idNumber = view.findViewById(R.id.idNumber);
        name1 = view.findViewById(R.id.name_1);
        name2 = view.findViewById(R.id.name_2);
        name3 = view.findViewById(R.id.name_3);
        name4 = view.findViewById(R.id.name_4);
        address = view.findViewById(R.id.address);
        mobile = view.findViewById(R.id.mobileNumber);
        city = view.findViewById(R.id.city);
        sector = view.findViewById(R.id.sector);
        social = view.findViewById(R.id.social);
        qualification = view.findViewById(R.id.qualification);
        SEXText = view.findViewById(R.id.sex);
        date = view.findViewById(R.id.date);
        sexLinear = view.findViewById(R.id.sexLinear);
        cityLinear = view.findViewById(R.id.cityLinear);
        sectorLinear = view.findViewById(R.id.sectorLinear);
        socialLinear = view.findViewById(R.id.socialLinear);
        qualificationLinear = view.findViewById(R.id.qualificationLinear);
        sectorList = view.findViewById(R.id.listSector);
        socialList = view.findViewById(R.id.listSocial);
        sexList = view.findViewById(R.id.listSex);
        qualificationList = view.findViewById(R.id.listQualification);
        cityList = view.findViewById(R.id.listCity);


    }

    public boolean Validate() {
        if (TextUtils.isEmpty(idNumber.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(name1.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(name2.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(name3.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(name4.getText().toString()))
            return false;
        else if (TextUtils.isEmpty(mobile.getText().toString()))
            return false;
        else if (sexNum==0)
            return false;
        else if (cityNum == 0)
            return false;
        else if (sectorNum == 0)
            return false ;
        else if (socialNum == 0)
            return false ;
        else if(qualificationNum == 0)
            return false ;

        return true;

    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void dateDialog(Activity activity) {

        DatePickerDialog datePickerDialog = new DatePickerDialog(activity, R.style.DialogTheme, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                int month = view.getMonth();
                int day = view.getDayOfMonth();
                int yearr = view.getYear();
                String dateText = yearr + "/" + month + "/" + day;
                date.setText(dateText);


            }
        }, 2018, 02, 26);
        datePickerDialog.show();
        datePickerDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(final DialogInterface dialog) {
                dialog.dismiss();
            }
        });


        //getWindow().getDecorView().getBackground().setColorFilter(new LightingColorFilter(0xFF000000,0xFF303030)).show();


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

        ////qua

        database.insertQualification("بكالويوسs", "");
        database.insertQualification("ثانوية", "");
        database.insertQualification("ماجستير", "");
        database.insertQualification("دبلوم", "");

        qualificationArrayList = database.getQualification();
        Log.d("ffffff",qualificationArrayList.size()+"");

        ///////social
        database.insertSocial("أعزب","");
        database.insertSocial("متزوج","");
        socialArrayList = database.getSocial();


        ///// sex
        sexArrayList.clear();
        sexArrayList.add("ذكر");
        sexArrayList.add("أنثى");

        ///////social
        database.insertCity("غزة","");
        database.insertCity("الوسطى","");

        cityArrayList = database.getCity();

        database.insertSector("1","النصر");
        database.insertSector("1","الرمال");
        database.insertSector("1","الشيخ رضوان");

        database.insertSector("2","دير البلح");
        database.insertSector("2","النصيرات");
        database.insertSector("2","البريج");



    }


//    public void BottomSheetSex() {
//
//        LayoutInflater inflater = LayoutInflater.from(getActivity());
//        view_sheet = inflater.inflate(R.layout.bottom_sheet, null);
//        bottomSheet = new BottomSheet.Builder(getActivity())
//                .setView(view_sheet).create();
//        bottomSheet.setCancelable(true);
//        bottomSheet.setCanceledOnTouchOutside(false);
//        listSheet.clear();
//        listSheet.add("ذكر");
//        listSheet.add("أنثى");
//
//        sheet_title = (FontTextViewRegular) view_sheet.findViewById(R.id.sheet_title);
//
//        sheet_title.setText("الجنس");
//
//
//        sheet_recyclerView = (RecyclerView) view_sheet.findViewById(R.id.recyclerView);
//        sheet_recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        sheet_recyclerView.setItemAnimator(new DefaultItemAnimator());
//        sheetAdapter = new SheetAdapter(getActivity(), listSheet, new CustomItemClickListener() {
//            @Override
//            public void onItemClick(View v, int position) {
//                SEXText.setText("");
//                SEXText.setText(listSheet.get(position));
//                bottomSheet.dismiss();
//                sexNum = position;
//
//
//            }
//        });
//        sheet_recyclerView.setAdapter(sheetAdapter);
//        sheetAdapter.notifyDataSetChanged();
//
//
//    }
}
