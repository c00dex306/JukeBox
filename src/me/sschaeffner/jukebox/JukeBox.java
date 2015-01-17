package me.sschaeffner.jukebox;

/**
 * @author sschaeffner
 */
public class JukeBox {

    public JukeBox(String v0) {
        this.video0 = v0;
        newestJukeBox = this;
    }

    private static JukeBox newestJukeBox;
    public static JukeBox getJukeBox () {
        return newestJukeBox;
    }

    OMXPlayer omxp;
    String video0;


    public void start() {
        omxp = new OMXPlayer(video0, true);
    }

    public void startOtherVideo(String media) {
        omxp.kill();
        omxp = new OMXPlayer(media, false);
    }

    void onLastVideoEnd() {
        if (omxp.isDead()) {
            omxp = new OMXPlayer("/home/pi/videos/hypnose.mp4", true);
        }
    }

    public void jumpTo0() {
        omxp.kill();
    }

    OMXPlayer getOMXP () {
        return omxp;
    }
}