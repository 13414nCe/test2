package com.edu.mall.product.web;

/**
 * @author box
 * @date 2019/5/11 - 12:22
 */
public class Response {
    /**
     * 200表示成功
     * 500表示失败
     */
    private String code;
    private String msg;
    private Object data;

    public Response(String code,String msg) {
        this.code=code;
        this.msg=msg;
    }
    public Response(String code,String msg,Object data) {
        this.code=code;
        this.msg=msg;
        this.data=data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {

        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {

        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
