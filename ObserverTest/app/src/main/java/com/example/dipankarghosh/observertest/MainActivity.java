package com.example.dipankarghosh.observertest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer, View.OnClickListener{

    BaseApp mBase;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBase = (BaseApp) getApplication();
        mBase.getObserver().addObserver(this); //registering the observer
        mButton = (Button)findViewById(R.id.button);
        //Button linkage with the button with id - button
        mButton.setText("Name: "+mBase.getObserver().getName());
        //set the name of the button text - "Name: Dipankar Ghosh(Test)
        mButton.setOnClickListener(this);
        //OnclickListener(this) is called

    }

    /*
     * update will be called whenever there is any change in the Subject (test)
     */
    @Override
    public void update(Observable observable, Object o) {
        Toast.makeText(this, "MainActivity is being Notified of the name change "+mBase.getObserver().getName(), Toast.LENGTH_SHORT).show();
       //Toast is notifying that the MainActivity is being notified of the name change...
        mButton.setText("Name: "+mBase.getObserver().getName());
        //Observable and object
    }

    @Override
    public void onClick(View view)
    {
        startActivity(new Intent(this, SecondActivity.class));
        //start new activity i.e. move to second activity
    }
}
