package com.ironhack.edgeservice.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;


public class Project {
    private Integer id;
    private String title;
    private Integer owner;
    private String description;
    private String summary;
    private BigDecimal goal;
    private BigDecimal reached;
    private BigDecimal interest;
    private String img;

    public Project() {
    }

    public Project(String title, Integer owner, String description, String summary, BigDecimal goal,  BigDecimal interest, List<Integer> messages, List<Integer> backers, String img) throws Exception {
        this.title = title;
        this.owner = owner;
        this.description = description;
        this.summary = summary;
        this.goal = goal;
        this.reached = new BigDecimal("0");
        setInterest(interest);
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getOwner() {
        return owner;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public BigDecimal getGoal() {
        return goal;
    }

    public void setGoal(BigDecimal goal) {
        this.goal = goal;
    }

    public BigDecimal getReached() {
        return reached;
    }

    public void setReached(BigDecimal reached) {
        this.reached = reached;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) throws Exception {
        this.interest = interest;
    }

}

