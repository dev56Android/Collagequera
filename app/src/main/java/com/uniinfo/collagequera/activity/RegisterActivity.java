package com.uniinfo.collagequera.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Carousel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.uniinfo.collagequera.R;
import com.uniinfo.collagequera.bean.User;

public class RegisterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText name, userEmail, userMobileNumber, userName,password, userType;
    TextView login;
    Button signUpButton;
    CheckBox terms_conditions;
    Spinner spType;
    User u;
    String type[]={"Select Type","Student","Faculty"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name =findViewById(R.id.name);
        userEmail = findViewById(R.id.userEmail);
        userMobileNumber =findViewById(R.id.userMobileNumber);
        userName =findViewById(R.id.userName);
        password =findViewById(R.id.password);
        userType =findViewById(R.id.userType);
        spType=findViewById(R.id.spType);

        signUpButton =findViewById(R.id.signUpBtn);
        login =findViewById(R.id.already_user);
        terms_conditions =findViewById(R.id.terms_conditions);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RegisterActivity.this, "Register user btn", Toast.LENGTH_SHORT).show();
                String nm= name.getText().toString();
                String username= userName.getText().toString();
                String email= userEmail.getText().toString();
                String mobile= userMobileNumber.getText().toString();
                String type= userType.getText().toString();
                String pw= password.getText().toString();
                if(type.equalsIgnoreCase("admin"))
                    u=new User(nm,username,email,pw,mobile,1);

                else if(type.equalsIgnoreCase("student"))
                    u=new User(nm,username,email,pw,mobile,2);

                else if(type.equalsIgnoreCase("faculty"))
                    u=new User(nm,username,email,pw,mobile,3);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                finish();
            }
        });

        spType.setOnItemSelectedListener(this);
        ArrayAdapter ad=new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,type);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spType.setAdapter(ad);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}