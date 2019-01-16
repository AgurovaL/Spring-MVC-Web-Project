package dbActions.dbModels;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "BOOKS")
public class Book implements DBModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bookId")
    private long id;
    @Column
    private String title;
    @Column
    private String author;
    @Column
    private String publisher;
    @Column
    private int yearOfWriting;
    @Column
    private int yearOfPublishing;
    @Column
    private int pagesNumber;

    @ManyToMany(mappedBy = "books")
    Set<User> clients = new HashSet<>();

    public static Book create(String title, String author, String publisher, int yearOfWriting, int yearOfPublishing, int pagesNumber) {
        Book book = new Book();

        book.setTitle(title);
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setYearOfWriting(yearOfWriting);
        book.setYearOfPublishing(yearOfPublishing);
        book.setPagesNumber(pagesNumber);
        return book;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", yearOfWriting=" + yearOfWriting +
                ", yearOfPublishing=" + yearOfPublishing +
                ", pagesNumber=" + pagesNumber +
                ", clients=" + clients +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return getYearOfWriting() == book.getYearOfWriting() &&
                getYearOfPublishing() == book.getYearOfPublishing() &&
                getPagesNumber() == book.getPagesNumber() &&
                getTitle().equals(book.getTitle()) &&
                getAuthor().equals(book.getAuthor()) &&
                getPublisher().equals(book.getPublisher());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
