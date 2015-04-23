package com.thoughtworks.marsrover;

import org.junit.Test;
import org.junit.Assert;

public class PositionTest {

    @Test
    public void testDefault() {
        Position position = Position.Default();
        Assert.assertEquals("Default x should be 0", position.getX(), 0);
        Assert.assertEquals("Default y should be 0", position.getY(), 0);
        Assert.assertEquals("Default direction should be NORTH", position.getDirection(), Direction.NORTH);
    }

    @Test
    public void testToString() {
        Position position = Position.Default();
        Assert.assertEquals("Should be 0 0 N", position.toString(), "0 0 N");

        position = new Position(1, 2, Direction.EAST);
        Assert.assertEquals("Should be 1 2 E", position.toString(), "1 2 E");
    }

    @Test
    public void testEquals() {
        Assert.assertTrue("Should be equal", Position.Default().equals(new Position(0, 0, Direction.NORTH)));
        Assert.assertFalse("Should NOT be equal", Position.Default().equals(new Position(1, 0, Direction.NORTH)));
        Assert.assertFalse("Should NOT be equal", Position.Default().equals(new Position(0, 1, Direction.NORTH)));
        Assert.assertFalse("Should NOT be equal", Position.Default().equals(new Position(0, 0, Direction.EAST)));
    }

    @Test
    public void testLeftTurn() {
        Position position = new Position(1, 2, Direction.NORTH);
        position.turnLeft();
        Assert.assertEquals("Should be WEST", position.getDirection(), Direction.WEST);
        position.turnLeft();
        Assert.assertEquals("Should be SOUTH", position.getDirection(), Direction.SOUTH);
        position.turnLeft();
        Assert.assertEquals("Should be EAST", position.getDirection(), Direction.EAST);
        position.turnLeft();
        Assert.assertEquals("Should be NORTH", position.getDirection(), Direction.NORTH);
    }

    @Test
    public void testRightTurn() {
        Position position = new Position(1, 2, Direction.NORTH);
        position.turnRight();
        Assert.assertEquals("Should be EAST", position.getDirection(), Direction.EAST);
        position.turnRight();
        Assert.assertEquals("Should be SOUTH", position.getDirection(), Direction.SOUTH);
        position.turnRight();
        Assert.assertEquals("Should be WEST", position.getDirection(), Direction.WEST);
        position.turnRight();
        Assert.assertEquals("Should be NORTH", position.getDirection(), Direction.NORTH);
    }

    @Test
    public void testNextMove() {
        Position position = new Position(1, 2, Direction.NORTH);
        Position nextPosition = position.getNextMove();
        Assert.assertEquals("Should be 1 3 N", nextPosition.toString(), "1 3 N");

        position = new Position(3, 3, Direction.EAST);
        nextPosition = position.getNextMove();
        Assert.assertEquals("Should be 4 3 E", nextPosition.toString(), "4 3 E");

        position = new Position(1, 2, Direction.SOUTH);
        nextPosition = position.getNextMove();
        Assert.assertEquals("Should be 1 1 S", nextPosition.toString(), "1 1 S");

        position = new Position(3, 3, Direction.WEST);
        nextPosition = position.getNextMove();
        Assert.assertEquals("Should be 2 3 W", nextPosition.toString(), "2 3 W");
    }

    @Test
    public void testMove() {
        Position position = new Position(1, 2, Direction.NORTH);
        position.move();
        Assert.assertEquals("Should be 1 3 N", position.toString(), "1 3 N");

        position = new Position(3, 3, Direction.EAST);
        position.move();
        Assert.assertEquals("Should be 4 3 E", position.toString(), "4 3 E");

        position = new Position(1, 2, Direction.SOUTH);
        position.move();
        Assert.assertEquals("Should be 1 1 S", position.toString(), "1 1 S");

        position = new Position(3, 3, Direction.WEST);
        position.move();
        Assert.assertEquals("Should be 2 3 W", position.toString(), "2 3 W");
    }

}
