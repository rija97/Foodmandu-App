package com.rija.foodmandu.ui;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rija.foodmandu.R;
import com.rija.foodmandu.api.Super7;
import com.rija.foodmandu.strictmode.StrictModeClass;
import com.rija.foodmandu.url.Url;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Member;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.rija.foodmandu.url.Url.imagePath;

public class memberAdaptar extends RecyclerView.Adapter<memberAdaptar.MemberViewHolder> {

    Context mcontext;
    List<member> memberList;

    public memberAdaptar(Context mcontext, List<member> memberList) {
        this.mcontext = mcontext;
        this.memberList = memberList;
    }

    @NonNull
    @Override
    public MemberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.memberview, parent, false);
        return new MemberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MemberViewHolder holder, int position) {
        member member = memberList.get(position);

        String imgpath = Url.imagePath + member.getImage();
        Log.e("Image path is :" ,"Image path is" + imgpath);

        holder.tvName.setText(member.getName());
        holder.tvAddress.setText(member.getLocation());
//        holder.tvfood.setText(member.getFoodtype());

        StrictModeClass.StrictMode();
        try{
            URL url = new URL(imgpath);
            holder.memberlogo.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return memberList.size();
    }


    public class MemberViewHolder extends RecyclerView.ViewHolder {
        ImageView memberlogo;
        TextView tvName, tvAddress, tvfood;

        public MemberViewHolder(@NonNull View itemView) {
            super(itemView);

            memberlogo = itemView.findViewById(R.id.memberlogo);
            tvName = itemView.findViewById(R.id.tvname);
            tvAddress = itemView.findViewById(R.id.tvAddress);
            tvfood = itemView.findViewById(R.id.tvfood);

        }
    }

}
