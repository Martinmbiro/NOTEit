package com.vickikbt.notekeeper.Models;

import java.util.Random;

public class Quotes {
    private String[] facts = {
            "Choices have consequences.",
            "Love what you do, do what you love ❤.",
            "Wanting to be someone else is a waste of who you are.",
            "If you think you are too small to make a difference, try sleeping with a mosquito.🦟",
            "A clear conscience is a sure sign of a bad memory.🧠",
            "I used to think i was indecisive, but now i'm not sure.",
            "The question isn't who is going to let me, it's who is going to stop me.",
            "A diamond is merely a lump of coal that did well under pressure.💎",
            "Women who seek to be equal to men lack ambition.💃",
            "Age is of no importance unless you are cheese.🧀",
            "Always remember you are unique -just like everybody else.",
            "I always wanted to be somebody, but now i realise i should have been more specific.",
            "When i hear somebody sigh, 'Life is hard', i am always tempted to ask, 'compared to what?' 🤷🏼‍♂️",
            "We don't stop playing because we get old, we grow old because we stop playing.👴🏼",
            "The minute you settle for less than you deserve, you get even less than you settled for.💸",
            "I cannot afford to waste my time making money.💰",
            "The difference between genius and stupidity is; genius has its limits."

    };

    public String getRandomFact() {
        Random random = new Random();
        int randomNumber = random.nextInt(facts.length);
        return facts[randomNumber];
    }
}
