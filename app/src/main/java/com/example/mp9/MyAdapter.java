package com.example.mp9;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    //Provides direct reference to each of the views within a data item
    //used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder{
        //Your holder should contain a member variable for any view that will be set as you render a row
        public TextView mltext;

        public ViewHolder(View itemView) {
            super(itemView);
            mltext= (TextView) itemView.findViewById(R.id.mltext);
        }
    }

    private List<textFound> mQ;
    //Create constructor for class
    public MyAdapter(List<textFound> query){
        mQ=query;
    }
    @Override
    //inflate the item layout and create the holder
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);

        //inflate the custom layout
        View contactView=inflater.inflate(R.layout.textfound,parent,false);

        //Return a new Holder Instance
        ViewHolder viewHolder=new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        textFound data=mQ.get(position);

        TextView text1=holder.mltext;
        text1.setText(data.getTex());
    }

    @Override
    public int getItemCount() {
        return mQ.size();
    }
}