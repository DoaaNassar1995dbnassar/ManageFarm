package co.neprass.managefarm.Adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import co.neprass.managefarm.Interface.CustomItemClickListener;
import co.neprass.managefarm.Objects.AddFarmObject;
import co.neprass.managefarm.R;
import co.neprass.managefarm.view.FontTextViewRegular;

/**
 * Created by AL-Qema on 05/06/18.
 */

public class LocalCropAdapter  extends RecyclerView.Adapter<LocalCropAdapter.MyViewHolder> {

    private List<AddFarmObject> farmList;
    CustomItemClickListener listener;
    Context context;
    LocalCropAdapter.MyRecyclerViewListener myRecyclerViewListener;
    List<Integer> color;



    public class MyViewHolder extends RecyclerView.ViewHolder {
        FontTextViewRegular name, number;
        ImageButton remove, edit;
        LinearLayout linearLayout;


        public MyViewHolder(View view) {
            super(view);
            name = itemView.findViewById(R.id.name);
            number = itemView.findViewById(R.id.number);
            remove = (ImageButton) itemView.findViewById(R.id.removeImage);
            edit = (ImageButton) itemView.findViewById(R.id.editImage);
            linearLayout = itemView.findViewById(R.id.linearLayout);


        }


    }

    public LocalCropAdapter(Context context, List<AddFarmObject> farmList, CustomItemClickListener listener,
                            LocalCropAdapter.MyRecyclerViewListener myRecyclerViewListener) {
        this.context = context;
        this.farmList = farmList;
        this.listener = listener;
        this.myRecyclerViewListener = myRecyclerViewListener;
        color = new ArrayList<>();

    }

    public List<AddFarmObject> getItems() {
        return farmList;
    }

    @Override
    public LocalCropAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_local_farm, parent, false);


        final LocalCropAdapter.MyViewHolder mViewHolder = new LocalCropAdapter.MyViewHolder(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                listener.onItemClick(v, mViewHolder.getAdapterPosition());
            }
        });

        return mViewHolder;
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(LocalCropAdapter.MyViewHolder holder, final int position) {

        AddFarmObject item = farmList.get(position);
//
//        holder.name.setText(item.getName());
//        holder.number.setText(item.getType());

        color.add(R.color.item1);
        color.add(R.color.item2);
        color.add(R.color.item3);
        color.add(R.color.item4);
        color.add(R.color.golden);




        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRecyclerViewListener.Delete(v, position);
            }
        });
        Random rand = new Random();
        int n = rand.nextInt(5);


        holder.linearLayout.setBackgroundColor(context.getResources().getColor(color.get(n)));

    }

    @Override
    public int getItemCount() {
        return farmList.size();
    }


    public interface MyRecyclerViewListener {
        public void Delete(View v, int position);

    }

}
