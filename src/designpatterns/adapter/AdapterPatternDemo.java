package designpatterns.adapter;

/*

Adapter pattern works as a bridge between two incompatible interfaces. This type of design pattern comes under
structural pattern as this pattern combines the capability of two independent interfaces.
Step 1 - Create interfaces for Media Player and Advanced Media Player.
Step 2 - Create concrete classes implementing the AdvancedMediaPlayer interface.
Step 3 - Create adapter class implementing the MediaPlayer interface.
Step 4 - Create concrete class implementing the MediaPlayer interface.
Step 5 - Use the AudioPlayer to play different types of audio formats.

 */
public class AdapterPatternDemo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }
}