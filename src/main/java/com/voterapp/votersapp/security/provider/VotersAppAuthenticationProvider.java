package com.voterapp.votersapp.security.provider;

import com.voterapp.votersapp.security.services.CustomUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;

@RequiredArgsConstructor
public class VotersAppAuthenticationProvider implements AuthenticationProvider {
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();

        UserDetails userDetails = userDetailsService.loadUserByUsername(email);

        boolean isPasswordValid = passwordEncoder.matches(password, userDetails.getPassword());

        if (isPasswordValid) {
            Collection <? extends GrantedAuthority> authorities = userDetails.getAuthorities();
            Authentication authentication1 = new UsernamePasswordAuthenticationToken(email, password, authorities);
            return authentication1;
        }


        throw new BadCredentialsException("Invalid authentication credentials");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
