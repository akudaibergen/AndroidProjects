package com.example.instagram;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FavouritePosts extends Fragment {
    private BottomNavigationView btmNav;
    View v;
    private FragmentBListener listener;
    private LikedPosts likedPosts;
    private boolean likedIs[]={true,false,true,false,true,false,true,false,false,false,false};
    private String users[],deccription[],title[];
    private RecyclerView recyclerView;
    private BottomNavigationView btm;
    private int image[]={R.drawable.one,R.drawable.second,R.drawable.three,R.drawable.four,R.drawable.five,
            R.drawable.six,R.drawable.seven,R.drawable.eight,R.drawable.nine,R.drawable.ten};

    public interface FragmentBListener {
        void onInputBSent(boolean abc[]);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         v= inflater.inflate(R.layout.fragment_favourites,container,false);
//         if(getActivity().getIntent()!=null){
//             likedPosts.likeIs=getActivity().getIntent().getBooleanArrayExtra("values");
//         }
        recyclerView = v.findViewById(R.id.recy_liked);
        users=getResources().getStringArray(R.array.users);
        deccription=getResources().getStringArray(R.array.description);

        likedPosts = new LikedPosts(v.getContext(),users,deccription,image,likedIs);
        recyclerView.setAdapter(likedPosts);
        recyclerView.setLayoutManager(new LinearLayoutManager((v.getContext())));
    //        btmNav=v.findViewById(R.id.bottom_navigation);
    //        btmNav.setOnNavigationItemSelectedListener(navListener);

        return v;
    }



}
