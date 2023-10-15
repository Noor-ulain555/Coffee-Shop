package Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.coffeeshop.R;
import com.example.coffeeshop.detailActivity;
import com.example.coffeeshop.databinding.OrderSampleBinding;
import java.util.ArrayList;
import Models.Ordermodel;
import data.DbHandler;

public class orderAdapter extends RecyclerView.Adapter<orderAdapter.viewholder> {
    private final ArrayList<Ordermodel> list;
    private final Context context;
    private final LayoutInflater layoutInflater;

    public orderAdapter(ArrayList<Ordermodel> list, Context context) {
        this.list = list;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        OrderSampleBinding binding = OrderSampleBinding.inflate(layoutInflater, parent, false);
        return new viewholder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        final Ordermodel model = list.get(position);
        OrderSampleBinding binding = holder.binding;

        binding.orderimage.setImageResource(model.getOrderImage());
        binding.orderNumber.setText(model.getOrderNumber());
        binding.price1.setText(String.valueOf(model.getPrice()));

        binding.orderItemName.setText(model.getSoldItemName());

        binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, detailActivity.class);
                intent.putExtra("id", Integer.parseInt(model.getOrderNumber()));
                intent.putExtra("type", 2);
                intent.putExtra("price", model.getPrice());
                context.startActivity(intent);
            }
        });

        binding.getRoot().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                new AlertDialog.Builder(context).setTitle("Delete Item").setIcon(R.drawable.warn)
                        .setMessage("Are you sure want to delete this item?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                DbHandler handler = new DbHandler(context);
                                if (handler.deleteOrder(model.getOrderNumber()) > 0) {
                                    Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(context, "error", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        }).show();

                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class viewholder extends RecyclerView.ViewHolder {
        OrderSampleBinding binding;

        public viewholder(OrderSampleBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
