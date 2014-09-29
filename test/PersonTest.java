/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import control.DBFacade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Person;
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
public class PersonTest {
    
    DBFacade db;
    
    public PersonTest() {
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
        Person test = new Person("Phill", "Smith", "25741729", "p@psmith.dk");
        db.persist(test);
        
        List<Person> returnpersons = db.getAllPersons();
        assertTrue(returnpersons.stream().anyMatch(p -> p.getFirstName().equals("Phill")));
        
        int id = returnpersons.get(0).getId();
        System.out.println(id);
        Person retrievedperson = db.getPersonById(id);
        System.out.println(retrievedperson.getFirstName());
        
        //cleanup
        for (Person p : returnpersons){
            if (p.getFirstName().equals("Phill") && p.getPhone().equals("25741729")){
                db.deletePerson(p);
            }
        }

        
        
    }

}
