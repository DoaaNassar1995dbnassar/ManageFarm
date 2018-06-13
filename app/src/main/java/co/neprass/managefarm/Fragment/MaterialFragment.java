package co.neprass.managefarm.Fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import co.neprass.managefarm.Adapter.MaterialAdapter;
import co.neprass.managefarm.AdapterList.SEXListAdapter;
import co.neprass.managefarm.ApplicationClass;
import co.neprass.managefarm.Interface.CustomItemClickListener;
import co.neprass.managefarm.Objects.AddMaterialObject;
import co.neprass.managefarm.R;
import co.neprass.managefarm.SQLDatabase;
import co.neprass.managefarm.Unit.MyCustomAnimation;
import co.neprass.managefarm.Unit.UIUtils;
import co.neprass.managefarm.view.FontButtonRegular;
import co.neprass.managefarm.view.FontTextViewRegular;


public class MaterialFragment extends Fragment {

    View view;
    RecyclerView recyclerView;
    MaterialAdapter materialAdapter ;
    List<AddMaterialObject> materialList ;
    FontTextViewRegular addNew ,typeText , ownerText;
    SQLDatabase database ;
    int typeNum, ownerNum;
    LinearLayout typeLinear, ownerLinear;
    ListView typeList, ownerList;
    int height;
    ArrayList<String> typeArrayList ,ownerArrayList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        materialList = new ArrayList<>() ;
        database = ApplicationClass.getInstance().getData();
        typeArrayList = new ArrayList<>();
        ownerArrayList = new ArrayList<>();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_material, container, false);
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

        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        materialAdapter = new MaterialAdapter(getActivity(), materialList, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

            }
        }, new MaterialAdapter.MyRecyclerViewListener() {
            @Override
            public void Delete(View v, int position) {
                YesNoDialog(getActivity() ,position);
            }

            @Override
            public void Edit(View v, int position) {

            }


        });

        recyclerView.setAdapter(materialAdapter);
        materialAdapter.notifyDataSetChanged();
        addNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    materialList.add(new AddMaterialObject( "","","","جرار زراعي "));
                    materialAdapter.notifyDataSetChanged();

            }
        });

        typeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
                typeText.setText(typeArrayList.get(position));
                SpinnerAnimationClose(typeLinear);
            }
        });


        ownerText.setOnClickListener(new View.OnClickListener() {
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
                ownerText.setText(ownerArrayList.get(position));
                SpinnerAnimationClose(ownerLinear);

            }
        });



        // Inflate the layout for this fragment
        return view;
    }

    public void YesNoDialog(Activity activity , final int position) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.setContentView(R.layout.yes_no_dialog);
        dialog.setCancelable(false);

        dialog.findViewById(R.id.yes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialList.remove(position);
                materialAdapter.notifyItemRemoved(position);
                materialAdapter.notifyDataSetChanged();
                dialog.cancel();
            }
        });

        dialog.findViewById(R.id.no).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });

        dialog.show();

    }

    public  void bindView(){
        typeLinear = view.findViewById(R.id.typeLinear);
        ownerLinear = view.findViewById(R.id.ownerLinear);
        typeList = view.findViewById(R.id.listType);
        ownerList = view.findViewById(R.id.listOwner);
        ownerText = view.findViewById(R.id.owner);
        typeText = view.findViewById(R.id.type);
        addNew = view.findViewById(R.id.addNew);


    }

    public void setData() {

        ////qua

        database.insertTypeInst("جرار زراعي", "");
        database.insertTypeInst("جرار", "");


        typeArrayList = database.getTypeInst();

        ///////social
        database.insertOwnerInst("ملك","");
        database.insertOwnerInst("ايجار","");
        ownerArrayList = database.getOwnerInst();

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
}
