package com.example.test.email.application;

import com.example.email.application.EmailGenerator;
import com.example.email.application.MailboxManager;
import com.example.email.application.PassayPasswordGenerator;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestEmailApplication {
    private final String firstName = "Anna";
    private final String lastName = "Smith";
    private final String department = "sales";

    @Test
    public void testTwoEmailGenerationsWithoutDepartment() {
        String[] firstNames = new String[]{"John", "Mary"};
        String[] lastNames = new String[]{"Doe", "Smith"};
        String[] emails = new String[2];

        EmailGenerator emailGenerator = new EmailGenerator();
        for (int i = 0; i < 2; i++) {
            emails[i] = emailGenerator.generateEmail(firstNames[i], lastNames[i], "");
        }

        for (int i = 0; i < 2; i++) {
            assertEquals(String.format("%s.%s@mycompany.com", firstNames[i].toLowerCase(), lastNames[i].toLowerCase()), emails[i]);
        }
    }

    @Test
    public void testEmailGenerationWithDepartment() {
        EmailGenerator emailGenerator = new EmailGenerator();
        String email = emailGenerator.generateEmail(firstName, lastName, department);

        assertEquals("anna.smith@sales.mycompany.com", email);
    }

    @Test
    public void testEmailGenerationWithoutDepartment() {
        EmailGenerator emailGenerator = new EmailGenerator();
        String email = emailGenerator.generateEmail(firstName, lastName, "");

        assertEquals("anna.smith@mycompany.com", email);
    }

    @Test
    public void testGeneratingAlternateEmail() {
        EmailGenerator emailGenerator = new EmailGenerator();
        String email = emailGenerator.generateAlternateEmail(firstName, lastName, department);

        assertEquals("alternate.anna.smith@sales.mycompany.com", email);
    }

    @Test
    public void testPassayPasswordGenerator() {
        PassayPasswordGenerator passayPasswordGenerator = new PassayPasswordGenerator();
        String password = passayPasswordGenerator.generatePassword(8);

        assertEquals(8, password.length());
    }

    @Test
    public void testAddingNewEmails() {
        MailboxManager mailboxManager = new MailboxManager(100);
        mailboxManager.addNewEmails(20);

        assertEquals(80, mailboxManager.getMailboxCapacity());
    }

    @Test(expected = RuntimeException.class)
    public void testAddingTooManyEmails() {
        MailboxManager mailboxManager = new MailboxManager(200);
        mailboxManager.addNewEmails(250);
    }

    @Test
    public void testRemovingEmails() {
        MailboxManager mailboxManager = new MailboxManager(120);
        mailboxManager.removeEmails(20);

        assertEquals(140, mailboxManager.getMailboxCapacity());
    }

    @Test
    public void testChangingCapacity() {
        MailboxManager mailboxManager = new MailboxManager(100);
        int oldCapacity = mailboxManager.getMailboxCapacity();
        int newCapacity = mailboxManager.changeMailboxCapacity(200);

        assertNotSame(oldCapacity, newCapacity);
    }
}
