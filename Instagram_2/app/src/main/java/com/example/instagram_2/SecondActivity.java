package com.example.instagram_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class SecondActivity extends AppCompatActivity {

    TextView userName,likername,posttime,likes;
    CircleImageView uploader,liker;
    ImageView post,like;
    String users[];
    boolean okIs[],lik;
    int image[],cnt,index;

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
            users=getIntent().getStringArrayExtra("users");
            image=getIntent().getIntArrayExtra("image");
            okIs=getIntent().getBooleanArrayExtra("bool");
            index=getIntent().getIntExtra("intIndex",1);
        }
        else
        {}
    }
    private void setData(){
        userName.setText(users[index]);
        likername.setText(users[index]);
        uploader.setImageResource(image[index]);
        liker.setImageResource(image[index]);
        post.setImageResource(image[index]);
        if(okIs[index]==true){
            like.setBackgroundResource(R.drawable.liked);
//            cnt=Integer.parseInt(likes.getText().toString());
//            cnt++;
//            likes.setText(null);
            likes.setText("25" );
            lik=okIs[index];

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
            okIs[index]=true;
        }
        else
        {
//            cnt--;
//            likes.setText(null);
            likes.setText("24");
            like.setBackgroundResource(R.drawable.ic_favorite);
            lik=false;
            okIs[index]=false;
        }
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);


    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("users1", users);
        intent.putExtra("image1", image);
        intent.putExtra("bool1", okIs);
        intent.putExtra("intIndex1",index);
        this.startActivity(intent);
    }
}
