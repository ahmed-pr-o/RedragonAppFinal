package com.example.redragonapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;



public class CartAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Product> cartItems;

    // Constructor
    public CartAdapter(Context context, ArrayList<Product> cartItems) {
        this.context = context;
        this.cartItems = cartItems;
    }

    @Override
    public int getCount() {
        return cartItems.size();
    }

    @Override
    public Object getItem(int position) {
        return cartItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.cart_item, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.cartProductImage);
        TextView nameView = convertView.findViewById(R.id.cartProductName);
        TextView priceView = convertView.findViewById(R.id.cartProductPrice);

        Product product = cartItems.get(position);
        if(product.getImageResource() != 0){
            imageView.setImageResource(product.getImageResource());
        } else {
            imageView.setImageResource(R.mipmap.ic_launcher);
        }
        nameView.setText(product.getName());
        priceView.setText(product.getPrice() + " $");

        return convertView;
    }
}

