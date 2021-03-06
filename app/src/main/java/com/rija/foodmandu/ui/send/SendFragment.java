package com.rija.foodmandu.ui.send;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.rija.foodmandu.R;
import com.rija.foodmandu.ui.LoginActivity;

public class SendFragment extends Fragment {
TextView txtAbout, txtFeedback, txtTerms,txtFaqs;
    Button btnLogin;

    private SendViewModel sendViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        sendViewModel =
                ViewModelProviders.of(this).get(SendViewModel.class);
        View view = inflater.inflate(R.layout.fragment_send, container, false);
//        final TextView textView = root.findViewById(R.id.text_send);
//        sendViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        txtAbout= view.findViewById(R.id.txtAbout);
        txtFeedback = view.findViewById(R.id.txtFeedback);
        txtFaqs = view.findViewById(R.id.txtFaqs);
        txtTerms = view.findViewById(R.id.txtTerms);
        btnLogin = view.findViewById(R.id.btnLogin);

        btnLogin= view.findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}