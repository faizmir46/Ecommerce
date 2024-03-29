package com.test.ecommerce.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.test.ecommerce.R;
import com.test.ecommerce.model.Attribute;

import java.util.List;

public class SpinnerAdapter extends ArrayAdapter<Attribute> {
    private List<Attribute> attributeList;
    public SpinnerAdapter(@NonNull Context context,List<Attribute> attributeList) {
        super(context, 0,attributeList);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }
    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }
    private View initView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.spinner_dropdown_view, parent, false
            );
        }
        TextView textViewName = convertView.findViewById(R.id.txtTitle);
        Attribute currentItem = getItem(position);
        if (currentItem != null) {
            textViewName.setText(currentItem.getValue());
        }
        return convertView;
    }
}
