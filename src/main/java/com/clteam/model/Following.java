package com.clteam.model;

import java.sql.Timestamp;

/**
 * Created by Dell on 30-Apr-17.
 */
public class Following {

    private Account account;

    private Timestamp timeStart;

    public Following(Account account, Timestamp timeStart) {
        this.account = account;
        this.timeStart = timeStart;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Timestamp getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Timestamp timeStart) {
        this.timeStart = timeStart;
    }
}
