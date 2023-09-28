package com.clubmatrix.crud.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class Member extends BaseModel {
    @OneToOne
    @JoinColumn(name = "login_id")
    private Login login;

    @Enumerated(EnumType.STRING)
    private PaymentDetails paymentDetails;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum PaymentDetails {
        CREDIT_CARD, DEBIT_CARD, BANK_TRANSFER, CASH
    }

    public enum Status {
        ACTIVE, INACTIVE, SUSPENDED
    }

    public Member() {
    }

    public Member(Login login, PaymentDetails paymentDetails, Status status) {
        this.login = login;
        this.paymentDetails = paymentDetails;
        this.status = status;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
