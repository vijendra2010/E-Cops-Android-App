package com.example.myproject.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myproject.Pojo.MissedPojo;
import com.example.myproject.Pojo.SightedPojo;
import com.example.myproject.R;

import java.util.ArrayList;

public class SightedCustomAdapter extends RecyclerView.Adapter<SightedCustomAdapter.ViewHolder> {

    private ArrayList<SightedPojo> arrayList;
    private Context context;
    public String number;

    // Constructor for Adapter
    public SightedCustomAdapter(ArrayList<SightedPojo> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.sighted_list_items, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final SightedPojo myMembers = arrayList.get(position);
        holder.number.setText(myMembers.getUser_no());
        holder.name.setText(myMembers.getName());
        holder.location.setText(myMembers.getLocation());
        holder.age.setText(myMembers.getAge());
        holder.gender.setText(myMembers.getGender());
        holder.description.setText(myMembers.getDescription());
        Glide.with(context).load(myMembers.getImageUrl()).into(holder.icon);
        holder.call_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d("89","");
                Uri callIntentUri = Uri.parse("tel:"+myMembers.getUser_no());
                Intent callIntent = new Intent(Intent.ACTION_DIAL, callIntentUri);
                v.getContext().startActivity(callIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView name;
        public TextView location;
        public TextView age;
        public TextView gender;
        public TextView description;
        public ImageView icon;
        public TextView number;
        public TextView call_btn;

        public ViewHolder(@NonNull View v) {
            super(v);
            name = v.findViewById(R.id.sighted_list_name);
            location = v.findViewById(R.id.sighted_list_location);
            age = v.findViewById(R.id.sighted_list_age);
            gender = v.findViewById(R.id.sighted_list_gender);
            description = v.findViewById(R.id.sighted_list_descrip);
            icon = v.findViewById(R.id.sighted_list_photo);
            number = v.findViewById(R.id.Make_call_sighted);
            call_btn = v.findViewById(R.id.call_button_sighted);
        }
    }
}
