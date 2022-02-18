package com.uniinfo.collagequera.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.uniinfo.collagequera.R;

public class StudentHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("setting");
        menu.add("logout");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String click=item.getTitle().toString();
        if(click.equalsIgnoreCase("logout"))
        {
            new AlertDialog.Builder(this)
                    .setTitle("confirmation....")
                    .setMessage("Are you really want to confirm logout ?")
                    .setPositiveButton("Logout", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            startActivity(new Intent(StudentHomeActivity.this,LoginActivity.class));
                            finish();
                        }
                    })
                    .setNegativeButton("Cancel",null)
                    .create()
                    .show();
        }
        else if(click.equalsIgnoreCase("setting"))
            Toast.makeText(this, click + " calling", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}