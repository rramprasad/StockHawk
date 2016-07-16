package com.exinnos.stockhawk.ui;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.db.chart.model.LineSet;
import com.db.chart.view.LineChartView;
import com.exinnos.stockhawk.R;

/**
 *
 * Stock Details Fragment to display stock price over time.
 * Activities that contain this fragment must implement the
 * {@link StockDetailsFragment.OnStockDetailsFragmentListener} interface
 * to handle interaction events.
 */
public class StockDetailsFragment extends Fragment {

    private static final String ARG_STOCK_SYMBOL = "stock_symbol";
    private static final String ARG_STOCK_LOCAL_DB_ID = "stock_local_db_id";

    private String stockSymbol;
    private int stockLocalDBId;

    private OnStockDetailsFragmentListener mListener;
    private View rootView;
    private ImageButton playButton;
    private ImageButton refreshButton;
    private String[] mLabels = {"06/7","07/7","08/7","09/7","10/7","11/7","12/7","13/7","14/7","15/7"};
    private float[] mValues = {37.25f,98.50f,717.31f,53.41f,37.25f,98.50f,717.31f,53.41f,717.31f,53.41f};
    private LineChartView lineChartView;

    public StockDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param stockSymbol Parameter 1.
     * @param stockLocalDBId Parameter 2.
     * @return A new instance of fragment StockDetailsFragment.
     */
    public static StockDetailsFragment newInstance(String stockSymbol, int stockLocalDBId) {
        StockDetailsFragment fragment = new StockDetailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_STOCK_SYMBOL, stockSymbol);
        args.putInt(ARG_STOCK_LOCAL_DB_ID, stockLocalDBId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            stockSymbol = getArguments().getString(ARG_STOCK_SYMBOL);
            stockLocalDBId = getArguments().getInt(ARG_STOCK_LOCAL_DB_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_stock_details, container, false);

        RelativeLayout chartToolbar = (RelativeLayout)rootView.findViewById(R.id.chart_toolbar);

        playButton = (ImageButton)chartToolbar.findViewById(R.id.play_button);
        refreshButton = (ImageButton)chartToolbar.findViewById(R.id.refresh_button);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 //showChart();
            }
        });

        lineChartView = (LineChartView) rootView.findViewById(R.id.stock_line_chart);


        showChart();

        return rootView;
    }

    private void showChart() {

        LineSet lineSet = new LineSet(mLabels, mValues);
        lineSet.setColor(Color.parseColor("#b3b5bb"))
                .setFill(Color.parseColor("#2d374c"))
                .setDotsColor(Color.parseColor("#ffc755"))
                .setThickness(4)
                .endAt(4);

        lineChartView.addData(lineSet);

        lineChartView.show();

    }

    private void disableChartToolbar() {
        playButton.setEnabled(false);
        refreshButton.setEnabled(false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnStockDetailsFragmentListener) {
            mListener = (OnStockDetailsFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     */
    public interface OnStockDetailsFragmentListener {
        //void onFragmentInteraction(Uri uri);
    }
}
