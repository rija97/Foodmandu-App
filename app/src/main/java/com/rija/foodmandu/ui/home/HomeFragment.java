package com.rija.foodmandu.ui.home;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rija.foodmandu.R;
import com.rija.foodmandu.ui.Contacts;
import com.rija.foodmandu.ui.ContactsAdapter;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment {
    RecyclerView recyclerView, recyclerView1;
   // TextView tvsuper7;
    private int[] mImages = new int[]{
            R.drawable.coke, R.drawable.byanjan, R.drawable.real, R.drawable.signature
    };
    private String[] mImageTitlte = new String[]{
            "liquor", "Momo", "Sauce", "Juice"
    };
    CarouselView carouselView;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.recycleview);
        recyclerView1 = view.findViewById(R.id.recycleview1);
        carouselView = view.findViewById(R.id.cara1);
        carouselView.setPageCount(mImages.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(mImages[position]);
            }
        });
        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(getContext(), mImageTitlte[position], Toast.LENGTH_SHORT).show();
            }
        });

//        //super7
//        tvsuper7 = view.findViewById(R.id.tvsuper7);
//        super7();
//
//        return view;
//    }
//
//    private void super7() {
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://10.0.2.2:3000/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        super7API super7API = retrofit.create(super7API.class);
//
//        Call<List<super7>> ListCall = super7API.getSuper7();
//        super7API super7API1 = url.getInstance().create(super7API.class);
//
//        ListCall.enqueue(new Callback<List<super7>>() {
//
//            @Override
//            public void onResponse(Call<List<super7>> call, Response<List<super7>> response) {
//                if(!response.isSuccessful()){
//                    tvsuper7.setText(" Code : " + response.code());
//                    return;
//                }
//                List<super7> super7List = response.body();
//
//                for (super7 super7 : super7List ){
//                    String content = " ";
//                    content +=  super7.getImage() + "\n";
//                    content +=  (super7.getName()+ "\n") ;
//                    content +=  super7.getLocation()+ "\n";
//
//                    tvsuper7.append(content);
//
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<List<super7>> call, Throwable t) {
//                tvsuper7.setText("Error" + t.getMessage());
//            }
//        });
//
//
//
//
//    }

        List<Contacts> contactsList = new ArrayList<>();
        contactsList.add(new Contacts("restaurant", R.drawable.restaurant));
        contactsList.add(new Contacts("liquors", R.drawable.liquors));
        contactsList.add(new Contacts("bakeries", R.drawable.bakeries));
        contactsList.add(new Contacts("organic", R.drawable.organic));

        ContactsAdapter contactsAdapter = new ContactsAdapter(getContext(), contactsList);
        recyclerView.setAdapter(contactsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        return view;
    }
}