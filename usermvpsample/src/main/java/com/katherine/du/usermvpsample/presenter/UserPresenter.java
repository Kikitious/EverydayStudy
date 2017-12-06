package com.katherine.du.usermvpsample.presenter;

import android.text.TextUtils;

import com.katherine.du.usermvpsample.model.IUserModel;
import com.katherine.du.usermvpsample.model.OnSaveListener;
import com.katherine.du.usermvpsample.model.UserModel;
import com.katherine.du.usermvpsample.model.bean.User;
import com.katherine.du.usermvpsample.view.IUserActivityView;

/**
 * Created by du on 17/12/6.
 */
public class UserPresenter {

    private IUserActivityView userActivityView;
    private IUserModel userModel;

    public UserPresenter(IUserActivityView userActivityView) {
        this.userActivityView = userActivityView;
        this.userModel = new UserModel();
    }

    public void saveUserInfo() {
        String userId = userActivityView.getUserId();
        String firstName = userActivityView.getFirstName();
        String lastName = userActivityView.getLastName();
        if (TextUtils.isEmpty(userId) || TextUtils.isEmpty(firstName)
                || TextUtils.isEmpty(lastName)) {
            userActivityView.showToast("各项信息不能为空！");
        } else {
            User user = new User();
            user.setUsrId(userId);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            userModel.saveUserInfo(user, new OnSaveListener() {
                @Override
                public void onSuccess() {
                    userActivityView.showToast("存取成功！");
                    userActivityView.clearUserInfo();
                }

                @Override
                public void onFailure() {
                    userActivityView.showToast("存取失败！");
                }
            });
        }
    }

    public void readUserInfo() {
        User user = userModel.readUserInfo();
        if (user == null || user.getUsrId() == null) {
            userActivityView.showToast("读取失败！");
        } else {
            userActivityView.setUserInfo(user);
        }
    }
}
