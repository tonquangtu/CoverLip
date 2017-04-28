package com.clteam.dataobject;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dell on 20-Apr-17.
 */
@Entity
@Table(name="account")
public class Account {
    private int id;
    private String username;
    private String password;
    private String fullname;
    private byte role;
    private byte state;
    private Timestamp dateJoin;

    private Set<IdolFollowing> idols = new HashSet<IdolFollowing>(0);

    private Set<IdolFollowing> fans = new HashSet<IdolFollowing>(0);


    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "fullname")
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Basic
    @Column(name = "role")
    public byte getRole() {
        return role;
    }

    public void setRole(byte role) {
        this.role = role;
    }

    @Basic
    @Column(name = "state")
    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    @Basic
    @Column(name = "date_join")
    public Timestamp getDateJoin() {
        return dateJoin;
    }

    public void setDateJoin(Timestamp dateJoin) {
        this.dateJoin = dateJoin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (id != account.id) return false;
        if (role != account.role) return false;
        if (state != account.state) return false;
        if (username != null ? !username.equals(account.username) : account.username != null) return false;
        if (password != null ? !password.equals(account.password) : account.password != null) return false;
        if (fullname != null ? !fullname.equals(account.fullname) : account.fullname != null) return false;
        return dateJoin != null ? dateJoin.equals(account.dateJoin) : account.dateJoin == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (fullname != null ? fullname.hashCode() : 0);
        result = 31 * result + (int) role;
        result = 31 * result + (int) state;
        result = 31 * result + (dateJoin != null ? dateJoin.hashCode() : 0);
        return result;
    }


//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "idol_following",
//            joinColumns = {@JoinColumn(name = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "account_id")})
//    public Set<IdolFollowing> getIdols() {
//        return idols;
//    }

    public void setIdols(Set<IdolFollowing> idols) {
        this.idols = idols;
    }

//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "idol_following",
//            joinColumns = {@JoinColumn(name = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "followed_account_id")})
//    public Set<IdolFollowing> getFans() {
//        return fans;
//    }

    public void setFans(Set<IdolFollowing> fans) {
        this.fans = fans;
    }
}



