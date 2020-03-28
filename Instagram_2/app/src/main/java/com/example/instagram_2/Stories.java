package com.example.instagram_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import de.hdodenhof.circleimageview.CircleImageView;

public class Stories extends RecyclerView.Adapter<Stories.MyViewHolder> {
    int t=0;
    Context ct;
    String users[];
    int image[];
    public Stories(Context ct, String users[], int image[]){
        this.ct=ct;
        this.users=users;
        this.image=image;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ct);
        View view = inflater.inflate(R.layout.stories,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.storiesname.setText(users[position]);
            holder.stories.setImageResource(image[position]);
    }

    @Override
    public int getItemCount() {
       return image.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView storiesname;
        CircleImageView stories;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            storiesname= itemView.findViewById(R.id.stories_name);
            stories= itemView.findViewById(R.id.stories_pic);
        }
    }
}
