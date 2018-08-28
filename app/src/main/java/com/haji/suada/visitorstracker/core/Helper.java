package com.haji.suada.visitorstracker.core;

import android.content.Context;

import com.haji.suada.visitorstracker.model.data.Andelan;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Helper {
    private final Context context;

    public Helper(Context context) {
        this.context = context;
    }

    public String readFile(String fileName) throws IOException {
        BufferedReader reader = null;
        reader = new BufferedReader(new InputStreamReader(context.getAssets().open(fileName), "UTF-8"));

        String content = "";
        String line;
        while ((line = reader.readLine()) != null) {
            content = content + line;
        }

        return content;

    }

    public List<Andelan> getAndelans() {
        String jsonFileContent = null;
        List<Andelan> andelans = new ArrayList<>();
        try {
            jsonFileContent = readFile("andelans.json");
            JSONArray jsonArray = null;
            jsonArray = new JSONArray(jsonFileContent);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObj = jsonArray.getJSONObject(i);
                Integer id = jsonObj.getInt("id");
                String fullName = jsonObj.getString("full_name");
                String email = jsonObj.getString("email");
                andelans.add(new Andelan(id, fullName, email));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return andelans;

    }
}
