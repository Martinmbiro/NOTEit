package com.vickikbt.notekeeper.Models;

import java.util.Random;

public class Quotes {
    String[] facts = {
            "Bado gari ni gari 🚗 kwa dereva. 💯",
            "Love what you do, do what you love ❤.",
            "Ata ukuwe mtamu😋 aje hauwezi jikula...peana hiyo kitu🍑",
            "Nakata waba 🥃 nijifry liver",
            "Inauma 💔 but itabidi uzoe 👍",
            "Trust no hoe."
    };

    public String getRandomFact() {
        Random random = new Random();
        int randomNumber = random.nextInt(facts.length);
        String fact = facts[randomNumber];
        return fact;
    }
}
