import java.time.LocalDate;

public class Book {
    private final String bookName;
    private final String author;
    private final LocalDate publicationDate;
    private Boolean isBorrowed;

    Book(String bookName, String author, LocalDate publicationDate, boolean isBorrowed){
        this.bookName = bookName;
        this.author = author;
        this.publicationDate = publicationDate;
        this.isBorrowed = false;
    }

    public String getBookName(){
        return bookName;
    }

    public String getAuthor(){
        return author;
    }

    public LocalDate getPublicationDate(){
        return publicationDate;
    }

    public boolean getIsBorrowed(){
        return isBorrowed;
    }

    public void setIsBorrowed(){
        isBorrowed = true;
    }

}
