package com.cst2335.manj0013;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    Switch aSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_relative);
        aSwitch =(Switch) findViewById(R.id.switch1);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton cb, boolean b) {
                Snackbar snackbar = Snackbar.make(aSwitch,"The switch is now "+(b?"ON":"OFF"),Snackbar.LENGTH_LONG)
                .setAction("Undo", click -> cb.setChecked(!b));
                snackbar.show();
            }
        });
    }
    public void click_Me_Toast(View v){
        Toast.makeText(MainActivity.this, getResources().getString(R.string.toast_message), Toast.LENGTH_LONG).show();
    }
//    public void onCheckedChanged(CompoundButton cb, boolean b){
//        aSwitch =(Switch) findViewById(R.id.switch1);
//        Snackbar snackbar = Snackbar.make(aSwitch,R.string.snackbar1,Snackbar.LENGTH_LONG)
//                .setAction("Undo", click -> cb.setChecked(!b));
//        snackbar.show();
//        //switch (buttonView.getID()){
//            //Snackbar snackbar = Snackbar.setAction("Undo", click -> cb.setChecked(!b));
//    }

}

