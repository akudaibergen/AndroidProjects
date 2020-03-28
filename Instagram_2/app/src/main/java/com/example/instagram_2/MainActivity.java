package com.example.instagram_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {
    private MyAdapter myAdapter;
    boolean likeIs[],defLikes[]={false,false,false,false,false,false,false,false,false,false};
    int index=0;
    String users[],deccription[],title[];
    private RecyclerView recyclerView,recyclerView1;
    private ScrollView myScrollView;
    int image[]={R.drawable.one,R.drawable.second,R.drawable.three,R.drawable.four,R.drawable.five,
            R.drawable.six,R.drawable.seven,R.drawable.eight,R.drawable.nine,R.drawable.ten};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        if(getIntent().hasExtra("users1")&&getIntent().hasExtra("image1")){
//            users=getIntent().getStringArrayExtra("users1");
//            deccription=getIntent().getStringArrayExtra("users1");
//            likeIs=getIntent().getBooleanArrayExtra("bool1");
//            myAdapter= new MyAdapter(this,users,deccription,image,index,likeIs);
//        }
//        else {
//            likeIs=defLikes;
//            users=getResources().getStringArray(R.array.users);
//            deccription=getResources().getStringArray(R.array.description);
//            myAdapter= new MyAdapter(this,users,deccription,image,index,likeIs);
//
//        }
        if(savedInstanceState!=null){
            likeIs=savedInstanceState.getBooleanArray("likesIsGet");
        }else
        {
            likeIs=defLikes;
        }
            users=getResources().getStringArray(R.array.users);
            deccription=getResources().getStringArray(R.array.description);
            myAdapter= new MyAdapter(this,users,deccription,image,index,likeIs);
        myScrollView=findViewById(R.id.my_scroll);
        recyclerView = findViewById(R.id.recy_feed);
        recyclerView1=findViewById(R.id.recy_stories);


//        users=getResources().getStringArray(R.array.users);
//        deccription=getResources().getStringArray(R.array.description);
//        myAdapter= new MyAdapter(this,users,deccription,image,index,likeIs);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager((this)));
        Stories stories = new Stories(this,users,image);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        ((LinearLayoutManager) layoutManager).setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView1.setLayoutManager(layoutManager);
        recyclerView1.setAdapter(stories);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBooleanArray("likesIsGet",myAdapter.likeIs);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        boolean rr[] = savedInstanceState.getBooleanArray("likesIsGet");
    }
}
