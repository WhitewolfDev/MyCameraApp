package com.example.android.mycameraapp;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button pictureButton = (Button) findViewById(R.id.takeAPictureButton);
        View.OnClickListener pictureListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // taking the picture
                dispatchTakePictureIntent();
            }
        };
        pictureButton.setOnClickListener(pictureListener);
    }

    private void dispatchTakePictureIntent() {

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // resolveActivity is used to return the first Activity that can handle the intent...
        // if nothing can handle the intent, a null is returned.  Otherwise, trying to
        // run the startActivity that no app can handle will crash the program.
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }
}
