package org.example;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class Laptop {
   @Id
    int id;
    String lapName;
    @ManyToOne
    //@JoinColumn(name="parentId")
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLapName() {
        return lapName;
    }

    public void setLapName(String lapName) {
        this.lapName = lapName;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", lapName='" + lapName + '\'' +
                '}';
    }
}
