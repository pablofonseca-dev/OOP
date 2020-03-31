package cr.ac.ucenfotec;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Book temporalBookObj = new Book(
                "The Lord of Rings",
                4782947432423424234L,
                "Pablo Fonseca",
                2020
        );

        Author author = new Author("Pablo", "Fonseca", "pablo.fonsecam@outlook.com", "118110145");

        ArrayList<Book> booksCollection = new ArrayList<>();
        booksCollection.add(temporalBookObj);
        author.setBooks(booksCollection);

        String pageFormat = "A book written by Pablo Fonseca with a lot of love...";
        temporalBookObj.setPages(pageFormat, 1);

        System.out.println(author.toString());
        for (int index = 0; index < 50; index++) {
            System.out.println("\n");
        }
        System.out.println(temporalBookObj.toString());

        temporalBookObj = null; //The book dies

        try {
            System.out.println(temporalBookObj.toString());
        } catch (NullPointerException e) {
            System.err.println("the book died in memory but still exists in the author...");
            System.out.println(author.toString());
        }
    }
}

class Author{
    private String name;
    private String lastName;
    private String email;
    private String identification;
    private ArrayList<Book> books;

    public Author(String name, String lastName, String email, String identification) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.identification = identification;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getIdentification() {
        return identification;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", identification='" + identification + '\'' +
                ", books=\n" + books.toString() +
                '}';
    }
}
class Book{

    private String title;
    private long ISBN;
    private String author;
    private int publicationYear;

    private ArrayList<Page> pages;

    public Book(){
        this.title = "";
        this.ISBN = 0;
        this.author = "";
        this.pages = new ArrayList<Page>(); //This emulates exclusiveness. You are going to have pages yes or yes.
    }

    public Book(String title, long ISBN, String author, int publicationYear) {
        this.title = title;
        this.ISBN = ISBN;
        this.author = author;
        this.publicationYear = publicationYear;
        this.pages = new ArrayList<Page>(); //This emulates exclusiveness. You are going to have pages yes or yes.
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public ArrayList<Page> getPages() {
        return pages;
    }

    //Build With Page Constructor Data
    public void setPages(String content, int number) {
        Page temporalPageObj = new Page(content, number);
        this.pages.add(temporalPageObj);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("========================================================================================").append("\n");
        builder.append("----------------------------------------------------------------------------------------").append("\n");
        builder.append("Book Title").append(":").append("\t").append(this.getTitle()).append("\n");
        builder.append("ISBN").append(":").append("\t").append(this.getISBN()).append("\n");
        builder.append("Author").append(":").append("\t").append(this.getAuthor()).append("\n");
        builder.append("Publication Year").append(":").append("\t").append(this.getPublicationYear()).append("\n");
        if(this.pages.size() > 0) {
            builder.append("Pages").append(":").append("\t").append("\n");
            int pageNumber = 1;
            for (Page e : this.pages) {
                builder.append(e.toString());
            }
        }
        builder.append("----------------------------------------------------------------------------------------").append("\n");
        builder.append("========================================================================================").append("\n");

        return builder.toString();
    }
}

class Page{
    private String content;
    private int number;

    public Page(String content, int number){
        this.content = content;
        this.number = number;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        assert this.number > 0;

        builder.append("----------------------------------------------------------------------------------------").append("\n");
        builder.append("Content").append(":").append("\t").append(content).append("\n");
        assert !this.content.equalsIgnoreCase(" ");
        builder.append("Number").append(":").append("\t").append(number).append("\n");
        builder.append("----------------------------------------------------------------------------------------").append("\n");

        return builder.toString();
    }
}


