package com.example.mikhail.game2;

/**
 * Basic level structure for game
 * <p/>
 * Created by Mikhail on 15.11.2015.
 */
public class lvl {
    public int image;
    public String answer;
    public int chapter;
    public int status;
    public int tryCount;
    public String help;

    lvl(int image, String answer, int chapter, int status, int tryCount, String help) {
        this.image = image;
        this.answer = answer;
        this.chapter = chapter;
        this.tryCount = tryCount;
        this.status = status;
        this.help = help;
    }
}
