package model;

import org.apache.commons.lang3.RandomUtils;

import java.time.LocalDate;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public class EmployeeDataBuilder {

    private String firstName = randomAlphabetic(10);
    private String lastName = randomAlphabetic(12);
    private String startDate = (LocalDate.now().plusYears(RandomUtils.nextInt(1, 50)).toString());
    ;
    private String email = getRandomEmail("cafeTown");

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

    public EmployeeDataBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public EmployeeDataBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public EmployeeDataBuilder setStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    public EmployeeDataBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public EmployeeData build() {
        EmployeeData employeeData = new EmployeeData();
        employeeData
                .setFirstName(firstName)
                .setLastName(lastName)
                .setStartDate(startDate)
                .setEmail(email);
        return employeeData;
    }

    public String getRandomEmail(String prefix) {
        int partBeforeDotMaxValue = 30;
        int additionalSymbols = 5;
        StringBuilder firstPartOfEmail = new StringBuilder(50)
                .append(prefix)
                .append(System.currentTimeMillis())
                .append("@");
        if (firstPartOfEmail.length() + additionalSymbols > partBeforeDotMaxValue) {
            additionalSymbols = partBeforeDotMaxValue - firstPartOfEmail.length();
        }
        return firstPartOfEmail
                .append(randomAlphanumeric(additionalSymbols))
                .append(".")
                .append(randomAlphabetic(3))
                .toString();
    }
}
