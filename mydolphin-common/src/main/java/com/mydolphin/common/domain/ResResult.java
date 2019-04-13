package com.mydolphin.common.domain;


/**
 * @author Ling
 * @create 2018-06-04-17:50
 **/
public class ResResult<T> {
    static final String SUCCESS = "ok";
    static final String FAIL = "fail";
    static final String ERROR = "error";
    private String code;
    private T data;
    private String msg;

    private ResResult(){}
    public ResResult(String code, T data) {
        this.code = code;
        this.data = data;
    }

    public static<T> ResResult success(T t){
        ResResult resResult = new ResResult();
        resResult.setCode(SUCCESS);
        resResult.setData(t);
        return resResult;
    }

    public static<T> ResResult success(String msg){
        ResResult resResult = new ResResult();
        resResult.setCode(SUCCESS);
        resResult.setMsg(msg);
        return resResult;
    }

    public static<T> ResResult fail(String msg) {
        ResResult resResult = new ResResult();
        resResult.setMsg(msg);
        resResult.setCode(FAIL);
        return resResult;
    }

    public static<T> ResResult error(String errMsg) {
        ResResult resResult = new ResResult();
        resResult.setMsg(errMsg);
        resResult.setCode(ERROR);
        return resResult;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
