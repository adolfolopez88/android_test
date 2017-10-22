package com.minotaur;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = "HomeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d(TAG, "OnCreate: Starting.");
        Button go_to_nav = (Button) findViewById(R.id.go_to_nav);


        go_to_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Clicked go_to_nav.");
                Intent intent = new Intent(HomeActivity.this, navigation_class.class);
                startActivity(intent);
            }
        });
    }

        /** Called when the activity is first created.

            Button next = (Button) findViewById(R.id.go_to_nav);
            next.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent myIntent = new Intent(view.getContext(), Navig.class);
                    startActivityForResult(myIntent, 0);
                }*/

}
