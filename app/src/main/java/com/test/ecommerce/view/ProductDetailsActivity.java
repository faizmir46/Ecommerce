package com.test.ecommerce.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.test.ecommerce.adapter.ProductPagerAdapter;
import com.test.ecommerce.adapter.RelatedProductAdapter;
import com.test.ecommerce.adapter.SpinnerAdapter;
import com.test.ecommerce.databinding.ActivityProductDetailsBinding;
import com.test.ecommerce.model.AssociatedProduct;
import com.test.ecommerce.model.RootModel;
import com.test.ecommerce.viewmodel.ProductViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.NonNull;

public class ProductDetailsActivity extends AppCompatActivity {
    private ActivityProductDetailsBinding productDetailsBinding;
    private ProductPagerAdapter productPagerAdapter;
    private List<String> list = new ArrayList<>();
    private RelatedProductAdapter  relatedProductAdapter;
    private List<AssociatedProduct> imageList = new ArrayList<>();
    private ProductViewModel productViewModel;
    private SpinnerAdapter colorSpinnerAdapter;
    private SpinnerAdapter sizeSpinnerAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        productDetailsBinding = ActivityProductDetailsBinding.inflate(getLayoutInflater());
        setContentView(productDetailsBinding.getRoot());
        initViews();

    }

    private void initViews(){
        productViewModel = new ViewModelProvider(this).get(ProductViewModel.class);
        productPagerAdapter = new ProductPagerAdapter(list);
        productDetailsBinding.productViewPager.setAdapter(productPagerAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        productDetailsBinding.rcViewRelatedProduct.setLayoutManager(linearLayoutManager);
        relatedProductAdapter = new RelatedProductAdapter(imageList);
        productDetailsBinding.rcViewRelatedProduct.setAdapter(relatedProductAdapter);
        productViewModel.getProductDetails().observe(this, new Observer<RootModel>() {
            @Override
            public void onChanged(RootModel rootModel) {

                updateUI(rootModel);
            }
        });
    }

    private void updateUI(RootModel rootModel){
        productDetailsBinding.setData(rootModel.getData());
        productPagerAdapter.setList(rootModel.getData().getImages());
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(productDetailsBinding.tabLayout, productDetailsBinding.productViewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {}
                });
        tabLayoutMediator.attach();
        relatedProductAdapter.setAssociatedProductList(rootModel.getData().getAssociated_products());
        colorSpinnerAdapter = new SpinnerAdapter(ProductDetailsActivity.this,rootModel.getData().getConfigurable_option().get(0).getAttributes());
        sizeSpinnerAdapter = new SpinnerAdapter(ProductDetailsActivity.this,rootModel.getData().getConfigurable_option().get(1).getAttributes());
        productDetailsBinding.colorSpinner.setAdapter(colorSpinnerAdapter);
        productDetailsBinding.sizeSpinner.setAdapter(sizeSpinnerAdapter);

    }



}