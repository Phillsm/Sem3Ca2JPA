/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Person;

/**
 *
 * @author Phill
 */
public class DBFacade {
    

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
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA2PU");
        EntityManager em = emf.createEntityManager();
        
        return em.find(Person.class, 1);
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
        Query q = em.createQuery("DELETE FROM Person p WHERE p.id = :id");
        q.setParameter("id", p.getId());
        q.executeUpdate();
        em.getTransaction().commit();
    }
    
}
