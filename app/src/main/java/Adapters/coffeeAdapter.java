package Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import Models.coffeemodel;
import com.example.coffeeshop.databinding.CardviewBinding;
import com.example.coffeeshop.R;
import com.example.coffeeshop.detailActivity;

public class coffeeAdapter extends RecyclerView.Adapter<coffeeAdapter.viewholder> {
    final ArrayList<coffeemodel> list;
    final Context context;

    public coffeeAdapter(ArrayList<coffeemodel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Use View Binding for the cardview layout
        CardviewBinding binding = CardviewBinding.inflate(LayoutInflater.from(context), parent, false);
        View view = binding.getRoot();

        return new viewholder(view, binding);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        coffeemodel model = list.get(position);
        holder.binding.image.setImageResource(model.getImage());
        holder.binding.names.setText(model.getNames());
        holder.binding.orderprice.setText(String.valueOf(model.getPrice()));
        holder.binding.descrip1.setText(model.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, detailActivity.class);
                intent.putExtra("image", model.getImage());
                intent.putExtra("price", model.getPrice());
                intent.putExtra("description", model.getDescription());
                intent.putExtra("name", model.getNames());
                intent.putExtra("type", 1); // data insert kr rhy hain
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class viewholder extends RecyclerView.ViewHolder {
        final CardviewBinding binding;

        public viewholder(@NonNull View itemView, CardviewBinding binding) {
            super(itemView);
            this.binding = binding;
        }
    }
}
