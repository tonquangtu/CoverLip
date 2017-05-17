package com.clteam.security.controller;

import com.clteam.security.dto.AccountDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String save(@ModelAttribute("accountForm") @Valid AccountDto accountDto) {
        return null;
    }

}