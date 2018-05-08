package com.example.dipankarghosh.observertest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * 2nd observer for the Subject (Test)
 * Test is the subject from where the value of string is passed
 * Observer needs to implement the method update()
 *   which will be called whenever there is any change in the Subject (test, in this case)
 */

public class SecondActivity extends AppCompatActivity implements Observer, View.OnClickListener{
// used the observer & View.OnClickListener
    BaseApp mBase;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBase = (BaseApp)getApplication();
        mBase.getObserver().addObserver(this); //registering the observer
        mButton = (Button)findViewById(R.id.button);
        mButton.setText("Name: "+mBase.getObserver().getName());
        Toast.makeText(this,"Currently getting the name",Toast.LENGTH_SHORT).show();
        mButton.setOnClickListener(this);
        // onClick second activity
    }

    @Override
    public void onClick(View view) {
        //Updating the subject (test)
        mBase.getObserver().setName("Sathya Babu ");
        // onclick on second activity the name changed is set by using the method getObserver()
        // once this is done the changed name reflects in the previous activity views.
    }

    /*
     * update will be called whenever there is any change in the Subject (test)
     */
    @Override
    public void update(Observable observable, Object o) {
        Toast.makeText(this, "SecondActivity is being informed "+mBase.getObserver().getName(), Toast.LENGTH_SHORT).show();
        mButton.setText("Changed Name: "+mBase.getObserver().getName());
        // Update method does what - getObserver.getname ; calls the getname method.
    }
}
