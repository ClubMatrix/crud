package com.clubmatrix.crud.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import java.util.Date;

@Entity
public class Feedback extends BaseModel {
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private Date dateReceived;
    private String providedBy;
    private String content;

    public Feedback() {
    }

    public Feedback(Employee employee, Date dateReceived, String providedBy, String content) {
        this.employee = employee;
        this.dateReceived = dateReceived;
        this.providedBy = providedBy;
        this.content = content;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(Date dateReceived) {
        this.dateReceived = dateReceived;
    }

    public String getProvidedBy() {
        return providedBy;
    }

    public void setProvidedBy(String providedBy) {
        this.providedBy = providedBy;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
