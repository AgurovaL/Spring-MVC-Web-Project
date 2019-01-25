package dbModels;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity(name = "OPERATIONS")
@Table(name = "OPERATIONS")
public class BuyingOperation implements DBModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "operationId")
    private long id;
    @Column
    private long bookId;
    @Column
    private long userId;
    @Column
    private Date date;

    public BuyingOperation(long bookId, long userId, Date date) {
        this.bookId = bookId;
        this.userId = userId;
        this.date = date;
    }
}
