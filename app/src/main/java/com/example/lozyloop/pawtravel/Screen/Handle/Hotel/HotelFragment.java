package com.example.lozyloop.pawtravel.Screen.Handle.Hotel;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.lozyloop.pawtravel.R;
import com.example.lozyloop.pawtravel.Screen.ItemHotel.ItemHotelFragment;
import com.example.lozyloop.pawtravel.Utils.Helper;
import com.example.lozyloop.pawtravel.data.Adapter.DealAdapter;
import com.example.lozyloop.pawtravel.data.Adapter.PlaceAdapter;
import com.example.lozyloop.pawtravel.data.Adapter.WorldAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class HotelFragment extends Fragment implements DealAdapter.OnItemClick{

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<Integer> mImage = new ArrayList<>();

    private ArrayList<Integer> mImageDeal = new ArrayList<>();
    private ArrayList<Integer> mNameDeal = new ArrayList<>();
    private ArrayList<Integer> mNameMoney = new ArrayList<>();
    private ArrayList<Integer> mNameInfo = new ArrayList<>();
    private ArrayList<Integer> mNameEmpty = new ArrayList<>();

    private ArrayList<Integer> mImageWord1 = new ArrayList<>();
    private ArrayList<Integer> mImageWord2 = new ArrayList<>();

    private String[] items;
    private ArrayList<String> listItem;
    private ArrayAdapter<String> adapter;
    private ListView lv_place;
    private EditText et_place;


    public final static String BACK_STACK_HOTEL = "fragment hotel";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.hotel_fragment, container, false);
        init(v);
        initList();

        SearchText();

        getImage(v);
        getImageDeal(v);
        getImageWorld(v);
        return v;
    }

    public void getImage(View view){

        //add recycle place

        mImage.add(R.drawable.ic_travel3);
        mNames.add("AnyWhere");

        mImage.add(R.drawable.ic_travel2);
        mNames.add("AnyWhere");

        mImage.add(R.drawable.ic_travel1);
        mNames.add("AnyWhere");

        mImage.add(R.drawable.ic_travel4);
        mNames.add("AnyWhere");

        mImage.add(R.drawable.img_dalat_tour3);
        mNames.add("AnyWhere");



        initRecycleView(view);

    }

    public void getImageDeal(View view){

        mImageDeal.add(R.drawable.ic_travel1);
        mNameDeal.add(R.string.text_place_deal);
        mNameMoney.add(R.string.text_money_deal);
        mNameInfo.add(R.string.text_info_deal);
        mNameEmpty.add(R.string.text_empty_deal);

        mImageDeal.add(R.drawable.ic_travel2);
        mNameDeal.add(R.string.text_place_deal);
        mNameMoney.add(R.string.text_money_deal);
        mNameInfo.add(R.string.text_info_deal);
        mNameEmpty.add(R.string.text_empty_deal);

        mImageDeal.add(R.drawable.ic_travel3);
        mNameDeal.add(R.string.text_place_deal);
        mNameMoney.add(R.string.text_money_deal);
        mNameInfo.add(R.string.text_info_deal);
        mNameEmpty.add(R.string.text_empty_deal);

        mImageDeal.add(R.drawable.ic_travel4);
        mNameDeal.add(R.string.text_place_deal);
        mNameMoney.add(R.string.text_money_deal);
        mNameInfo.add(R.string.text_info_deal);
        mNameEmpty.add(R.string.text_empty_deal);

        mImageDeal.add(R.drawable.img_dalat_tour2);
        mNameDeal.add(R.string.text_place_deal);
        mNameMoney.add(R.string.text_money_deal);
        mNameInfo.add(R.string.text_info_deal);
        mNameEmpty.add(R.string.text_empty_deal);

        initRecycleViewDeal(view);
    }

    public void getImageWorld(View view){

        mImageWord1.add(R.drawable.img_dalat_tour1);
        mImageWord2.add(R.drawable.img_dalat_tour2);

        mImageWord1.add(R.drawable.img_dalat_tour3);
        mImageWord2.add(R.drawable.img_dalat_tour4);

        mImageWord1.add(R.drawable.ic_travel3);
        mImageWord2.add(R.drawable.ic_travel4);

        initRecycleViewWorld(view);
    }

    public void initRecycleView(View view){
        //recycle_place
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycle_place);
        recyclerView.setLayoutManager(layoutManager);
        PlaceAdapter adapter = new PlaceAdapter(getContext(), mNames, mImage);
        recyclerView.setAdapter(adapter);

    }

    public void initRecycleViewDeal(View view){
        //recycle_deal
        LinearLayoutManager layoutManager_deal = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView_deal = view.findViewById(R.id.recycle_deal);
        recyclerView_deal.setLayoutManager(layoutManager_deal);
        DealAdapter adapter1 = new DealAdapter(getContext(), mImageDeal, mNameDeal, mNameMoney, mNameInfo, mNameEmpty, this);
        recyclerView_deal.setAdapter(adapter1);
    }

    public void initRecycleViewWorld(View view){
        LinearLayoutManager layoutManager_world = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView_deal = view.findViewById(R.id.recycle_world);
        recyclerView_deal.setLayoutManager(layoutManager_world);
        WorldAdapter adapter2 = new WorldAdapter(getContext(), mImageWord1, mImageWord2);
        recyclerView_deal.setAdapter(adapter2);
    }

    public void init(View view){
        lv_place = view.findViewById(R.id.lv_place);
        et_place = view.findViewById(R.id.et_place);
    }

    public void initList(){
        items = getResources().getStringArray(R.array.Locate);
        listItem = new ArrayList<>(Arrays.asList(items));
        adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, listItem);
        lv_place.setAdapter(adapter);
        Helper.getListViewSize(lv_place);
    }

    public void SearchText(){

        et_place.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().equals("")){
                    initList();
                    lv_place.setVisibility(View.GONE);
                }else {
                    //perform search
                    SearchItem(s.toString());
                    lv_place.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void SearchItem(String textToSearch){
        for (String item:items){
            if (!item.contains(textToSearch)){
                listItem.remove(item);
            }
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(int position) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.addToBackStack(BACK_STACK_HOTEL);
        transaction.replace(R.id.layout_hotel, new ItemHotelFragment(), BACK_STACK_HOTEL);
        transaction.commit();
    }
}
