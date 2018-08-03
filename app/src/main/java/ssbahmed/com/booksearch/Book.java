package ssbahmed.com.booksearch;

public class Book {
    private String title;
    private String author;
    private String des;
    private String publishDate;
    private String imageLinks;

    public Book(String t,String a,String p,String link){
        this.title=t;
        this.author=a;
      //  this.des=d;
        this.publishDate=p;
       this.imageLinks = link;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDes() {
        return des;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public String getImageLinks() {
        return imageLinks;
    }
}
