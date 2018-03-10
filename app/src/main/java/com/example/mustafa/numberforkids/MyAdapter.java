package com.example.mustafa.numberforkids;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by SAR on 28/02/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

//    private PopupWindow popupWindow;
//    private LayoutInflater layoutInflater;

    Intent intent;
    private ArrayList<Cell> galleryList;
    private Context context;

    public MyAdapter(Context context, ArrayList<Cell> galleryList) {
        this.galleryList = galleryList;
        this.context = context;
    }

    @Override
    public void onBindViewHolder(final MyAdapter.ViewHolder viewHolder, final int position) {

        viewHolder.title.setText(galleryList.get(position).getTitle());

        viewHolder.img.setScaleType(ImageView.ScaleType.FIT_CENTER);

        viewHolder.img.setImageResource(galleryList.get(position).getImg());




        //final ViewHolder mViewHolder = new ViewHolder();

//        viewHolder.img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //layoutInflater = (LayoutInflater) getApplicationContext(). getSystemService();
//
//                int j = viewHolder.getAdapterPosition();
//                intent = new Intent(context, Pop.class);
//                intent.putExtra("Index", j);
//                context.startActivity(intent);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//
//            }
//        });
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, final int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell, viewGroup, false);

        //ViewHolder viewHolder = new ViewHolder(view);
        return new ViewHolder(view);
    }


    @Override
    public int getItemCount() {
        return galleryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView title;
        private ImageView img;

        public ViewHolder(View view) {
            super(view);

            title = (TextView) view.findViewById(R.id.title);
            img = (ImageView) view.findViewById(R.id.img);
            img.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            int j = getAdapterPosition();
            intent = new Intent(context, Pop.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("Index", j);
            context.startActivity(intent);


        }
    }
}

    //    int[] icons;
//    int[] numbers;
//    Context context;
//    LayoutInflater layoutInflater;
//
//    public MyAdapter(Context context) {
//        this.context = context;
//    }
//
//
//    @Override
//    public int getCount() {
//        return numbers.length;
//    }
//
//    @Override
//    public Object getItem(int i) {
//        return numbers[i];
//    }
//
//    @Override
//    public long getItemId(int i) {
//        return i;
//    }
//
//    @Override
//    public View getView(int i, View view, ViewGroup viewGroup) {
//        View gridView = view;
//
//        if (view == null) {
//            layoutInflater = (LayoutInflater) context.
//                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            gridView = layoutInflater.inflate(R.layout.cell, null);
//
//
//        }
//
//        ImageView imageView = (ImageView) gridView.findViewById(R.id.icons);
//        TextView textView = (TextView) gridView.findViewById(R.id.numbers);
//        imageView.setImageResource(icons[i]);
//        textView.setText(numbers[i]);
//
//        return gridView;
//    }

