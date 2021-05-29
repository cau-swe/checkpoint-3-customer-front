package org.techtown.pizzaactivity.ui.cart;

import androidx.recyclerview.widget.RecyclerView;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import org.techtown.pizzaactivity.R;

import java.util.ArrayList;


public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    ArrayList<Cart> items = new ArrayList<Cart>();



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.review_item_layout, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Cart item = items.get(position);
        viewHolder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(Cart item) {
        items.add(item);
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView cart_name;
        TextView cart_number;


        public ViewHolder(View itemView) {
            super(itemView);

            cart_name = itemView.findViewById(R.id.cart_name);
            cart_number = itemView.findViewById(R.id.cart_number);
        }

        public void setItem(Cart item) {
            cart_name.setText(item.getName());
            cart_number.setText(Integer.toString(item.getNumber())+" 개");
        }



    }


}

