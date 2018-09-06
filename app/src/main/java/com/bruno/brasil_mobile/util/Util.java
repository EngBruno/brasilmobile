package com.bruno.brasil_mobile.util;

import com.bruno.brasil_mobile.model.State;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Util {
    public static List<State> createListState(String json){
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<State>>(){}.getType();
        List<State> listState = gson.fromJson(json,listType);
        return listState;
    }
}
