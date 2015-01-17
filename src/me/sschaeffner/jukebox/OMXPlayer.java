package me.sschaeffner.jukebox;

/**
 * @author sschaeffner
 */
public class OMXPlayer implements ProcessHandler.AfterRunnable {

    private ProcessHandler ph;
    private boolean loop;
    private boolean dead;

    public OMXPlayer (String media, boolean loop) {
        this.loop = loop;
        dead = false;
        String p = "omxplayer -b";
        if (loop) p += " --loop";
        p += " --no-osd " + media;

        ph = new ProcessHandler(p, this);
    }

    public void kill () {
        if (!dead) {
            dead = true;
            ph.sendKeystroke('q');
        }
    }

    public boolean isDead () {
        return dead;
    }

    public boolean doLoop() {
        return loop;
    }

    @Override
    public void onProcessDead() {
        dead = true;
        JukeBox.getJukeBox().onLastVideoEnd();
    }
}
