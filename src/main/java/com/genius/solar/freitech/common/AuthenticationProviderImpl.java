package com.genius.solar.freitech.common;

import com.genius.solar.freitech.db.mysql.entity.User;
import com.genius.solar.freitech.db.mysql.repository.UserRepository;
import com.genius.solar.freitech.domain.Email;
import com.genius.solar.freitech.domain.crypt.ICryptService;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@NoArgsConstructor
public class AuthenticationProviderImpl implements AuthenticationProvider {

    private UserRepository userRepository;

    private ICryptService cryptService;

    @Autowired
    public AuthenticationProviderImpl(UserRepository userRepository, ICryptService cryptService) {
        this.userRepository = userRepository;
        this.cryptService = cryptService;
    }

    /**
     * 認証情報の存在チェックとユーザの存在チェックを実施する。
     *
     * @param auth
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        String email = auth.getName();
        String password = auth.getCredentials().toString();

        if (StringUtils.isEmpty(email) || StringUtils.isEmpty(password)) {
            throw new AuthenticationCredentialsNotFoundException("login Info has error credentials");
        }

        User user = userRepository.findByEmail(new Email(email))
                .orElseThrow(() -> new AuthenticationCredentialsNotFoundException("User Not Found"));

        if(cryptService.notMatch(password, user.getPassword())) {
            new AuthenticationCredentialsNotFoundException("password not match");
        }

        return new UsernamePasswordAuthenticationToken(user, user.getPassword(), auth.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(aClass);
    }
}
