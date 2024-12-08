package ma.ismagi.ci2.apptest.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import ma.ismagi.ci2.apptest.R;

public class FooterActivity extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_footer);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.navigation_favorite){
                showFavorite();
                return true;
            }else if (itemId == R.id.navigation_add){
                showAdd();
                return true;

            } else if (itemId == R.id.navigation_profile) {
                showProfile();
                return true;
            }
            return false;
        });
    }

    private void showFavorite(){

    }

    private void showAdd(){

    }

    private void showProfile(){

    }
}