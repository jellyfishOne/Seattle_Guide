package com.trivia_game.android.seattleguide;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Location Adapter is an ArrayAdapter that can provide the layout for each list item based on
 * a data source, which is a list of Location objects.
 */
public class LocationAdapter extends ArrayAdapter<Location>{
    /////////////////// Instance Variables //////////////////////

    //resource ID for the background color of this list of Locations
    private int mColorResourceID;

    /////////////////// Constructors //////////////////////

    /**
     * Create a new LocationAdapter object
     *
     * @param context is the current context that the adapter is being created in
     * @param locations is the list of Locations to be displayed
     * @param colorResourceID is the resource ID for the background color for this list of Locations
     */
    public LocationAdapter(Context context, ArrayList<Location> locations, int colorResourceID){
        super(context, 0, locations);
        mColorResourceID = colorResourceID;
    }

    /////////////////// Methods  //////////////////////

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Check if an exisiting view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        //GEt the Location object located at this position in the list
        Location currentLocation = getItem(position);

        //Find the TextView in the list_item.xml layout with the ID name_text_view.
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name_text_view);
        //Get the name of the current Location object and set this text on the nameTextView
        nameTextView.setText(currentLocation.getName());

        //Find the TextView in the list_item.xml layout with the ID address_text_view.
        TextView addressTextView = (TextView) listItemView.findViewById(R.id.address_text_view);
        //Get the address of the current Location object and set this text on the
        // address_text_view
        addressTextView.setText(currentLocation.getAddress());

        //Find the TextView in the list_item.xml layout with the ID phoneNumber_text_view.
        TextView phoneNumberTextView = (TextView) listItemView.findViewById(
                R.id.phoneNumber_text_view);
        //Get the phone of the current Location object and set this text on the
        // phoneNumber_text_view
        phoneNumberTextView.setText(currentLocation.getPhoneNumber());


        //Find the ImageView in the list_item.xml layout with the ID imgage.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        //Check if an image is provided for this Location
        if(currentLocation.hasImage()){
            //If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentLocation.getImage());
        } else {
            //Hide the ImageView
            imageView.setVisibility(View.GONE);
        }

        //Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        //Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceID);
        //Set the background color of the text container view
        textContainer.setBackgroundColor(color);

        //Return the whole list item layout so that it can be shown in the ListView
        return listItemView;

    }


}
