package viewModels;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.*;

@Data
@NoArgsConstructor
@ToString
@Entity
public class ViewUser implements ViewModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private String address;
    private String login;
    private String password;
    private String password2;
    private Set<ViewBook> books = new HashSet<>();
    private String role;

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

    public ViewUser(long id, String firstName, String lastName, String address,
                    String login, String password, String role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public ViewUser(String firstName, String lastName, String address,
                    String login, String password, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.login = login;
        this.password = password;
        this.role = role;
    }


    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> auths = new java.util.ArrayList<SimpleGrantedAuthority>();

        auths.add(new SimpleGrantedAuthority(role));

        return auths;
    }
}
