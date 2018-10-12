package com.example.lozyloop.pawtravel.Screen.Handle.Flight;

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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.lozyloop.pawtravel.R;
import com.example.lozyloop.pawtravel.Screen.ItemFlight.ItemFindFlightFragment;
import com.example.lozyloop.pawtravel.Screen.ItemHotel.ItemWriteRateFragment;
import com.example.lozyloop.pawtravel.Utils.Helper;
import com.example.lozyloop.pawtravel.data.Adapter.CityAdapter;
import com.example.lozyloop.pawtravel.data.Adapter.DealAdapter;
import com.example.lozyloop.pawtravel.data.Adapter.DealFlightAdapter;
import com.example.lozyloop.pawtravel.data.Adapter.DestinationAdapter;
import com.example.lozyloop.pawtravel.data.Adapter.PlaceAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class FlightFragment extends Fragment {

    private String[] items1;
    private ArrayList<String> listItem1;
    private ArrayAdapter<String> adapter1;
    private ListView lv_place_flight;
    private EditText et_place_flight;

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<Integer> mImage = new ArrayList<>();

    private ArrayList<Integer> mImageDeal = new ArrayList<>();
    private ArrayList<Integer> mNameDeal = new ArrayList<>();
    private ArrayList<Integer> mNameMoney = new ArrayList<>();
    private ArrayList<Integer> mNameInfo = new ArrayList<>();
    private ArrayList<Integer> mNameEmpty = new ArrayList<>();

    private ArrayList<String> mNamesCity = new ArrayList<>();
    private ArrayList<Integer> mImageCity = new ArrayList<>();

    Button btn_findflight;

    public final static String BACK_STACK_FLIGHT = "fragment flight";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.flight_fragment, container, false);
        init(v);
        initList();
        SearchText();

        getImage(v);
        getImageDeal(v);
        getImageCity(v);
        onClickEvent();
        return v;
    }

    public void getImage(View view){

        //add recycle place

        mImage.add(R.drawable.ic_travel3);
        mNames.add("DaNang");

        mImage.add(R.drawable.ic_travel2);
        mNames.add("SaiGon");

        mImage.add(R.drawable.ic_travel1);
        mNames.add("Hue");

        mImage.add(R.drawable.ic_travel4);
        mNames.add("HaNoi");

        mImage.add(R.drawable.img_dalat_tour3);
        mNames.add("QuangNam");



        initRecycleView(view);

    }

    public void getImageDeal(View view){

        mImageDeal.add(R.drawable.ic_travel1);
        mNameDeal.add(R.string.text_place_deal_flight);
        mNameMoney.add(R.string.text_money_deal_flight);
        mNameInfo.add(R.string.text_info_deal_flight);
        mNameEmpty.add(R.string.text_empty_deal_flight);

        mImageDeal.add(R.drawable.ic_travel2);
        mNameDeal.add(R.string.text_place_deal_flight);
        mNameMoney.add(R.string.text_money_deal_flight);
        mNameInfo.add(R.string.text_info_deal_flight);
        mNameEmpty.add(R.string.text_empty_deal_flight);

        mImageDeal.add(R.drawable.ic_travel3);
        mNameDeal.add(R.string.text_place_deal_flight);
        mNameMoney.add(R.string.text_money_deal_flight);
        mNameInfo.add(R.string.text_info_deal_flight);
        mNameEmpty.add(R.string.text_empty_deal_flight);

        mImageDeal.add(R.drawable.ic_travel4);
        mNameDeal.add(R.string.text_place_deal_flight);
        mNameMoney.add(R.string.text_money_deal_flight);
        mNameInfo.add(R.string.text_info_deal_flight);
        mNameEmpty.add(R.string.text_empty_deal_flight);

        mImageDeal.add(R.drawable.img_dalat_tour2);
        mNameDeal.add(R.string.text_place_deal_flight);
        mNameMoney.add(R.string.text_money_deal_flight);
        mNameInfo.add(R.string.text_info_deal_flight);
        mNameEmpty.add(R.string.text_empty_deal_flight);

        initRecycleViewDeal(view);
    }

    public void getImageCity(View view){

        //add recycle place

        mImageCity.add(R.drawable.ic_travel3);
        mNamesCity.add("DaNang");

        mImageCity.add(R.drawable.ic_travel2);
        mNamesCity.add("SaiGon");

        mImageCity.add(R.drawable.ic_travel1);
        mNamesCity.add("Hue");

        mImageCity.add(R.drawable.ic_travel4);
        mNamesCity.add("HaNoi");

        mImageCity.add(R.drawable.img_dalat_tour3);
        mNamesCity.add("QuangNam");



        initRecycleViewCity(view);

    }

    public void initRecycleView(View view){
        //recycle_place
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycle_destination);
        recyclerView.setLayoutManager(layoutManager);
        DestinationAdapter adapter = new DestinationAdapter(getContext(), mNames, mImage);
        recyclerView.setAdapter(adapter);

    }

    public void initRecycleViewDeal(View view){
        //recycle_deal
        LinearLayoutManager layoutManager_deal = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView_deal = view.findViewById(R.id.recycle_deal_flight);
        recyclerView_deal.setLayoutManager(layoutManager_deal);
        DealFlightAdapter adapter1 = new DealFlightAdapter(getContext(), mImageDeal, mNameDeal, mNameMoney, mNameInfo, mNameEmpty);
        recyclerView_deal.setAdapter(adapter1);
    }

    public void initRecycleViewCity(View view){
        //recycle_place
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycle_city);
        recyclerView.setLayoutManager(layoutManager);
        CityAdapter adapter2 = new CityAdapter(getContext(), mNamesCity, mImageCity);
        recyclerView.setAdapter(adapter2);

    }




    public void init(View view){
        lv_place_flight = view.findViewById(R.id.lv_place_flight);
        et_place_flight = view.findViewById(R.id.et_place_flight);
        btn_findflight = view.findViewById(R.id.btn_findflight);
    }

    public void initList(){
        items1 = getResources().getStringArray(R.array.Locate);
        listItem1 = new ArrayList<>(Arrays.asList(items1));
        adapter1 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, listItem1);
        lv_place_flight.setAdapter(adapter1);
        Helper.getListViewSize(lv_place_flight);
    }

    public void SearchText(){

        et_place_flight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().equals("")){
                    initList();
                    lv_place_flight.setVisibility(View.GONE);
                }else {
                    //perform search
                    SearchItem(s.toString());
                    lv_place_flight.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void SearchItem(String textToSearch){
        for (String item:items1){
            if (!item.contains(textToSearch)){
                listItem1.remove(item);
            }
        }
        adapter1.notifyDataSetChanged();
    }

    public void onClickEvent(){
        btn_findflight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.addToBackStack(BACK_STACK_FLIGHT);
                transaction.replace(R.id.layout_flight, new ItemFindFlightFragment(), BACK_STACK_FLIGHT);
                transaction.commit();
            }
        });
    }


}
