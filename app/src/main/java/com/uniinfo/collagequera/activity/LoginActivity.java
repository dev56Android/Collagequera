package com.uniinfo.collagequera.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.uniinfo.collagequera.R;


public class LoginActivity extends AppCompatActivity {

    EditText login_emailid, login_password;
    Button loginBtn;
    TextView forgetPassword, createAccount;
    CheckBox show_hide_password;
    LinearLayout loginLayout;
    Animation shakeAnimation;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_emailid=findViewById(R.id.login_emailid);
        login_password=findViewById(R.id.login_password);
        loginBtn=findViewById(R.id.loginBtn);
        forgetPassword=findViewById(R.id.forget_password);
        createAccount=findViewById(R.id.createAccount);
        show_hide_password=findViewById(R.id.show_hide_password);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=(login_emailid.getText().toString());
                String pass=(login_password.getText().toString());

                if(email.equalsIgnoreCase("ADMIN") && pass.equals("ADMIN"))
                {
                    startActivity(new Intent(LoginActivity.this,AdminHomeActivity.class));
                    finish();
                }
                else if(email.equalsIgnoreCase("STUDENT") && pass.equals("STUDENT"))
                {
                    startActivity(new Intent(LoginActivity.this,StudentHomeActivity.class));
                    finish();
                }
                else if(email.equalsIgnoreCase("FACULTY") && pass.equals("FACULTY"))
                {
                    startActivity(new Intent(LoginActivity.this,FacultyHomeActivity.class));
                    finish();
                }
                else if(email.isEmpty() && pass.isEmpty())
                {
                    Toast.makeText(LoginActivity.this, "Please enter Email and Password", Toast.LENGTH_SHORT).show();
                }
                else if(pass.isEmpty())
                {
                    Toast.makeText(LoginActivity.this, "Please enter Password", Toast.LENGTH_SHORT).show();
                }
                else if(email.isEmpty())
                {
                    Toast.makeText(LoginActivity.this, "Please enter Email", Toast.LENGTH_SHORT).show();
                }
                else
                Toast.makeText(LoginActivity.this, "username and password mismatch", Toast.LENGTH_SHORT).show();
            }
        });

        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,ForgetActivity.class));
            }
        });

        createAccount.setOnClickListener(view -> startActivity(new Intent(LoginActivity.this,RegisterActivity.class)));

        show_hide_password.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton Button, boolean isChecked) {
                if(isChecked){
                    show_hide_password.setText(R.string.hide_pwd);
                    login_password.setInputType(InputType.TYPE_CLASS_TEXT);
                    login_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());// show password
                }
                else
                {
                    show_hide_password.setText(R.string.show_pwd);
                    login_password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    login_password.setTransformationMethod(PasswordTransformationMethod.getInstance());// hide password
                }
            }
        });
    }
}