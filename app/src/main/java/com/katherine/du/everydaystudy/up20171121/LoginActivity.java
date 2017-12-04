package com.katherine.du.everydaystudy.up20171121;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.katherine.du.everydaystudy.BaseActivity;
import com.katherine.du.everydaystudy.MainActivity;
import com.katherine.du.everydaystudy.R;
import com.katherine.du.everydaystudy.up20171121.presenter.LoginPresenter;
import com.katherine.du.everydaystudy.up20171121.view.ILoginView;

/**
 * Created by du on 17/11/21.
 */

public class LoginActivity extends BaseActivity implements ILoginView {

    private EditText username;
    private EditText passward;
    private Button login;
    private ProgressBar progress;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        presenter = new LoginPresenter(this);
        findView();
    }

    private void findView() {
        progress = (ProgressBar) findViewById(R.id.progressbar);
        username = (EditText) findViewById(R.id.usrname);
        passward = (EditText) findViewById(R.id.passward);
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.login();
            }
        });
    }

    @Override
    public String getUserName() {
        return username.getText().toString();
    }

    @Override
    public String getPassward() {
        return passward.getText().toString();
    }

    @Override
    public void hideLoading() {
        progress.setVisibility(View.GONE);
    }

    @Override
    public void showLoading() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void goToMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
    }
}
