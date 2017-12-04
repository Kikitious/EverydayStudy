package com.katherine.du.everydaystudy.up20171121.biz;

import com.katherine.du.everydaystudy.up20171121.bean.User;

/**
 * Created by du on 17/11/21.
 */
public class UserBiz implements IUserBiz {


    @Override
    public void login(final String usrname, final String pwd, final OnLoginListener listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    listener.loginFailure();
                }
                if (usrname.equals("dhl") && pwd.equals("123456")) {
                    User user = new User();
                    user.setPassward(pwd);
                    user.setUsrname(usrname);
                    listener.loginSuccess(user);
                } else {
                    listener.loginFailure();
                }
            }
        }).start();
    }



}
