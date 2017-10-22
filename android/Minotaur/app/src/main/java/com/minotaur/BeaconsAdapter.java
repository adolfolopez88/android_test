package com.minotaur;

import android.annotation.SuppressLint;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import org.altbeacon.beacon.Identifier;

/**
 * Created by et on 8/10/17.
 */

public class BeaconsAdapter extends RecyclerView.Adapter<BeaconsAdapter.ViewHolder> {
    public void setmDataset(BeaconInfo[] mDataset) {
        this.mDataset = mDataset;
    }

    private BeaconInfo[] mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public CardView mCardView;
        public ViewHolder(CardView v) {
            super(v);
            mCardView = v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public BeaconsAdapter(BeaconInfo[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public BeaconsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        CardView v = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.beacon_card, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        BeaconInfo beaconInfo = mDataset[position];
        CardView beaconCard = holder.mCardView;
        TextView beaconId = beaconCard.findViewById(R.id.beaconIdText);
        TextView namespaceId = beaconCard.findViewById(R.id.namespaceIdText);
        TextView distanceText = beaconCard.findViewById(R.id.distanceText);
        TextView descriptionText = beaconCard.findViewById(R.id.descriptionText);
        TextView locationText = beaconCard.findViewById(R.id.locationText);
        beaconId.setText(beaconInfo.getBeaconId().toString());
        namespaceId.setText(beaconInfo.getNamespaceId().toString());
        distanceText.setText(beaconInfo.getDistance());
        locationText.setText(String.format("(%.2f, %.2f)", beaconInfo.getX(), beaconInfo.getY()));
        descriptionText.setText(beaconInfo.getDescription());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}



