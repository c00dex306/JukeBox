package me.sschaeffner.jukebox;

/**
 * @author sschaeffner
 */
public class Launcher {
    public static void main (String[] args) {
        System.out.println("hello world");
        JukeBox jb = new JukeBox("/home/pi/videos/hypnose.mp4");
        jb.start();
    }
}
