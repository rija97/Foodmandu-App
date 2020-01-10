package com.rija.foodmandu.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.UserHandle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rija.foodmandu.MainActivity;
import com.rija.foodmandu.R;
import com.rija.foodmandu.api.UsersAPI;
import com.rija.foodmandu.bll.LoginBLL;
import com.rija.foodmandu.serverresponse.SignUpResponse;
import com.rija.foodmandu.strictmode.StrictModeClass;
import com.rija.foodmandu.ui.home.HomeFragment;
import com.rija.foodmandu.ui.send.RegisterActivity;
import com.rija.foodmandu.ui.send.SendFragment;
import com.rija.foodmandu.url.Url;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private EditText etEmail, etPassword;
    private TextView tvCreate, tvForgetPassword;
    private Button btnLogin, btnFacebook, btnGoogle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvCreate = findViewById(R.id.tvCreate);
        tvForgetPassword = findViewById(R.id.tvForgetPassword);
        btnFacebook = findViewById(R.id.btnFacebook);
        btnGoogle = findViewById(R.id.btnGoogle);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        tvCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
    private void login() {
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        LoginBLL loginBLL = new LoginBLL();

com.rija.foodmandu.ui.username Username= new username(email,password);
        StrictModeClass.StrictMode();
        UsersAPI usersAPI = Url.getInstance().create(UsersAPI.class);
        Call<SignUpResponse> userCall = usersAPI.checkLogin(Username);
        userCall.enqueue(new Callback<SignUpResponse>() {
            @Override
            public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(LoginActivity.this, "Code",Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(LoginActivity.this, "Login Successful",Toast.LENGTH_SHORT).show();
                Url.token +=response.body().getToken();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<SignUpResponse> call, Throwable t) {

                Toast.makeText(LoginActivity.this, "error" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
