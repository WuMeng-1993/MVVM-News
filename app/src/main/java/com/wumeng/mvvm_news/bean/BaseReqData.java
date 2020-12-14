package com.wumeng.mvvm_news.bean;

/**
 * @author WuMeng
 * @date 2020/12/14
 * desc:
 */
public class BaseReqData<T> {

    private String statue;

    private String msg;

    private T body;

    public String getStatue() {
        return statue;
    }

    public void setStatue(String statue) {
        this.statue = statue;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
