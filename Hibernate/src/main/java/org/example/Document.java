package org.example;

import jakarta.persistence.*;

//POJO
//private fields,
//public getters and setters,
//empty constructor
@Entity
@Table(name = "document")
public class Document {
    //numDoc: name of the external key to connect with the other table
    @Id
    @Column(name = "numDoc", unique = true)
    private String numDoc;
    @Column(name = "releaseDate")
    private String releaseDate;
    private String company;
    @Transient
    private String employeeReleased;

    public Document(){

    }

    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmployeeReleased() {
        return employeeReleased;
    }

    public void setEmployeeReleased(String employeeReleased) {
        this.employeeReleased = employeeReleased;
    }
}
