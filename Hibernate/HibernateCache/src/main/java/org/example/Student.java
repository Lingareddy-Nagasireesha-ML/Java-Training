package org.example;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity(name="StudentInfo_table")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "myEntityCacheRegion")
public class Student {
    @Id
    int id;
    StudentName name;
    String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StudentName getName() {
        return name;
    }

    public void setName(StudentName name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ",name= "+name+
                ", address='" + address + '\'' +
                '}';
    }
}
