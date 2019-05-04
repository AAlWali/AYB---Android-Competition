package com.example.home;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.BaseAdapter;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;

public class itemsAdapter extends ArrayAdapter<model> {
    private Context context;
    private ArrayList<model> modelArrayList;

    public itemsAdapter(@NonNull Context context, ArrayList<model> modelArrayList) {
        super(context, 0, modelArrayList);
        this.modelArrayList = modelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.item, null, true);
        }
        model models = getItem(position);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
        Picasso.get()
                .load(models.getImageLink())
                .into(imageView);

        TextView postName = convertView.findViewById(R.id.textView3);
        postName.setText(models.getName());

        TextView postPrice = convertView.findViewById(R.id.Price);
        postPrice.setText(models.getPrice());

        return convertView;

    }
}
