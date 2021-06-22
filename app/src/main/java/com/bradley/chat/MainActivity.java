package com.bradley.chat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.bradley.chatlib.Message;
import com.bradley.chatlib.MessageUtil;
import com.bradley.chatlib.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.stfalcon.chatkit.messages.MessageInput;
import com.stfalcon.chatkit.messages.MessagesList;
import com.stfalcon.chatkit.messages.MessagesListAdapter;

import java.util.UUID;

public class MainActivity extends AppCompatActivity implements MessagesListAdapter.OnLoadMoreListener {

    private MessageInput messageInput;
    private MessagesList messagesList;
    private MessagesListAdapter<Message> adapter;
    private  static User user;
    private static MessageUtil messageUtil;

    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = new User("BBJ","juma");

        init_widgets();
        init_adapter();



        messageUtil = new MessageUtil("1:401535359444:android:f70c983ccf2692f87b1e41","chattest-69f6b","AIzaSyBPRouw4sbdJTwfEofv9mqjDo35Hbfn7EA","https://chattest-69f6b-default-rtdb.firebaseio.com/",getApplicationContext());


        //ToDo: Create a loader to load as the messages are being fetched from the database
        //Todo: create a way to handle messages sent when there is no conection

        messageUtil.showPreviousMessages(adapter,user.getId(),"TMAK");

        messageInput.setInputListener(new MessageInput.InputListener() {
            @Override
            public boolean onSubmit(CharSequence input) {


                Message message = new Message(UUID.randomUUID().toString(),user,input.toString());
                messageUtil.sendMessage(message,user.getId(),"TMAK");
                return true;
            }
        });

    }

    private void init_widgets(){
        messageInput = findViewById(R.id.message_text);
        messagesList = findViewById(R.id.messagesList);


    }

    private void init_adapter(){
        adapter  = new MessagesListAdapter<>(user.getId(),null);
        adapter.setLoadMoreListener(this);
        messagesList.setAdapter(adapter);
    }

    @Override
    public void onLoadMore(int page, int totalItemsCount) {

    }


}