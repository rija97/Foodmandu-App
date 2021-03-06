package com.rija.foodmandu.ui;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rija.foodmandu.R;
import com.rija.foodmandu.strictmode.StrictModeClass;
import com.rija.foodmandu.url.Url;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class DetailsAdapter  extends RecyclerView.Adapter<DetailsAdapter.ContactsViewHolder> {
    Context mContext;
    List<Details> detailsList;


    public DetailsAdapter(Context mContext, List<Details> detailsList) {
        this.mContext = mContext;
        this.detailsList = detailsList;
    }

    @NonNull
    @Override
    public DetailsAdapter.ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_layout, parent, false);
        return new DetailsAdapter.ContactsViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ContactsViewHolder contactsViewHolder, int i) {
//        Contacts contacts = contactsList.get(position);
//        holder.imgProfile.setImageResource(contacts.getimageId());
//        holder.tvName.setText(contacts.getName());
//        holder.tvPhoneNo.setText(contacts.getPhoneNo());
        final Details details = detailsList.get(i);
        //contactsViewHolder.monday.setImageResource(details.getImage());
        String imgPath = Url.imagePath+details.getImage();

        contactsViewHolder.tvname.setText(details.getName());
        contactsViewHolder.tvtitle.setText(details.getItemtype());
        contactsViewHolder.tvaddress.setText(details.getLocation());
        StrictModeClass.StrictMode();

        try{
            URL url = new URL(imgPath);
            contactsViewHolder.card1.setImageBitmap(BitmapFactory.decodeStream((InputStream)
            url.getContent()));
        } catch(IOException e){
            e.printStackTrace();
        }


    }
//


    @Override
    public int getItemCount() {
        return detailsList.size();
    }

    public class ContactsViewHolder extends RecyclerView.ViewHolder {

        ImageView imgbox, card1;
        TextView tvtitle, tvaddress, tvname;


        public ContactsViewHolder(@NonNull View itemView) {
            super(itemView);
            card1 = itemView.findViewById(R.id.card1);
            imgbox=itemView.findViewById(R.id.imgbox);
            tvtitle = itemView.findViewById(R.id.tvtitle);
            tvaddress = itemView.findViewById(R.id.tvaddress);
            tvname = itemView.findViewById(R.id.tvname);


        }

    }
}
