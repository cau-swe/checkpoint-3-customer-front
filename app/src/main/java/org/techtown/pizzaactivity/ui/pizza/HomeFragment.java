package org.techtown.pizzaactivity.ui.pizza;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.techtown.pizzaactivity.MainActivity;
import org.techtown.pizzaactivity.R;

public class HomeFragment extends Fragment {

    public static PizzaAdapter adapter;

    public static String name="";
    public static int image;
    public static String info="";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_pizza, container, false);

        RecyclerView recyclerView = v.findViewById(R.id.recyclerView_pizza);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);
        GridLayoutManager layoutManager = new GridLayoutManager(this.getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new PizzaAdapter();




       for(Pizza i: MainActivity.pizzaItem){
            adapter.addItem(i);
        }

        recyclerView.setAdapter(adapter);

       adapter.setOnItemClickListener(new OnPizzaClickListener() {
           @Override
           public void onItemClick(PizzaAdapter.ViewHolder holder, View view, int position) {
               Intent intent = new Intent(getContext(), PizzaInfoActivity.class);

               name = adapter.items.get(position).getName();
               image = adapter.items.get(position).getImage();
               info  = adapter.items.get(position).getInfo();
               startActivity(intent);
           }
       });

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}