package fr.istic.M2ILA.taaTP1;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("mysql");
        EntityManager manager = factory.createEntityManager();

        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
            
        /*Department dep = new Department();
        dep.setName("Info");
        
        manager.persist(dep);
        
        Employee emp = new Employee();
        emp.setName("toto");
        emp.setDepartment(dep);
        
        manager.persist(emp);*/
        	Sport foot = new Sport();
            foot.setName("Football");
            
            manager.persist(foot);
            
        	Sport volley = new Sport();
            volley.setName("Volley-ball");
            
            manager.persist(volley);
            
            Location cesson = new Location();
            cesson.setName("cesson-sevigné");
            
            manager.persist(cesson);
            
            Person p1 = new Person();
            p1.setName("toto");
            p1.addLocation(cesson);
            p1.addSport(foot);
            p1.addSport(volley);
            
            manager.persist(p1);
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();
        
        manager.close();
        factory.close();
    }

}
