package com.thoughtworks.marsrover;

import org.junit.Test;
import org.junit.Assert;

public class DirectionTest {

    @Test
    public void testToString() {
        Direction direction = Direction.NORTH;
        Assert.assertTrue("Should be N", direction.toString().equals("N"));
        direction = Direction.EAST;
        Assert.assertTrue("Should be E", direction.toString().equals("E"));
        direction = Direction.SOUTH;
        Assert.assertTrue("Should be S", direction.toString().equals("S"));
        direction = Direction.WEST;
        Assert.assertTrue("Should be W", direction.toString().equals("W"));
    }

    @Test
    public void testFromString() {
        Direction direction = Direction.fromString("N");
        Assert.assertEquals("Should be NORTH", direction, Direction.NORTH);
        direction = Direction.fromString("E");
        Assert.assertEquals("Should be EAST", direction, Direction.EAST);
        direction = Direction.fromString("S");
        Assert.assertEquals("Should be SOUTH", direction, Direction.SOUTH);
        direction = Direction.fromString("W");
        Assert.assertEquals("Should be WEST", direction, Direction.WEST);
    }

    @Test
    public void testTurns() {
        Direction direction = Direction.NORTH;
        Assert.assertEquals("Left of NORTH should be WEST", direction.left(), Direction.WEST);
        Assert.assertEquals("Right of NORTH should be EAST", direction.right(), Direction.EAST);

        direction = Direction.EAST;
        Assert.assertEquals("Left of EAST should be NORTH", direction.left(), Direction.NORTH);
        Assert.assertEquals("Right of EAST should be SOUTH", direction.right(), Direction.SOUTH);

        direction = Direction.SOUTH;
        Assert.assertEquals("Left of SOUTH should be EAST", direction.left(), Direction.EAST);
        Assert.assertEquals("Right of SOUTH should be WEST", direction.right(), Direction.WEST);

        direction = Direction.WEST;
        Assert.assertEquals("Left of WEST should be SOUTH", direction.left(), Direction.SOUTH);
        Assert.assertEquals("Right of WEST should be NORTH", direction.right(), Direction.NORTH);
    }
}
