package com.clteam.dataobject;

import javax.persistence.*;

/**
 * Created by Dell on 20-Apr-17.
 */
@Entity
@Table(name = "top_cover_idol")
public class TopCoverIdol {
    private int id;
    private int accountId;
    private int topId;
    private int score;

    private Account account;

    private TopList topList;


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
    @Column(name = "top_id")
    public int getTopId() {
        return topId;
    }

    public void setTopId(int topId) {
        this.topId = topId;
    }

    @Basic
    @Column(name = "score")
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TopCoverIdol that = (TopCoverIdol) o;

        if (id != that.id) return false;
        if (accountId != that.accountId) return false;
        if (topId != that.topId) return false;
        return score == that.score;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + accountId;
        result = 31 * result + topId;
        result = 31 * result + score;
        return result;
    }
//
//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name="account_id")
//    public Account getAccount() {
//        return account;
//    }
//
//    public void setAccount(Account account) {
//        this.account = account;
//    }
//
//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name="top_id")
//    public TopList getTopList() {
//        return topList;
//    }
//
//    public void setTopList(TopList topList) {
//        this.topList = topList;
//    }
}
