package com.clteam.security.controller;

import com.clteam.dataobject.AccountEntity;
import com.clteam.security.constant.ActivateAccountToken;
import com.clteam.security.dto.AccountDto;
import com.clteam.security.listener.OnRegistrationCompleteEvent;
import com.clteam.security.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;

/**
 * Created by Khanh Nguyen on 15/5/2017.
 */
@Controller
@RequestMapping("/signup")
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @GetMapping("")
    public String index(Model model) {

        model.addAttribute("accountForm", new AccountDto());
        return "common/signup";
    }

    @PostMapping("")
    public String save(@Valid @ModelAttribute("accountForm") AccountDto accountDto, BindingResult result, Model model, final HttpServletRequest req) {
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (result.hasErrors()) {
            model.addAttribute("accountForm", accountDto);
            return "common/signup";
        } else {
            AccountEntity account = signUpService.createNewAccount(accountDto);
            eventPublisher.publishEvent(new OnRegistrationCompleteEvent(account, getAppUrl(req)));
            // return view nontify sign up success and contain url link to main page
            return "redirect:/cover";
        }
    }

    @GetMapping("/success")
    public String signUpSuccess() {
        return "common/sign_up_success";
    }

    @GetMapping("/registrationConfirm")
    public String registrationConfirm(@RequestParam("token") final String token, Model model) {
        ActivateAccountToken result = signUpService.validateVerificationToken(token);
        if (result == ActivateAccountToken.TOKEN_VALID) {
            model.addAttribute("status", "token valid");
        } else if (result == ActivateAccountToken.TOKEN_EXPIRED) {
            model.addAttribute("status", "token expired");
        } else {
            model.addAttribute("status", "token invalid");
        }
        return "common/after_activate";
    }


    private String getAppUrl(HttpServletRequest request) {
        return "https://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }

}