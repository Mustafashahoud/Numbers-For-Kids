package com.example.mustafa.numberforkids;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class Main2ActivityGallery extends AppCompatActivity {
    private final String image_title[]={
            "Img1",
            "Img2",
            "Img3",
            "Img4",
            "Img5",
            "Img6",
            "Img7",
            "Img8",
            "Img9",
            "Img10"
    };
    private  Integer image_ids[]={
            R.drawable.num1,
            R.drawable.num2,
            R.drawable.num3,
            R.drawable.num4,
            R.drawable.num5,
            R.drawable.num6,
            R.drawable.num7,
            R.drawable.num8,
            R.drawable.num9,
            R.drawable.num10,


    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_gallery);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.gallery);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),3);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<Cell> cells = prepareData();

        MyAdapter adapter = new MyAdapter(getApplicationContext(),cells);
        recyclerView.setAdapter(adapter);

    }

    private ArrayList<Cell> prepareData(){

        ArrayList<Cell> theImage= new ArrayList<>();

        for (int i = 0 ; i < image_title.length ; i++  ){
            Cell cell = new Cell();
            cell.setTitle(image_title[i]);
            cell.setImg(image_ids[i]);
            theImage.add(cell);
        }
        return theImage;

    }

//    public static Integer getImage(int position) {
//        return image_ids[position];
//
//    }
}
