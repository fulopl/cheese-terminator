package com.codecool.dungeoncrawl.ui.elements;

import java.util.Random;

public enum VictoryMessage {
    MONSTER_KILL("Monster killlll"),
    YES("YESSSS"),
    BLOODLUST("BloodLust!!"),
    RAGE("AAAAAAAAAAA"),
    ANNIHILATED("That's what you get!"),
    OBLITERATED("You just got erased!"),
    DECIMATED("Consider yourself... decimated."),
    OWNAGE("Total ownage!"),
    BOOM_HEADSHOT("Boom! Headshot!"),
    GET_WRECKED("Get wrecked, scrublord!"),
    FATALITY("Fatality!"),
    FLAWLESS_VICTORY("Flawless victory!"),
    SKILLZ("Skillz that killz!"),
    EASY_PEASY("Too easy."),
    REKT("Rekt, mate."),
    WASTED("Wasted!"),
    FRIED("You just got fried!"),
    OUTPLAYED("Outplayed and outsmarted."),
    DOMINATED("Domination!"),
    EZ("EZ PZ."),
    SMOKED("Smoked!"),
    BACK_TO_LOBBY("Back to the lobby, amateur!"),
    SLICED_AND_DICED("Sliced and diced!"),
    CAKEWALK("That was a cakewalk!"),
    YOU_ARE_TOAST("And... you're toast!"),
    SAYONARA("Sayonara, sucker!"),
    PACK_YOUR_BAGS("Pack your bags, you're done!"),
    DISPATCHED("Dispatched with disdain!"),
    DELETE_YOUR_ACCOUNT("Delete your account!"),
    CANCELLED("Cancelled!"),
    SEE_YA("See ya wouldn’t wanna be ya!"),
    END_OF_LINE("End of the line!"),
    GAME_OVER("Game over for you!"),
    STAY_DOWN("And stay down!"),
    NEXT("Next!"),
    THAT_ALL_YOU_GOT("That all you got?"),
    BETTER_LUCK_NEXT_LIFE("Better luck next life!"),
    TO_THE_VICTOR("To the victor go the spoils!"),
    SLEEP_TIGHT("Sleep tight!"),
    OUTMATCHED("You’re outmatched!"),
    NUKED("Nuked 'em!"),
    OFF_THE_SERVER("Off the server with you!"),
    THATS_ALL_SHE_WROTE("That’s all she wrote!"),
    YOU_MET_YOUR_MAKER("You met your maker!"),
    SHUFFLED_OFF("Shuffled off this mortal coil!"),
    ANOTHER_ONE_BITES_THE_DUST("Another one bites the dust!"),
    CRUSHED_IT("Crushed it!"),
    BYE_FELICIA("Bye, Felicia!"),
    DUSTED("Dusted!"),
    GROUND_INTO_DIRT("Ground into the dirt!"),
    ANOTHER_NOTCH("Another notch on my belt!");

    private final String message;

    VictoryMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }


    public static VictoryMessage getRandomMessage() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
    }

