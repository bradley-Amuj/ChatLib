package com.bradley.chatlib;

import android.content.Context;
import android.util.Log;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.stfalcon.chatkit.messages.MessagesListAdapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MessageUtil {

    private static final String TAG = "MessageUtil";
    private static FirebaseDatabase firebaseDatabase;
    private static DatabaseReference databaseRef;
    private String appId;
    private String projectId;
    private String APIKEY;
    private FirebaseOptions firebaseOptions;
    private String databaseUrl;
    private List<Message> PreviousMessages;
    private String sender;
    private String recipient;

    public MessageUtil() {
    }

    public MessageUtil(String appId, String projectId, String APIKEY, String databaseUrl, Context context) {
        this.appId = appId;
        this.projectId = projectId;
        this.APIKEY = APIKEY;
        this.databaseUrl = databaseUrl;


        FirebaseOptions firebaseOptions = new FirebaseOptions.Builder()
                .setProjectId(projectId)
                .setApplicationId(appId)
                .setApiKey(APIKEY)
                .setDatabaseUrl(databaseUrl)
                .build();

        this.firebaseOptions = firebaseOptions;

        FirebaseApp.initializeApp(context, firebaseOptions);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseRef = firebaseDatabase.getReference();



    }


    public void sendMessage(Message message, String sender, String recipient) {


        databaseRef.child("message").child(setOneToOneChat(sender, recipient))
                .push()
                .setValue(message);

        Log.d(TAG, "sendMessage: Message has been sent");


    }


    /*
    creating a node to store the messages between two particular people
    * */
    private String setOneToOneChat(String uid1, String uid2) {

        if (uid1.compareTo(uid2) < 0) {
            return uid1 + uid2;

        } else {
            return uid2 + uid1;

        }
    }


    /*
    Should be called in the oncreate method
     */
    public void showPreviousMessages(MessagesListAdapter adapter,  String sender, String recipient) {
         PreviousMessages = new ArrayList<>();


        databaseRef.child("message")
                .child(setOneToOneChat(sender, recipient))
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        PreviousMessages.clear();
                        adapter.clear();
                        for (DataSnapshot row:dataSnapshot.getChildren()) {
                            PreviousMessages.add(row.getValue(Message.class));
                        }

                        Log.d(TAG, "onDataChange: Data has been changed");

                        adapter.addToEnd(PreviousMessages,true);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


    }

    public String  getOnetoOne(String  uid1,String uid2){

        return setOneToOneChat(uid1,uid2);
    }

}
