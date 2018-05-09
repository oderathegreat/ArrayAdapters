package com.valentishealth.app.presshub.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.valentishealth.app.presshub.R;
import com.valentishealth.app.presshub.model.Modelist;
import com.valentishealth.app.presshub.R;


import java.util.List;

/**
 * Created by Hp on 4/13/2018.
 */

public class RecyclerAdapter extends  RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{

    private Context context;
    private List<Modelist> mDataList;
    RequestOptions option;



    public RecyclerAdapter(Context context, List<Modelist> mDataList) {
        this.context = context;
        this.mDataList = mDataList;

        //Request option for glide
        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);



    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.row_items, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


        holder.tv_name.setText(mDataList.get(position).getName());
        holder.tv_rating.setText(mDataList.get(position).getRating());
        holder.tv_studio.setText(mDataList.get(position).getStudio());
        holder.tv_category.setText(mDataList.get(position).getCategories());
        holder.tv_name.setText(mDataList.get(position).getName());
        holder.tv_desc.setText(mDataList.get(position).getDescription());

        //load image from the iternet and set it into imageview using glide

        /*Glide.with(context).load(mDataList.get(position).getImg()).apply(option).into(holder.img_thumbanil);
*/
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_name;
        TextView tv_desc;
        TextView tv_rating;
        TextView tv_studio;
        TextView tv_category;
        ImageView img_thumbanil;





        public MyViewHolder(View itemView) {
            super(itemView);


            tv_name = itemView.findViewById(R.id.txtAnimeTitle);
            tv_category = itemView.findViewById(R.id.txtCategories);
            tv_desc = itemView.findViewById(R.id.txtDescription);
            tv_rating = itemView.findViewById(R.id.txtRating);
            tv_studio = itemView.findViewById(R.id.txtStudio);
            img_thumbanil = itemView.findViewById(R.id.thumbnail);


        }
    } {

    }

}
