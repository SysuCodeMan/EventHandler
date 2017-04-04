package com.example.chen.experiment2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by Chen on 2016/10/4.
 */
public class extendActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.extend_page);

        final LinearLayout rootLayout = (LinearLayout)findViewById(R.id.rootLayout);

        final TextInputLayout usernameText = (TextInputLayout)findViewById(R.id.usernameText);
        final TextInputLayout passwordText = (TextInputLayout)findViewById(R.id.passwordText);
        final EditText usernameEdit = usernameText.getEditText();
        final EditText passwordEdit = passwordText.getEditText();

        Button login = (Button)findViewById(R.id.extendLogin);
        Button register = (Button)findViewById(R.id.extendRegister);

        RadioGroup Group = (RadioGroup)findViewById(R.id.extendGroup);
        final RadioButton student = (RadioButton)findViewById(R.id.extendStudent);
        final RadioButton teacher = (RadioButton)findViewById(R.id.extendTeacher);
        final RadioButton society = (RadioButton)findViewById(R.id.extendSociety);
        final RadioButton manager = (RadioButton)findViewById(R.id.extendManager);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                if (TextUtils.isEmpty(username)) {
                    usernameText.setErrorEnabled(true);
                    usernameText.setError("用户名不能为空");
                } else if(TextUtils.isEmpty(password)) {
                    usernameText.setErrorEnabled(false);
                    passwordText.setErrorEnabled(true);
                    passwordText.setError("密码不能为空");
                } else if (username.equals("Android") && password.equals("123456")) {
                    usernameText.setErrorEnabled(false);
                    passwordText.setErrorEnabled(false);
                    Snackbar.make(rootLayout, "登录成功", Snackbar.LENGTH_SHORT).setAction("按钮", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(extendActivity.this, "SnackBar的按钮被点击了", Toast.LENGTH_SHORT).show();
                        }
                    }).setActionTextColor(getResources().getColor(R.color.colorPrimary)).show();
                } else {
                    usernameText.setErrorEnabled(false);
                    passwordText.setErrorEnabled(false);
                    Snackbar.make(rootLayout,"登录失败", Snackbar.LENGTH_SHORT).setAction("按钮", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(extendActivity.this, "SnackBar的按钮被点击了", Toast.LENGTH_SHORT).show();
                        }
                    }).setActionTextColor(getResources().getColor(R.color.colorPrimary)).show();
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "身份注册功能尚未开启";
                if (student.isChecked())
                    message = "学生" + message;
                if (teacher.isChecked())
                    message = "教师" + message;
                if (society.isChecked())
                    message = "社团" + message;
                if (manager.isChecked())
                    message = "管理者" + message;
                Snackbar.make(rootLayout, message, Snackbar.LENGTH_SHORT).setAction("按钮", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(extendActivity.this, "SnackBar的按钮被点击了", Toast.LENGTH_SHORT).show();
                    }
                }).setActionTextColor(getResources().getColor(R.color.colorPrimary)).show();
            }
        });

        Group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String message = "身份被选中";
                if (checkedId == student.getId())
                    message = "学生" + message;
                if (checkedId == teacher.getId())
                    message = "教师" + message;
                if (checkedId == society.getId())
                    message = "社团" + message;
                if (checkedId == manager.getId())
                    message = "管理者" + message;
                Snackbar.make(rootLayout, message, Snackbar.LENGTH_SHORT).setAction("按钮", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(extendActivity.this, "SnackBar的按钮被点击了", Toast.LENGTH_SHORT).show();
                    }
                }).setActionTextColor(getResources().getColor(R.color.colorPrimary)).show();
            }
        });
    }
}
