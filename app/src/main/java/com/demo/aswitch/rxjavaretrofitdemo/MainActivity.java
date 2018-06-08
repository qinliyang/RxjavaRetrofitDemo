package com.demo.aswitch.rxjavaretrofitdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.aswitch.rxjavaretrofitdemo.Molde.LoginResponseBean;
import com.demo.aswitch.rxjavaretrofitdemo.Presenter.LoginHelper;
import com.demo.aswitch.rxjavaretrofitdemo.View.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, LoginView {

    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.text_view)
    TextView textView;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;
    private Unbinder bind;
    private LoginHelper loginHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bind = ButterKnife.bind(this);
        loginHelper = new LoginHelper(this);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.login) {
            String username_text = username.getText().toString().trim();
            String password_text = password.getText().toString().trim();
            loginHelper.requestLogin(username_text, password_text);
        }
    }


    @Override
    public void onSuccess(LoginResponseBean loginResponseBean) {
        Toast.makeText(this,"令牌:" + loginResponseBean.accesstoken,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFailed() {
        Toast.makeText(this,"onFailed",Toast.LENGTH_LONG).show();
    }
}
