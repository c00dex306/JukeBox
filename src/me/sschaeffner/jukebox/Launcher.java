package me.sschaeffner.jukebox;

/**
 * THIS IS JUST AN EXAMPLE IMPLEMENTATION!
 * LIBRARY IS: JukeBox, OMXPlayer and ProcessHandler!
 */

/**
 * @author sschaeffner
 */
public class Launcher {
    public static void main (String[] args) {
        System.out.println("hello world");

        JukeBox jb = new JukeBox("/home/pi/videos/hypnose.mp4");
        jb.start();

        Thread ti = new Thread(new InputHandler());
        ti.start();
    }
}
