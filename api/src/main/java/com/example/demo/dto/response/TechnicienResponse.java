package com.example.demo.dto.response;

import org.springframework.beans.BeanUtils;

import com.example.demo.model.Technicien;

public class TechnicienResponse {
    // @JsonView(CustomJsonViews.Common.class)
    private Integer id;
    // @JsonView(CustomJsonViews.Common.class)
    private String firstName;
    // @JsonView(CustomJsonViews.Common.class)
    private String lastName;
    // @JsonView(CustomJsonViews.Common.class)
    private String email;
    // @JsonView(CustomJsonViews.Common.class)
    private String login;
    // @JsonView(CustomJsonViews.Common.class)
    private String password;

    public TechnicienResponse() {
    }

    public TechnicienResponse(Technicien technicien) {
        this(technicien, true);
    }

    public TechnicienResponse(Technicien technicienEntity, boolean bool) {
        BeanUtils.copyProperties(technicienEntity, this);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
