package ssbahmed.com.booksearch;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**To manage and display the data of RecyclerView
we need a class that will extend RecyclerView.Adapter
 Inside this class we need RecyclerView.ViewHolder**/
public class BookAdapter  extends ArrayAdapter<Book> {
    public BookAdapter(MainActivity context, ArrayList<Book> element) {

        super(context, 0, element);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.book_list, parent, false);
        }

        // Get the  object located at this position in the list
        Book book = getItem(position);

        // Find the TextView in book_list.xml layout
        TextView title = (TextView) listItemView.findViewById(R.id.title);
        title.setText(book.getTitle());
        // Find the TextView in book_list.xml layout
        TextView author = (TextView) listItemView.findViewById(R.id.author);
        author.setText(book.getAuthor());
        // Find the TextView in ebook_list.xml layout
        TextView publisher = (TextView) listItemView.findViewById(R.id.publisher);
        author.setText(book.getPublishDate());
        ImageView cover =(ImageView) listItemView.findViewById(R.id.cover);
        Picasso.with(getContext()).load(book.getImageLinks()).into(cover);

        return listItemView;
    }

}
