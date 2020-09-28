package com.example.email.application;

public class MailboxManager {
    private int mailboxCapacity;

    public MailboxManager(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    public void addNewEmails(int amount) {
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
