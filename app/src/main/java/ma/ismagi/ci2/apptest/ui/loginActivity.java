package ma.ismagi.ci2.apptest.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

import ma.ismagi.ci2.apptest.R;

public class loginActivity extends AppCompatActivity {
    TextInputEditText editTextEmail, editTextPassword;
    Button buttonLog;
    FirebaseAuth mAuth;
    ProgressBar progressBar;
    TextView textView;

    @Override
    protected void onStart() {
        super.onStart();
        mAuth = FirebaseAuth.getInstance(); // Initialisation de mAuth
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        editTextEmail = findViewById(R.id.etEmail);
        editTextPassword = findViewById(R.id.etPassword);
        buttonLog = findViewById(R.id.btn_connect);
        progressBar = findViewById(R.id.progressBar);
        textView = findViewById(R.id.btn_SignUp);

        textView.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), registerActivity.class);
            startActivity(intent);
            finish();
        });

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            // Si l'utilisateur est déjà connecté, rediriger vers MainFragment
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }
        buttonLog.setOnClickListener(v -> {
            progressBar.setVisibility(View.VISIBLE);
            buttonLog.setEnabled(false);

            String email = Objects.requireNonNull(editTextEmail.getText()).toString().trim();
            String password = Objects.requireNonNull(editTextPassword.getText()).toString().trim();

            if (TextUtils.isEmpty(email)) {
                progressBar.setVisibility(View.GONE);
                buttonLog.setEnabled(true);
                Toast.makeText(loginActivity.this, "Enter your email", Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(password)) {
                progressBar.setVisibility(View.GONE);
                buttonLog.setEnabled(true);
                Toast.makeText(loginActivity.this, "Enter Password", Toast.LENGTH_SHORT).show();
                return;
            }

            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task -> {
                        progressBar.setVisibility(View.GONE);
                        buttonLog.setEnabled(true);
                        if (task.isSuccessful()) {
                            Toast.makeText(loginActivity.this, "Login success", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            String errorMessage = task.getException() != null ? task.getException().getMessage() : "Authentication failed";
                            Toast.makeText(loginActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
                        }
                    });
        });
    }
}
