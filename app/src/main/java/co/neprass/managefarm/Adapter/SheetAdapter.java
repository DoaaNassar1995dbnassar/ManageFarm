package co.neprass.managefarm.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import co.neprass.managefarm.Interface.CustomItemClickListener;
import co.neprass.managefarm.R;
import co.neprass.managefarm.view.FontTextViewRegular;

/**
 * Created by AL-Qema on 04/06/18.
 */

public class SheetAdapter extends RecyclerView.Adapter<SheetAdapter.MyViewHolder> {

    private List<String> advertPlaceList;
    CustomItemClickListener listener;
    Context context;
    View.OnClickListener clickListener;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public FontTextViewRegular name;

        public MyViewHolder(View view) {
            super(view);
            name = (FontTextViewRegular) itemView.findViewById(R.id.name);
        }

    }

    public SheetAdapter(Context context, List<String> advertPlaceList, CustomItemClickListener listener) {
        this.context = context;
        this.advertPlaceList = advertPlaceList;
        this.listener = listener;

    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_sheet, parent, false);
        final MyViewHolder mViewHolder = new MyViewHolder(itemView);
        return mViewHolder;
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final String advertPlace = advertPlaceList.get(position);

        holder.name.setText(advertPlace);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(view, position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return advertPlaceList.size();
    }


}
