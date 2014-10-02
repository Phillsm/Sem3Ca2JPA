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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Phill
 */
@Entity
@Table(name = "COURSES")
public class Course implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Expose
    private Integer id;
    @Expose
    private String name;
    @Expose
    private String Description;

    public Course() {
    }

    public Course(String name, String Description) {
        this.name = name;
        this.Description = Description;
    }
    
    @ManyToMany(mappedBy = "courses", cascade = CascadeType.PERSIST)
    private List<Teacher> teachers;
    @ManyToMany(mappedBy = "courses", cascade = CascadeType.PERSIST)
    private List<Student> students;
    @ManyToMany(mappedBy = "courses", cascade = CascadeType.PERSIST)
    private List<AssistentTeacher> assistents;
    
    public void addTeacher(Teacher inp){
        if (teachers == null){teachers = new ArrayList();}
        teachers.add(inp);
    }
     public void addStudent(Student inp){
        if (students == null){students = new ArrayList();}
        students.add(inp);
    }
      public void addAssistent(AssistentTeacher inp){
        if (assistents == null){assistents = new ArrayList();}
        assistents.add(inp);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<AssistentTeacher> getAssistents() {
        return assistents;
    }

    public void setAssistents(List<AssistentTeacher> assistents) {
        this.assistents = assistents;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Course[ id=" + id + " ]";
    }
    
}
