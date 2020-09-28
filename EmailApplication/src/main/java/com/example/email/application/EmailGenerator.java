package com.example.email.application;

public class EmailGenerator {
    private static final String DOMAIN = "mycompany.com";

    public String generateEmail(String firstName, String lastName, String department) {
        firstName = firstName.toLowerCase();
        lastName = lastName.toLowerCase();
        department = department.toLowerCase();

        if (department.isBlank()) {
            return String.format("%s.%s@%s", firstName, lastName, DOMAIN);
        } else {
            return String.format("%s.%s@%s.%s", firstName, lastName, department, DOMAIN);
        }
    }

    public String generateAlternateEmail(String firstName, String lastName, String department) {
        return "alternate." + generateEmail(firstName, lastName, department);
    }
}
