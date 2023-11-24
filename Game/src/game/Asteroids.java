package game;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.*;
import java.util.*;

class DataStructure {
    int number;
    String word;
    String meaning;
}

public class Asteroids extends Application {
    public static void main(String[] args) {
        try {
            launch(args);
        }
        catch (Exception error) {
            error.printStackTrace();
        }
        finally {
            System.exit(0);
        }
    }

    int score;
    int numCha;
    String wordChallenge;
    String wordMeaning;
    boolean[] hitLetter = new boolean[26];

    private Set<Integer> numSet = new HashSet<>();
    private Random random = new Random();

    // Random int from a to b.
    public int randomInt(int a, int b) {
        if (a > b) {
            throw new IllegalArgumentException("Invalid range");
        }
        int range = b - a + 1;
        if (numSet.size() == range) {
            numSet.clear();
        }
        int randomNum;
        do {
            randomNum = random.nextInt(range) + a;
        } while (numSet.contains(randomNum));
        numSet.add(randomNum);
        return randomNum;
    }

    public void start(Stage mainStage) {
        mainStage.setTitle("Gem");

        BorderPane root = new BorderPane();
        Scene mainScene = new Scene(root);

        mainStage.setScene(mainScene);

        Canvas canvas = new Canvas(800, 500);
        GraphicsContext context = canvas.getGraphicsContext2D();
        root.setCenter(canvas);

        ArrayList<String> keyPress = new ArrayList<String>();
        ArrayList<Sprite> bulletList = new ArrayList<Sprite>();
        ArrayList<Sprite> asteroidsList = new ArrayList<Sprite>();
        ArrayList<String> keyJustPress = new ArrayList<String>();
        ArrayList<DataStructure> dataList = new ArrayList<DataStructure>();

        mainScene.setOnKeyPressed(
                (KeyEvent event) -> {
                    String keyName = event.getCode().toString();
                    // avoid adding duplicated to List.
                    if (!keyPress.contains(keyName)){
                        keyPress.add(keyName);
                        keyJustPress.add(keyName);
                    }
                }
        );

        mainScene.setOnKeyReleased(
                (KeyEvent event) -> {
                    String keyName = event.getCode().toString();
                    if (keyPress.contains(keyName)) keyPress.remove(keyName);
                }
        );

        Sprite background = new Sprite("C://Java//OOP_N12_EnglishDictionary//Game//src//image//back.png");
        background.position.set(400, 250);

        Sprite spaceship = new Sprite("C:\\Java\\OOP_N12_EnglishDictionary\\Game\\src\\image\\spaceship.png");
        spaceship.position.set(50, 200);

        int asteroidsCount = 5;
        for (int i = 0; i < asteroidsCount; i++) {
            int numPic = randomInt(1, 26);
            Sprite asteroid = null;
            switch(numPic) {
                case 1:
                    asteroid = new Sprite("C://Java//OOP_N12_EnglishDictionary//Game//src//image//A.png");
                    break;
                case 2:
                    asteroid = new Sprite("C://Java//OOP_N12_EnglishDictionary//Game//src//image//B.png");
                    break;
                case 3:
                    asteroid = new Sprite("C://Java//OOP_N12_EnglishDictionary//Game//src//image//C.png");
                    break;
                case 4:
                    asteroid = new Sprite("C://Java//OOP_N12_EnglishDictionary//Game//src//image//D.png");
                    break;
                case 5:
                    asteroid = new Sprite("C://Java//OOP_N12_EnglishDictionary//Game//src//image//E.png");
                    break;
                case 6:
                    asteroid = new Sprite("C://Java//OOP_N12_EnglishDictionary//Game//src//image//F.png");
                    break;
                case 7:
                    asteroid = new Sprite("C://Java//OOP_N12_EnglishDictionary//Game//src//image//G.png");
                    break;
                case 8:
                    asteroid = new Sprite("C://Java//OOP_N12_EnglishDictionary//Game//src//image//H.png");
                    break;
                case 9:
                    asteroid = new Sprite("C://Java//OOP_N12_EnglishDictionary//Game//src//image//I.png");
                    break;
                case 10:
                    asteroid = new Sprite("C://Java//OOP_N12_EnglishDictionary//Game//src//image//J.png");
                    break;
                case 11:
                    asteroid = new Sprite("C://Java//OOP_N12_EnglishDictionary//Game//src//image//K.png");
                    break;
                case 12:
                    asteroid = new Sprite("C://Java//OOP_N12_EnglishDictionary//Game//src//image//L.png");
                    break;
                case 13:
                    asteroid = new Sprite("C://Java//OOP_N12_EnglishDictionary//Game//src//image//M.png");
                    break;
                case 14:
                    asteroid = new Sprite("C://Java//OOP_N12_EnglishDictionary//Game//src//image//N.png");
                    break;
                case 15:
                    asteroid = new Sprite("C://Java//OOP_N12_EnglishDictionary//Game//src//image//O.png");
                    break;
                case 16:
                    asteroid = new Sprite("C://Java//OOP_N12_EnglishDictionary//Game//src//image//P.png");
                    break;
                case 17:
                    asteroid = new Sprite("C://Java//OOP_N12_EnglishDictionary//Game//src//image//Q.png");
                    break;
                case 18:
                    asteroid = new Sprite("C://Java//OOP_N12_EnglishDictionary//Game//src//image//R.png");
                    break;
                case 19:
                    asteroid = new Sprite("C://Java//OOP_N12_EnglishDictionary//Game//src//image//S.png");
                    break;
                case 20:
                    asteroid = new Sprite("C://Java//OOP_N12_EnglishDictionary//Game//src//image//T.png");
                    break;
                case 21:
                    asteroid = new Sprite("C://Java//OOP_N12_EnglishDictionary//Game//src//image//U.png");
                    break;
                case 22:
                    asteroid = new Sprite("C://Java//OOP_N12_EnglishDictionary//Game//src//image//V.png");
                    break;
                case 23:
                    asteroid = new Sprite("C://Java//OOP_N12_EnglishDictionary//Game//src//image//W.png");
                    break;
                case 24:
                    asteroid = new Sprite("C://Java//OOP_N12_EnglishDictionary//Game//src//image//X.png");
                    break;
                case 25:
                    asteroid = new Sprite("C://Java//OOP_N12_EnglishDictionary//Game//src//image//Y.png");
                    break;
                case 26:
                    asteroid = new Sprite("C://Java//OOP_N12_EnglishDictionary//Game//src//image//Z.png");
                    break;
            }
            double x = 500 * Math.random() + 300; // 300 - 800
            double y = 300 * Math.random() + 100; // 100 - 400
            asteroid.position.set(x, y);
            double angle = 360 * Math.random();
            asteroid.velocity.setLength(20);
            asteroid.velocity.setAngle(angle);
            asteroidsList.add(asteroid);
        }

        score = 0;
        numCha = 1;
        for(int i = 0; i < 26; i++) hitLetter[i] = false;

        AnimationTimer gameloop = new AnimationTimer() {

            // File Input method.
            public void readDatafromTextfile(String filepath) {
                try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] parts = line.split("\\."); // substring by ".".
                        if (parts.length == 3) {
                            DataStructure temp = new DataStructure();
                            temp.number = Integer.parseInt(parts[0]);
                            temp.word = parts[1];
                            temp.meaning = parts[2];
                            dataList.add(temp);
                        } else {
                            System.out.println("Invalid data format in line: " + line);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            // Check collision between bullet and text.
            public boolean checkCollision() {
                return false;
            }

            int numWord = randomInt(0, 99);
            @Override
            public void handle(long nanotime) {
                // process user input.
                if(keyPress.contains("A")) spaceship.rotation -= 2;

                if(keyPress.contains("D")) spaceship.rotation += 2;

                if(keyPress.contains("W")) {
                    spaceship.velocity.setLength(80); // speed.
                    spaceship.velocity.setAngle(spaceship.rotation); // go ahead.
                } else { // not pressing up
                    spaceship.velocity.setLength(0);
                }

                if(keyJustPress.contains("SPACE")) {
                    Sprite bullet = new Sprite("C://Java//OOP_N12_EnglishDictionary//Game//src//image//bullet.png");
                    bullet.position.set(spaceship.position.x, spaceship.position.y);
                    bullet.velocity.setLength(150);
                    bullet.velocity.setAngle(spaceship.rotation);
                    bulletList.add(bullet);
                }

                // after processing user input, clear justPress.
                keyJustPress.clear();

                for (Sprite asteroid : asteroidsList) asteroid.update(1/60.0);
                // update bullet; destroy if 4s passed.
                for(int i = 0; i < bulletList.size(); i++) {
                    Sprite bullet = bulletList.get(i);
                    bullet.update(1/60.0);
                    if (bullet.elapsedTime > 4) bulletList.remove(i);
                }

                spaceship.update(1/60.0);

                background.render(context);
                spaceship.render(context);
                for(Sprite bullet : bulletList) bullet.render(context);
                for(Sprite asteroids : asteroidsList) asteroids.render(context);

                readDatafromTextfile("C://Java//OOP_N12_EnglishDictionary//Game//src//game//Data.txt");

                // Shape: Question.
                context.setFill(Color.BEIGE);
                context.setStroke(Color.BEIGE);
                context.fillRect(0, 350, 800, 150);

                // Text: Score.
                context.setFill(Color.YELLOW);
                context.setStroke(Color.YELLOW);
                context.setFont(new Font("Calibri", 25));
                String scoreText = "Score: " + score;
                int scoreX = 680;
                int scoreY = 40;
                context.fillText(scoreText, scoreX, scoreY);
                context.strokeText(scoreText, scoreX, scoreY);

                // Text: Number of Challenge.
                context.setFill(Color.GREY);
                context.setStroke(Color.RED);
                String numChaText = "Challenge " + numCha + ":";
                int questX = 20;
                int questY = 380;
                context.fillText(numChaText, questX, questY);
                context.strokeText(numChaText, questX, questY);

                // Text: Challenge.
                context.setFill(Color.BLACK);
                context.setStroke(Color.CHOCOLATE);
                context.setFont(new Font("Calibri", 65));
                DataStructure wordTemp = dataList.get(numWord);
                char x = wordTemp.word.charAt(1);
                x = Character.toUpperCase(x);
                String fileName = "C://Java//OOP_N12_EnglishDictionary//Game//src//image//" + x + ".png";
                Sprite asteroidChallenge = new Sprite(fileName);
                String newWord = wordTemp.word.charAt(0) + "_" + wordTemp.word.substring(2);
                String wordText = newWord + ": " + wordTemp.meaning;
                int wordX = 230;
                int wordY = 440;
                context.fillText(wordText, wordX, wordY);
                context.strokeText(wordText, wordX, wordY);

                // when bullet overlaps asteroids, remove both.
                // when spaceship overlaps asteroids, set spaceship to the spawn.
                for(int bulletNum = 0; bulletNum < bulletList.size(); bulletNum++) {
                    Sprite bullet = bulletList.get(bulletNum);
                    for(int asteroidNum = 0; asteroidNum < asteroidsList.size(); asteroidNum++) {
                        Sprite asteroid = asteroidsList.get(asteroidNum);
                        if (bullet.overlaps(asteroid)) {
                            score++;
                            numCha++;
                            bulletList.remove(bulletNum);
                            asteroidsList.remove(asteroidNum);
                        }
                    }
                }
            }
        };

        gameloop.start();

        mainStage.show();
    }
}