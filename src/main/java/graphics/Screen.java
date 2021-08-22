package graphics;

import game.Game;
import game.SpaceObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Screen extends Canvas {
    public static Map<String, BufferedImage> imageMap = new HashMap<>();


    private final BufferStrategy strategy;
    private final Integer width;
    private final Integer height;
    private final Game game = new Game();


    public Screen(Integer width, Integer height) {
        this.width = width;
        this.height = height;
        JFrame container = new JFrame("SpaceX");

        JPanel panel = (JPanel) container.getContentPane();
        panel.setPreferredSize(new Dimension(width, height));
        panel.setLayout(null);

        setBounds(0, 0, width, height);
        panel.add(this);
        setIgnoreRepaint(true);

        container.pack();
        container.setResizable(false);
        container.setVisible(true);

        container.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        createBufferStrategy(2);
        strategy = getBufferStrategy();
    }

    public void gameLoop() throws InterruptedException, IOException {
        while (true) {
            Thread.sleep(20);
            draw();
        }
    }

    private void draw() {
        var g = getGameGraphics();
        drawBackground(g);
        ArrayList<SpaceObject> objects = game.spaceObjects;
        drawObject(g, objects);
        game.moveObjects(objects);

        g.dispose();
        strategy.show();
    }

    private Graphics2D getGameGraphics() {
        return (Graphics2D) strategy.getDrawGraphics();
    }

    private void drawBackground(Graphics2D g) {
        g.setColor(new Color(49, 46, 43));
        g.fillRect(0, 0, width, height);
    }

    private void drawObject(Graphics2D g, ArrayList<SpaceObject> objects) {
        for (SpaceObject o : objects) {
            g.setColor(o.color);
            g.fillOval(o.x, o.y, (int) o.radius * 2, (int) o.radius * 2);
        }
    }


}
