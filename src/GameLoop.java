import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GameLoop extends Application {
    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(800, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        new AnimationTimer() {
            double x = 0;

            @Override
            public void handle(long now) {
                gc.setFill(Color.BLACK);
                gc.fillRect(0, 0, 800, 600);

                gc.setFill(Color.RED);
                gc.fillOval(x, 300, 50, 50);

                x += 2;
                if (x > 800) x = -50;
            }
        }.start();

        stage.setScene(new Scene(new javafx.scene.Group(canvas)));
        stage.setTitle("Jogo 2D com JavaFX");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
