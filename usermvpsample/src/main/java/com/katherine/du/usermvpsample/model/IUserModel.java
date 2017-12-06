package com.katherine.du.usermvpsample.model;

import com.katherine.du.usermvpsample.model.bean.User;

/**
 * Created by du on 17/12/6.
 */

public interface IUserModel {

    void saveUserInfo(User user, OnSaveListener listener);

    User readUserInfo();

}
