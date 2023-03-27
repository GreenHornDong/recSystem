package com.recSystem.Utils;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonToMapper {
    public static void main(String args[]){
        JsonParser parse =new JsonParser();  //创建json解析器
        try {
            JsonReader jsonReader = new JsonReader(new FileReader("D:/arxiv-metadata-oai-snapshot.json"));
            jsonReader.setLenient(true);
            JsonObject json= parse.parse(jsonReader).getAsJsonObject();  //创建jsonObject对象
            //System.out.println("title:"+json.get("title").getAsInt());  //将json数据转为为int型的数据
            System.out.println("authors:"+json.get("title").getAsString());     //将json数据转为为String型的数据

            JsonObject result=json.get("title").getAsJsonObject();
            JsonObject today=result.get("authors").getAsJsonObject();
            System.out.println("title:"+today.get("title").getAsString());
            System.out.println("authors:"+today.get("authors").getAsString());

        } catch (JsonIOException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
