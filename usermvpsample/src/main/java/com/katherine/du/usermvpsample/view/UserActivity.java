package com.katherine.du.usermvpsample.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.katherine.du.usermvpsample.R;
import com.katherine.du.usermvpsample.model.bean.User;
import com.katherine.du.usermvpsample.presenter.UserPresenter;

public class UserActivity extends Activity implements
        View.OnClickListener, IUserActivityView {

    private EditText userIdEt;
    private EditText firstNameEt;
    private EditText lastNameEt;
    private Button saveBt;
    private Button readBt;
    private UserPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        findView();
        presenter = new UserPresenter(this);
    }

    private void findView() {
        userIdEt = (EditText) findViewById(R.id.usr_id_et);
        firstNameEt = (EditText) findViewById(R.id.first_name_et);
        lastNameEt = (EditText) findViewById(R.id.last_name_et);
        saveBt = (Button) findViewById(R.id.save_bt);
        readBt = (Button) findViewById(R.id.read_bt);
        saveBt.setOnClickListener(this);
        readBt.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.save_bt:
                presenter.saveUserInfo();
                break;
            case R.id.read_bt:
                presenter.readUserInfo();
                break;
        }
    }

    @Override
    public String getUserId() {
        return userIdEt.getText().toString().trim();
    }

    @Override
    public String getFirstName() {
        return firstNameEt.getText().toString().trim();
    }

    @Override
    public String getLastName() {
        return lastNameEt.getText().toString().trim();
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setUserInfo(User userInfo) {
        userIdEt.setText(userInfo.getUsrId());
        firstNameEt.setText(userInfo.getFirstName());
        lastNameEt.setText(userInfo.getLastName());
    }

    @Override
    public void clearUserInfo() {
        userIdEt.setText("");
        firstNameEt.setText("");
        lastNameEt.setText("");
    }
}
