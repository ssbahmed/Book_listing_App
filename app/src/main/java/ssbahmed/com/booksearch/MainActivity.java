package ssbahmed.com.booksearch;

import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.app.LoaderManager.LoaderCallbacks;
import java.util.ArrayList;
import java.util.List;
import android.widget.AdapterView;


public class MainActivity extends AppCompatActivity implements LoaderCallbacks<List<Book>>{
    //a list to store all the books
    List<Book> list;
    /** URL for earthquake data from the USGS dataset */
    private static final String REQUEST_URL ="https://www.googleapis.com/books/v1/volumes?q=java";
    private BookAdapter adapter;

    //the recyclerview
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        
        adapter = new BookAdapter(this, new ArrayList<Book>());

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
    }


    @Override
    public Loader<List<Book>> onCreateLoader(int i, Bundle bundle) {
        // Create a new loader for the given URL
        return new BookLoader(this, REQUEST_URL);
    }

    @Override
    public void onLoadFinished(Loader<List<Book>> loader, List<Book> books) {
        // Clear the adapter of previous earthquake data
       books.clear();
        // If there is a valid list of {@link book}s, then add them to the adapter's
        // data set. This will trigger the RecyclerView to update.
        if (books != null && !books.isEmpty()) {
           books.addAll(books);
        }

    }

    @Override
    public void onLoaderReset(Loader<List<Book>> loader) {
        // Loader reset, so we can clear out our existing data.
       list.clear();
    }
}
