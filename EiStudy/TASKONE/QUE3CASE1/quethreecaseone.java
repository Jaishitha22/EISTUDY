// Target Interface

interface MediaPlayer {

    void play(String audioType, String fileName);
}

// Concrete Media Player Class
class AudioPlayer implements MediaPlayer {

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing MP3 file: " + fileName);
        } else {
            System.out.println("Invalid media type: " + audioType);
        }
    }
}

// Adaptee Class
interface VideoPlayer {

    void playVideo(String fileName);
}

// Concrete Video Player Class
class AdvancedVideoPlayer implements VideoPlayer {

    @Override
    public void playVideo(String fileName) {
        System.out.println("Playing video file: " + fileName);
    }
}

// Adapter Class
class VideoPlayerAdapter implements MediaPlayer {

    private AdvancedVideoPlayer advancedVideoPlayer;

    public VideoPlayerAdapter() {
        advancedVideoPlayer = new AdvancedVideoPlayer();
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp4")) {
            advancedVideoPlayer.playVideo(fileName);
        } else {
            System.out.println("Invalid media type: " + audioType);
        }
    }
}

// Client Class
public class quethreecaseone {

    public static void main(String[] args) {
        // Create AudioPlayer
        MediaPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "song.mp3");
        audioPlayer.play("mp4", "video.mp4"); // Invalid media type
        // Using Adapter to play video
        MediaPlayer videoPlayer = new VideoPlayerAdapter();
        videoPlayer.play("mp4", "video.mp4");
        videoPlayer.play("avi", "movie.avi"); // Invalid media type
    }
}
