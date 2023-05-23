package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        /**
         * Create an object EntityManager
         * 1) use an EntityManagerFactory [to create the entity manager]
         * 2) use the created EntityManager to execute the transactions [atomic execution, all together in order to be able to operate on the DB]
         */


        //1) I read the files of configuration in the persistence
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistenceMysql");

        //2) I create the entity manager using the entityManagerFactory
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        /*
        //3) We use EntityManager to do the operation in the db
        Person person1 = new Person();
        person1.setAge(50);
        person1.setFirstName("Gianluigi");
        person1.setLastName("Della Barca Venezuela");
        person1.setWeight(80);


        /**
         * This beautiful code weirdly is unchecked
         * We could use a try catch
         * But since we are sigma we ain't do that.
         */

        /*
        try{
            System.out.println("Sigma mindset");

            //We start the transaction
            entityManager.getTransaction().begin();

            //We insert the date in the stage of the entity manager before we commit them
            entityManager.persist(person1);

            //We write the data (object) in the database
            entityManager.getTransaction().commit();

            //clear() [we cancel the session but not the connection] || close() [we close the connection JDBC with the database]
            entityManager.close();

        }catch (Exception e){
            System.out.println("Nothing I cannot handle, like a sigma Bruh: " + e.getMessage());
            entityManager.getTransaction().rollback();
        }
        */

        // disable log in the console
        //Logger logger = Logger.getLogger("org.hibernate");
        //logger.setLevel(Level.INFO);

        LogManager.getLogManager().getLogger("").setLevel(Level.OFF);
        Controller controller = new Controller();
        //controller.inserisciInDatabase();

        /**
         * We create an object Document & an object Person
         */

        Document document1 = new Document();
        document1.setNumDoc("D1234");
        document1.setReleaseDate("12/12/2023");
        document1.setCompany("Fulla land");
        document1.setEmployeeReleased("Checco Zalone");

        Person person2 = new Person();
        person2.setFirstName("Giacomo");
        person2.setLastName("Detto Giacomino");
        person2.setAge(78);
        person2.setWeight(90);
        person2.setDocument(document1);


        //Managing the db
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(document1);
            entityManager.persist(person2);
            entityManager.getTransaction().commit();
            entityManager.clear();
        }catch (Exception ex){
            System.out.println("Rollback to find the problems: " + ex);
            ex.printStackTrace();
        }

        /**
         * It works. Test connection passed
         */
        /*
        String url = "jdbc:mysql://localhost:3306/testConnection";
        String user = "root";
        String password = "MySQL7698!";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("first_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        */
    }
}