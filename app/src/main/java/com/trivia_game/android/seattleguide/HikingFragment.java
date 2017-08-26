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
 * Fragment that displays a list of hiking locations
 */
public class HikingFragment extends Fragment {


    public HikingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        //Create a list of Locations
        final ArrayList<Location> locations = new ArrayList<Location>();

        //TODO add more locations
        locations.add(new Location(R.string.Rattlesnake_name,R.string.Rattlesnake_address,
                R.string.Rattlesnake_phone,R.string.Rattlesnake_geo));
        locations.add(new Location(R.string.Little_name,R.string.Little_address,
                R.string.Little_phone,R.string.Little_geo));
        locations.add(new Location(R.string.Pilchuck_name,R.string.Pilchuck_address,
                R.string.Pilchuck_phone,R.string.Pilchuck_geo));
        locations.add(new Location(R.string.Ebey_name,R.string.Ebey_address,
                R.string.Ebey_phone,R.string.Ebey_geo));
        locations.add(new Location(R.string.Summerland_name,R.string.Summerland_address,
                R.string.Summerland_phone,R.string.Summerland_geo));
        locations.add(new Location(R.string.Chain_name,R.string.Chain_address,
                R.string.Chain_phone,R.string.Chain_geo));
        locations.add(new Location(R.string.Dungeness_name,R.string.Dungeness_address,
                R.string.Dungeness_phone,R.string.Dungeness_geo));
        locations.add(new Location(R.string.Kendall_name,R.string.Kendall_address,
                R.string.Kendall_phone,R.string.Kendall_geo));
        locations.add(new Location(R.string.Maple_name,R.string.Maple_address,
                R.string.Matts_phone,R.string.Maple_geo));
        locations.add(new Location(R.string.Enchantments_name,R.string.Enchantments_address,
                R.string.Enchantments_phone,R.string.Enchantments_geo));



        //Create a LocationAdapter, whose data source is a list of Locations. The
        //adapter knows how to create list items for each item in the list.
        LocationAdapter adapter = new LocationAdapter(getActivity(), locations, R.color.hiking_green);

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
                //TODO include geo locations in Location object
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
