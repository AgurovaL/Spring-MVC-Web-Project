package viewModels;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Objects;

@Data
@NoArgsConstructor
@Entity
public class ViewUser implements ViewModel{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private String address;
    private String login;
    private String password;
    private String password2;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ViewUser user = (ViewUser) o;
        return
                getFirstName().equals(user.getFirstName()) &&
                        getAddress().equals(user.getAddress()) &&
                        getLogin().equals(user.getLogin()) &&
                        getPassword().equals(user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
