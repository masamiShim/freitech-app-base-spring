package com.genius.solar.freitech.service.signin;

import com.genius.solar.freitech.db.mysql.entity.User;
import com.genius.solar.freitech.domain.Email;
import com.genius.solar.freitech.domain.valueobject.VoSignIn;
import com.genius.solar.freitech.exception.ExistEmailException;

public interface ISignInService {
    /**
     * メールアドレスが登録済みかどうか確認する。
     *
     * @param email
     * @throws ExistEmailException
     */
    void exist(Email email) throws ExistEmailException;

    /**
     * ユーザ登録を行う
     *
     * @param signInValue
     */
    User register(VoSignIn signInValue);
}
