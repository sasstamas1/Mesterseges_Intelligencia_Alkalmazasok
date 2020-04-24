package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class Main extends Application {
    private static Tile[][] board = new Tile[8][8];

    private static Pane root = new Pane();
    private static Pane root1 = new Pane();

    private Parent createContent() {
        root.setPrefSize(800, 800);
        int temp = 0;
        for (int i = 0; i < 8; i++) {
            temp++;
            for (int j = 0; j < 8; j++) {
                temp++;
                Tile tile = null;
                if (temp % 2 == 0) {
                    tile = new Tile(0, i, j);
                } else {
                    tile = new Tile(1, i, j);
                }

                tile.setTranslateX(j * 100);
                tile.setTranslateY(i * 100);

                root.getChildren().add(tile);

                board[i][j] = tile;
            }
        }
        return root;
    }

    public static void clear(int i, int j, String c){
         Tile tile = board[i][j];
        tile.clear(c);

    }


    public static void movewhite(int i, int j){
        Tile tile = board[i][j];
        tile.movewhite();
    }


    public static boolean endgame(String s) {
        s = s + " nyert!";
        Text text = new Text("Játék Vége!" + s);
        text.setX(80);
        text.setY(80);
        text.setFill(Color.RED);
        text.setFont(Font.font ("Verdana", 20));
        root1.getChildren().addAll(text);
        Scene scene = new Scene(root1, 400, 400);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        return true;

    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }

    public static Tile[][] getBoard() {
        return board;
    }

    public static void setBoard(Tile[][] board) {
        Main.board = board;
    }


}
