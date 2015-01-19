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
        System.out.println("startOtherVideo -> nextVideo = media (" + media + ")");
        nextVideo = media;
        omxp.kill();
        System.out.println("startOtherVideo -> done");
    }

    void onLastVideoEnd() {
        System.out.println("onLastVideoEnd -> new OMXPlayer(nextVideo=" + nextVideo + ", " + (nextVideo == video0) + ")");
        omxp = new OMXPlayer(nextVideo, nextVideo == video0);
        nextVideo = video0;
        System.out.println("onLastVideoEnd -> nextVideo = video0");
    }

    public void jumpTo0() {
        omxp.kill();
    }

    OMXPlayer getOMXP () {
        return omxp;
    }
}