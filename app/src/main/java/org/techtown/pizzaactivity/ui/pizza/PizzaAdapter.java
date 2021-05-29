package org.techtown.pizzaactivity.ui.pizza;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.techtown.pizzaactivity.R;

import java.util.ArrayList;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.ViewHolder> implements OnPizzaClickListener {

    ArrayList<Pizza> items = new ArrayList<>();

    OnPizzaClickListener listener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.recycler_pizza, parent, false);
        return new ViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Pizza item = items.get(position);
        viewHolder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public void addItem(Pizza item) {
        items.add(item);
    }

    public void setOnItemClickListener(OnPizzaClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        LinearLayout linearLayout = view.findViewById(R.id.pizza_layout);
        if (listener != null) {
            listener.onItemClick(holder, view, position);


        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView pizzaName;
        ImageView pizzaImage;
        TextView restParking;
        TextView restTel;

        public ViewHolder(View itemView, final OnPizzaClickListener listener) {
            super(itemView);

            pizzaName = itemView.findViewById(R.id.pizza_text);
            pizzaImage = itemView.findViewById(R.id.pizza_image);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int position = getAdapterPosition();
                    if (listener != null) {
                        listener.onItemClick(ViewHolder.this, view, position);
                    }

                }
            });
        }

        public void setItem(Pizza item) {
            pizzaImage.setImageResource(item.getImage());
            pizzaName.setText(item.getName());

        }

    }

}
