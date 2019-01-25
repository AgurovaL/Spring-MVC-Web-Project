package viewModels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ViewBuyingOperation implements ViewModel {
    private long id;
    private long bookId;
    private long userId;
    private Date date;
}
