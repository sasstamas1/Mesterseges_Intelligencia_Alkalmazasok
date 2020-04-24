package sample;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.Random;


public class Tile extends StackPane {

    private boolean turnX = true;
    private boolean playable = true;
    private Rectangle border = new Rectangle(100, 100);
    private Moves moves = new Moves();
    private int[] as = {-1,1,2,-2};
    public Tile(){

    }

    public Tile(int x, int i, int j) {
        if (x == 1) {
            if (i == 0 && j == 0) {
                Image img = new Image("sample/blackwithwhite.png");
                border.setFill(new ImagePattern(img));

            } else {
                border.setFill(Color.BLACK);
            }
        } else {
            if (i == 7 && j == 7) {
                Image img = new Image("sample/whitewithblack.png");

                border.setFill(new ImagePattern(img));
            } else if (i == 0 && j == 0) {
                Image img = new Image("sample/blackwithwhite.png");
                border.setFill(new ImagePattern(img));
            } else {
                border.setFill(Color.WHITE);
            }
        }

        border.setStroke(Color.BLACK);
        setAlignment(Pos.CENTER);
        getChildren().addAll(border);

        setOnMouseClicked(event -> {
            if (!playable)
                return;

            if (event.getButton() == MouseButton.PRIMARY) {
                if (!turnX)
                    return;
                if(moves.lepes(i,j)){
                    moveblack(border);
                    geplep();
                }
                turnX = false;
            }
        });
    }

    public void geplep(){
        if (moves.geplep(getRandom(as),getRandom(as))){
            System.out.println("Lépett a gép");
        }else{
            geplep();
        }
    }

    public void moveblack(Rectangle border) {
        if (border.getFill() == Color.BLACK) {
            Image img = new Image("sample/black with black.png");
            border.setFill(new ImagePattern(img));
        } else {
            Image img = new Image("sample/blackwithwhite.png");
            border.setFill(new ImagePattern(img));
        }
    }

    public void movewhite() {
        if (border.getFill() == Color.BLACK) {
            Image img = new Image("sample/white.png");
            border.setFill(new ImagePattern(img));
        } else {
            Image img = new Image("sample/whitewithblack.png");
            border.setFill(new ImagePattern(img));
        }
    }

    public void clear(String c){
        if (c.equals("b")){
            this.border.setFill(Color.RED);
        }
        if(c.equals("w")){
            this.border.setFill(Color.RED);
        }
    }


    public void setBorder(Rectangle border) {
        this.border = border;
    }

    public static int getRandom(int[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }
}