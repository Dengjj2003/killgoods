package com.zking.killgoods.util;

import lombok.Data;

@Data
public class JsonResponseBody<T> {
    private int code;
    private String msg;
    private T data;
    private long total;

    public JsonResponseBody(){
        this.code=JsonResponseStatus.SUCCESS.getCode();
        this.msg=JsonResponseStatus.SUCCESS.getMsg();
    }

    public JsonResponseBody(JsonResponseStatus jsonResponseStatus){
        this.code=jsonResponseStatus.getCode();
        this.msg=jsonResponseStatus.getMsg();
    }
    public JsonResponseBody(T data,long total){
        this.code=JsonResponseStatus.SUCCESS.getCode();
        this.msg=JsonResponseStatus.SUCCESS.getMsg();
        this.data=data;
        this.total=total;
    }


}
