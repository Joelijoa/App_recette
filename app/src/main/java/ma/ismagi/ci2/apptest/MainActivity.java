package ma.ismagi.ci2.apptest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.card.MaterialCardView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth auth;
    Button button, buttonMainDish, buttonDessert, buttonEntree,  buttonSnack;
    TextView textView;
    FirebaseUser user;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();
        button = findViewById(R.id.logout);
        buttonMainDish = findViewById(R.id.btn_Plat);
        buttonEntree = findViewById(R.id.btn_Entre);
        buttonDessert = findViewById(R.id.btn_Dessert);
        buttonSnack = findViewById(R.id.btn_snack);
        textView = findViewById(R.id.user_details);
        user = auth.getCurrentUser();

        if (user == null){
            Intent intent = new Intent(getApplicationContext(), login.class);
            startActivity(intent);
            finish();
        }else {
            textView.setText(user.getEmail());
        }
        
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), login.class);
                startActivity(intent);
                finish();
            }
        });
        buttonMainDish.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainDishActivity.class);
            startActivity(intent);
        });

        buttonEntree.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, EntreeActivity.class);
            startActivity(intent);
        });

        buttonDessert.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DessertActivity.class);
            startActivity(intent);
        });

        buttonSnack.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SnackActivity.class);
            startActivity(intent);
        });

        MaterialCardView cardMainDish = findViewById(R.id.card_main_dish);
        cardMainDish.setOnClickListener(v -> {
            cardMainDish.animate()
                    .scaleX(0.95f)
                    .scaleY(0.95f)
                    .setDuration(200)
                    .withEndAction(() -> {
                        cardMainDish.animate()
                                .scaleX(1f)
                                .scaleY(1f)
                                .setDuration(200)
                                .withEndAction(() -> {
                                    Intent intent = new Intent(MainActivity.this, MainDishActivity.class);
                                    startActivity(intent);
                                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                                });
                    });
        });

        MaterialCardView cardEntree = findViewById(R.id.card_starter);
        cardEntree.setOnClickListener(v -> {
            cardEntree.animate()
                    .scaleX(0.95f)
                    .scaleY(0.95f)
                    .setDuration(200)
                    .withEndAction(() -> {
                        cardEntree.animate()
                                .scaleX(1f)
                                .scaleY(1f)
                                .setDuration(200)
                                .withEndAction(() -> {
                                    Intent intent = new Intent(MainActivity.this, EntreeActivity.class);
                                    startActivity(intent);
                                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                                });
                    });
        });


        MaterialCardView cardDessert = findViewById(R.id.card_dessert);
        cardDessert.setOnClickListener(v -> {
            cardDessert.animate()
                    .scaleX(0.95f)
                    .scaleY(0.95f)
                    .setDuration(200)
                    .withEndAction(() -> {
                        cardDessert.animate()
                                .scaleX(1f)
                                .scaleY(1f)
                                .setDuration(200)
                                .withEndAction(() -> {
                                    Intent intent = new Intent(MainActivity.this, DessertActivity.class);
                                    startActivity(intent);
                                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                                });
                    });
        });


        MaterialCardView cardSnack = findViewById(R.id.card_snack);
        cardSnack.setOnClickListener(v -> {
            cardSnack.animate()
                    .scaleX(0.95f)
                    .scaleY(0.95f)
                    .setDuration(200)
                    .withEndAction(() -> {
                        cardSnack.animate()
                                .scaleX(1f)
                                .scaleY(1f)
                                .setDuration(200)
                                .withEndAction(() -> {
                                    Intent intent = new Intent(MainActivity.this, SnackActivity.class);
                                    startActivity(intent);
                                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                                });
                    });
        });
    }
}