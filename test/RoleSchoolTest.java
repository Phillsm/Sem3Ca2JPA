/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import control.DBFacade;
import model.AssistentTeacher;
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
public class RoleSchoolTest {
    
    DBFacade db;
    public RoleSchoolTest() {
        db = new DBFacade();
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
        Teacher t = new Teacher("Proff of theoretical javas", "Freeman");
        Student s = new Student("First", "Phill");
        AssistentTeacher at = new AssistentTeacher("Freeman");
        
        db.persist(t);
        db.persist(s);
        db.persist(at);
        
        db.deleteRoleSchool(s);
        db.deleteRoleSchool(t);
        db.deleteRoleSchool(at);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
