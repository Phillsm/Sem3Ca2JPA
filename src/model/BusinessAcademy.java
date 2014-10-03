/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
@Table(name="BusinessAcademy")
public class BusinessAcademy {
   private static final long serialVersionUID = 1L;
   @Column(name = "NAME")
   private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
   public BusinessAcademy(){ }
   public BusinessAcademy(String name){
      this.name = name;
   }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
