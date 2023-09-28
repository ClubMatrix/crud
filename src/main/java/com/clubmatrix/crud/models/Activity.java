package com.clubmatrix.crud.models;

import java.util.Date;

import jakarta.persistence.Entity;

@Entity
public class Activity extends BaseModel {
    private String name;
    private String description;
    private String ageRange;
    private String skillLevel;
    private String classSchedule;

    public Activity() {
    }

    public Activity(String name, String description, String ageRange, String skillLevel, String classSchedule,
            Date createdAt, Date updatedAt, Date deletedAt) {
        this.name = name;
        this.description = description;
        this.ageRange = ageRange;
        this.skillLevel = skillLevel;
        this.classSchedule = classSchedule;
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
}
