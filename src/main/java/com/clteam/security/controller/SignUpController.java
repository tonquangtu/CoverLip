package com.clteam.security.controller;

import com.clteam.security.dto.AccountDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * Created by Khanh Nguyen on 15/5/2017.
 */
@Controller
public class SignUpController {

    @GetMapping("/signup")
    public String index(Model model) {
        model.addAttribute("accountForm", new AccountDto());
        return "common/signup";
    }

    @PostMapping("/signup")
    public String save(@Valid @ModelAttribute("accountForm") AccountDto accountDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("accountForm", accountDto);
            return "common/signup";
        }
        return "common/signup";
    }

    @GetMapping("/success")
    public String success() {
        return "common/error";
    }

}