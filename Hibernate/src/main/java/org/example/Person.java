package org.example;

import jakarta.persistence.*;

/**
 * This class will become an Entity, like Neo the One
 * The only two obliged annotations are @Entity and @Id
 */
@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //sql, autoincrement for every insert
    private int id;
    @Column(name = "first_name", length = 100, nullable = true, unique = false)
    private String firstName;
    @Column(name = "last_name", length = 100)
    private String lastName;
    @Column(name = "age")
    private int age;
    //it doesn't get insert in the db with the annotation @Transient
    @Transient
    private int weight;

    //numDoc: external key of document
    //@OneToOne
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "numDoc")
    private Document document;
    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }
}
