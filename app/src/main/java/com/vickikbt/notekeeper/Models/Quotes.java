package com.vickikbt.notekeeper.Models;

import java.util.Random;

public class Quotes {
    String[] facts = {
            "Love what you do, do what you love ❤.",
            "Ata ukuwe mtamu😋 aje hauwezi jikula...peana hiyo kitu🍑",
            "Nakata waba 🥃 nijifry liver",
            "Inauma 💔 but itabidi uzoe 👍",
            "Trust no hoe.",
            "Gari ni gari 🚗 kwa dereva."
    };

    public String getRandomFact() {
        Random random = new Random();
        int randomNumber = random.nextInt(facts.length);
        String fact = facts[randomNumber];
        return fact;
    }
}
