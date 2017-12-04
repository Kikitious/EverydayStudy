package com.katherine.du.everydaystudy.up20171121.biz;

import com.katherine.du.everydaystudy.up20171121.bean.User;

/**
 * Created by du on 17/11/21.
 */

public interface OnLoginListener {
    void loginSuccess(User user);

    void loginFailure();
}
