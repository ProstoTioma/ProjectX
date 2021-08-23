package game;

import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;

public class Game {
    public ArrayList<SpaceObject> spaceObjects = createSolarSystem();
    private final double G = Math.pow(6.67, -6);


    public void moveObjects(ArrayList<SpaceObject> objects) {
        for (SpaceObject o : objects) {
            if (o.distanceToSun != 0) {
//                o.velocity[0] = (G * (objects.get(0).mass * o.mass) / (o.distanceToSun * o.distanceToSun));
//                o.velocity[1] = (G * (objects.get(0).mass * o.mass) / (o.distanceToSun * o.distanceToSun));
                o.velocity[0] = Math.sqrt(G * objects.get(0).mass * ((2 / o.distanceToSun) + (1 / o.a)));
                o.velocity[1] = Math.sqrt(G * objects.get(0).mass * ((2 / o.distanceToSun) + (1 / o.a)));
                //if (o.x == 870 && o.y == 520) o.velocity[1] = 0;
                if (o.x >= 870) {
                    o.x -= o.velocity[0];
                } else {
                    o.x += o.velocity[0];
                    //o.y -= o.velocity[1];
                }
                if (o.y > 520) o.y -= o.velocity[1];
                else  o.y += o.velocity[1];
                o.distanceToSun = Math.sqrt(Math.pow(870 - o.x, 2) + Math.pow(520 - o.y, 2));
            }
        }
    }


    public static ArrayList<SpaceObject> createSolarSystem() {
        ArrayList<SpaceObject> objects = new ArrayList<>();
        objects.add(new SpaceObject(Color.YELLOW, 800, 450, 70, 332_940, 0, new double[]{0.0, 0}, 0));
        SpaceObject sun = objects.get(0);
        objects.add(new SpaceObject(Color.GRAY, sun.x + 246, 450, 2.4, 0.055, 46, new double[]{0, 0}, 0.38));
        objects.add(new SpaceObject(Color.ORANGE, sun.x + 307, 450, 6, 0.815, 107, new double[]{0, 0}, 0.72));
        objects.add(new SpaceObject(Color.GREEN, sun.x + 350, 450, 6.4, 1, 150, new double[]{0, 0}, 1));
        objects.add(new SpaceObject(Color.RED, sun.x + 406, 450, 3.4, 0.107, 206, new double[]{0, 0}, 1.52));
        objects.add(new SpaceObject(Color.PINK, sun.x + 940, 450, 7, 31, 740, new double[]{0, 0}, 5.2));
        return objects;
    }


}
