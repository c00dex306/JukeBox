package me.sschaeffner.jukebox;

/**
 * @author sschaeffner
 */
public class JukeBox {

    public JukeBox(String v0) {
        this.video0 = v0;
        newestJukeBox = this;
        nextVideo = v0;
    }

    private static JukeBox newestJukeBox;
    public static JukeBox getJukeBox () {
        return newestJukeBox;
    }

    OMXPlayer omxp;
    String video0;
    String nextVideo;


    public void start() {
        omxp = new OMXPlayer(video0, true);
    }

    public void startOtherVideo(String media) {
        nextVideo = media;
        omxp.kill();
    }

    void onLastVideoEnd() {
        omxp = new OMXPlayer(nextVideo, true);
        nextVideo = video0;
    }

    public void jumpTo0() {
        omxp.kill();
    }

    OMXPlayer getOMXP () {
        return omxp;
    }
}