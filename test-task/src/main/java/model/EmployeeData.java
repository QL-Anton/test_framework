package model;

import java.util.Objects;

/**
 * Model object for Creating new Employee via CafeTown app.
 */

public class EmployeeData {

    private String firstName;
    private String lastName;
    private String startDate;
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEmail() {
        return email;
    }

    public EmployeeData setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public EmployeeData setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public EmployeeData setStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    public EmployeeData setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public String toString() {
        return "EmployeeData{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", startDate='" + startDate + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeData that = (EmployeeData) o;
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, startDate, email);
    }
}
