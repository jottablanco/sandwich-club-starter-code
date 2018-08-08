package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        Sandwich sandwich = null;
        try {
            JSONObject jsonSandwich = new JSONObject(json);
            JSONObject sandwichName = jsonSandwich.getJSONObject("name");
            String sandwichMainName = sandwichName.getString("mainName");
            JSONArray sandwichAlsoKnowAsArray = sandwichName.getJSONArray("alsoKnownAs");
            String sandwichPlaceOfOrigin = jsonSandwich.getString("placeOfOrigin");
            String sandwichDescription = jsonSandwich.getString("description");
            String sandwichImageUrl = jsonSandwich.getString("image");
            JSONArray sandwichIngredientsArray = jsonSandwich.getJSONArray("ingredients");

            List<String> sandwichAlsoKnownNames = new ArrayList<>();
            List<String> sandwichIngredientsList = new ArrayList<>();

            for(int i = 0; i < sandwichAlsoKnowAsArray.length(); i++) {
                sandwichAlsoKnownNames.add(sandwichAlsoKnowAsArray.get(i).toString());
            }

            for(int i = 0; i < sandwichIngredientsArray.length(); i++) {
                sandwichIngredientsList.add(sandwichIngredientsArray.get(i).toString());
            }

            sandwich = new Sandwich(sandwichMainName, sandwichAlsoKnownNames, sandwichPlaceOfOrigin,
                    sandwichDescription, sandwichImageUrl, sandwichIngredientsList);


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return sandwich;
    }
}
