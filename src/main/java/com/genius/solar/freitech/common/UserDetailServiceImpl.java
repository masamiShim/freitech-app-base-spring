package com.genius.solar.freitech.common;

import com.genius.solar.freitech.db.mysql.repository.UserRepository;
import com.genius.solar.freitech.domain.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("FtUserDetailsService")
public class UserDetailServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(new Email(email))
                .orElseThrow(() -> new UsernameNotFoundException("Not Registered " + email + " was not found"));
    }
}
