package com.minotaur;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.*;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Dima on 21.10.2017.
 */

public class navigation_class extends AppCompatActivity {

    private static final String TAG = "navigation_class";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_screen);
        Log.d(TAG, "onCreate: Starting.");


        ImageView position = (ImageView) findViewById(R.id.positionDisplay);

        position.setTranslationX(300);
        position.setTranslationY(300);

        Button btn = (Button) findViewById(R.id.go_back);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked btn.");

                Intent intent = new Intent(navigation_class.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
