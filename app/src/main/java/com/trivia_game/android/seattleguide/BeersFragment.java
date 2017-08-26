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
 * Fragment that displays a list of Brewery locations
 */
public class BeersFragment extends Fragment {


    public BeersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        //Create a list of Locations
        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(R.string.Optimism_name, R.string.Optimism_address,
                R.string.Optimism_phone, R.string.Optimism_geo));
        locations.add(new Location(R.string.Elysian_name,R.string.Elysian_address,
                R.string.Elysian_phone,R.string.Elysian_geo));
        locations.add(new Location(R.string.Pike_name,R.string.Pike_address,
                R.string.Pike_phone,R.string.Pike_geo));
        locations.add(new Location(R.string.TwoBeers_name,R.string.TwoBeers_address,
                R.string.TwoBeers_phone,R.string.TwoBeers_geo));
        locations.add(new Location(R.string.Fremont_name,R.string.Fremont_address,
                R.string.Fremont_phone,R.string.Fremont_geo));
        locations.add(new Location(R.string.Standard_name,R.string.Standard_address,
                R.string.Standard_phone,R.string.Standard_geo));
        locations.add(new Location(R.string.Cloud_name,R.string.Cloud_address,
                R.string.Cloud_phone,R.string.Cloud_geo));
        locations.add(new Location(R.string.George_name,R.string.George_address,
                R.string.George_phone,R.string.George_geo));
        locations.add(new Location(R.string.OldStove_name,R.string.OldStove_address,
                R.string.OldStove_phone,R.string.OldStove_geo));
        locations.add(new Location(R.string.Roof_name,R.string.Roof_address,
                R.string.Roof_phone,R.string.Roof_geo));
        locations.add(new Location(R.string.Bad_name,R.string.Bad_address,
                R.string.Bad_phone,R.string.Bad_geo));
        locations.add(new Location(R.string.Holy_name,R.string.Holy_address,
                R.string.Holy_phone,R.string.Holy_geo));
        locations.add(new Location(R.string.Outer_name,R.string.Outer_address,
                R.string.Outer_phone,R.string.Outer_geo));
        locations.add(new Location(R.string.Outlander_name,R.string.Outlander_address,
                R.string.Outlander_phone,R.string.Outlander_geo));

        //Create a LocationAdapter, whose data source is a list of Locations. The
        //adapter knows how to create list items for each item in the list.
        LocationAdapter adapter = new LocationAdapter(getActivity(), locations, R.color.beer_amber);

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
