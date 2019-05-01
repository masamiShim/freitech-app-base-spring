package com.genius.solar.freitech.controller;

import com.genius.solar.freitech.present.form.LoginForm;
import com.genius.solar.freitech.present.form.ValidationResult;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class AuthController extends ControllerBase {

    @GetMapping("/")
    public String index() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(
            @RequestParam(name = "timeout", required = false) Optional<String> timeOut, Model model) {
        timeOut.ifPresent(t -> model.addAttribute("timeout", true));
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@ModelAttribute("form") LoginForm form, Model model) {

        Optional<List<ValidationResult>> bindingResult = form.valid();
        if (bindingResult.isPresent()) {
            bindingResult.get().stream().forEach(vr -> model.addAttribute(vr.getAttr(), vr.getMessage()));
            return "redirect:/login";
        }

        return "redirect:/service/index";
    }

    @PostMapping("/auth")
    public String auth() {
        return "redirect:/service/index";
    }

    @GetMapping("/login_success")
    public String postAuth() {
        return "redirect:/service/index";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }
}
