package digi.coders.loginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    Intent a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

   /*     new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                SharedPreferences sharedPreferences = getSharedPreferences("login",MODE_PRIVATE);
                int status = sharedPreferences.getInt("Hello",0);

                if (status==1234){
                    startActivity(new Intent(SplashActivity.this,AdminActivity.class));
                }
                else if (status==1111){
                    startActivity(new Intent(SplashActivity.this,HomeActivity.class));
                }
                else {
                    startActivity(new Intent(SplashActivity.this,MainActivity.class));
                }
                finish();

            }
        },3000);

        */

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                SharedPreferences sharedPreferences = getSharedPreferences("passcode",MODE_PRIVATE);
                int status = sharedPreferences.getInt("flag",0);

                switch (status){
                    case 1:
                        a = new Intent(SplashActivity.this, HomeActivity.class);
                        break;

                    case 2:

                        a = new Intent(SplashActivity.this, AdminActivity.class);
                        break;
                    case 0:
                        a = new Intent(SplashActivity.this, MainActivity.class);
                }
                startActivity(a);
                finish();
            }
        },1000);

    }
}