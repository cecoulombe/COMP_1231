import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class MediaTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        String mediaFile = "/resources/floop.wav"; // Update the path to your media file
        Media media = new Media(mediaFile);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();

        StackPane root = new StackPane();
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
