package com.example.back.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hits")
public class Hit {
    @Id
    @GeneratedValue
    private Long id;
    private Float x;
    private Float y;
    private Float r;
    private Boolean hit;

    public Hit(Float x, Float y, Float r, Boolean hit) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.hit = hit;
    }

    public Hit() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getX() {
        return x;
    }

    public void setX(Float x) {
        this.x = x;
    }

    public Float getY() {
        return y;
    }

    public void setY(Float y) {
        this.y = y;
    }

    public Float getR() {
        return r;
    }

    public void setR(Float r) {
        this.r = r;
    }

    public Boolean getHit() {
        return hit;
    }

    public void setHit(Boolean hit) {
        this.hit = hit;
    }

    @Override
    public String toString() {
        return "Hit{" +
                "id=" + id +
                ", x=" + x +
                ", y=" + y +
                ", r=" + r +
                ", hit=" + hit +
                '}';
    }
}
