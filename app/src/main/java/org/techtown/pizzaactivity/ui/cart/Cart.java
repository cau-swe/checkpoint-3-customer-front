package org.techtown.pizzaactivity.ui.cart;


public class Cart {
    private String id;
    private String name;
    private int number;

    public Cart( String name, int number){
        this.name = name;
        this.number = number;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int image) {
        this.number = number;
    }



    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }



}
