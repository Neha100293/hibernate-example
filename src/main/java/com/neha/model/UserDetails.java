package com.neha.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="user_table")
public class UserDetails {
    @Id
    private int userId;
    private String userName;
    @Version
    private int version;
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }

}
