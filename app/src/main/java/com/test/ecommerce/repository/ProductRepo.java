package com.test.ecommerce.repository;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.test.ecommerce.model.RootModel;
import com.test.ecommerce.networking.ApiClient;
import com.test.ecommerce.networking.ApiServices;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ProductRepo {


    public MutableLiveData<RootModel> callProductApis(Context context, CompositeDisposable
                                                      compositeDisposable){
        MutableLiveData<RootModel> modelMutableLiveData = new MutableLiveData<>();
        ApiServices apiServices = ApiClient.getClient(context).create(ApiServices.class);
                apiServices.getProductDetails().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(new Consumer<Disposable>() {
                            @Override
                            public void accept(Disposable disposable) throws Exception {
                                compositeDisposable.add(disposable);
                            }
                        })
                .subscribe(new Observer<RootModel>() {
                    @Override
                    public void onSubscribe(@io.reactivex.annotations.NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@io.reactivex.annotations.NonNull RootModel rootModel) {
                        modelMutableLiveData.setValue(rootModel);
                    }

                    @Override
                    public void onError(@io.reactivex.annotations.NonNull Throwable e) {
                        Log.d("==","d"+e.getMessage());


                    }

                    @Override
                    public void onComplete() {

                    }
                });
        return modelMutableLiveData;
    }

}
