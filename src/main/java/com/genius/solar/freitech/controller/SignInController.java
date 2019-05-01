package com.genius.solar.freitech.controller;

import com.genius.solar.freitech.db.mysql.entity.User;
import com.genius.solar.freitech.domain.Email;
import com.genius.solar.freitech.domain.Password;
import com.genius.solar.freitech.domain.crypt.ICryptService;
import com.genius.solar.freitech.domain.valueobject.VoSignIn;
import com.genius.solar.freitech.present.form.LoginForm;
import com.genius.solar.freitech.usecase.signin.SignInUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignInController {
    private SignInUseCase signInUseCase;
    private ICryptService cryptService;

    @ModelAttribute("form")
    public LoginForm signInForm() {
        return new LoginForm();
    }

    @Autowired
    public SignInController(SignInUseCase signInUseCase, ICryptService cryptService) {
        this.signInUseCase = signInUseCase;
        this.cryptService = cryptService;
    }

    @GetMapping("/signin")
    public String getSignIn() {
        return "signin";
    }

    @PostMapping("/signin")
    public String postSignIn(@ModelAttribute("form") LoginForm loginForm) {
        // FIXME: Password内で暗号化とかしたい。。。
        User user = signInUseCase.signIn(new VoSignIn(
                new Email(loginForm.getEmail()),
                new Password(cryptService.encryptWithSalt(loginForm.getPassword())))
        );
        if(user == null) {
            throw new RuntimeException("user登録ミス!!");
        }
        return "/service/index";
    }

}
