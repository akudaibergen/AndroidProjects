package com.example.instagram;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    boolean ok=false;
    int cnt;
    String users[],description[],numberLike;
    int image[];
    Context ct;
    int index;
    boolean likeIs[];
    public MyAdapter(Context ct, String users[], String description[], int image[], int index, boolean likeIs[]){
        this.ct=ct;
        this.users=users;
        this.description=description;
        this.image=image;
        this.index=index;
        this.likeIs=likeIs;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ct);
        View view = inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int i) {

            holder.userName.setText(users[i]);
            holder.likername.setText(users[i]);
            holder.uploader.setImageResource(image[i]);
            holder.liker.setImageResource(image[i]);
            holder.post.setImageResource(image[i]);
            if (likeIs[i] == true) {
                holder.likes.setBackgroundResource(R.drawable.liked);
                holder.numberOfLikes.setText("25");
            }

            holder.mainLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ct, SecondActivity.class);
                    intent.putExtra("users", users[i]);
                    intent.putExtra("image", image[i]);
                    intent.putExtra("bool", likeIs[i]);
                    ct.startActivity(intent);
                }
            });
            holder.likes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (likeIs[i] != true) {
                        holder.likes.setBackgroundResource(R.drawable.liked);
                        holder.numberOfLikes.setText("25");
                        likeIs[i] = true;
                    } else {

                        holder.likes.setBackgroundResource(R.drawable.ic_favorite);
                        likeIs[i] = false;
                        holder.numberOfLikes.setText("24");
                    }

                }
            });

        }


    @Override
    public int getItemCount() {
        return users.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView userName,likername,numberOfLikes;
        CircleImageView uploader,liker;
        ImageView post,likes;
        RelativeLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            userName= itemView.findViewById(R.id.tv_uploader_name);
            likername= itemView.findViewById(R.id.liker_name);
            uploader= itemView.findViewById(R.id.uploader_pro_pic);
            liker= itemView.findViewById(R.id.liker_pro_pic);
            post= itemView.findViewById(R.id.post_pic);
            mainLayout=itemView.findViewById(R.id.main_post);
            likes=itemView.findViewById(R.id.like_icon);
            numberOfLikes=itemView.findViewById(R.id.tv_likes);

        }
    }
}
