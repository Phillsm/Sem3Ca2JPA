/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Phill
 */
@Entity 
@Table(name = "RoleSchool")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class RoleSchool implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Expose
    private Integer id;
    
    @ManyToMany( cascade = CascadeType.PERSIST)
    @JoinTable(name = "ROLECOURSES")
    @Expose
    private List<Course> courses;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ownerId")
    
    private Person owner;
    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
     
    public void addCourse(Course inp){
        if (courses == null){courses = new ArrayList();}
        courses.add(inp);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    private String name;

    public RoleSchool(String name) {
        this.name = name;
    }

    public RoleSchool() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return id == null ? 0 : id.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoleSchool)) {
            return false;
        }
        RoleSchool other = (RoleSchool) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.RoleSchool[ id=" + id + " ]";
    }
    
}
