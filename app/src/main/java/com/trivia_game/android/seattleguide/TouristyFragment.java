package com.trivia_game.android.seattleguide;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Fragment that displays a list of Touristy locations
 */
public class TouristyFragment extends Fragment {


    public TouristyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        //Create a list of Locations
        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(R.string.Space_name,R.string.Space_address,
                R.string.Space_phone,R.string.Space_geo));
        locations.add(new Location(R.string.Experience_name,R.string.Experience_address,
                R.string.Experience_phone,R.string.Experience_geo));
        locations.add(new Location(R.string.PikeMarket_name,R.string.PikeMarket_address,
                R.string.PikeMarket_phone,R.string.PikeMarket_geo));
        locations.add(new Location(R.string.GasWorks_name,R.string.GasWorks_address,
                R.string.GasWorks_phone,R.string.GasWorks_geo));
        locations.add(new Location(R.string.Olympic_name,R.string.Olympic_address,
                R.string.Olympic_phone,R.string.Olympic_geo));
        locations.add(new Location(R.string.Aquarium_name,R.string.Aquarium_address,
                R.string.Aquarium_phone,R.string.Aquarium_geo));
        locations.add(new Location(R.string.Zoo_name,R.string.Zoo_address,
                R.string.Zoo_phone,R.string.Zoo_geo));
        locations.add(new Location(R.string.Gum_name,R.string.Gum_address,
                R.string.Gum_phone,R.string.Gum_geo));
        locations.add(new Location(R.string.Kendall_name,R.string.Kendall_address,
                R.string.Kendall_phone,R.string.Kendall_geo));
        locations.add(new Location(R.string.Chihuly_name,R.string.Chihuly_address,
                R.string.Chihuly_phone,R.string.Chihuly_geo));

        //Create a LocationAdapter, whose data source is a list of Locations. The
        //adapter knows how to create list items for each item in the list.
        LocationAdapter adapter = new LocationAdapter(getActivity(), locations, R.color.touristy_teal);

        //Find the ListView object in the view hierarchy of the Activity.
        //There should be a ListView with the view ID called list, which is declared in the
        //location_list.xml layout file
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        //make the ListView use the LocationAdapter, so that the ListView will display list items
        //for each Location in the list
        listView.setAdapter(adapter);

        //Set a click listener to launch the maps application when the location item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Get the Location object at the given position the user clicked on
                Location location = locations.get(i);

                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri latLong = Uri.parse(getString(location.getGeoLocation()));
                intent.setData(latLong);
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        return rootView;
    }

}
