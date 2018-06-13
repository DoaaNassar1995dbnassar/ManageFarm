package co.neprass.managefarm.AdapterList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.HashMap;

import co.neprass.managefarm.R;
import co.neprass.managefarm.view.FontTextViewRegular;

/**
 * Created by AL-Qema on 11/06/18.
 */

public class SEXListAdapter  extends BaseAdapter {

    Activity con;
    ArrayList<String> arrayList;
    boolean selectAll ;

    public SEXListAdapter(Activity con, ArrayList<String> arrayList) {
        this.con = con;
        this.arrayList = arrayList;

    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        View row;
        final ViewHolder viewHolder;

        if (view == null) {

            row = con.getLayoutInflater().inflate(R.layout.item_list_choose, viewGroup, false);
            viewHolder = new ViewHolder();

            viewHolder.name= row.findViewById(R.id.name);

            row.setTag(viewHolder);

        } else {
            row = view;
            viewHolder = (ViewHolder) view.getTag();
        }

        final String item = arrayList.get(i);
        viewHolder.name.setText(item);



//        else {
//            if (map.containsKey(item.getTrainer_name())) {
//                viewHolder.checkBox.setChecked(false);
//            } else {
//                viewHolder.checkBox.setChecked(true);
//
//            }
//        }

        return row;
    }

    public class ViewHolder {
        FontTextViewRegular name;


    }

    public void toggleSelectAll() {
        this.selectAll = !this.selectAll;
        notifyDataSetInvalidated();
    }
}

