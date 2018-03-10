package com.example.mustafa.numberforkids;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;

public class Pop extends AppCompatActivity {
    //private LayoutInflater layoutInflater;
    //private PopupWindow popupWindow;
    //RelativeLayout relativeLayout;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView imageView10;

    //Integer images[];
    Context context = Pop.this;
    int index;
    int index2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);

        //ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.activity_pop, null);
        imageView1 = (ImageView) findViewById(R.id.fullScreenImageView1);

        Intent intent = getIntent();

        if (intent != null){
            index = intent.getIntExtra("Index", index);
            if (intent!=null && index != -1){
        }
        switch (index) {
            case 0:
                Glide.with(context).load(R.drawable.num1).into(imageView1);
                break;
            case 1:
                Glide.with(context).load(R.drawable.num2).into(imageView1);
                break;
            case 2:
                Glide.with(context).load(R.drawable.num3).into(imageView1);
                break;
            case 3:
                Glide.with(context).load(R.drawable.num4).into(imageView1);
                break;
            case 4:
                Glide.with(context).load(R.drawable.num5).into(imageView1);
                break;
            case 5:
                Glide.with(context).load(R.drawable.num6).into(imageView1);
                break;
            case 6:
                Glide.with(context).load(R.drawable.num7).into(imageView1);
                break;
            case 7:
                Glide.with(context).load(R.drawable.num8).into(imageView1);
                break;
            case 8:
                Glide.with(context).load(R.drawable.num9).into(imageView1);
                break;
            case 9:
                Glide.with(context).load(R.drawable.num10).into(imageView1);
                break;
        }


//        Glide.with(context).load(R.drawable.).into();
//
//
//
//
//        Intent intent = getIntent();
//        for (int i = 0 ; i<10 ; i++){
//             images[i] = intent.getIntExtra("img",i);
//
//
//        }


    }
    }

}
//.........................................................

//        relativeLayout = (RelativeLayout) findViewById(R.id.test);
//        layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
//
//
//
//        popupWindow = new PopupWindow(container, ViewGroup.LayoutParams.FILL_PARENT, RecyclerView.LayoutParams.FILL_PARENT, true);
//        popupWindow.showAtLocation(relativeLayout, Gravity.CENTER, 500, 500);

//        private void showpopup()
//        {
//            LayoutInflater inflater = this.getLayoutInflater();
//            View mView= inflater.inflate(R.layout.popup,(ViewGroup)findViewById(R.id.lnparentpopup));
//            PopupWindow mPopupWindow = new PopupWindow(mView, ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT, false);
//            mPopupWindow.setAnimationStyle(android.R.style.Animation_Dialog);
//
//            TextView TV=(TextView)this.findViewById(R.id.txtmain);
//            // TableLayout L1 = (TableLayout)findViewById(R.id.tblntarialview);
//
//            mPopupWindow.showAtLocation(TV, Gravity.CENTER, 45, 0);
//
//        }
//
//    }
//}
