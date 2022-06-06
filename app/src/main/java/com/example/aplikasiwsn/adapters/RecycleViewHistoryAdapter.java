package com.example.aplikasiwsn.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasiwsn.R;
import com.example.aplikasiwsn.models.NodeSensor;

import java.util.ArrayList;

public class RecycleViewHistoryAdapter extends RecyclerView.Adapter<RecycleViewHistoryAdapter.ViewHolder>{
    private ArrayList<NodeSensor> nodes;
    private LayoutInflater mInflater;
    private RecycleViewHistoryAdapter.ItemClickListener mClickListener;
    private Context context;

    // data is passed into the constructor
    public RecycleViewHistoryAdapter(Context context, ArrayList<NodeSensor> nodes) {
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        this.nodes = nodes;
    }
    // inflates the cell layout from xml when needed
    @Override
    @NonNull
    public RecycleViewHistoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recycleview_history_item, parent, false);
        return new RecycleViewHistoryAdapter.ViewHolder(view);
    }

    // binds the data to the TextView in each cell

    @Override
    public void onBindViewHolder(@NonNull RecycleViewHistoryAdapter.ViewHolder holder, int position) {

    }

    // total number of cells
    @Override
    public int getItemCount() {
        return nodes.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv_rvhistory_name;
        TextView tv_rvhistory_keasaman_text;
        TextView tv_rvhistory_kelembaban_text;
        TextView tv_rvhistory_tanah_text;
        TextView tv_rvhistory_udara_text;
        TextView tv_rvhistory_waktu_text;
        ConstraintLayout clHistory;

        ViewHolder(View itemView) {
            super(itemView);
            tv_rvhistory_name = itemView.findViewById(R.id.tv_rvhistory_name);
            tv_rvhistory_keasaman_text = itemView.findViewById(R.id.tv_rvhistory_keasaman_text);
            tv_rvhistory_kelembaban_text = itemView.findViewById(R.id.tv_rvhistory_kelembaban_text);
            tv_rvhistory_tanah_text = itemView.findViewById(R.id.tv_rvhistory_tanah_text);
            tv_rvhistory_udara_text = itemView.findViewById(R.id.tv_rvhistory_udara_text);
            tv_rvhistory_waktu_text = itemView.findViewById(R.id.tv_rvhistory_waktu_text);
            clHistory = itemView.findViewById(R.id.cl_history);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // allows clicks events to be caught
    public void setClickListener(RecycleViewHistoryAdapter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}