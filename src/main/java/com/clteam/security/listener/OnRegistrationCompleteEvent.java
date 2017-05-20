package com.clteam.security.listener;

import com.clteam.dataobject.AccountEntity;
import org.springframework.context.ApplicationEvent;

/**
 * Created by Khanh Nguyen on 18/5/2017.
 */
public class OnRegistrationCompleteEvent extends ApplicationEvent {

    private AccountEntity accountEntity;
    private String appUrl;
    /**
     * Create a new ApplicationEvent.
     *
     * @param accountEntity the object on which the event initially occurred (never {@code null})
     */
    public OnRegistrationCompleteEvent(AccountEntity accountEntity, String appUrl) {
        super(accountEntity);
        this.accountEntity = accountEntity;
        this.appUrl = appUrl;
    }

    public AccountEntity getAccount() {
        return accountEntity;
    }

    public void setAccountEntity(AccountEntity accountEntity) {
        this.accountEntity = accountEntity;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }
}
