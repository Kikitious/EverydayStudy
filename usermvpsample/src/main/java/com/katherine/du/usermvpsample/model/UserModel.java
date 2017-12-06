package com.katherine.du.usermvpsample.model;

import android.util.SparseArray;

import com.katherine.du.usermvpsample.common.C;
import com.katherine.du.usermvpsample.model.bean.User;

/**
 * Created by du on 17/12/6.
 */

public class UserModel implements IUserModel {

    SparseArray<User> users = new SparseArray<>();

    @Override
    public void saveUserInfo(User user, OnSaveListener listener) {
        if (user != null) {
            C.USER = user;
            listener.onSuccess();
        } else {
            listener.onFailure();
        }
    }

    @Override
    public User readUserInfo() {
        return C.USER;
    }
}
