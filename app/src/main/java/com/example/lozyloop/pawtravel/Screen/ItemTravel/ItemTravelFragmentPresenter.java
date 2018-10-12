package com.example.lozyloop.pawtravel.Screen.ItemTravel;

import android.util.Log;

import com.example.lozyloop.pawtravel.data.Model.Root;
import com.example.lozyloop.pawtravel.data.Model.coffee_shops;
import com.example.lozyloop.pawtravel.data.Source.Remote.Api.ApiService.BaseException;
import com.example.lozyloop.pawtravel.data.Source.Remote.Api.Error.RequestError;
import com.example.lozyloop.pawtravel.data.Source.Repository.AuthenticationRepository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class ItemTravelFragmentPresenter implements ItemTravelFragmentContract.Presenter {

    ItemTravelFragmentContract.View mView;
    AuthenticationRepository mAuthenticationRepository;
    CompositeDisposable mCompositeDisposable;

    public ItemTravelFragmentPresenter(AuthenticationRepository mAuthenticationRepository) {
        this.mAuthenticationRepository = mAuthenticationRepository;
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void getData() {
        onGetDataSuccess();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {
        mCompositeDisposable.clear();
    }

    public void setView(ItemTravelFragmentContract.View view ){
        this.mView = view;
    }

    private void onGetDataSuccess(){
//        Disposable disposable = mAuthenticationRepository.getCoffeeShop()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<List<coffee_shops>>() {
//                    @Override
//                    public void accept(List<coffee_shops> coffee_shops) throws Exception {
//                        mView.showData(coffee_shops);
//                    }
//                }, new RequestError() {
//                    @Override
//                    public void onRequestError(BaseException error) {
//                        Log.d("ABC", "error");
//                    }
//                });
//        mCompositeDisposable.add(disposable);

        Disposable disposable = mAuthenticationRepository.getTravelFragment()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Root>() {
                    @Override
                    public void accept(Root root) throws Exception {
                        mView.showData(root.getmCoffee_shops());
                    }
                });

        mCompositeDisposable.add(disposable);
    }
}
