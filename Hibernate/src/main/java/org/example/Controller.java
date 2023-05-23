package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Scanner;

/**
 * Classe per la creazione egestione di entity manager e transazioni
 *
 */
public class Controller {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager ;

    // Constructor to instantiate an entityManager
    public Controller(){
        entityManagerFactory = Persistence.createEntityManagerFactory("persistenceMysql");
        entityManager =entityManagerFactory.createEntityManager();
    }

    // metodi per la gestione delle transazioni
    public void inserisciInDatabase( ){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert last name: ");
        String lastName  = scanner.next();
        System.out.println("Insert first name");
        String firstName  = scanner.next();
        System.out.println("Insert age");
        int age  = scanner.nextInt();
        System.out.println("Insert weight");
        int weight  = scanner.nextInt();
        Person persona = new Person();
        persona.setLastName(lastName);
        persona.setFirstName(firstName);
        persona.setAge(age);
        persona.setWeight(weight);
        try {

            //--> Let's start a transaction
            entityManager.getTransaction().begin();
            //--> Insert date in the stage, before committing them
            entityManager.persist(persona);
            //--> We write data (Object) in the db
            entityManager.getTransaction().commit();
            // ---> close() : close closes the connection JDBC with the db
            // ---> clear() :cancel the session but not the connection
            entityManager.clear();
        }
        catch (Exception ex){
            System.out.println("Exception generate: " + ex.getMessage());
            entityManager.getTransaction().rollback();
        }
    }
}