package ma.ismagi.ci2.apptest.viewModels;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import ma.ismagi.ci2.apptest.R;
import ma.ismagi.ci2.apptest.models.Category;
import ma.ismagi.ci2.apptest.ui.DetailsFragment;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private final List<Category> categoryList;
    private final Context context;

    public CategoryAdapter(List<Category> categoryList, Context context) {
        this.categoryList = categoryList;
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_category, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = categoryList.get(position);
        holder.tvName.setText(category.getName());
        holder.tvDesc.setText(category.getDesc());
        String imgUrl = category.getImg();

        if (imgUrl != null && !imgUrl.isEmpty()) {
            Glide.with(context)
                    .load(imgUrl)
                    .placeholder(R.drawable.password)
                    .into(holder.imgCategory);
        } else {
            Glide.with(context)
                    .load(R.drawable.password)
                    .into(holder.imgCategory);
        }

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailsFragment.class);
            intent.putExtra("categoryName", category.getName());
            intent.putExtra("categoryDesc", category.getDesc());
            intent.putExtra("categoryImg", category.getImg());
            context.startActivity(intent);
        });
    }


    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvDesc;
        ImageView imgCategory;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCategory = itemView.findViewById(R.id.imgCategory);
            tvName = itemView.findViewById(R.id.tvNameItem);
            tvDesc = itemView.findViewById(R.id.tvDescItem);

        }
    }
}
