package com.clteam.security.service;

import com.clteam.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Khanh Nguyen on 21/5/2017.
 */

public interface AdminAccountService {

    List<User> findAllUser();

}
