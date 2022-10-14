package com.cst2335.manj0013;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ProfileActivity extends AppCompatActivity {
    private static final String TAG = "PROFILE_ACTIVITY";
    private EditText email;
    private ImageButton imageButton;
    private ImageView imgView;
    ActivityResultLauncher<Intent> myPictureTakerLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == Activity.RESULT_OK) {
                Intent data = result.getData();
                Bitmap imgbitmap = (Bitmap) data.getExtras().get("data");
                imgView.setImageBitmap(imgbitmap);
            } else if (result.getResultCode() == Activity.RESULT_CANCELED)
                Log.i(TAG, "User refused to capture a picture.");
        }
    });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Intent fromMain = getIntent();
        Log.e(TAG, "In function:" + "onCreate");
        email = findViewById(R.id.activity_profile_email);
        imageButton = findViewById(R.id.activity_profile_imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatchTakePictureIntent();
            }
        });
        email.setText(fromMain.getStringExtra("EMAIL"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "In function:" + "onPause");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "In function:" + "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "In function:" + "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "In function:" + "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "In function:" + "onDestroy");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e(TAG, "In function:" + "onActivityResult");
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            myPictureTakerLauncher.launch(takePictureIntent);
        }
    }
}