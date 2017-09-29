package org.ostroukh.dionisus.app.model.entity.geography;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Geographical coordinate of an object
 * @author Eugene Ostroukh
 */
@Embeddable
public class Coordinate {
    @Column(name = "X")
    private double x;

    @Column(name = "Y")
    private double y;

    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
