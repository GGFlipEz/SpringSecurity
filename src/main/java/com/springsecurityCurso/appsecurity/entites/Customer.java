package com.springsecurityCurso.appsecurity.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Table(name="customers")
public class Customer implements Serializable {
    @Id
    @Column(name = "id")
    private BigInteger id;
    @Column(name = "email")
    private String email;
    @Column(name = "pwd")
    private String pwd;
    @Column(name = "rol")
    private String rol;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
