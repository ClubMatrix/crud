package com.clubmatrix.crud.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class Employee extends BaseModel {
    @OneToOne
    @JoinColumn(name = "login_id")
    private Login login;

    private String position;
    private Double salary;

    public Employee() {
    }

    public Employee(Login login, String position, Double salary) {
        this.login = login;
        this.position = position;
        this.salary = salary;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
