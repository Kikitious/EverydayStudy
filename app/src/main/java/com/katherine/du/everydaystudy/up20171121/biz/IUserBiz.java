package com.katherine.du.everydaystudy.up20171121.biz;

/**
 * Created by du on 17/11/21.
 */

public interface IUserBiz {

    void login(String usrname, String pwd, OnLoginListener listener);
}
