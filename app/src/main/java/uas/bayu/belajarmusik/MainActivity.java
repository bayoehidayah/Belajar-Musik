package uas.bayu.belajarmusik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread timer = new Thread(){
            public void run(){
                try {
                    sleep(5000);
                } catch (Exception e) {
                    // TODO: handle exception
                } finally{
                    Intent i = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(i);
                }
            }
        };

        timer.start();
    }
}