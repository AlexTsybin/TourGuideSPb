package com.alextsy.tourguidespb;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlacesFragment extends Fragment {


    public PlacesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        // Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word(R.string.place_one, R.string.place_time_one, R.string.place_tick_one,
                R.drawable.sosnovka, R.string.place_map_one));
        words.add(new Word(R.string.place_two, R.string.place_time_two, R.string.place_tick_two,
                R.drawable.number_two, R.string.place_map_two));
        words.add(new Word(R.string.place_three, R.string.place_time_three, R.string.place_tick_three,
                R.drawable.number_three, R.string.place_map_three));
        words.add(new Word(R.string.place_four, R.string.place_time_four, R.string.place_tick_four,
                R.drawable.number_four, R.string.place_map_four));
        words.add(new Word(R.string.place_five, R.string.place_time_five, R.string.place_tick_five,
                R.drawable.number_five, R.string.place_map_five));
        words.add(new Word(R.string.place_six, R.string.place_time_six, R.string.place_tick_six,
                R.drawable.number_six, R.string.place_map_six));
        words.add(new Word(R.string.place_seven, R.string.place_time_seven, R.string.place_tick_seven,
                R.drawable.number_seven, R.string.place_map_seven));
        words.add(new Word(R.string.place_eight, R.string.place_time_eight, R.string.place_tick_eight,
                R.drawable.number_eight, R.string.place_map_eight));
        words.add(new Word(R.string.place_nine, R.string.place_time_nine, R.string.place_tick_nine,
                R.drawable.number_nine, R.string.place_map_nine));
        words.add(new Word(R.string.place_ten, R.string.place_time_ten, R.string.place_tick_ten,
                R.drawable.number_ten, R.string.place_map_ten));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.category_numbers);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Get the {@link Word} object at the given position the user clicked on
                Word word = words.get(position);

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(getString(word.getGeoId())));
                startActivity(intent);
            }
        });

        return rootView;
    }

}
