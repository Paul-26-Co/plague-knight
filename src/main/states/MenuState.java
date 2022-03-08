package main.states;

import main.Game;
import main.button.Button;
import main.gfx.ImageLoader;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import static java.lang.Thread.sleep;

public class MenuState extends State
{
    private Game game;
    private Button storyButton;
    private Button survivalButton;
    private Button exitButton;
    private String path = "/assets/menu/menubuttons/menubuttonsv3.png";
    // TODO Auto-generated method stub


    public MenuState(Game game)
    {
        this.game = game;
//        Coordinate in Frame
        survivalButton = new Button(new Point(300, 250), new Point(180, 100));
        storyButton = new Button(new Point(300, 370), new Point(180, 100));
        exitButton = new Button(new Point(300, 490), new Point(180, 100));

//        Coordinate in Photos
        survivalButton.setTexture(new Point(0, 0), new Point(173, 87), path);
        storyButton.setTexture(new Point(522, 0), new Point(173, 87), path);
        exitButton.setTexture(new Point(1044, 0), new Point(173, 87), path);
    }

    @Override
    public void tick() {
        SurvivalMenuState survivalMenuState = new SurvivalMenuState();
        int x = game.getMouseManager().getMouseX();
        int y = game.getMouseManager().getMouseY();

        if(isInside(x, y, storyButton) || isInside(x, y, survivalButton) || isInside(x, y, exitButton)){
//            MenuState.setState(survivalMenuState);
        }

    }

    @Override
    public void render(Graphics g)
    {
        g.drawImage(survivalButton.getImage(), (int) survivalButton.getPos().getX(), (int) survivalButton.getPos().getY(),
                (int) survivalButton.getSize().getX(), (int) survivalButton.getSize().getY(), null);

        g.drawImage(storyButton.getImage(), (int) storyButton.getPos().getX(), (int) storyButton.getPos().getY(),
                (int) storyButton.getSize().getX(), (int) storyButton.getSize().getY(), null);

        g.drawImage(exitButton.getImage(), (int) exitButton.getPos().getX(), (int) exitButton.getPos().getY(),
                (int) exitButton.getSize().getX(), (int) exitButton.getSize().getY(), null);
    }


    public boolean isInside(float x, float y, Button butt){

        Point getPos = butt.getImagePos();
//        x <= image.width + image.x && x >= image.x
//        y <= image.width + image.y && y >= image.y
        if((x <= butt.getSize().getX() + butt.getPos().getX() && x >=  butt.getPos().getX()) &&
                (y <= butt.getSize().getY() + butt.getPos().getY() && y >= butt.getPos().getY())){

            butt.setTexture(new Point((int) (butt.getImagePos().getX() + 174), 0), new Point(173, 87), path);

//            If button clicked
            if(game.getMouseManager().getMouseButtonState(MouseEvent.BUTTON1)){
//              Animate button
                butt.setTexture(new Point((int) (butt.getImagePos().getX() + 175), 0), new Point(173, 87), path);
                butt.setImagePos(getPos);
                return true;
            }

            butt.setImagePos(getPos);
            return false;
        }

//        butt.setImagePos(getPos);

//        butt.setTexture(new Point((int) (butt.getImagePos().getX()), 0), new Point(173, 87), path);
        return false;
    }
}
