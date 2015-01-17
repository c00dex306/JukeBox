package me.sschaeffner.jukebox;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * @author sschaeffner
 */
public class ProcessHandler {

    private Process p;
    private Writer w;

    public ProcessHandler(String cmd, final AfterRunnable ar) {

        try {
            p = Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    p.waitFor();
                    ar.onProcessDead();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        if (p != null) {
            w = new PrintWriter(new BufferedOutputStream(p.getOutputStream()));
        }
    }

    void sendKeystroke(char c) {
        if (w != null) {
            char[] carr = new char[1];
            carr[0] = c;
            try {
                w.write(carr);
                w.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public interface AfterRunnable {
        public void onProcessDead();
    }
}
