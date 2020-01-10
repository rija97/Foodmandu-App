package com.rija.foodmandu.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rija.foodmandu.R;

import java.util.List;

public class BakeriesAdapter extends RecyclerView.Adapter<BakeriesAdapter.BakeryViewHolder> {
        Context mContext;
        List<Bakeries> bakeriesList;


public BakeriesAdapter(Context mContext, List<Bakeries> bakeriesList) {
        this.mContext = mContext;
        this.bakeriesList = bakeriesList;
        }

@NonNull
@Override
public BakeriesAdapter.BakeryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.bakery, parent, false);
        return new BakeriesAdapter.BakeryViewHolder(view);

        }

@Override
public void onBindViewHolder(@NonNull BakeryViewHolder BakeryViewHolder, int i) {
//        Contacts contacts = contactsList.get(position);
//        holder.imgProfile.setImageResource(contacts.getimageId());
//        holder.tvName.setText(contacts.getName());
//        holder.tvPhoneNo.setText(contacts.getPhoneNo());
        final Bakeries bakeries = bakeriesList.get(i);
        BakeryViewHolder.imageId.setImageResource(bakeries.getImageId());
//        BakeryViewHolder.imageId.setImageResource(bakeries.getImageId());

        //contactsViewHolder.monday.setImageResource(details.getImage());
//        holder.imageId.setImageResource(Bakeries.getImageId());


        }



@Override
public int getItemCount() {
        return bakeriesList.size();
        }

public class BakeryViewHolder extends RecyclerView.ViewHolder {

    ImageView imageId;


    public BakeryViewHolder(@NonNull View itemView) {
        super(itemView);
        imageId=itemView.findViewById(R.id.image);



    }

}
}


