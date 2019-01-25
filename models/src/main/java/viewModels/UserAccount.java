package viewModels;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@ToString
public class UserAccount implements UserDetails {
    private String username;
    private String password;
    private String[] roles;

    public UserAccount(String username, String password, String... roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    private static final long serialVersionUID = 2059202961588104658L;

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> auths = new java.util.ArrayList<SimpleGrantedAuthority>();

        for (String role : roles) {
            auths.add(new SimpleGrantedAuthority(role));
        }
        return auths;
    }
}


