package com.example.diksh.firebase;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ErrorCodes;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    private static final int RC_SIGN_IN = 1000;
    Button button;
    EditText edittext;

    ListView listView;
    ArrayList<String>notes=new ArrayList<>();
    ArrayAdapter<String>arrayAdapter;
    FirebaseUser firebaseuser;
    // the user currenlyusing this app
    // if firebaseuser==null then user is not logged in else it is logged in



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button =findViewById(R.id.btnDB);
        edittext=findViewById(R.id.editext);
        listView=findViewById(R.id.lview);
        arrayAdapter=new ArrayAdapter<String>(
                this
                ,android.R.layout.simple_list_item_1,
                notes);

          listView.setAdapter(arrayAdapter);


          firebaseuser=FirebaseAuth.getInstance().getCurrentUser();

          if(firebaseuser!=null){
              //Logged in
              addlisterners();
          }
          else{
              //Logged out
              startActivityForResult(
                      AuthUI.getInstance()
                              .createSignInIntentBuilder()
                              .setIsSmartLockEnabled(false)//disabled google smart lock
                              .setAvailableProviders(Arrays.asList(
                                      new AuthUI.IdpConfig.GoogleBuilder().build(),
                                      new AuthUI.IdpConfig.EmailBuilder().build(),
                                      new AuthUI.IdpConfig.PhoneBuilder().build()
                                      ))
                              .build(),
                      RC_SIGN_IN);
          }



    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // RC_SIGN_IN is the request code you passed into startActivityForResult(...) when starting the sign in flow.
        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            // Successfully signed in
            if (resultCode == RESULT_OK) {

                firebaseuser=FirebaseAuth.getInstance().getCurrentUser();

                addlisterners();
                //Toast.makeText(this, String.valueOf(firebaseuser.getDisplayName())+"\n "+String.valueOf(firebaseuser.getUid()), Toast.LENGTH_SHORT).show();



            } else {
                // Sign in failed
                if (response == null) {
                    // User pressed back button

                    return;
                }

                if (response.getError().getErrorCode() == ErrorCodes.NO_NETWORK) {

                    return;
                }


            }
        }
    }

    public void addlisterners(){
        final DatabaseReference dbRef=FirebaseDatabase.getInstance().getReference();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String noteyy=edittext.getText().toString();



                //upload the note
                //overrides the earlier save
                //FirebaseDatabase.getInstance().getReference().setValue(note);


                //no overring
                //FirebaseDatabase.getInstance().getReference().push().setValue(note);


                //saving value in two seperate nodes
                dbRef.child("note").child(firebaseuser.getUid()).push().setValue(noteyy);
               /* dbRef.child("seperateChild").push().setValue(note);
                dbRef.child("seperateNote").push().setValue(note);*/

                //save using Note class

               /* Note n=new Note("Hello","World");
                dbRef.child("note").push().setValue(n);
                dbRef.child("seperateChild").push().setValue(n);
                dbRef.child("seperateNote").push().setValue(n);

                */
            }
        });
        dbRef.child("note").child(firebaseuser.getUid()).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                // Called when a new data node is inserted to the note node
                // all the value are stored in the datasnapshot


                // Note data=dataSnapshot.getValue(Note.class);

                String data=dataSnapshot.getValue(String.class);
                notes.add(data);

                arrayAdapter.notifyDataSetChanged();







            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                //An existing data node is updated
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                // when a data at a subnode is removed
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                // when the position of a subnode changes
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // when the read operation is failed
            }
        });

    }


}
