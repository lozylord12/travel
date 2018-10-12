package com.example.lozyloop.pawtravel.Screen.ItemTravel;

import com.example.lozyloop.pawtravel.Screen.BasePresenter;
import com.example.lozyloop.pawtravel.data.Model.Root;
import com.example.lozyloop.pawtravel.data.Model.coffee_shops;

import java.util.List;

public class ItemTravelFragmentContract {

   interface View{
       void showData(List<coffee_shops> root);
   }

   interface Presenter extends BasePresenter<View>{
       void getData();
   }
}
