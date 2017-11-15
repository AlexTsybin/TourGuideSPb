package com.alextsy.tourguidespb;


import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ParksFragment extends Fragment {

    public ParksFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        // Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word(R.string.park_one, R.string.park_time_one, R.string.park_tick_one,
                R.drawable.sosnovka, R.string.park_map_one));
        words.add(new Word(R.string.park_two, R.string.park_time_two, R.string.park_tick_two,
                R.drawable.number_two, R.string.park_map_two));
        words.add(new Word(R.string.park_three, R.string.park_time_three, R.string.park_tick_three,
                R.drawable.number_three, R.string.park_map_three));
        words.add(new Word(R.string.park_four, R.string.park_time_four, R.string.park_tick_four,
                R.drawable.number_four, R.string.park_map_four));
        words.add(new Word(R.string.park_five, R.string.park_time_five, R.string.park_tick_five,
                R.drawable.number_five, R.string.park_map_five));
        words.add(new Word(R.string.park_six, R.string.park_time_six, R.string.park_tick_six,
                R.drawable.number_six, R.string.park_map_six));
        words.add(new Word(R.string.park_seven, R.string.park_time_seven, R.string.park_tick_seven,
                R.drawable.number_seven, R.string.park_map_seven));
        words.add(new Word(R.string.park_eight, R.string.park_time_eight, R.string.park_tick_eight,
                R.drawable.number_eight, R.string.park_map_eight));
        words.add(new Word(R.string.park_nine, R.string.park_time_nine, R.string.park_tick_nine,
                R.drawable.number_nine, R.string.park_map_nine));
        words.add(new Word(R.string.park_ten, R.string.park_time_ten, R.string.park_tick_ten,
                R.drawable.number_ten, R.string.park_map_ten));

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
