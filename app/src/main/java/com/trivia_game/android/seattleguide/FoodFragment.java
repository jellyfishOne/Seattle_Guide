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
 * Fragment that displays a list of Food locations
 */
public class FoodFragment extends Fragment {


    public FoodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        //Create a list of Locations
        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(R.string.Wataru_name,R.string.Wataru_address,
                R.string.Wataru_phone,R.string.Wataru_geo));
        locations.add(new Location(R.string.Wandering_name,R.string.Wandering_address,
                R.string.Wandering_phone,R.string.Wandering_geo));
        locations.add(new Location(R.string.Kedai_name,R.string.Kedai_address,
                R.string.Kedai_phone,R.string.Kedai_geo));
        locations.add(new Location(R.string.State_name,R.string.State_address,
                R.string.State_phone,R.string.State_geo));
        locations.add(new Location(R.string.Matts_name,R.string.Matts_address,
                R.string.Matts_phone,R.string.Matts_geo));
        locations.add(new Location(R.string.Tsukushinbo_name,R.string.Tsukushinbo_address,
                R.string.Tsukushinbo_phone,R.string.Tsukushinbo_geo));
        locations.add(new Location(R.string.Beecher_name,R.string.Beecher_address,
                R.string.Beecher_phone,R.string.Beecher_geo));
        locations.add(new Location(R.string.Salumi_name,R.string.Salumi_address,
                R.string.Salumi_phone,R.string.Salumi_geo));
        locations.add(new Location(R.string.PikeChowder_name,R.string.PikeChowder_address,
                R.string.PikeChowder_phone,R.string.PikeChowder_geo));
        locations.add(new Location(R.string.CatFish_name,R.string.Cloud_address,
                R.string.CatFish_phone,R.string.CatFish_geo));
        locations.add(new Location(R.string.Alibi_name,R.string.Alibi_address,
                R.string.Alibi_phone,R.string.Alibi_geo));


        //Create a LocationAdapter, whose data source is a list of Locations. The
        //adapter knows how to create list items for each item in the list.
        LocationAdapter adapter = new LocationAdapter(getActivity(), locations, R.color.food_orange);

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
