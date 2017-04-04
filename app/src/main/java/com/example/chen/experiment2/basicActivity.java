package com.example.chen.experiment2;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by Chen on 2016/10/3.
 */
public class basicActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_page);

        Button login = (Button) findViewById(R.id.Login);
        Button register = (Button) findViewById(R.id.Register);
        final EditText userName = (EditText) findViewById(R.id.userName);
        final EditText password = (EditText) findViewById(R.id.password);
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radiogroup);
        final RadioButton student = (RadioButton)findViewById(R.id.student);
        final RadioButton teacher = (RadioButton)findViewById(R.id.teacher);
        final RadioButton society = (RadioButton)findViewById(R.id.society);
        final RadioButton manager = (RadioButton)findViewById(R.id.manager);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = userName.getText().toString();
                String pw = password.getText().toString();
                if (TextUtils.isEmpty(user)) {
                    Toast.makeText(basicActivity.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(pw)) {
                    Toast.makeText(basicActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
                } else if (user.equals("Android") && pw.equals("123456")) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(basicActivity.this);
                    alert.setTitle("提示");
                    alert.setMessage("登录成功");
                    alert.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(basicActivity.this, " “确定”按钮被点击", Toast.LENGTH_SHORT).show();
                        }
                    });
                    alert.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(basicActivity.this, "“取消”按钮被点击", Toast.LENGTH_SHORT).show();
                        }
                    });
                    alert.create();
                    alert.show();
                } else {
                    AlertDialog.Builder alert = new AlertDialog.Builder(basicActivity.this);
                    alert.setTitle("提示");
                    alert.setMessage("登录失败");
                    alert.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(basicActivity.this, " “确定”按钮被点击", Toast.LENGTH_SHORT).show();
                        }
                    });
                    alert.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(basicActivity.this, "“取消”按钮被点击", Toast.LENGTH_SHORT).show();
                        }
                    });
                    alert.create();
                    alert.show();
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "身份注册功能尚未开启";
                if (student.isChecked())
                    message = "学生"+ message;
                if (teacher.isChecked())
                    message = "教师"+ message;
                if (society.isChecked())
                    message = "社团" + message;
                if (manager.isChecked())
                    message = "管理者" + message;
                Toast.makeText(basicActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
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
                Toast.makeText(basicActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
