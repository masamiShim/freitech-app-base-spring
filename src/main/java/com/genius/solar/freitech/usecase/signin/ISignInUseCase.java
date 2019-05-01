package com.genius.solar.freitech.usecase.signin;

import com.genius.solar.freitech.db.mysql.entity.User;
import com.genius.solar.freitech.domain.valueobject.VoSignIn;

public interface ISignInUseCase {

    /**
     * ユーザ登録を行う
     *
     * @param signInValue
     * @return 登録済みユーザ情報
     */
    User signIn(VoSignIn signInValue);
}
