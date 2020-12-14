package com.wumeng.mvvm_news.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.wumeng.mvvm_news.R;
import com.wumeng.mvvm_news.bean.BaseReqData;
import com.wumeng.mvvm_news.bean.login.UserBean;
import com.wumeng.mvvm_news.databinding.ActivityLoginBinding;

/**
 * 登录界面
 * @author WuMeng
 */
public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding mActivityLoginBinding;

    private LoginViewModel mLoginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        mLoginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        clickEvent();
    }

    /**
     * 点击事件
     */
    private void clickEvent() {
        // 登录
        mActivityLoginBinding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoginViewModel.login(getUserName(),getPass());
            }
        });

        mLoginViewModel.loginLiveData.observe(this, new Observer<BaseReqData<UserBean>>() {
            @Override
            public void onChanged(BaseReqData<UserBean> userBeanBaseReqData) {

            }
        });
        
    }

    /**
     * 获取输入框的用户名
     * @return
     */
    private String getUserName() {
        return mActivityLoginBinding.etAccount.getText().toString().trim();
    }

    /**
     * 获取输入框的密码
     * @return
     */
    private String getPass() {
        return mActivityLoginBinding.etPass.getText().toString().trim();
    }

}