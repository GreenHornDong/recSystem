package com.recSystem.Utils;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public List<B> bList;

    public List<B> getbList(){
        return bList;
    }

    public void setbList(List<B> bList){
        this.bList = bList;
    }

    public static void main(String[] args) throws IOException {
        File file = new File("D:/a.json");
        FileInputStream fis=new FileInputStream(file);
        try(Reader reader = new InputStreamReader(fis,"UTF-8")){
            Gson gson = new GsonBuilder().create();
            // Test p = gson.fromJson(reader, Test.class);
            JsonObject jsonObject = new JsonParser().parse(reader).getAsJsonObject();

            JsonArray b = jsonObject.getAsJsonArray("B");
            List<B> bList=new ArrayList<>();
            for (JsonElement o:b) {
                B content=gson.fromJson(o,new TypeToken<B>(){}.getType());
                bList.add(content);
            }

            // List<B> content = p.getbList();
            Integer count = 0;
//            for (B content1:content) {
//                System.out.println(content1.toString());
//                count++;
//                System.out.println(count);
//            }
        }
    }
}
