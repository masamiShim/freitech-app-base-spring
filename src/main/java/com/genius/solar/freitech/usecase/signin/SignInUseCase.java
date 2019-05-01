package com.genius.solar.freitech.usecase.signin;

import com.genius.solar.freitech.common.annotation.UseCase;
import com.genius.solar.freitech.db.mysql.entity.User;
import com.genius.solar.freitech.domain.valueobject.VoSignIn;
import com.genius.solar.freitech.service.signin.ISignInService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;

@UseCase
public class SignInUseCase implements ISignInUseCase {
    private ISignInService signInService;

    @Autowired
    public SignInUseCase(ISignInService signInService) {
        this.signInService = signInService;
    }

    @Override
    public User signIn(@NotNull VoSignIn signInValue) {
        signInService.exist(signInValue.getEmail());
        return signInService.register(signInValue);
    }
}
