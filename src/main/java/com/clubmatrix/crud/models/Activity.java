package com.clubmatrix.crud.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String ageRange;
    private String skillLevel;
    private String classSchedule;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;

    public Activity() {
    }

    public Activity(String name, String description, String ageRange, String skillLevel, String classSchedule) {
        this.name = name;
        this.description = description;
        this.ageRange = ageRange;
        this.skillLevel = skillLevel;
        this.classSchedule = classSchedule;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
    }

    public String getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }

    public String getClassSchedule() {
        return classSchedule;
    }

    public void setClassSchedule(String classSchedule) {
        this.classSchedule = classSchedule;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt() {
        this.updatedAt = new Date();
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt() {
        this.deletedAt = new Date();
    }

    public void unsetDeletedAt() {
        this.deletedAt = null;
    }
}
