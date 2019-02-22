package com.example.kartikeyachaauhan.sample2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public int quantity=0;

    /**
     * These two methods adjust the quantity.
     */
    public void IncreaseQuantity(View view) {
        display(++quantity);
    }
    public void DecreaseQuantity(View view) {
        if(quantity==0){
            return;
        }
        display(--quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean haschocolateCheckBox = whippedCreamCheckBox.isChecked();

        EditText text = (EditText) findViewById(R.id.name_field);
        String name = text.getText().toString();

        int price = calculatePrice();
        String message = createOrderSummary(name, price, hasWhippedCream, haschocolateCheckBox);
        display(message);
    }

    /**
     * This method calculates price
     *
     * @return total price
     */
    private int calculatePrice() {
        return quantity * 5;
    }

    /**
     *
     * @param name of the customer
     * @param price of the order
     * @param addWhippedCream — whether user wants the whipped cream
     * @return text summary
     */
    private String createOrderSummary(String name, int price, boolean addWhippedCream, boolean addChocolate) {

        String priceMessage = "Name: " + name + "\n";
        priceMessage += "Add whipped cream? " + addWhippedCream + "\n";
        priceMessage += "Add chocolate? " + addChocolate + "\n";
        priceMessage += "Quantity: " + quantity + "\n";
        priceMessage += "Total: $" + price + "\n";
        priceMessage += "\nThank You!";
        return priceMessage;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(String message) {
        TextView orderSummaryView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryView.setText(message);
    }

}