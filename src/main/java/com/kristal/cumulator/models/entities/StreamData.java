package com.kristal.cumulator.models.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class StreamData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    private String numberStream; //comma separated 5 random numbers

    private Integer sum;

    public String getNumberStream() {
        return numberStream;
    }

    public void setNumberStream(String numberStream) {
        this.numberStream = numberStream;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }
}
