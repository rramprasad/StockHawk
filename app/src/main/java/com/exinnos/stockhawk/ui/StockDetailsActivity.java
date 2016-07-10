package com.exinnos.stockhawk.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.exinnos.stockhawk.R;

public class StockDetailsActivity extends AppCompatActivity implements StockDetailsFragment.OnStockDetailsFragmentListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_details);

        if(savedInstanceState == null){
            StockDetailsFragment stockDetailsFragment = StockDetailsFragment.newInstance("YHOO", 0);
            getSupportFragmentManager().beginTransaction().replace(R.id.stock_details_fragment_container,stockDetailsFragment).commit();
        }
    }
}
