package com.rija.foodmandu.ui.home;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.ContactsContract;
import android.util.Log;
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
import com.rija.foodmandu.api.Super7;
import com.rija.foodmandu.strictmode.StrictModeClass;
import com.rija.foodmandu.ui.Bakeries;
import com.rija.foodmandu.ui.BakeriesAdapter;
import com.rija.foodmandu.ui.Contacts;
import com.rija.foodmandu.ui.ContactsAdapter;
import com.rija.foodmandu.ui.Details;
import com.rija.foodmandu.ui.DetailsAdapter;
import com.rija.foodmandu.ui.member;
import com.rija.foodmandu.ui.memberAdaptar;
import com.rija.foodmandu.url.Url;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.rija.foodmandu.url.Url.imagePath;

public class HomeFragment extends Fragment {
    List<Details> detailsList;
    List<member> memberList;
    memberAdaptar memberAdaptar;
    DetailsAdapter detailsAdapter;
    BakeriesAdapter bakeriesAdapter;
    List<Bakeries> bakeriesList;
    RecyclerView recyclerView, recyclerView1,recyclerView2, memberrecycleview;
   // TextView tvsuper7;
    ImageView card1;

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
        recyclerView2 = view.findViewById(R.id.recycleview2);
        memberrecycleview = view.findViewById(R.id.memberrecycleview);
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

        List<Bakeries> bakeriesList= new ArrayList<>();
        bakeriesList.add(new Bakeries(R.drawable.blueberry));
        bakeriesList.add(new Bakeries(R.drawable.pastry));
        bakeriesList.add(new Bakeries(R.drawable.macron));
        bakeriesList.add(new Bakeries(R.drawable.chickenpatty));
        bakeriesList.add(new Bakeries(R.drawable.croissant));
//        contactsList.add(new Contacts("2", R.drawable.bhaktapur));
//        contactsList.add(new Contacts("3", R.drawable.saturday));
//        contactsList.add(new Contacts("4", R.drawable.happylunch));
        BakeriesAdapter bakeriesAdapter = new BakeriesAdapter(getContext(),bakeriesList);
        recyclerView2.setAdapter(bakeriesAdapter);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        super7();
        return view;
    }

    private void super7() {
        detailsList = new ArrayList<>();
        Super7 s = Url.getInstance().create(Super7.class);
        Call<Details> listCall1 = s.getImage(imagePath);
        listCall1.enqueue(new Callback<Details>() {
            @Override
            public void onResponse(Call<Details> call, Response<Details> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getActivity(), "code" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                String imagepath = imagePath + response.body().getImage();
                StrictModeClass.StrictMode();
                try {
                    //java URL
                    URL url = new URL(imagepath);
                    card1.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


            @Override
            public void onFailure(Call<Details> call, Throwable t) {
                Toast.makeText(getActivity(), "Error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        Call<List<Details>> ListCall = s.getSuper7();
        ListCall.enqueue(new Callback<List<Details>>() {
            @Override
            public void onResponse(Call<List<Details>> call, Response<List<Details>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getContext(), "Error" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                List<Details> detailsList1 = response.body();
                detailsAdapter = new DetailsAdapter(getContext(), detailsList1);
                recyclerView1.setAdapter(detailsAdapter);
                recyclerView1.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
                recyclerView1.setHasFixedSize(true);
            }

            @Override
            public void onFailure(Call<List<Details>> call, Throwable t) {
                Log.d("Error Message", "Error " + t.getLocalizedMessage());
                Toast.makeText(getActivity(),"Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}