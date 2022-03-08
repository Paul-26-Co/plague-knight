package main.states;

import main.Game;
import main.button.Button;
import main.gfx.ImageLoader;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class MenuState extends State
{
    private Game game;
    private Button storyButton;
    private Button survivalButton;
    private Button exitButton;
    private String path = "/assets/menu/menubuttons/menubuttons.png";
    // TODO Auto-generated method stub


    public MenuState(Game game)
    {
        this.game = game;
//        Coordinate in Frame
        survivalButton = new Button(new Point(300, 250), new Point(180, 100));
        storyButton = new Button(new Point(300, 370), new Point(180, 100));
        exitButton = new Button(new Point(300, 490), new Point(180, 100));

//        Coordinate in Photos
        survivalButton.setTexture(new Point(1, 1), new Point(174, 89), path);
        storyButton.setTexture(new Point(348, 1), new Point(174, 89), path);
        exitButton.setTexture(new Point(696, 1), new Point(174, 89), path);
    }

    @Override
    public void tick() {
        int x = game.getMouseManager().getMouseX();
        int y = game.getMouseManager().getMouseY();
//        if(game.getMouseManager().getMouseButtonState(MouseEvent.BUTTON1)){
//            if(isInside(x, y, storyButton, "Story") || isInside(x, y, survivalButton, "Survival") || isInside(x, y, exitButton, "Exit")){
//                System.out.println("Inside");
//            }
//            else{
//                System.out.println("outside");
//            }
//        }
        if(game.getMouseManager().isMouseInside() || isInside(x, y, storyButton) || isInside(x, y, survivalButton) || isInside(x, y, exitButton)){
            System.out.println("INSIDE");
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
            if(game.getMouseManager().getMouseButtonState(MouseEvent.BUTTON1)){
                butt.setTexture(new Point((int) (butt.getImagePos().getX() + 173), 1), new Point(174, 89), path);
            }
            else{
                System.out.println("JUST HOVERING");
            }
            butt.setImagePos(getPos);
            return true;
        }
        return false;

    }
}

//            System.out.println(name);
//            System.out.println("QWEQWEQWE" + getPos);
//            System.out.println("ASDASDA" + butt.getImagePos());


//            System.out.println("VZZCZXC" + butt.getImagePos());
