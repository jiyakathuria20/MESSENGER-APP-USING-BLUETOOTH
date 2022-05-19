package com.example.bluetooth_messaging_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.bluetooth_messaging_app.Adapters.FragmentsAdapter;
import com.example.bluetooth_messaging_app.Models.Users;
import com.example.bluetooth_messaging_app.Models.main_chating;
import com.example.bluetooth_messaging_app.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    FloatingActionButton floatingbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        DBHelper db = new DBHelper(this);
        db.initializeUser("Hirusha Uthsara",2);

        Contact c1 = new Contact("A","Chiran",3);
        Contact c2 = new Contact("B","Ruchira",1);
        Contact c3 = new Contact("C","Hirusha",5);
        Contact c4 = new Contact("D","Viduri",2);
        Contact c5 = new Contact("E","Kalana",5);
        Contact c6 = new Contact("F","Nimesh",6);
        Contact c7 = new Contact("G","Madhuka",1);
        Contact c8 = new Contact("H","Sanduni",2);
        Contact c9 = new Contact("I","Amila",3);
        Contact c10 = new Contact("J","Piyumi",4);
        Contact c11 = new Contact("K","Sayuru",5);

        db.storeContact(c1);
        db.storeContact(c2);
        db.storeContact(c3);
        db.storeContact(c4);
        db.storeContact(c5);
        db.storeContact(c6);
        db.storeContact(c7);
        db.storeContact(c8);
        db.storeContact(c9);
        db.storeContact(c10);
        db.storeContact(c11);


        Message m1 = new Message(1000,"MyUserId","A","hi");
        Message m2 = new Message(1001,"A","MyUserId","hello");
        Message m3 = new Message(1015,"MyUserId","B","How are you");
        Message m4 = new Message(1018,"B","MyUserId","I'm fine");
        Message m5 = new Message(1035,"MyUserId","B","Where are u going today");
        Message m6 = new Message(1041,"B","MyUserId","I'm going to my sister's school. Wy is that?");
        Message m7 = new Message(1058,"MyUserId","A","Can i joion with you?");
        Message m8 = new Message(1105,"A","MyUserId","If you can' come with me");

        db.storeMessage(m1);
        db.storeMessage(m2);
        db.storeMessage(m3);
        db.storeMessage(m4);
        db.storeMessage(m5);
        db.storeMessage(m6);
        db.storeMessage(m7);
        db.storeMessage(m8);


        //This is the floating button at the bottom of the main layout
        floatingbutton = findViewById(R.id.floatingbutton);
        floatingbutton.setOnClickListener(new View.OnClickListener() {  //On the click it directs us to the all components
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), allcomponents.class);
                startActivity(i);
            }
        });

        binding.viewPager.setAdapter(new FragmentsAdapter(getSupportFragmentManager()));
        binding.tablayout.setupWithViewPager(binding.viewPager);


    }
    // link for page 13 setting
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_page14, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //This part handles the pop up list of the main layout
        switch(item.getItemId()){
            case R.id.profile:
                Intent i = new Intent(getApplicationContext(),page4.class);
                startActivity(i);
                break;
            case R.id.search:
                Intent i1 = new Intent(getApplicationContext(),list_paired_devices.class);
                startActivity(i1);
                break;
            case R.id.create_groupchat:
                Intent i3 = new Intent(getApplicationContext(),page12.class);
                startActivity(i3);
                break;
            case R.id.list_devices:
                Intent i4 = new Intent(getApplicationContext(),page2_3.class);
                startActivity(i4);
                break;
        }

        return super.onOptionsItemSelected(item);


    }






}