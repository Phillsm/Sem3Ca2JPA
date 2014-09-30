/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import model.Person;
import model.RoleSchool;
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
public class JSONFacadeTest {
    JSONFacade jf;
    Person p1;
    Person p2;
    Person p3;
    public JSONFacadeTest() {
        jf = new DBFacade();
    }
    
    @BeforeClass
    public static void setUpClass() {

    }
    
    @AfterClass
    public static void tearDownClass() {

    }
    
    @Before
    public void setUp() {
        DBFacade db = new DBFacade();
        p1 = new Person("Test1", "Test1", "321332", "Testemail");
        p2 = new Person("Test2", "Test2", "321332", "Testemail");
        p3 = new Person("Test3", "Test3", "321332", "Testemail");
        db.persist(p1);
        db.persist(p2);
        db.persist(p3);
    }
    
    @After
    public void tearDown() {
        DBFacade db = new DBFacade();
        db.deletePerson(p1);
        db.deletePerson(p2);
        db.deletePerson(p3);
    }

    /**
     * Test of getPersonsAsJSON method, of class JSONFacade.
     */
    @Test
    public void testGetPersonsAsJSON() {
        System.out.println(jf.getPersonsAsJSON());
        List<Person> p = new Gson().fromJson(jf.getPersonsAsJSON(), new TypeToken<List<Person>>(){}.getType());
        assertTrue(p.stream().anyMatch(pe -> pe.getFirstName().equals("Test1") ));
        assertTrue(p.stream().anyMatch(pe -> pe.getFirstName().equals("Test2") ));
        assertTrue(p.stream().anyMatch(pe -> pe.getFirstName().equals("Test3") ));
    }
    
    @Test
    public void testingweirdbug(){
        
    }
    

    /**
     * Test of GetPersonAsJson method, of class JSONFacade.
     */
    @Test
    public void testGetPersonAsJson() {
        String json = jf.GetPersonAsJson(p1.getId());
        System.out.println(json);
        Person p = new Gson().fromJson(json, Person.class);
        assertTrue(p.getFirstName().equals("Test1"));
       
        
//        Person p4 = new Person("Firstname", "Lastname", "312312", "Emailaddress");
//        String json = new Gson().toJson(p4,Person.class);
//        System.out.println(json);
//        Person wut = new Gson().fromJson(json, Person.class);
//        System.out.println(wut.getFirstName() + wut.getLastName() + wut.getPhone() + wut.getEmail());
//        
//        List<Person> list = new ArrayList();
//        list.add(p4);
//        list.add(p1);
//        list.add(p2);
//        list.add(p3);
//        System.out.println(new Gson().toJson(list));
    }

    /**
     * Test of addPersonFromGson method, of class JSONFacade.
     */
    @Test
    public void testAddPersonFromGson() {
        //Make new person
        Person p6 = new Person("TestPerson", "Testperson", "123123", "Ragglefraggle");
        String json = new Gson().toJson(p6, Person.class);
        //add personfromjson
        Person r = jf.addPersonFromGson(json);
        //retrieve person to check
       // Person retrievep = ((DBFacade)jf).getPersonById(p6.getId());
        //check that person was retrieved
        assertTrue(r.getFirstName().equals("TestPerson"));
        
        //cleanup
        ((DBFacade)jf).deletePerson(r);
    }

    /**
     * Test of addRoleFromGson method, of class JSONFacade.
     */
    //CLEANUP DATABASE STUFF AFTER
    @Test
    public void testAddRoleFromGson() {
                //Make new person
        RoleSchool rs = new RoleSchool("Test");
        String json = new Gson().toJson(rs, RoleSchool.class);
        //add personfromjson
        RoleSchool r = jf.addRoleFromGson(json, 1337);
        //retrieve person to check
       // Person retrievep = ((DBFacade)jf).getPersonById(p6.getId());
        //check that person was retrieved
        assertTrue(r.getName().equals("Test"));
        ((DBFacade)jf).deleteRoleSchool(r);
    }

    /**
     * Test of delete method, of class JSONFacade.
     */
    @Test
    public void testDelete() {
        Person p8 = new Person("testtt", "testat", "23123", "raggle");
        ((DBFacade)jf).persist(p8);
        assertTrue(((DBFacade)jf).getAllPersons()
                     .stream().anyMatch(person ->
                      person.getFirstName().equals("testtt")));
        jf.delete(p8.getId());
        assertFalse(((DBFacade)jf).getAllPersons()
                     .stream().anyMatch(person ->
                      person.getFirstName().equals("testtt")));
        
        ((DBFacade)jf).deletePerson(p8);
        
       
    }

    
}
