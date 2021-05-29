package org.techtown.pizzaactivity.ui.cart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.techtown.pizzaactivity.R;

import java.util.ArrayList;

public class CartFragment extends Fragment {

    public static ArrayList<Cart> carts = new ArrayList<>();

    public static CartAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_cart, container, false);

        RecyclerView recyclerView = v.findViewById(R.id.recyclerView_cart);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layoutManager);

        adapter = new CartAdapter();



        for(Cart i: carts){
            adapter.addItem(i);
        }

        recyclerView.setAdapter(adapter);


        return v;
    }
}