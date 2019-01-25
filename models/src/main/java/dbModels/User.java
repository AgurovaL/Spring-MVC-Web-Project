package dbModels;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@Entity(name = "CLIENTS")
@Table(name = "CLIENTS")
public class User implements DBModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId")
    private long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String address;
    @Column
    private String login;
    @Column
    private String password;
    //@Column
    private String role;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Client_Book",
            joinColumns = {@JoinColumn(name = "userId")},
            inverseJoinColumns = {@JoinColumn(name = "bookId")}
    )
    private Set<Book> books = new HashSet<>();

    public static User create(long id, String firstName, String lastName, String address,
                              String login, String password, String role) {
        User user = new User();
        user.setId(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAddress(address);
        user.setLogin(login);
        user.setPassword(password);
        user.setRole(role);
        return user;
    }

    public static User create(String firstName, String lastName, String address,
                              String login, String password, String role) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAddress(address);
        user.setLogin(login);
        user.setPassword(password);
        user.setRole(role);
        return user;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", books=" + books +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getFirstName().equals(user.getFirstName()) &&
                getLastName().equals(user.getLastName()) &&
                getAddress().equals(user.getAddress()) &&
                getLogin().equals(user.getLogin()) &&
                getPassword().equals(user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

