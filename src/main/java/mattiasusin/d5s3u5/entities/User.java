package mattiasusin.d5s3u5.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mattiasusin.d5s3u5.enums.Role;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@Setter
@Getter
@NoArgsConstructor
@JsonIgnoreProperties({"password", "role", "authorities", "enabled", "accountNonLocked", "accountNonExpired", "credentialsNonExpired"})
public class User implements UserDetails {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;
    private String name;
    private String surname;
    private String email;
    private String password;


    @Enumerated(EnumType.STRING)
    private Role role;
    

    public User(String surname, String email, String name, String password, String role) {
        this.surname = surname;
        this.email = email;
        this.name = name;
        this.password = password;
        this.role = Role.valueOf(role);
    }
    public List<SimpleGrantedAuthority> getAuthorities() {

        return List.of(new SimpleGrantedAuthority(this.role.name()));
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    // TO STRING


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
