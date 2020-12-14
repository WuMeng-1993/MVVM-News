package com.wumeng.mvvm_news.bean.login;

/**
 * @author WuMeng
 * @date 2020/12/10
 * desc:
 */
public class ReqBean {

    private String userName;

    private String userPass;

    public ReqBean(String userName, String userPass) {
        this.userName = userName;
        this.userPass = userPass;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPass() {
        return userPass;
    }

}
