package ssbahmed.com.booksearch;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

/**To manage and display the data of RecyclerView
we need a class that will extend RecyclerView.Adapter
 Inside this class we need RecyclerView.ViewHolder**/
public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder>  {
    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the Books in a list
    private List<Book> bookList;

    //getting the context and product list with constructor
    public BookAdapter(Context mCtx, List<Book> List) {
        this.mCtx = mCtx;
        this.bookList = List;
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {

        TextView title, author, des;
        ImageView image;

        public BookViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            author = itemView.findViewById(R.id.author);
            des = itemView.findViewById(R.id.des);
            image = itemView.findViewById(R.id.image);

        }
    }

    @Override
    /**This method returns a new instance of our ViewHolder*/
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.book_list, null);
        return new BookViewHolder(view);
    }

    @Override
    /**This method binds the data to the view holder*/
    public void onBindViewHolder(BookViewHolder holder, int position) {
        Book book = bookList.get(position);

        holder.title.setText(book.getTitle());
        holder.author.setText(book.getAuthor());
        holder.des.setText(book.getDes());
       // holder.image.setImageResource(book.getImage());
    }
 /**This method returns the size of the List*/
    @Override
    public int getItemCount() {
        return bookList.size();
    }



}
