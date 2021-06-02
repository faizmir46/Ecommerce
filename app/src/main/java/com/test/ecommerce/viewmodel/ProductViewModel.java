package com.test.ecommerce.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.test.ecommerce.model.RootModel;
import com.test.ecommerce.repository.ProductRepo;

import io.reactivex.disposables.CompositeDisposable;

public class ProductViewModel extends AndroidViewModel {
    private ProductRepo productRepo;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public ProductViewModel(@NonNull @io.reactivex.annotations.NonNull Application application) {
        super(application);
        productRepo = new ProductRepo();
    }

    public LiveData<RootModel> getProductDetails() {
        return  productRepo.callProductApis(getApplication(),compositeDisposable);
    }

    @Override
    protected void onCleared() {
        compositeDisposable.dispose();
        super.onCleared();
    }
}
