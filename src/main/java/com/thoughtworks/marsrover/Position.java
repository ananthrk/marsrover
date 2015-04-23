package com.thoughtworks.marsrover;

/**
 * Represents Position of a rover
 */
public class Position {
    int x = 0;
    int y = 0;
    Direction direction = Direction.NORTH;

    private Position() {
        this(0, 0, Direction.NORTH);
    }

    public Position(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public static Position Default() {
        return new Position();
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Direction getDirection() {
        return this.direction;
    }

    /**
     * Turn left from the current position
     * @return New position after the turn
     */
    public Position turnLeft() {
        this.direction = this.direction.left();
        return this;
    }

    /**
     * Turn right from the current position
     * @return New position after the turn
     */
    public Position turnRight() {
        this.direction = this.direction.right();
        return this;
    }

    /**
     * Calculate the next possible move from the current position
     * @return Next possible position
     */
    public Position getNextMove() {
        switch (this.direction) {
            case NORTH:
                return new Position(this.x, this.y + 1, this.direction);
            case EAST:
                return new Position(this.x + 1, this.y, this.direction);
            case SOUTH:
                return new Position(this.x, this.y - 1, this.direction);
            case WEST:
                return new Position(this.x - 1, this.y, this.direction);
            default:
                return new Position(this.x, this.y, this.direction);
        }
    }

    /**
     * Move the current position based on the next possible move
     * @return New position after the move
     */
    public Position move() {
        Position nextMove = getNextMove();
        this.x = nextMove.getX();
        this.y = nextMove.getY();
        this.direction = nextMove.getDirection();
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Position))
            return false;

        Position pos = (Position)obj;
        if (pos == null)
            return false;

        return (this.getX() == pos.getX() && this.getY() == pos.getY() && this.getDirection() == pos.getDirection());
    }

    @Override
    public String toString() {
        return String.format("%d %d %s", this.x, this.y, this.direction);
    }
}
