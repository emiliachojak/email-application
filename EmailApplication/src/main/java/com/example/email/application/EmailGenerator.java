package com.example.email.application;

public class EmailGenerator {
    private final String firstName;
    private final String lastName;
    private final String department;

    public EmailGenerator(String firstName, String lastName, String department) {
        this.firstName = firstName.toLowerCase();
        this.lastName = lastName.toLowerCase();
        this.department = department.toLowerCase();
    }

    public EmailGenerator(String firstName, String lastName) {
        this(firstName, lastName, "");
    }

    public String generateEmail() {
        String company = "mycompany";
        if (department.isBlank()) {
            return String.format("%s.%s@%s.com", firstName, lastName, company);
        } else {
            return String.format("%s.%s@%s.%s.com", firstName, lastName, department, company);
        }
    }

    public String generateAlternateEmail() {
        return "alternate." + generateEmail();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
