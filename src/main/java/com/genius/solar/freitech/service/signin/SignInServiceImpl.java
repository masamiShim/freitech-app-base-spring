package com.genius.solar.freitech.service.signin;

import com.genius.solar.freitech.db.mysql.entity.User;
import com.genius.solar.freitech.db.mysql.repository.UserRepository;
import com.genius.solar.freitech.domain.Email;
import com.genius.solar.freitech.domain.valueobject.VoSignIn;
import com.genius.solar.freitech.exception.ExistEmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SignInServiceImpl implements ISignInService {

    private UserRepository userRepository;

    @Autowired
    public SignInServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void exist(Email email) throws ExistEmailException {
        Optional<User> user = userRepository.findByEmail(email);
        // 存在してたら登録できない
        if(user.isPresent()){
            throw new ExistEmailException(email.getEmail());
        }
    }

    @Override
    public User register(VoSignIn signInValue) {
        return userRepository.save(User.from(signInValue));
    }
}
