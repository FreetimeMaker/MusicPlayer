package com.freetime.musicplayer;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.GridViewHolder> {

    private final int itemCount = 40; // Total number of items in the grid
    private final int greenColor = Color.parseColor("#006400"); // Dark Green
    private final int pinkColor = Color.parseColor("#FFC0CB");   // Pink

    // This method is called when a new ViewHolder is needed.
    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for a single grid item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item, parent, false);
        return new GridViewHolder(view);
    }

    // This method is called to display the data at a specific position.
    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        // This logic creates the checkered pattern based on row and column
        int row = position / 4; // 4 is the number of columns
        int col = position % 4;

        // Alternate colors to create the green and pink checkered pattern
        if ((row % 2 == 0 && col % 2 == 0) || (row % 2 != 0 && col % 2 != 0)) {
            holder.gridItemView.setBackgroundColor(greenColor);
        } else {
            holder.gridItemView.setBackgroundColor(pinkColor);
        }
    }

    // This method returns the total number of items in the list.
    @Override
    public int getItemCount() {
        return itemCount;
    }

    // The ViewHolder class holds the views for a single grid item.
    public static class GridViewHolder extends RecyclerView.ViewHolder {
        View gridItemView;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            // Find the view inside the item layout
            gridItemView = itemView.findViewById(R.id.gridItemView);
        }
    }
}
