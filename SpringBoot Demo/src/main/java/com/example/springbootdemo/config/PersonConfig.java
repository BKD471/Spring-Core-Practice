package com.example.springbootdemo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "phoenix.config")
@Component
public class PersonConfig {

    private String name;
    private String email;
    private Long password;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPassWord() {
        return password;
    }

    public void setPassWord(Long password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "PersonConfig{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", passWord='" + password + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
