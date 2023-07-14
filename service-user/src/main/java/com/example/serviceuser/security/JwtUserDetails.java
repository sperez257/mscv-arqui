package com.example.serviceuser.security;

import com.example.serviceuser.entity.Role;
import com.example.serviceuser.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class JwtUserDetails implements UserDetails {

    private String username;
    private String password;
    private Set<Role> role;

    private JwtUserDetails(String username, String password,Set<Role> role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public static JwtUserDetails create(User user){
        return new JwtUserDetails(user.getUserName(), user.getUserPassword(), user.getRole());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

