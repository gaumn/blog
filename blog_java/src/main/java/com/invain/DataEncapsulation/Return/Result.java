package com.invain.DataEncapsulation.Return;

import lombok.Data;

/**
 * @autor invain
 * @date 2022/1/13
 **/
@Data
/**
 * 1.@Data可以为类提供读写功能，从而不用写get、set方法。
 * 2.@Data提供 equals()、hashCode()、toString() 方法
 **/
public class Result  {
    private  int code;
    private  String  message;
    private  Object  data;

    public static Result returnData(int code,String message,Object data){
        Result result=new Result();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }
    public  static Result success(Object data){
        Result result=new Result();
        result.setCode(200);
        result.setMessage("successful");
        result.setData(data);
        return result;
    }
    public  static Result err(String message ,Object data){
        Result result=new Result();
        result.setCode(400);
        result.setMessage(message);
        result.setData(data);
        return result;
    }
    public  static Result err(Object data){
        Result result=new Result();
        result.setCode(400);
        result.setMessage("err");
        result.setData(data);
        return result;
    }
}
