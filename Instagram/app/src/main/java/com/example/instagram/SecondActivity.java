package com.example.instagram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class SecondActivity extends AppCompatActivity {
    TextView userName,likername,posttime,likes;
    CircleImageView uploader,liker;
    ImageView post,like;
    String users;
    boolean okIs,lik;
    int image,cnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        userName=findViewById(R.id.tv_uploader_name_d);
        likername=findViewById(R.id.liker_name_d);
        uploader=findViewById(R.id.uploader_pro_pic_d);
        liker=findViewById(R.id.liker_pro_pic_d);
        post=findViewById(R.id.post_pic_d);
        like=findViewById(R.id.like_icon);
        likes=findViewById(R.id.tv_likes);
        getData();
        setData();
    }
    private void getData(){
        if(getIntent().hasExtra("users")&&getIntent().hasExtra("image")){
            users=getIntent().getStringExtra("users");
            image=getIntent().getIntExtra("image",1);
            okIs=getIntent().getBooleanExtra("bool",false);
        }
        else
        {}
    }
    private void setData(){
        userName.setText(users);
        likername.setText(users);
        uploader.setImageResource(image);
        liker.setImageResource(image);
        post.setImageResource(image);
        if(okIs==true){
            like.setBackgroundResource(R.drawable.liked);
//            cnt=Integer.parseInt(likes.getText().toString());
//            cnt++;
//            likes.setText(null);
            likes.setText("25" );
            lik=okIs;

        }
    }

    public void liked_is(View view) {
        cnt=Integer.parseInt(likes.getText().toString());
        if(lik!=true){
//            cnt++;
//            likes.setText(null);
            likes.setText("25");
            like.setBackgroundResource(R.drawable.liked);
            lik=true;
        }
        else
        {
//            cnt--;
//            likes.setText(null);
            likes.setText("24");
            like.setBackgroundResource(R.drawable.ic_favorite);
            lik=false;
        }
    }
}
