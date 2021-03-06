package co.neprass.managefarm.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import co.neprass.managefarm.Interface.CustomItemClickListener;
import co.neprass.managefarm.Objects.AddMaterialObject;
import co.neprass.managefarm.R;
import co.neprass.managefarm.view.FontTextViewRegular;

/**
 * Created by AL-Qema on 04/06/18.
 */

public class MaterialAdapter  extends RecyclerView.Adapter<MaterialAdapter.MyViewHolder> {

    private List<AddMaterialObject> materialList ;
    CustomItemClickListener listener;
    Context context;
    MaterialAdapter.MyRecyclerViewListener myRecyclerViewListener;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        FontTextViewRegular name , number ;
        ImageButton  remove  ,edit;



        public MyViewHolder(View view) {
            super(view);
            name = itemView.findViewById(R.id.name);
            number = itemView.findViewById(R.id.number);
            remove = (ImageButton) itemView.findViewById(R.id.removeImage);
            edit  = (ImageButton) itemView.findViewById(R.id.editImage);


        }


    }

    public MaterialAdapter(Context context, List<AddMaterialObject> materialList, CustomItemClickListener listener,
                             MaterialAdapter.MyRecyclerViewListener myRecyclerViewListener) {
        this.context = context;
        this.materialList = materialList;
        this.listener = listener;
        this.myRecyclerViewListener = myRecyclerViewListener ;

    }

    public List<AddMaterialObject> getItems() {
        return materialList;
    }

    @Override
    public MaterialAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.material_item, parent, false);

        final MaterialAdapter.MyViewHolder mViewHolder = new MaterialAdapter.MyViewHolder(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                listener.onItemClick(v, mViewHolder.getAdapterPosition());
            }
        });

        return mViewHolder;
    }


    @Override
    public void onBindViewHolder(MaterialAdapter.MyViewHolder holder, final int position) {

        AddMaterialObject item = materialList.get(position);
//
//        holder.name.setText(item.getName());
//        holder.number.setText(item.getType());

        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRecyclerViewListener.Delete(v,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return materialList.size();
    }


    public interface MyRecyclerViewListener {
        public void Delete(View v, int position);
        public void Edit (View v ,int position);

    }

}
