package game;

import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;

public class SpaceObject {
    public Color color;
    public int x, y;
    public double distanceToSun;
    public double radius, mass;
    public double[] velocity;


    public SpaceObject(Color color, int x, int y, double radius, double mass, int distanceToSun, double[] velocity) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.mass = mass;
        this.distanceToSun = distanceToSun;
        this.velocity = velocity;
    }


}
