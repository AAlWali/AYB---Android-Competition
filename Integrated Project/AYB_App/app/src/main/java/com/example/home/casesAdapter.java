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

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class casesAdapter extends ArrayAdapter<casemodel> {
    private Context context;
    private ArrayList<casemodel> modelArrayList;

    public casesAdapter(@NonNull Context context, ArrayList<casemodel> modelArrayList) {
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
        casemodel models = getItem(position);

        TextView postDetail = convertView.findViewById(R.id.Details);
        postDetail.setText(models.getDetails()
        );

        return convertView;

    }
}
