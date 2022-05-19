package com.example.witsoverflow;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class temp extends AppCompatActivity {
    DatabaseReference database; //= FirebaseDatabase.getInstance().getReferen("Posts");
//    FirebaseFirestore firebaseFirestore;
  //  FirebaseAuth mAuth;
    String uuid;
    int oldVotes;
    int newVotes;

    public temp(String uuid){
        this.uuid = uuid;
    }

    /*@Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);
        RecyclerView rv = findViewById(R.id.postlist);
    }*/

    public void setVotes(int votes) {

//        database.child("Posts").addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if(snapshot.hasChild(uuid)){
//                oldVotes[0] = snapshot.child(uuid).child("upvote").getValue(Integer.class);
//                //updateVotes(oldVotes[0]);
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Log.w(TAG, "Failed to read value.", error.toException());
//            }
//        });
        this.oldVotes = votes;
    }

    public void addVotes(){
        this.newVotes = this.oldVotes + 1;
    }

    public int getVotes(){
        addVotes();
        return newVotes;
    }
/////

    public void sbVotes(){
        this.newVotes = this.oldVotes - 1;
    }

    public int getVotes2(){
        sbVotes();
        return newVotes;
    }

    public void updateupVotes(int newVotes){

        //update database
        HashMap post = new HashMap();
        post.put("upvote", newVotes);

        //database = FirebaseDatabase.getInstance().getReference("Posts");
        //uuid = mAuth.getCurrentUser().getUid().toString();
        database = FirebaseDatabase.getInstance().getReference("Posts");

        database.child(this.uuid).updateChildren(post).addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
                if (task.isSuccessful()){
                    //Toast.makeText(temp.this, "updated", Toast.LENGTH_SHORT).show();
                }else{
                    //Toast.makeText(temp.this, "failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //return uuid;
    }

    public void updatednVotes(int newVotes){

        //update database
        HashMap post = new HashMap();
        post.put("downvote", newVotes);

        //database = FirebaseDatabase.getInstance().getReference("Posts");
        //uuid = mAuth.getCurrentUser().getUid().toString();
        database = FirebaseDatabase.getInstance().getReference("Posts");

        database.child(this.uuid).updateChildren(post).addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
                if (task.isSuccessful()){
                    //Toast.makeText(temp.this, "updated", Toast.LENGTH_SHORT).show();
                }else{
                    //Toast.makeText(temp.this, "failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //return uuid;
    }

}
