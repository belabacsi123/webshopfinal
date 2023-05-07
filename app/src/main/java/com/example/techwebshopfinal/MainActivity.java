package com.example.techwebshopfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getName();
    private static final String PREF_KEY = MainActivity.class.getPackage().toString();

    EditText emailET;
    EditText passwordET;
    TextView title;
    Button login;
    Button register;
    TextView other;

    private SharedPreferences preferences;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        emailET = findViewById(R.id.inputEmail);
        passwordET = findViewById(R.id.inputPassword);
        title = findViewById(R.id.textView);
        other = findViewById(R.id.textView2);
        login = findViewById(R.id.button1);
        register = findViewById(R.id.button2);

        emailET.startAnimation(fadeIn);
        passwordET.startAnimation(fadeIn);
        title.startAnimation(fadeIn);
        other.startAnimation(fadeIn);
        login.startAnimation(fadeIn);
        register.startAnimation(fadeIn);


        preferences = getSharedPreferences(PREF_KEY, MODE_PRIVATE);
        mAuth = FirebaseAuth.getInstance();

    }

    public void login(View view) {
        String email = emailET.getText().toString();
        String password = passwordET.getText().toString();

        Log.i(LOG_TAG, "Successful login: " + email + ", password: " + password);

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Log.d(LOG_TAG, "Login success!");
                    shopping();
                } else {
                    Log.d(LOG_TAG, "Login failed!");
                    Toast.makeText(MainActivity.this, "Problem: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void shopping() {
        Intent intent = new Intent(this, ShoppingActivity.class);
        startActivity(intent);
    }

    public void sign_Up(View view) {
        Intent intent_Sign_Up = new Intent(this, SignUpActivity.class );
        startActivity(intent_Sign_Up);
    }

    @Override
    protected void onPause() {      // Ezzel viszem át az adatokat a SignUpActivity-be, annak esetén, ha beírt már valamit és azután nyomott a regisztrációs gombra
        super.onPause();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("email", emailET.getText().toString());
        editor.apply();
    }
}