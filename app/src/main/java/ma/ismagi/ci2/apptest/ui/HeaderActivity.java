package ma.ismagi.ci2.apptest.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import ma.ismagi.ci2.apptest.R;

public class HeaderActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header);

        mAuth = FirebaseAuth.getInstance();
        Button btnLogout = findViewById(R.id.logout);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logoutUser();
            }
        });

    }

    private void logoutUser() {
        Log.d("Logout", "Déconnexion en cours...");
        mAuth.signOut();
        Log.d("Logout", "Déconnexion réussie.");

        // Lancer la page de connexion après déconnexion
        Intent intent = new Intent(HeaderActivity.this, loginActivity.class);
        startActivity(intent);
        finish(); // Terminer HeaderActivity pour éviter de revenir à cette activité
    }


}