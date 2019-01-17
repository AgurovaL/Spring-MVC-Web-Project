package viewModels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViewBook implements ViewModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;
    private String author;
    private String publisher;
    private int yearOfWriting;
    private int yearOfPublishing;
    private int pagesNumber;
    private int price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ViewBook viewBook = (ViewBook) o;
        return getYearOfWriting() == viewBook.getYearOfWriting() &&
                getYearOfPublishing() == viewBook.getYearOfPublishing() &&
                getPrice() == viewBook.getPrice() &&
                getPagesNumber() == viewBook.getPagesNumber() &&
                getTitle().equals(viewBook.getTitle()) &&
                getAuthor().equals(viewBook.getAuthor()) &&
                getPublisher().equals(viewBook.getPublisher());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
