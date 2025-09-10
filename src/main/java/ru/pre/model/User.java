package ru.pre.model;

import org.hibernate.proxy.HibernateProxyHelper;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "full_name")
    @NotBlank(message = "Fill in the field!")
    @Size(min = 3, message = "Minimum 3 characters!")
    private String fullName;

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Past(message = "The date must be in the past")
    private Date dateOfBirth;

    @Column(name = "country")
    @NotBlank(message = "Fill in the field!")
    @Size(min = 3, max = 15, message = "The field must contain from 3 to 15 characters!")
    private String country;

    public User() {}

    public User(String fullName, String country) {
        this.fullName = fullName;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || HibernateProxyHelper.getClassWithoutInitializingProxy(this)
                != HibernateProxyHelper.getClassWithoutInitializingProxy(o)) {
            return false;
        }
        User user = (User) o;
        return getId() > 0 && getId() == user.getId();
    }

    @Override
    public int hashCode() {
        return HibernateProxyHelper.getClassWithoutInitializingProxy(this).hashCode();
    }
}