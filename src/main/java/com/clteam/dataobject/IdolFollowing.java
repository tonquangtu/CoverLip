package com.clteam.dataobject;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Dell on 28-Apr-17.
 */
@Entity
@Table(name = "idol_following")
public class IdolFollowing {
    private int id;
    private int accountId;
    private int followedAccountId;
    private Timestamp timeStartFollow;
    private Account accountByAccountId;
    private Account accountByFollowedAccountId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "account_id")
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Basic
    @Column(name = "followed_account_id")
    public int getFollowedAccountId() {
        return followedAccountId;
    }

    public void setFollowedAccountId(int followedAccountId) {
        this.followedAccountId = followedAccountId;
    }

    @Basic
    @Column(name = "time_start_follow")
    public Timestamp getTimeStartFollow() {
        return timeStartFollow;
    }

    public void setTimeStartFollow(Timestamp timeStartFollow) {
        this.timeStartFollow = timeStartFollow;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IdolFollowing that = (IdolFollowing) o;

        if (id != that.id) return false;
        if (accountId != that.accountId) return false;
        if (followedAccountId != that.followedAccountId) return false;
        if (timeStartFollow != null ? !timeStartFollow.equals(that.timeStartFollow) : that.timeStartFollow != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + accountId;
        result = 31 * result + followedAccountId;
        result = 31 * result + (timeStartFollow != null ? timeStartFollow.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public Account getAccountByAccountId() {
        return accountByAccountId;
    }

    public void setAccountByAccountId(Account accountByAccountId) {
        this.accountByAccountId = accountByAccountId;
    }

    @ManyToOne
    @JoinColumn(name = "followed_account_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public Account getAccountByFollowedAccountId() {
        return accountByFollowedAccountId;
    }

    public void setAccountByFollowedAccountId(Account accountByFollowedAccountId) {
        this.accountByFollowedAccountId = accountByFollowedAccountId;
    }
}
