package com.clteam.security.constant;

/**
 * Created by Khanh Nguyen on 12/5/2017.
 */
public final class SecurityConstant {

    public static final String ROLE_ADMIN_STR = "ROLE_ADMIN";
    public static final String ROLE_USER_STR = "ROLE_USER";
    public static final String ROLE_FB_USER_STR = "ROLE_FB_USER";

    public static final String ADMIN = "ADMIN";
    public static final String USER = "USER";
    public static final String FB_USER = "FB_USER";

    public static final byte ACCOUNT_ACTIVATED = (byte) 1;
    public static final byte ACCOUNT_NON_ACTIVATED = (byte) 0;

    public static final int ACCOUNT_ACTIVATED_INT =  1;
    public static final int ACCOUNT_NON_ACTIVATED_INT =  0;

    public static final byte ROLE_ADMIN_BYTE = (byte) 1;
    public static final byte ROLE_USER_BYTE = (byte) 2;
    public static final byte ROLE_FB_USER_BYTE = (byte) 3;

    public static final int USER_SESSION_TIMEOUT = 30 * 60;
    public static final int ADMIN_SESSION_TIMEOUT = 40 * 60;

    public static final String TARGET_USER_URL = "/cover";
    public static final String TARGET_ADMIN_URL = "/admin";

    public static final int MAX_RECORD_PER_PAGE = 20;
    public static final int MAX_NUM_PER_PAGE = 5;

    public static final String NON_ACTIVATE_URL = "/non-activate";

}
