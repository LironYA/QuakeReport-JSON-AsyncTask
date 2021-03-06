/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.content.Loader;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> parent of 71c5935... AsyncTask
=======
>>>>>>> parent of 23213c2... 1
=======
>>>>>>> parent of 8d4ddb5... Revert "AsyncTask"
=======
>>>>>>> parent of 8d4ddb5... Revert "AsyncTask"
=======
>>>>>>> parent of 8d4ddb5... Revert "AsyncTask"
=======
>>>>>>> parent of 53fefa3... Revert "AsyncTask updates"
public class EarthquakeActivity extends AppCompatActivity implements LoaderCallbacks<List<Earthquake>> {
    /**
     * Constant value for the earthquake loader ID. We can choose any integer.
     * This really only comes into play if you're using multiple loaders.
     */
    private static final int EARTHQUAKE_LOADER_ID = 1;
    private static final String EARTHQUAKE_JSON_RESPONSE = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&eventtype=earthquake&orderby=time&minmag=6&limit=10";
    private EarthquakeAdapter mAdapter;
    /** TextView that is displayed when the list is empty */
    private TextView mEmptyStateTextView;
<<<<<<< HEAD

public class EarthquakeActivity extends AppCompatActivity {


=======
<<<<<<< HEAD
>>>>>>> parent of 71c5935... AsyncTask
    public static final String LOG_TAG = EarthquakeActivity.class.getName();
    private ProgressBar progressBar;

public class EarthquakeActivity extends AppCompatActivity {
<<<<<<< HEAD
    /** Adapter for the list of earthquakes */
    private static final String EARTHQUAKE_JSON_RESPONSE = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&eventtype=earthquake&orderby=time&minmag=6&limit=10";
    private EarthquakeAdapter mAdapter;
<<<<<<< HEAD
>>>>>>> parent of 8c45a19... AsyncTask updates
=======
>>>>>>> parent of 99e45d6... AsyncTask
=======

>>>>>>> 2dfb5488aa21d644771c8be509da870be660e0bd

=======
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> parent of 23213c2... 1
=======
>>>>>>> parent of 99e45d6... AsyncTask
<<<<<<< HEAD
>>>>>>> parent of 8d4ddb5... Revert "AsyncTask"
=======
>>>>>>> parent of 99e45d6... AsyncTask
<<<<<<< HEAD
>>>>>>> parent of 8d4ddb5... Revert "AsyncTask"
=======
>>>>>>> parent of 8d4ddb5... Revert "AsyncTask"
public class EarthquakeActivity extends AppCompatActivity {
    /** Adapter for the list of earthquakes */
    private static final String EARTHQUAKE_JSON_RESPONSE = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&eventtype=earthquake&orderby=time&minmag=6&limit=10";
    private EarthquakeAdapter mAdapter;

>>>>>>> parent of 8c45a19... AsyncTask updates
    public static final String LOG_TAG = EarthquakeActivity.class.getName();
=======
    public static final String LOG_TAG = EarthquakeActivity.class.getName();
    private ProgressBar progressBar;

>>>>>>> parent of 53fefa3... Revert "AsyncTask updates"

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);
<<<<<<< HEAD
=======
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> parent of 23213c2... 1
=======
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> parent of 8d4ddb5... Revert "AsyncTask"
=======
>>>>>>> parent of 8d4ddb5... Revert "AsyncTask"
=======
>>>>>>> parent of 8d4ddb5... Revert "AsyncTask"
=======
>>>>>>> parent of 53fefa3... Revert "AsyncTask updates"
        ListView earthquakeListView = (ListView) findViewById(R.id.list);
        mEmptyStateTextView = (TextView) findViewById(R.id.empty_view);
        earthquakeListView.setEmptyView(mEmptyStateTextView);
        progressBar = (ProgressBar) findViewById(R.id.loading_spinner);
        ConnectivityManager cm =
                (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
if(isConnected) {

    // Get a reference to the LoaderManager, in order to interact with loaders.
    LoaderManager loaderManager = getLoaderManager();
    // Initialize the loader. Pass in the int ID constant defined above and pass in null for
    // the bundle. Pass in this activity for the LoaderCallbacks parameter (which is valid
    // because this activity implements the LoaderCallbacks interface).
    loaderManager.initLoader(EARTHQUAKE_LOADER_ID, null, this);
    // Find a reference to the {@link ListView} in the layout
}
else {
    progressBar.setVisibility(View.GONE);
    mEmptyStateTextView.setText("No internet connection");
}


<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> parent of 8c45a19... AsyncTask updates

        // Get the list of earthquakes from {@link QueryUtils}
        ArrayList<Earthquake> earthquakes = QueryUtils.extractEarthquakes();

=======
>>>>>>> 2dfb5488aa21d644771c8be509da870be660e0bd
        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Create a new adapter that takes the list of earthquakes as input
        final EarthquakeAdapter adapter = new EarthquakeAdapter(this, earthquakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
<<<<<<< HEAD
=======

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);
        // Kick off an {@link AsyncTask} to perform the network request
        EarthquakeAsyncTask task = new EarthquakeAsyncTask();
        task.execute(EARTHQUAKE_JSON_RESPONSE);
=======

>>>>>>> parent of 53fefa3... Revert "AsyncTask updates"
        // Create a new adapter that takes an empty list of earthquakes as input
        mAdapter = new EarthquakeAdapter(this, new ArrayList<Earthquake>());
        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
<<<<<<< HEAD
>>>>>>> parent of 8c45a19... AsyncTask updates
=======

>>>>>>> parent of 53fefa3... Revert "AsyncTask updates"
        earthquakeListView.setAdapter(mAdapter);
<<<<<<< HEAD


        // Get the list of earthquakes from {@link QueryUtils}
        ArrayList<Earthquake> earthquakes = QueryUtils.extractEarthquakes();

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Create a new adapter that takes the list of earthquakes as input
        final EarthquakeAdapter adapter = new EarthquakeAdapter(this, earthquakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);

<<<<<<< HEAD

        // Get the list of earthquakes from {@link QueryUtils}
        ArrayList<Earthquake> earthquakes = QueryUtils.extractEarthquakes();

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Create a new adapter that takes the list of earthquakes as input
        final EarthquakeAdapter adapter = new EarthquakeAdapter(this, earthquakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);

        // Get the list of earthquakes from {@link QueryUtils}
        ArrayList<Earthquake> earthquakes = QueryUtils.extractEarthquakes();

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Create a new adapter that takes the list of earthquakes as input
        final EarthquakeAdapter adapter = new EarthquakeAdapter(this, earthquakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);

        // Get the list of earthquakes from {@link QueryUtils}
        ArrayList<Earthquake> earthquakes = QueryUtils.extractEarthquakes();

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Create a new adapter that takes the list of earthquakes as input
        final EarthquakeAdapter adapter = new EarthquakeAdapter(this, earthquakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD

        // Get the list of earthquakes from {@link QueryUtils}
        ArrayList<Earthquake> earthquakes = QueryUtils.extractEarthquakes();

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Create a new adapter that takes the list of earthquakes as input
        final EarthquakeAdapter adapter = new EarthquakeAdapter(this, earthquakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);

<<<<<<< HEAD
>>>>>>> parent of 99e45d6... AsyncTask
=======
        earthquakeListView.setAdapter(adapter);

>>>>>>> parent of 99e45d6... AsyncTask
=======
>>>>>>> 2dfb5488aa21d644771c8be509da870be660e0bd
=======
>>>>>>> parent of 71c5935... AsyncTask
=======
>>>>>>> parent of 99e45d6... AsyncTask
>>>>>>> parent of 23213c2... 1
=======
>>>>>>> parent of 99e45d6... AsyncTask
>>>>>>> parent of 8d4ddb5... Revert "AsyncTask"
=======
>>>>>>> parent of 99e45d6... AsyncTask
>>>>>>> parent of 8d4ddb5... Revert "AsyncTask"
=======
>>>>>>> parent of 99e45d6... AsyncTask
>>>>>>> parent of 8d4ddb5... Revert "AsyncTask"
        // Set an item click listener on the ListView, which sends an intent to a web browser
        // to open a website with more information about the selected earthquake.
        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Find the current earthquake that was clicked on
                Earthquake currentEarthquake = mAdapter.getItem(position);

                // Convert the String URL into a URI object (to pass into the Intent constructor)
                Uri earthquakeUri = Uri.parse(currentEarthquake.getUrl());

                // Create a new intent to view the earthquake URI
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, earthquakeUri);

                // Send the intent to launch a new activity
                startActivity(websiteIntent);
            }
        });
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> parent of 8d4ddb5... Revert "AsyncTask"

<<<<<<< HEAD
=======
>>>>>>> 2dfb5488aa21d644771c8be509da870be660e0bd
=======
>>>>>>> parent of 8d4ddb5... Revert "AsyncTask"
=======
>>>>>>> parent of 8d4ddb5... Revert "AsyncTask"

    }
    class EarthquakeAsyncTask extends AsyncTask <String, Void,  List<Earthquake>> {
=======
>>>>>>> parent of 23213c2... 1

        @Override
        protected List<Earthquake> doInBackground(String... urls) {
            // Don't perform the request if there are no URLs, or the first URL is null.
            if (urls.length < 1 || urls[0] == null) {
                return null;
            }
=======
>>>>>>> parent of 71c5935... AsyncTask

<<<<<<< HEAD
            List<Earthquake> result = QueryUtils.fetchEarthquakeData(urls[0]);
            return result;
=======
>>>>>>> parent of 53fefa3... Revert "AsyncTask updates"
        }



    @Override
    public android.content.Loader<List<Earthquake>> onCreateLoader(int i, Bundle bundle) {
        return new EarthquakeLoader(EarthquakeActivity.this, EARTHQUAKE_JSON_RESPONSE);
    }

    @Override
    public void onLoadFinished(android.content.Loader<List<Earthquake>> loader, List<Earthquake> data) {
        progressBar.setVisibility(View.GONE);
        mEmptyStateTextView.setText("No earthquakes found");
        // Clear the adapter of previous earthquake data
        mAdapter.clear();

        // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if (data != null && !data.isEmpty()) {
            mAdapter.addAll(data);
        }

    }
