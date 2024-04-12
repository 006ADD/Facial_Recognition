/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.time.LocalDateTime;

/**
 *
 * @author User
 */
public class ModelPerson {
    private int id;
    private String firstName, lastName, yearOfBirth, position,  image, date;
    private LocalDateTime registrationTime;

    public ModelPerson() {
    }

    public ModelPerson(int id, String firstName, String lastName, String position, String yearOfBirth, LocalDateTime registrationTime) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position; 
        this.yearOfBirth = yearOfBirth;     
        this.registrationTime=registrationTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    public LocalDateTime getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(LocalDateTime registrationTime) {
        this.registrationTime = registrationTime;
    }
}
