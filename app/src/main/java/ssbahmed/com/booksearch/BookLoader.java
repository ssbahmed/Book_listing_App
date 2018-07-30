package ssbahmed.com.booksearch;
import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;
/**
 * Loads a list of earthquakes by using an AsyncTask to perform the
 * network request to the given URL.
 */

public class BookLoader extends AsyncTaskLoader<List<Book>> {
/** Query URL */
private String mUrl;

/**
 * Constructs a new  BookLoader.
 *
 * @param context of the activity  @param url to load data from
 */
public BookLoader(Context context, String url) {
        super(context);
        mUrl = url;
        }

@Override
protected void onStartLoading() {
        forceLoad();
        }

/**
 * This is on a background thread.
 */
@Override
public List<Book> loadInBackground() {
        if (mUrl == null) {
        return null;
        }

        // Perform the network request, parse the response, and extract a list of earthquakes.
        List<Book> books =Query.fetchBookData(mUrl);
        return books;
        }

}
