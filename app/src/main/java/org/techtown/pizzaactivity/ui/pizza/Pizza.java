package org.techtown.pizzaactivity.ui.pizza;

import android.os.Build;


import androidx.annotation.RequiresApi;

import java.util.Objects;

public class Pizza {

    private String id;
    private String name;
    private int image;
    private String info;

    public Pizza(String id, String name, int image){
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setInfo(String info) { this.info = info; }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public String getInfo(){
        return info;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return id.equals(pizza.id) &&
                name.equals(pizza.name) &&
                image == pizza.image;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(id, name, image);
    }
}
