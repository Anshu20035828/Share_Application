package digi.coders.loginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText editText;
    Button btnLogin;

    public int  status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); 

        editText = findViewById(R.id.editText);
        btnLogin = findViewById(R.id.LoginBtn);

      /*  btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String number = editText.getText().toString();
                if (!number.isEmpty()){
                   status = Integer.parseInt(number);

                    SharedPreferences sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("code", status);
                    editor.apply();

                    if (status == 1234) {

                        startActivity(new Intent(MainActivity.this, AdminActivity.class));

                    } else if (status == 1111) {

                        startActivity(new Intent(MainActivity.this, HomeActivity.class));
                    } else {
                        Toast.makeText(MainActivity.this, "Invalid Code", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
*/
        
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                String passcode = editText.getText().toString();
                if (passcode.equalsIgnoreCase("") || passcode==null){
                    Toast.makeText(MainActivity.this, "Enter you Password", Toast.LENGTH_SHORT).show();
                }
                
                SharedPreferences sharedPreferences = getSharedPreferences("passcode",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                if (passcode.equalsIgnoreCase("1234")) {
                    editor.putInt("flag ",1);
                    editor.apply();
                    startActivity(new Intent(MainActivity.this, HomeActivity.class));
                }
                else if (passcode.equalsIgnoreCase("1111")){
                    editor.putInt("flag",2);
                    editor.apply();
                    startActivity(new Intent(MainActivity.this, AdminActivity.class));
                }
                else {
                    Toast.makeText(MainActivity.this, "InValid NUmber", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}