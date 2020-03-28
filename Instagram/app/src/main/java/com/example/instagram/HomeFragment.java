package com.example.instagram;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeFragment extends Fragment {
    private Intent intent;
     View rView;
    private FragmentAListener listener;
    private BottomNavigationView btmNav;
    private MyAdapter myAdapter;
    int index=0;
    boolean likeIs[]={false,false,false,false,false,false,false,false,false,false,};
    String users[],deccription[],title[];
    private RecyclerView recyclerView,recyclerView1;
    private ScrollView myScrollView;
    int image[]={R.drawable.one,R.drawable.second,R.drawable.three,R.drawable.four,R.drawable.five,
            R.drawable.six,R.drawable.seven,R.drawable.eight,R.drawable.nine,R.drawable.ten};

        public interface FragmentAListener{
        void onInputASent(boolean abc[]);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         rView =inflater.inflate(R.layout.fragment_home,container,false);
        myScrollView=rView.findViewById(R.id.my_scroll);
        recyclerView = rView.findViewById(R.id.recy_feed);
        recyclerView1=rView.findViewById(R.id.recy_stories);
        users=getResources().getStringArray(R.array.users);
        deccription=getResources().getStringArray(R.array.description);

        myAdapter= new MyAdapter(rView.getContext(),users,deccription,image,index,likeIs);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager((rView.getContext())));
        Stories stories = new Stories(rView.getContext(),users,image);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(rView.getContext());
        ((LinearLayoutManager) layoutManager).setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView1.setLayoutManager(layoutManager);
        recyclerView1.setAdapter(stories);

//        intent=new Intent(rView.getContext(),FavouritePosts.class);
//        intent.putExtra("values",myAdapter.likeIs);
//        rView.getContext().startActivity(intent);


        return rView;

    }
        public void updateLikesHome(boolean abc[]) {
        myAdapter.likeIs=abc;
    }






}
