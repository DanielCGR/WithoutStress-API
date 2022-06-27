package com.withoutstress.ws_api.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.withoutstress.ws_api.entities.Usuario;

@Getter
@AllArgsConstructor
public class UserPrincipal  implements UserDetails {

    private Usuario user;
    private Collection<? extends GrantedAuthority> authorities;

    public static UserPrincipal create(Usuario user){
        List<GrantedAuthority> authorities = Collections
                .singletonList(new SimpleGrantedAuthority("ROLE_USER"));
        return new UserPrincipal(user, authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getCorreo();
    }

    public Usuario getUsuario(){
        return user;
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

    public static Usuario getCurrentUser() {
        UserPrincipal principal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal.getUsuario();
    }
}