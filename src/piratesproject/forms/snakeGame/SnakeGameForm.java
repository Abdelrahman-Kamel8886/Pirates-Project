package piratesproject.forms.snakeGame;

import java.util.LinkedList;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import piratesproject.forms.Settings.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import piratesproject.drawable.values.Pathes;

public class SnakeGameForm {
    private static final int TILE_SIZE = 30;
    private static final int WIDTH = 30;
    private static final int HEIGHT = 20;
    
    private static final int EASY = 120;
    private static final int MEDIUM = 80;
    private static final int HARD = 50;
    
    private static int GAME_SPEED = MEDIUM;
    
    private static int SCORE_RATE = 1;

    private LinkedList<Point> snake = new LinkedList<>();
    private Point food = new Point(10, 10);
    private String direction = "RIGHT";
    private boolean gameOver = false;
    
    private static Stage window;
    
private boolean gameStarted = false;

public void display(Stage owner) {
    Canvas canvas = new Canvas(WIDTH * TILE_SIZE, HEIGHT * TILE_SIZE);
    GraphicsContext gc = canvas.getGraphicsContext2D();

    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(GAME_SPEED), e -> {
        if (gameStarted) {
            run(gc);
        } else {
            drawInitialScreen(gc);
        }
    }));
    timeline.setCycleCount(Timeline.INDEFINITE);
    timeline.play();

    Group root = new Group(canvas);
    Scene scene = new Scene(root);
    scene.setOnKeyPressed(e -> {
        if (e.getCode() == KeyCode.ENTER && !gameStarted) {
            gameStarted = true; // Start the game
        } else if (gameStarted) {
            if (e.getCode() == KeyCode.UP && !"DOWN".equals(direction)) {
                direction = "UP";
            }
            if (e.getCode() == KeyCode.DOWN && !"UP".equals(direction)) {
                direction = "DOWN";
            }
            if (e.getCode() == KeyCode.LEFT && !"RIGHT".equals(direction)) {
                direction = "LEFT";
            }
            if (e.getCode() == KeyCode.RIGHT && !"LEFT".equals(direction)) {
                direction = "RIGHT";
            }
        }
    });

    if (GAME_SPEED == HARD) {
        SCORE_RATE = 10;
    } else if (GAME_SPEED == MEDIUM) {
        SCORE_RATE = 5;
    }
    snake.add(new Point(5, 5));
    snake.add(new Point(4, 5));
    snake.add(new Point(3, 5));

    window = new Stage();
    window.initOwner(owner);
    window.initModality(Modality.WINDOW_MODAL);
    window.setTitle("Snake Game");
    window.setResizable(false);
    window.getIcons().add(new Image(getClass().getResource(Pathes.SNAKE_LOGO_PATH).toString()));
    window.setScene(scene);

    window.show();
}

private void drawInitialScreen(GraphicsContext gc) {
    drawBackground(gc);
    draw(gc);

    // Draw the "Press Enter to Play" message
    gc.setFont(javafx.scene.text.Font.font(40));
    gc.setFill(Color.WHITE);
    gc.fillText("Press Enter to Play", WIDTH * TILE_SIZE / 2 - 150, HEIGHT * TILE_SIZE / 2);
}


    
    private void run(GraphicsContext gc) {
        if (gameOver) {
            gc.setFill(Color.RED);
            gc.setFont(javafx.scene.text.Font.font(40));
            gc.fillText("Game Over!", WIDTH * TILE_SIZE / 2 - 120, HEIGHT * TILE_SIZE / 2);
            gc.setFont(javafx.scene.text.Font.font(30));
            gc.setFill(Color.WHITE);
            gc.fillText("Score : " + (snake.size() - 3)*SCORE_RATE, WIDTH * TILE_SIZE / 2 - 60, HEIGHT * TILE_SIZE / 2 + 40);

            return;
        }

        moveSnake();

        if (checkCollision()) {
            gameOver = true;
        }

        if (snake.getFirst().equals(food)) {
            snake.add(new Point(-1, -1)); // Extend the snake
            spawnFood();
        }

        draw(gc);
    }

    private void moveSnake() {
        Point head = snake.getFirst();
        Point newHead;
        switch (direction) {
            case "UP":
                newHead = new Point(head.x, head.y - 1);
                break;
            case "DOWN":
                newHead = new Point(head.x, head.y + 1);
                break;
            case "LEFT":
                newHead = new Point(head.x - 1, head.y);
                break;
            case "RIGHT":
                newHead = new Point(head.x + 1, head.y);
                break;
            default:
                newHead = head;
                break;
        }

        snake.addFirst(newHead);
        snake.removeLast();
    }

    private boolean checkCollision() {
        Point head = snake.getFirst();

        // Check wall collision
        if (head.x < 0 || head.x >= WIDTH || head.y < 0 || head.y >= HEIGHT) {
            return true;
        }

        // Check self-collision
        for (int i = 1; i < snake.size(); i++) {
            if (head.equals(snake.get(i))) {
                return true;
            }
        }

        return false;
    }

    private void spawnFood() {
        Random random = new Random();
        food = new Point(random.nextInt(WIDTH), random.nextInt(HEIGHT));

        // Ensure food does not spawn on the snake
        while (snake.contains(food)) {
            food = new Point(random.nextInt(WIDTH), random.nextInt(HEIGHT));
        }
    }

    private void draw(GraphicsContext gc) {
        drawBackground(gc);

        // Draw the snake
        gc.setFill(Color.web("#FFD700"));
        for (Point p : snake) {
            gc.fillRect(p.x * TILE_SIZE, p.y * TILE_SIZE, TILE_SIZE - 1, TILE_SIZE - 1);
        }

        // Draw the food
        gc.setFill(Color.web("#FF6347"));
        gc.fillOval(food.x * TILE_SIZE, food.y * TILE_SIZE, TILE_SIZE - 1, TILE_SIZE - 1);

        // Draw the score in the top-left corner
        gc.setFont(javafx.scene.text.Font.font(30));  // Set font size for the score
        gc.setFill(Color.WHITE);
        gc.fillText("Score : " + (snake.size() - 3)*SCORE_RATE, 10, 30);  // Score will be updated live
    }

    private void drawBackground(GraphicsContext gc) {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if ((i + j) % 2 == 0) {
                    gc.setFill(Color.web("#436399"));
                } else {
                    gc.setFill(Color.web("#6FA1D7"));
                }
                gc.fillRect(j * TILE_SIZE, i * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        }
    }

    public static void closeForm(){
        window.close();
    }
    private static class Point {

        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Point point = (Point) obj;
            return x == point.x && y == point.y;
        }
    }
}
