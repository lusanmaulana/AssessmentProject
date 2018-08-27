package com.tujuhsembilan.assessmentproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    public static final String STRING_EXTRA_MSG = "username";

    TextView tvUsername, tvPassword;
    String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvUsername = findViewById(R.id.etUsername);
        tvPassword = findViewById(R.id.etPassword);
    }

    public void btnLoginOnClick(View v){
        username = tvUsername.getText().toString();
        password = tvPassword.getText().toString();

        if(!username.equals("") && !password.equals("")){
            Intent main = new Intent(getApplicationContext(), MainActivity.class);
            main.putExtra(STRING_EXTRA_MSG, username);
            startActivity(main);
            this.finish();
        }else{
            Toast t = Toast.makeText(getApplicationContext(), "Invalid username or password.", Toast.LENGTH_SHORT);
            t.show();
        }
    }
}
