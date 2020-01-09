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

public class HomeFragment extends Fragment {
    RecyclerView recyclerView, recyclerView1;
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