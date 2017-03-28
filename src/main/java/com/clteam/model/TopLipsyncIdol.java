package com.clteam.model;

import javax.persistence.*;

/**
 * Created by Khanh Nguyen on 28/3/2017.
 */
@Entity
@Table(name = "top_lipsync_idol", schema = "coverlip", catalog = "")
public class TopLipsyncIdol {
    private int id;
    private int accountId;
    private int topId;
    private int score;
    private Account accountByAccountId;
    private TopList topListByTopId;

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

        TopLipsyncIdol that = (TopLipsyncIdol) o;

        if (id != that.id) return false;
        if (accountId != that.accountId) return false;
        if (topId != that.topId) return false;
        if (score != that.score) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + accountId;
        result = 31 * result + topId;
        result = 31 * result + score;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
    public Account getAccountByAccountId() {
        return accountByAccountId;
    }

    public void setAccountByAccountId(Account accountByAccountId) {
        this.accountByAccountId = accountByAccountId;
    }

    @ManyToOne
    @JoinColumn(name = "top_id", referencedColumnName = "id", nullable = false)
    public TopList getTopListByTopId() {
        return topListByTopId;
    }

    public void setTopListByTopId(TopList topListByTopId) {
        this.topListByTopId = topListByTopId;
    }
}
