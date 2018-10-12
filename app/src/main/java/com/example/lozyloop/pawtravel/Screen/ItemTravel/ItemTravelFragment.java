package com.example.lozyloop.pawtravel.Screen.ItemTravel;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lozyloop.pawtravel.R;
import com.example.lozyloop.pawtravel.data.Adapter.CoffeeAdapter;
import com.example.lozyloop.pawtravel.data.Model.coffee_shops;
import com.example.lozyloop.pawtravel.data.Source.Local.AuthenticationLocalDataSource;
import com.example.lozyloop.pawtravel.data.Source.Local.sharedprf.SharedPrefsImpl;
import com.example.lozyloop.pawtravel.data.Source.Remote.Api.RetrofitClient;
import com.example.lozyloop.pawtravel.data.Source.Remote.AuthenticationRemoteDataSource;
import com.example.lozyloop.pawtravel.data.Source.Repository.AuthenticationRepository;

import java.util.ArrayList;
import java.util.List;

public class ItemTravelFragment extends Fragment implements ItemTravelFragmentContract.View {

    ItemTravelFragmentPresenter mPresenter;

    AuthenticationRepository mAuthenticationRepository;

    AuthenticationLocalDataSource mAuthenticationLocalDataSource;
    AuthenticationRemoteDataSource mAuthenticationRemoteDataSource;

    SharedPrefsImpl mSharedPrefsImpl;

    RetrofitClient mRetrofitClient = new RetrofitClient();

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImage = new ArrayList<>();

    private TextView tv_image;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.item_travel_fragment, container, false);


        init(v);
        SlideImage();
        initRecyclerView();


        return v;
    }

//
//    private void getImages(View view){
//
//
//        mImage.add("https://firebasestorage.googleapis.com/v0/b/paw-travel-214608.appspot.com/o/1777b34723af5ecb92b2f4d67b21707c.jpg?alt=media\u0026token=ad8f81da-9b33-4112-aba8-841343231371");
//        mNames.add("SomeWhere");
//
//        mImage.add("https://firebasestorage.googleapis.com/v0/b/paw-travel-214608.appspot.com/o/c8843722b7da66631aa01c6638fe47eb.jpg?alt=media\u0026token=92e475b7-5efb-447c-bc75-43887ac7f72f");
//        mNames.add("SomeWhere");
//
//        mImage.add("https://firebasestorage.googleapis.com/v0/b/paw-travel-214608.appspot.com/o/2743bf642c9837cf2f582320025dafd2.jpg?alt=media\u0026token=db1bd8b1-0ac9-4e89-84ec-8f94b6a0dfe8");
//        mNames.add("SomeWhere");
//
//        mImage.add("https://firebasestorage.googleapis.com/v0/b/paw-travel-214608.appspot.com/o/42d1cc13a9411e8358d721ea58111d20.jpg?alt=media\u0026token=9ebc1490-3a42-446f-a86f-fab8987c5999");
//        mNames.add("SomeWhere");
//
//        mImage.add("https://firebasestorage.googleapis.com/v0/b/paw-travel-214608.appspot.com/o/7a6c07ae8f25a4bdceb0b9b2aeb10267.jpg?alt=media\u0026token=c8320852-b1e4-4dd5-9af4-88a7fc528b60");
//        mNames.add("SomeWhere");
//
//        mImage.add("https://firebasestorage.googleapis.com/v0/b/paw-travel-214608.appspot.com/o/feb32b902a36062175027e6f5cd89e4b.jpg?alt=media\u0026token=a5901bb8-e52a-4277-bb99-fbd78af4a8d8");
//        mNames.add("SomeWhere");
//
//
//
//
//        initRecyclerView(view);
//
//    }

    private void initRecyclerView(){

//        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
//        RecyclerView recyclerView = view.findViewById(R.id.recycle_shop);
//        recyclerView.setLayoutManager(layoutManager);
//        CoffeeAdapter adapter = new CoffeeAdapter(getContext(), mNames, mImage);
//        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        mPresenter.getData();
        ViewCompat.setNestedScrollingEnabled(recyclerView, false);
    }

    public void init(View view){
        tv_image = view.findViewById(R.id.tv_image);

        recyclerView = view.findViewById(R.id.recycle_shop);

        mAuthenticationLocalDataSource = new AuthenticationLocalDataSource(mSharedPrefsImpl);
        mAuthenticationRemoteDataSource = new AuthenticationRemoteDataSource(mRetrofitClient.provideNameApi(RetrofitClient.getGetInstanceFake()));

        mAuthenticationRepository = new AuthenticationRepository (mAuthenticationLocalDataSource,mAuthenticationRemoteDataSource);
        mPresenter = new ItemTravelFragmentPresenter(mAuthenticationRepository);
        mPresenter.setView(this);
    }

    public void SlideImage(){
        tv_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),SlideImageActivity.class);
                startActivity(intent);

            }
        });
    }

    @Override
    public void showData(List<coffee_shops> root) {
        CoffeeAdapter adapter = new CoffeeAdapter(getContext(), root);
        recyclerView.setAdapter(adapter);
    }


//    @Override
//    public void showData(List<coffee_shops> coffee_shops) {
//        CoffeeAdapter adapter = new CoffeeAdapter(getContext(), coffee_shops);
//        recyclerView.setAdapter(adapter);
//    }


}
