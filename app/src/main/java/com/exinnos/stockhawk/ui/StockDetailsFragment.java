package com.exinnos.stockhawk.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.db.chart.model.LineSet;
import com.db.chart.view.LineChartView;
import com.exinnos.stockhawk.R;

/**
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

        /*LineChartView lineChartView = (LineChartView) rootView.findViewById(R.id.stock_line_chart);

        String[] strings = {"A","B","C","D","E"};
        float[] floats = {1.0f,2.3f,3.0f,4.3f,5.0f};

        LineSet lineSet = new LineSet(strings, floats);*/



        return rootView;
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
