package com.thoughtworks.marsrover;

/*
 * Represents a rectangular Plateau on which Rovers will land
 * NOTE: We assume that a single cell in the rectangular grid can support
 * more than one rover at the same time
 */
public class Plateau {
    int lx = 0;
    int ly = 0;
    int rx = 0;
    int ry = 0;

    public Plateau() {
        this(0, 0, 5, 5);
    }

    public Plateau(int rx, int ry) {
        this(0, 0, rx, ry);
    }

    public Plateau(int lx, int ly, int rx, int ry) {
        //Make sure we have atleast one grid in the Plateau
        if (lx < 0 || ly < 0 || rx <= 0 || rx <= lx || ry <= 0 || ry <= ly)
            throw new IllegalArgumentException("Invalid co-ordinates");
        this.lx = lx;
        this.ly = ly;
        this.rx = rx;
        this.ry = ry;
    }

    public int getLx() {
        return this.lx;
    }

    public int getLy() {
        return this.ly;
    }

    public int getRx() {
        return this.rx;
    }

    public int getRy() {
        return this.ry;
    }

    /**
     * Checks whether the given position falls within the Plateau's grid
     * @param position
     * @return True - if the position falls within the grid and False otherwise
     */
    public boolean contains(Position position) {
        if (position == null)
            return false;
        return contains(position.getX(), position.getY());
    }

    /**
     * Checks whether the given co-ordinates fall within the Plateau's grid
     * @param x
     * @param y
     * @return True - if the co-ordinates fall within the grid and False otherwise
     */
    public boolean contains(int x, int y) {
        return (x >= lx && x <= rx && y >= ly && y <= ry);
    }
}