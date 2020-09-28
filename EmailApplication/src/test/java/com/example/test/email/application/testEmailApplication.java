package com.example.test.email.application;

import com.example.email.application.EmailGenerator;
import com.example.email.application.MailboxManager;
import com.example.email.application.PassayPasswordGenerator;
import junit.framework.TestCase;
import org.junit.Test;

public class testEmailApplication extends TestCase {
    private String firstName = "Anna";
    private String lastName = "Smith";
    private String department = "sales";

    @Test
    public void testEmailGenerationWithDepartment() {
        EmailGenerator emailGenerator = new EmailGenerator(firstName, lastName, department);
        String email = emailGenerator.generateEmail();
        assertEquals("anna.smith@sales.mycompany.com", email);
    }

    @Test
    public void testEmailGenerationWithoutDepartment() {
        EmailGenerator emailGenerator = new EmailGenerator(firstName, lastName);
        String email = emailGenerator.generateEmail();
        assertEquals("anna.smith@mycompany.com", email);
    }

    @Test
    public void testGeneratingAlternateEmail() {
        EmailGenerator emailGenerator = new EmailGenerator(firstName, lastName, department);
        String email = emailGenerator.generateAlternateEmail();
        assertEquals("alternate.anna.smith@sales.mycompany.com", email);
    }

    @Test
    public void testPassayPasswordGenerator() {
        PassayPasswordGenerator passayPasswordGenerator = new PassayPasswordGenerator();
        String password = passayPasswordGenerator.generatePassword();
        assertEquals(8, password.length());
    }

    @Test
    public void testChangingPassword() {
        PassayPasswordGenerator passayPasswordGenerator = new PassayPasswordGenerator();
        String oldPassword = passayPasswordGenerator.generatePassword();
        String newPassword = passayPasswordGenerator.setNewPassword();
        assertFalse(newPassword == oldPassword);
    }

    @Test
    public void testAddingNewEmails() {
        MailboxManager mailboxManager = new MailboxManager(100);
        mailboxManager.addNewEmails(20);
        assertEquals(80, mailboxManager.getMailboxCapacity());
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
        assertFalse(oldCapacity == newCapacity);
    }
}
