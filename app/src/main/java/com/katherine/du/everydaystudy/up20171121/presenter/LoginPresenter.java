package com.katherine.du.everydaystudy.up20171121.presenter;

import android.os.Handler;

import com.katherine.du.everydaystudy.up20171121.bean.User;
import com.katherine.du.everydaystudy.up20171121.biz.IUserBiz;
import com.katherine.du.everydaystudy.up20171121.biz.OnLoginListener;
import com.katherine.du.everydaystudy.up20171121.biz.UserBiz;
import com.katherine.du.everydaystudy.up20171121.view.ILoginView;

/**
 * Created by du on 17/11/21.
 */
public class LoginPresenter {

    private ILoginView loginView;
    private IUserBiz userBiz;
    private Handler handler = new Handler();

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
        this.userBiz = new UserBiz();
    }

    public void login() {
        loginView.showLoading();
        userBiz.login(loginView.getUserName(), loginView.getPassward(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.hideLoading();
                        loginView.showToast("登录成功，欢迎您！ " + user.getUsrname());
                        loginView.goToMainActivity();
                    }
                });
            }

            @Override
            public void loginFailure() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.hideLoading();
                        loginView.showToast("登录失败");
                    }
                });
            }
        });
    }
}
