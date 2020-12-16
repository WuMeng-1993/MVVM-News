package com.wumeng.mvvm_news.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.wumeng.mvvm_news.MainActivity;
import com.wumeng.mvvm_news.R;
import com.wumeng.mvvm_news.bean.BaseReqData;
import com.wumeng.mvvm_news.bean.login.UserBean;
import com.wumeng.mvvm_news.config.HttpConfig;
import com.wumeng.mvvm_news.databinding.ActivityLoginBinding;

/**
 * 登录界面
 *
 * @author WuMeng
 */
public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding mActivityLoginBinding;

    private LoginViewModel mLoginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
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
                mLoginViewModel.login(getUserName(), getPass());
            }
        });

        mLoginViewModel.loginLiveData.observe(this, new Observer<BaseReqData<UserBean>>() {
            @Override
            public void onChanged(BaseReqData<UserBean> userBeanBaseReqData) {
                if (userBeanBaseReqData.getStatue().equals(HttpConfig.REQUEST_OK)) {
                    showToast(userBeanBaseReqData.getMsg());
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    showToast(userBeanBaseReqData.getMsg());
                }
            }
        });

    }

    /**
     * Toast提示
     *
     * @param message
     */
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * 获取输入框的用户名
     *
     * @return
     */
    private String getUserName() {
        return mActivityLoginBinding.etAccount.getText().toString().trim();
    }

    /**
     * 获取输入框的密码
     *
     * @return
     */
    private String getPass() {
        return mActivityLoginBinding.etPass.getText().toString().trim();
    }

}