=======

    @Override
    public void onLoaderReset(android.content.Loader<List<Earthquake>> loader) {
        mAdapter.clear();
    }
    class EarthquakeAsyncTask extends AsyncTask <String, Void,  List<Earthquake>> {

<<<<<<< HEAD
        @Override
        protected List<Earthquake> doInBackground(String... urls) {
            // Don't perform the request if there are no URLs, or the first URL is null.
            if (urls.length < 1 || urls[0] == null) {
                return null;
            }

            List<Earthquake> result = QueryUtils.fetchEarthquakeData(urls[0]);
            return result;
        }

            @Override
            protected void onPostExecute(List<Earthquake> data) {
                // Clear the adapter of previous earthquake data
                mAdapter.clear();

                // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
                // data set. This will trigger the ListView to update.
                if (data != null && !data.isEmpty()) {
                    mAdapter.addAll(data);
                }
            }
        /**
         * Returns new URL object from the given string URL.
         */

>>>>>>> parent of 8c45a19... AsyncTask updates

    }

<<<<<<< HEAD
<<<<<<< HEAD
=======

}


=======
>>>>>>> parent of 53fefa3... Revert "AsyncTask updates"
    }
}
<<<<<<< HEAD
>>>>>>> parent of 99e45d6... AsyncTask
=======
    }
}
>>>>>>> parent of 99e45d6... AsyncTask
=======
    }
}
>>>>>>> parent of 99e45d6... AsyncTask
=======
    }
}
>>>>>>> parent of 99e45d6... AsyncTask
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
    }
}
>>>>>>> parent of 99e45d6... AsyncTask
=======

>>>>>>> 2dfb5488aa21d644771c8be509da870be660e0bd
=======
        /**
         * Return an {@link ArrayList} object by parsing out information
         * about the first earthquake from the input earthquakeJSON string.
         */

    }

    }

>>>>>>> parent of 8c45a19... AsyncTask updates
=======
>>>>>>> parent of 71c5935... AsyncTask
=======
>>>>>>> parent of 23213c2... 1
=======
>>>>>>> parent of 8d4ddb5... Revert "AsyncTask"
=======
>>>>>>> parent of 8d4ddb5... Revert "AsyncTask"
=======
>>>>>>> parent of 8d4ddb5... Revert "AsyncTask"
