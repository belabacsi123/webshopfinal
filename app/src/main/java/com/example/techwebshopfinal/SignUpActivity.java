package com.example.techwebshopfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {
    private static final String LOG_TAG = SignUpActivity.class.getName();
    private static final String PREF_KEY = SignUpActivity.class.getPackage().toString();

    EditText usernameET;
    EditText emailET;
    EditText passwordET;
    EditText passwordVerifyET;

    private SharedPreferences preferences;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        usernameET = findViewById(R.id.signUpUsername);
        emailET = findViewById(R.id.signUpEmail);
        passwordET = findViewById(R.id.signUpPassword);
        passwordVerifyET = findViewById(R.id.inputSignUpPasswordVerify);

        preferences = getSharedPreferences(PREF_KEY, MODE_PRIVATE);
        String email = preferences.getString("email", "");
        emailET.setText(email);

        mAuth = FirebaseAuth.getInstance();
    }

    public void sign_Up(View view) {
        String username = usernameET.getText().toString();
        String email = emailET.getText().toString();
        String password = passwordET.getText().toString();
        String passwordVerification = passwordVerifyET.getText().toString();

        if (!password.equals(passwordVerification)) {
            Log.e(LOG_TAG, "The password and the password verification don't match!");
            Toast.makeText(this, "The password and the password verification don't match!", Toast.LENGTH_SHORT).show();
            return;
        }

        Log.i(LOG_TAG, "Registered user " + username + ", email: " + email);

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Log.d(LOG_TAG, "User creation success!");
                    Toast.makeText(SignUpActivity.this, "User creation success!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Log.d(LOG_TAG, "User creation failed!");
                    Toast.makeText(SignUpActivity.this, "User creation failed! Problem: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void cancel(View view) {
        finish();
    }
}