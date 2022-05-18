package com.example.bluetooth_messaging_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.bluetooth_messaging_app.Adapters.ChatAdapter;
import com.example.bluetooth_messaging_app.databinding.ActivityPage6Binding;

import java.util.ArrayList;

public class page6 extends AppCompatActivity {

    ActivityPage6Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        binding = ActivityPage6Binding.inflate(getLayoutInflater());

        String userID = getIntent().getStringExtra("userID");
        String username = getIntent().getStringExtra("username");
        String profilepic = getIntent().getStringExtra("profilepic");

        setContentView(binding.getRoot());

        binding.contactname.setText(username);
        binding.contactname.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(getApplicationContext(),page7.class);
                startActivity(i1);
            }
        });

        binding.invitebutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(getApplicationContext(),page8.class);
                startActivity(i1);
            }
        });

        final ArrayList<Message> messageModel = new ArrayList<>();

        //I should take messages of the particular chat by the database using a function

        Message m1 = new Message(1,1200,2,3,"hi");
        Message m2 = new Message(3,1300,1,5,"h");
        Message m3 = new Message(2,1200,2,3,"hi");
        messageModel.add(m1);
        messageModel.add(m2);
        messageModel.add(m3);

        final ChatAdapter chatAdapter = new ChatAdapter(messageModel,this);
        binding.directchatmessages.setAdapter(chatAdapter);

        LinearLayoutManager layoutmanager = new LinearLayoutManager(this);
        binding.directchatmessages.setLayoutManager(layoutmanager);

        binding.sendbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = binding.typingtext.getText().toString();
                final Message m = new Message(1,1,1,1,msg);
                messageModel.add(m);
                binding.typingtext.setText("");
            }
        });

    }


}
