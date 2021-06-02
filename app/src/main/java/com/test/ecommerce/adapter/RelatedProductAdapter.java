package com.test.ecommerce.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.test.ecommerce.R;
import com.test.ecommerce.databinding.ItemProductImageBinding;
import com.test.ecommerce.databinding.ItemRelatedProductRowBinding;
import com.test.ecommerce.model.AssociatedProduct;

import java.util.List;

public class RelatedProductAdapter extends RecyclerView.Adapter<RelatedProductAdapter.RelatedProductViewHolder> {
    private List<AssociatedProduct> associatedProductList;
    private LayoutInflater layoutInflater;

    public RelatedProductAdapter(List<AssociatedProduct> associatedProductList) {
        this.associatedProductList = associatedProductList;
    }

    @NonNull
    @Override
    public RelatedProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        ItemRelatedProductRowBinding itemRelatedProductRowBinding =
                DataBindingUtil.inflate(layoutInflater, R.layout.item_related_product_row, parent, false);
        return new RelatedProductViewHolder(itemRelatedProductRowBinding);
    }

    @Override
    public void onBindViewHolder(RelatedProductAdapter.RelatedProductViewHolder holder, int position) {
        AssociatedProduct associatedProduct = associatedProductList.get(position);
        holder.relatedProductRowBinding.setAProduct(associatedProduct);

    }

    @Override
    public int getItemCount() {
        return associatedProductList.size();
    }

    public void setAssociatedProductList(List<AssociatedProduct> associatedProductList){
        this.associatedProductList = associatedProductList;
        notifyDataSetChanged();
    }

    public class RelatedProductViewHolder extends RecyclerView.ViewHolder{
        private ItemRelatedProductRowBinding relatedProductRowBinding;

        public RelatedProductViewHolder(ItemRelatedProductRowBinding relatedProductRowBinding) {
            super(relatedProductRowBinding.getRoot());
            this.relatedProductRowBinding = relatedProductRowBinding;
        }
    }


}
