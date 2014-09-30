/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import control.DBFacade;
import java.util.ArrayList;
import model.Course;
import model.Person;
import model.RoleSchool;
import model.Student;
import model.Teacher;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Phill
 */
public class CourseTest {
    
    public CourseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    
    @Test
    public void testPersistance(){
        //Make a course
        Course c1 = new Course("Java 101", "Introduction to coffee");
        //Make a Teacher role and Person
        RoleSchool t = new Teacher("PhD in Coffee", "Freeman");
        ArrayList troles = new ArrayList<RoleSchool>();
        troles.add(t);
        Person teach = new Person("Gordon", "Freeman", "1337","cool@cool.cool", troles);
        //add him to course
        c1.addTeacher((Teacher)t);
        t.addCourse(c1);
        
        //Add some students
        RoleSchool s1 = new Student("First", "Brian");
        RoleSchool s2 = new Student("First", "Abekat");
        RoleSchool s3 = new Student("First", "raggle");
        Person st1 = new Person("Brian", "navn", "123", "123");
        Person st2 = new Person("Abekat", "navn", "123", "123");
        Person st3 = new Person("raggle", "navn", "123", "123");
        st1.AddRole(s1);
        st2.AddRole(s2);
        st3.AddRole(s3);
        //Add students to courses and course to students ( should probably make some shortcut method for creating persons with roles and attaching them to courses
        s1.addCourse(c1);
        s2.addCourse(c1);
        s3.addCourse(c1);
        c1.addStudent((Student)s1);
        c1.addStudent((Student)s2);
        c1.addStudent((Student)s3);
        
        DBFacade db = new DBFacade();
        db.persist(c1);
        
        db.deleteCourse(c1);
        //person delete deletes assosiated roleschools
        db.deletePerson(st1);
        db.deletePerson(st2);
        db.deletePerson(st3);
        db.deletePerson(teach);
        
        
        
        
        
        
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
