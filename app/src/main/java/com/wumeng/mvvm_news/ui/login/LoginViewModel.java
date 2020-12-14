package com.wumeng.mvvm_news.ui.login;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.wumeng.mvvm_news.bean.BaseReqData;
import com.wumeng.mvvm_news.bean.login.ReqBean;
import com.wumeng.mvvm_news.bean.login.UserBean;
import com.wumeng.mvvm_news.repository.LoginRepository;

/**
 * @author WuMeng
 * @date 2020/12/9
 * desc:
 */
public class LoginViewModel extends ViewModel {

    private final MutableLiveData<ReqBean> reqBeanMutableLiveData = new MutableLiveData<>();

    /**
     * 登录方法
     * @param userName
     * @param userPass
     */
    public void login(String userName,String userPass) {
        ReqBean reqBean = new ReqBean(userName,userPass);
        reqBeanMutableLiveData.setValue(reqBean);
    }

    public LiveData<BaseReqData<UserBean>> loginLiveData = Transformations.switchMap(reqBeanMutableLiveData, new Function<ReqBean, LiveData<BaseReqData<UserBean>>>() {
        @Override
        public LiveData<BaseReqData<UserBean>> apply(ReqBean input) {
            return LoginRepository.login(input.getUserName(),input.getUserPass());
        }
    });

}
