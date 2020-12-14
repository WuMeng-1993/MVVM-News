package com.wumeng.mvvm_news.repository;

import androidx.lifecycle.MutableLiveData;

import com.wumeng.mvvm_news.bean.BaseReqData;
import com.wumeng.mvvm_news.bean.login.UserBean;
import com.wumeng.mvvm_news.config.HttpConfig;
import com.wumeng.mvvm_news.config.UserConfig;

/**
 * @author WuMeng
 * @date 2020/12/14
 * desc: 登录 仓库 这里模拟网络请求获取的数据
 */
public class LoginRepository {

    public static MutableLiveData<BaseReqData<UserBean>> login(String username,String password) {
        BaseReqData<UserBean> baseReqData = new BaseReqData<>();
        if (username.equals(UserConfig.USER_NAME) && password.equals(UserConfig.USER_PASS)) {
            UserBean userBean = new UserBean();
            userBean.setNickName(username);
            userBean.setPassword(password);
            baseReqData.setBody(userBean);
            baseReqData.setMsg("登录成功");
            baseReqData.setStatue(HttpConfig.REQUEST_OK);
        } else {
            baseReqData.setMsg("用户名或密码错误");
            baseReqData.setStatue(HttpConfig.REQUEST_FAILED);
        }
        MutableLiveData<BaseReqData<UserBean>> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(baseReqData);
        return mutableLiveData;
    }

}
