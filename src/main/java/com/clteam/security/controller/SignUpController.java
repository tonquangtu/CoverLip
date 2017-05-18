package com.clteam.security.controller;

import com.clteam.security.dto.AccountDto;
import com.clteam.security.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Khanh Nguyen on 15/5/2017.
 */
@Controller
@RequestMapping("/signup")
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("accountForm", new AccountDto());
        return "common/signup";
    }

    @PostMapping("")
    public String save(@Valid @ModelAttribute("accountForm") AccountDto accountDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("accountForm", accountDto);
            return "common/signup";
        } else {
            signUpService.saveAccount(accountDto);
            // return view nontify sign up success and contain url link to main page
            return "redirect:/signup/success";
        }
    }

    @GetMapping("/success")
    public String signUpSuccess() {
        return "common/sign_up_success";
    }

}