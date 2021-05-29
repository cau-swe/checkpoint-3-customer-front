package org.techtown.pizzaactivity.ui.pizza;

import android.view.View;

public interface OnPizzaClickListener {
    public void onItemClick(PizzaAdapter.ViewHolder holder, View view, int position);
}
