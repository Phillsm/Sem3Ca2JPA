/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 *
 * @author Marcus
 */
@Entity
@Table(name="TimeBlock")
public class TimeBlock implements Serializable{
    @Column(name = "Date")
   private Date date;
    @Column(name = "Start time")
   private Calendar startTime;
    @Column(name = "End time")
   private Calendar endTime;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public TimeBlock(Date date, Calendar startTime, Calendar endTime) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public TimeBlock(){
        
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Calendar getStartTime() {
        return startTime;
    }

    public void setStartTime(Calendar startTime) {
        this.startTime = startTime;
    }

    public Calendar getEndTime() {
        return endTime;
    }

    public void setEndTime(Calendar endTime) {
        this.endTime = endTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
   
}
