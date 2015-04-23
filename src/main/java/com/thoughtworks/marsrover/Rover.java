package com.thoughtworks.marsrover;

/**
 * Represents a single rover than can be landed on a plateau.
 */
public class Rover {
    Plateau plateau;
    Position position;

    public Rover() {
        position = Position.Default();
    }

    public Rover(Position position) {
        if (position == null)
            throw new IllegalArgumentException("Invalid position");
        this.position = position;
    }

    public Rover(int x, int y, Direction direction) {
        this.position = new Position(x, y, direction);
    }

    public Position getCurrentPosition() {
        return position;
    }

    public Position land(Plateau plateau) throws Exception {
        return land(plateau, this.position);
    }

    public Position land(Plateau plateau, int x, int y, Direction direction) throws Exception {
        return land(plateau, new Position(x, y, direction));
    }

    /**
     * Lands this rover in the given plateau after checking whether the landing
     * position falls within the plateau's rectangular grid
     * @param plateau Plateau on which the rover should be landed
     * @param position Position in which the rover should land in the plateau
     * @return Position of the rover after a successful landing
     */
    public Position land(Plateau plateau, Position position) {
        if (plateau == null)
            throw new IllegalArgumentException("Invalid plateau");
        if (position == null || !plateau.contains(position))
            throw new IllegalArgumentException("Invalid position");

        this.plateau = plateau;
        this.position = position;
        return getCurrentPosition();
    }

    /**
     * Turns this rover by 90% to the left
     * @return Position of the rover after the turn
     * @throws Exception
     */
    public Position turnLeft() throws Exception {
        if (plateau == null)
            throw new Exception("Invalid plateau");
        this.position.turnLeft();
        System.out.println("L:" + getCurrentPosition());
        return getCurrentPosition();
    }

    /**
     * Turns this rover by 90% to the right
     * @return Position of the rover after the turn
     * @throws Exception
     */
    public Position turnRight() throws Exception {
        if (plateau == null)
            throw new Exception("Invalid plateau");
        this.position.turnRight();
        System.out.println("R:" + getCurrentPosition());
        return getCurrentPosition();
    }

    /**
     * Checks whether the rover can move forward in its current direction
     * by checking whether the new position will fall within the plateau
     * NOTE: If the plateau does not allow multiple rovers in a single cell,
     * this method needs to be expanded to check for that criteria as well!
     * @return
     */
    public boolean canMove() {
        if (this.plateau == null || this.position == null)
            return false;
        Position nextPosition = this.position.getNextMove();
        //System.out.println(String.format("NextPos: %s", nextPosition));
        return this.plateau.contains(nextPosition);
    }

    /**
     * Move the rover forward in its current direction
     * @return Position of the rover after the move
     * @throws Exception
     */
    public Position move() throws Exception {
        if (! canMove())
            throw new Exception("Cannot move further");

        this.position.move();
        System.out.println("M:" + getCurrentPosition());
        return getCurrentPosition();
    }

    /**
     * Execute the given command.
     * @param command Command to be executed. Possible commands are 'L', 'R' and 'M'
     * @return True - if the command is executed successfully and False otherwise.
     */
    public boolean execute(char command) {
        switch (command) {
            case 'L':
                try {
                    turnLeft();
                    return true;
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                    return false;
                }
            case 'R':
                try {
                    turnRight();
                    return true;
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                    return false;
                }
            case 'M':
                try {
                    move();
                    return true;
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                    return false;
                }
            default:
                return false;
        }
    }
}
