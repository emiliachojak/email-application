package com.example.email.application;

public class MailboxManager {
    private int mailboxCapacity;

    public MailboxManager(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    public void addNewEmails(int amount) {
        if (amount > mailboxCapacity) {
            throw new RuntimeException("You want to add too many emails!");//TODO More specific exception
        }
        mailboxCapacity -= amount;
    }

    public void removeEmails(int amount) {
        mailboxCapacity += amount;
    }

    public int changeMailboxCapacity(int newCapacity) {
        mailboxCapacity = newCapacity;
        return mailboxCapacity;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }
}
