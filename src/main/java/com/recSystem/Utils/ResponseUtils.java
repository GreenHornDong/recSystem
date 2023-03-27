//package com.recSystem.Utils;
//
//import com.recSystem.Entity.DTO.BaseDTO;
//import com.recSystem.Entity.POJO.HttpResponse;
//
//
//public class ResponseUtils {
//    private static HttpResponse httpResponse;
//    //默认成功,无数据
//    public static <T extends BaseDTO> HttpResponse<T> success(){
//        return new HttpResponse<T>(httpResponse.getCode(),httpResponse.getMessage());
//    }
//    //成功，有数据
//    public static <T extends BaseDTO> HttpResponse<T> suc(T data){
//        HttpResponse<T> res = success();
//        res.setData(data);
//        return res;
//    }
//    public static HttpResponse<BaseDTO> suc(int code, String message){
//        HttpResponse<BaseDTO> res=success();
//        res.setCode(code);
//        res.setMessage(message);
//        res.setData(null);
//        return res;
//    }
//
//    //失败
//    public static <T extends BaseDTO> HttpResponse<T> fail(){
//        return new HttpResponse<T>(httpResponse.getCode(),httpResponse.getMessage());
//    }
//    //自定义错误信息
//    public static HttpResponse<BaseDTO> fail(int code, String message){
//        HttpResponse<BaseDTO> res=fail();
//        res.setCode(code);
//        res.setMessage(message);
//        res.setData(null);
//        return res;
//    }
//
//}
//
