package com.iut.rodez.Recipes.model;

import net.bytebuddy.utility.RandomString;

import javax.persistence.*;

@Entity
public class Step {

    @PrePersist
    private void ensureId(){
        this.setId_step(RandomString.make(15));
    }

    @Id
    private String id_step;

    private String descr;

    private int step_order;

    public String getId_step() {
        return id_step;
    }

    public void setId_step(String id_step) {
        this.id_step = id_step;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public int getStep_order() {
        return step_order;
    }

    public void setStep_order(int step_order) {
        this.step_order = step_order;
    }
}
