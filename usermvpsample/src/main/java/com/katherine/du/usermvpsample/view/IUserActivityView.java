package com.katherine.du.usermvpsample.view;

import com.katherine.du.usermvpsample.model.bean.User;

/**
 * Created by du on 17/12/6.
 */

public interface IUserActivityView {
    String getUserId();

    String getFirstName();

    String getLastName();

    void showToast(String msg);

    void setUserInfo(User userInfo);

    void clearUserInfo();

}
