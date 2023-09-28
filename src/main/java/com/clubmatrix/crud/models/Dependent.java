package com.clubmatrix.crud.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class Dependent extends BaseModel {
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private String name;
    private String relationship;

    public Dependent() {
    }

    public Dependent(Member member, String name, String relationship) {
        this.member = member;
        this.name = name;
        this.relationship = relationship;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }
}
