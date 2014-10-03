/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
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
@Table(name="ClassRoom")
public class ClassRoom implements Serializable {
    @Column(name = "Room number")
   private String roomNo;
    @Column(name = "Number of seats")
   private int noOffSeats;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public ClassRoom() {
    }

    public ClassRoom(String roomNo, int noOffSeats) {
        this.roomNo  = roomNo;
        this.noOffSeats = noOffSeats;
    }
   
    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public int getNoOffSeats() {
        return noOffSeats;
    }

    public void setNoOffSeats(int noOffSeats) {
        this.noOffSeats = noOffSeats;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
