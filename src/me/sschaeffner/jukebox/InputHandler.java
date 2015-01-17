package me.sschaeffner.jukebox;

import java.util.Scanner;

/**
 * @author sschaeffner
 */
public class InputHandler implements Runnable {
    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);

        String in;
        System.out.print("$ ");

        while(!(in = sc.nextLine()).equalsIgnoreCase("exit")) {
            if (in.equalsIgnoreCase("kill")) {
                JukeBox.getJukeBox().jumpTo0();
            } else if (in.equalsIgnoreCase("other1")) {
                JukeBox.getJukeBox().startOtherVideo("/home/pi/videos/walking.mp4");
            } else if (in.equalsIgnoreCase("other2")) {
                JukeBox.getJukeBox().startOtherVideo("/home/pi/videos/hero.mp4");
            } else if (in.equalsIgnoreCase("other3")) {
                JukeBox.getJukeBox().startOtherVideo("/home/pi/videos/cheat.mp4");
            } else {
                System.out.println("unknown command");
            }
            System.out.print("$ ");
        }
    }
}
