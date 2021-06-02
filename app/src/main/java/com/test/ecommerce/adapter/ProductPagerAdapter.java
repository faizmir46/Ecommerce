package com.test.ecommerce.adapter;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.test.ecommerce.R;
import com.test.ecommerce.databinding.ItemProductImageBinding;

import java.util.List;

public class ProductPagerAdapter extends RecyclerView.Adapter<ProductPagerAdapter.ProductViewHolder> {
    private LayoutInflater layoutInflater;
    private List<String> productImageList;

    public ProductPagerAdapter(List<String> productImageList) {
        this.productImageList = productImageList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       if (layoutInflater == null) {
           layoutInflater = LayoutInflater.from(parent.getContext());
       }
       ItemProductImageBinding itemProductImageBinding =
               DataBindingUtil.inflate(layoutInflater, R.layout.item_product_image, parent, false);
        return new ProductViewHolder(itemProductImageBinding);
    }

    @Override
    public void onBindViewHolder(ProductPagerAdapter.ProductViewHolder holder, int position) {
        String image = productImageList.get(position);
        holder.itemProductImageBinding.setImage(image);

    }

    @Override
    public int getItemCount() {
        return productImageList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{
       ItemProductImageBinding itemProductImageBinding;

        public ProductViewHolder(ItemProductImageBinding itemProductImageBinding) {
            super(itemProductImageBinding.getRoot());
            this.itemProductImageBinding = itemProductImageBinding;
        }
    }
    public void setList(List<String> imagesList){
        this.productImageList = imagesList;
        notifyDataSetChanged();
    }
}
