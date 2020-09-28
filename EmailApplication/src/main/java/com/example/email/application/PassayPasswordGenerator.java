package com.example.email.application;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;

public class PassayPasswordGenerator {
    private final CharacterRule alphabets = new CharacterRule(EnglishCharacterData.Alphabetical);
    private final CharacterRule digits = new CharacterRule(EnglishCharacterData.Digit);
    private final CharacterRule special = new CharacterRule(EnglishCharacterData.Special);

    private final PasswordGenerator passwordGenerator = new PasswordGenerator();

    public String generatePassword(int length) {
        return passwordGenerator.generatePassword(length, alphabets, digits, special);
    }
}
