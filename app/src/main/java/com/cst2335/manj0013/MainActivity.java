package com.cst2335.manj0013;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    private EditText v_Email;
    private Button login_Button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = getSharedPreferences("com.cst2335.manj0013",MODE_PRIVATE);
        setContentView(R.layout.activity_main_linear);
        login_Button = (Button) findViewById(R.id.login);
        v_Email= findViewById(R.id.email_lab3);
        login_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToProfile = new Intent(MainActivity.this, ProfileActivity.class);
                goToProfile.putExtra("EMAIL",sharedPreferences.getString("email","") );
                startActivity(goToProfile);
            }
        });


        v_Email.setText(sharedPreferences.getString("email",""));
    }
    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences emailPreference = getSharedPreferences("com.cst2335.manj0013", MODE_PRIVATE);
        SharedPreferences.Editor editor = emailPreference.edit();
        editor.putString("email",v_Email.getText().toString());
        editor.apply();

    }
}

