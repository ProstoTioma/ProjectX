package game;

import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;

public class Game {
    public ArrayList<SpaceObject> spaceObjects = createSolarSystem();
    private final double G = Math.pow(6.67, 1);


    public void moveObjects(ArrayList<SpaceObject> objects) {
        for (SpaceObject o : objects) {
            if (o.distanceToSun != 0) {
                o.velocity[0] = Math.sqrt(G * (objects.get(0).mass * o.mass) / (o.distanceToSun * o.distanceToSun));
                o.velocity[1] = Math.sqrt(G * (objects.get(0).mass * o.mass) / (o.distanceToSun * o.distanceToSun));
                o.x += o.velocity[0];
                o.y += o.velocity[1];
                o.distanceToSun = Math.sqrt(Math.pow(objects.get(0).x - o.x, 2) + Math.pow(objects.get(0).y - o.y, 2));
            }
        }
    }


    public static ArrayList<SpaceObject> createSolarSystem() {
        ArrayList<SpaceObject> objects = new ArrayList<>();
        objects.add(new SpaceObject(Color.YELLOW, 800, 450, 70, 332_940, 0, new double[]{-4.8, 0}));
        SpaceObject sun = objects.get(0);
        objects.add(new SpaceObject(Color.GRAY, sun.x + 246, 450, 2.4, 0.055, 46, new double[]{-3.5, 0}));
        objects.add(new SpaceObject(Color.ORANGE, sun.x + 307, 450, 6, 0.815, 107, new double[]{-3.0, 0}));
        objects.add(new SpaceObject(Color.GREEN, sun.x + 350, 450, 6.4, 1, 150, new double[]{-2.4, 0}));
        objects.add(new SpaceObject(Color.PINK, sun.x + 406, 450, 3.4, 0.107, 206, new double[]{-1.3, 0}));
        return objects;
    }


}
