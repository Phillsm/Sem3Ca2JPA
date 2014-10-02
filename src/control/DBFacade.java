/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Course;
import model.Person;
import model.RoleSchool;
import model.Teacher;

/**
 *
 * @author Phill
 */
public class DBFacade implements JSONFacade{
    

    public DBFacade() {
    }
        
        
    
    public void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA2PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public Person getPersonById(Integer id){
        Person returnp;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA2PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT p FROM Person p WHERE p.id = :id");
        q.setParameter("id", id);
        returnp = (Person) q.getSingleResult();
        em.getTransaction().commit();
        return returnp;
        
    }
    
    public List<Person> getAllPersons(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA2PU");
        EntityManager em = emf.createEntityManager();
        List<Person> rtlist = new ArrayList();
        em.getTransaction().begin();
        try {
        rtlist =  em.createQuery("Select p FROM Person p").getResultList();
        } catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
        return rtlist;
    }
    
    public void deletePerson(Person p){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA2PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query qe = em.createQuery("DELETE FROM RoleSchool rs WHERE rs.owner.id = :id");
        Query q = em.createQuery("DELETE FROM Person p WHERE p.id = :id");
        q.setParameter("id", p.getId());
        qe.setParameter("id", p.getId());
        qe.executeUpdate();
        q.executeUpdate();
        em.getTransaction().commit();
    }
    
    public void deleteRoleSchool(RoleSchool r){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA2PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("DELETE FROM RoleSchool p WHERE p.id = :id");
        q.setParameter("id", r.getId());
        q.executeUpdate();
        em.getTransaction().commit();
    }
    
    public void deleteCourse(Course r){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA2PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("DELETE FROM Course c WHERE c.id = :id");
        q.setParameter("id", r.getId());
        q.executeUpdate();
        em.getTransaction().commit();
    }
    
    
    @Override
    public String getPersonsAsJSON(){
        
        List<Person> p = getAllPersons();
        Type ptype = new TypeToken<List<Person>>() {}.getType();
        String json = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().toJson(p, ptype);
        return json;
    }

    @Override
    public String GetPersonAsJson(Integer id) {
        Person p = getPersonById(id);
        return new Gson().toJson(p);
    }

    // Right now returns inputjson as object but could fetch from DB somehow if there
    // was strictly enforced minimum values on input json object
    @Override
    public Person addPersonFromGson(String json) {
        Person p = new Gson().fromJson(json, Person.class);
        persist(p);
        return p;
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RoleSchool addRoleFromGson(String json, Integer id) {
        RoleSchool rs = new Gson().fromJson(json, RoleSchool.class);
        persist(rs);
        return rs;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Person delete(Integer id) {
        Person returnperson = getPersonById(id);
        deletePerson(returnperson);
        return returnperson;//To change body of generated methods, choose Tools | Templates.
    }
    
    //Charles, tilpasses.
     /*
    Pass in true to create a new instance. Usefull for testing.
  */
     private static DBFacade instance = new DBFacade();
    
  public static DBFacade getFacade(boolean reseet){
    if(true){
      instance = new DBFacade();
    }
    return instance;
  }
  
  DBFacade db;
  public void createTestData() {
////    addPerson(gson.toJson(new Person("Lars","Mortensen","1234")));
             
//        Person test = new Person("Charles", "Day", "1234", "day@dk.dk");
//        RoleSchool rs = new Teacher("Professor of shat", "jalol");
//        test.AddRole(rs);
//        db.persist(test);
        Person p1;
        Person p2;    
      
        DBFacade db = new DBFacade();
        p1 = new Person("Test1", "Test1", "321332", "Testemail");
        p2 = new Person("Test2", "Test2", "321332", "Testemail");
        db.persist(p1);
        db.persist(p2);
        
      
  }
    
}
