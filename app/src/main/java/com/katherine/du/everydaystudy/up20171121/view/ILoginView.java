package com.katherine.du.everydaystudy.up20171121.view;

/**
 * Created by du on 17/11/21.
 */

public interface ILoginView {

    String getUserName();

    String getPassward();

    void hideLoading();

    void showLoading();

    void showToast(String msg);

    void goToMainActivity();

}
