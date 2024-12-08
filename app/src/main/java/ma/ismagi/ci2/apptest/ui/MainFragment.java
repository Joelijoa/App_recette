package ma.ismagi.ci2.apptest.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.List;

import ma.ismagi.ci2.apptest.viewModels.CategoryAdapter;
import ma.ismagi.ci2.apptest.R;
import ma.ismagi.ci2.apptest.models.Category;

public class MainFragment extends AppCompatActivity {

    private CategoryAdapter adapter;
    private List<Category> categoryList;
    private FirebaseFirestore db;
    private FirebaseStorage storage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        storage = FirebaseStorage.getInstance();
        categoryList = new ArrayList<>();
        adapter = new CategoryAdapter(categoryList, this);
        recyclerView.setAdapter(adapter);

        db = FirebaseFirestore.getInstance();
        loadCategoriesFromFirestore();
    }

    @SuppressLint("NotifyDataSetChanged")
    private void loadCategoriesFromFirestore() {
        db.collection("Category")
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    if (!queryDocumentSnapshots.isEmpty()) {
                        for (DocumentSnapshot doc : queryDocumentSnapshots) {
                            String name = doc.getString("name");
                            String desc = doc.getString("desc");
                            String img = doc.getString("img");

                            Category category = new Category(name, img,desc);
                            categoryList.add(category);

                        }
                        adapter.notifyDataSetChanged();
                    }
                })
                .addOnFailureListener(e -> Log.e("FirestoreError", "Erreur lors du chargement des catégories", e));
    }
}
