package com.thoughtworks.marsrover;

import org.junit.Assert;
import org.junit.Test;

public class RoverTest {

    @Test
    public void testLand() {
        Plateau plateau = new Plateau(0, 0, 5, 5);
        Rover rover = new Rover();

        try {
            rover.land(plateau);
        } catch (Exception ex) {
            Assert.fail("Landing failed");
        }

        rover = new Rover();
        try {
            rover.land(null);
            Assert.fail("Landing should fail for invalid plateau");
        } catch (Exception ex) {
            Assert.assertEquals(ex.getMessage(),"Invalid plateau");
        }

        rover = new Rover();
        try {
            rover.land(plateau, 4, 6, Direction.NORTH);
            Assert.fail("Landing should fail for invalid position");
        } catch (Exception ex) {
            Assert.assertEquals(ex.getMessage(),"Invalid position");
        }
    }

    @Test
    public void testLeftTurn() {
        Plateau plateau = new Plateau(0, 0, 5, 5);
        Rover rover = new Rover();

        try {
            rover.turnLeft();
            Assert.fail("Turn should fail when rover is not landed");
        } catch (Exception ex) {
            Assert.assertEquals(ex.getMessage(),"Invalid plateau");
        }

        try {
            rover.land(plateau);
        } catch (Exception ex) {
            Assert.fail("Landing should have been successful");
        }

        try {
            rover.turnLeft();
            Assert.assertEquals("Should be WEST", rover.getCurrentPosition().getDirection(), Direction.WEST);
        } catch (Exception ex) {
            Assert.fail("Turn should have been successful");
        }

        try {
            rover.turnLeft();
            Assert.assertEquals("Should be SOUTH", rover.getCurrentPosition().getDirection(), Direction.SOUTH);
        } catch (Exception ex) {
            Assert.fail("Turn should have been successful");
        }
    }

    @Test
    public void testRightTurn() {
        Plateau plateau = new Plateau(0, 0, 5, 5);
        Rover rover = new Rover();

        try {
            rover.turnRight();
            Assert.fail("Turn should fail when rover is not landed");
        } catch (Exception ex) {
            Assert.assertEquals(ex.getMessage(),"Invalid plateau");
        }

        try {
            rover.land(plateau);
        } catch (Exception ex) {
            Assert.fail("Landing should have been successful");
        }

        try {
            rover.turnRight();
            Assert.assertEquals("Should be EAST", rover.getCurrentPosition().getDirection(), Direction.EAST);
        } catch (Exception ex) {
            Assert.fail("Turn should have been successful");
        }

        try {
            rover.turnRight();
            Assert.assertEquals("Should be SOUTH", rover.getCurrentPosition().getDirection(), Direction.SOUTH);
        } catch (Exception ex) {
            Assert.fail("Turn should have been successful");
        }
    }

    @Test
    public void testCanMove() {
        Plateau plateau = new Plateau(0, 0, 5, 5);
        Rover rover = new Rover();

        Assert.assertFalse("Should not be able to move when rover is not landed", rover.canMove());

        try {
            rover.land(plateau);
        } catch (Exception ex) {
            Assert.fail("Landing should have been successful");
        }

        Assert.assertTrue("Should be able to move when rover is landed", rover.canMove());

        rover = new Rover(5, 4, Direction.NORTH);
        try {
            rover.land(plateau);
        } catch (Exception ex) {
            Assert.fail("Landing should have been successful");
        }

        try {
            rover.move();
        } catch (Exception ex) {
            Assert.fail("Move should not fail");
        }

        Assert.assertFalse("Should not be able to move further", rover.canMove());
    }

    @Test
    public void testMove() {
        Plateau plateau = new Plateau(0, 0, 5, 5);
        Rover rover = new Rover();

        try {
            rover.move();
            Assert.fail("Move should fail when rover is not landed");
        } catch (Exception ex) {
            Assert.assertEquals(ex.getMessage(), "Cannot move further");
        }

        try {
            rover.land(plateau);
        } catch (Exception ex) {
            Assert.fail("Landing should have been successful");
        }

        try {
            rover.move();
        } catch (Exception ex) {
            Assert.fail("Should have moved further");
        }

        rover = new Rover(5, 4, Direction.NORTH);
        try {
            rover.land(plateau);
        } catch (Exception ex) {
            Assert.fail("Landing should have been successful");
        }

        try {
            rover.move();
        } catch (Exception ex) {
            Assert.fail("Move should not fail");
        }

        try {
            rover.move();
            Assert.fail("Move should have failed");
        } catch (Exception ex) {
            Assert.assertEquals(ex.getMessage(), "Cannot move further");
        }
    }

    @Test
    public void testExecute() {
        Plateau plateau = new Plateau(0, 0, 5, 5);
        Rover rover = new Rover();

        try {
            rover.land(plateau, 1, 2, Direction.NORTH);
        } catch (Exception ex) {
            Assert.fail("Landing should have been successful");
        }

        Assert.assertTrue("Command 1 should not have failed", rover.execute('L'));
        Assert.assertTrue("Command 2 should not have failed", rover.execute('M'));
        Assert.assertTrue("Command 3 should not have failed", rover.execute('L'));
        Assert.assertTrue("Command 4 should not have failed", rover.execute('M'));
        Assert.assertTrue("Command 5 should not have failed", rover.execute('L'));
        Assert.assertTrue("Command 6 should not have failed", rover.execute('M'));
        Assert.assertTrue("Command 7 should not have failed", rover.execute('L'));
        Assert.assertTrue("Command 8 should not have failed", rover.execute('M'));
        Assert.assertTrue("Command 9 should not have failed", rover.execute('M'));

        Assert.assertEquals("Position should have been 1 3 N", rover.getCurrentPosition().toString(), "1 3 N");

        rover = new Rover();

        try {
            rover.land(plateau, 3, 3, Direction.EAST);
        } catch (Exception ex) {
            Assert.fail("Landing should have been successful");
        }

        Assert.assertTrue("Command 1 should not have failed", rover.execute('M'));
        Assert.assertTrue("Command 2 should not have failed", rover.execute('M'));
        Assert.assertTrue("Command 3 should not have failed", rover.execute('R'));
        Assert.assertTrue("Command 4 should not have failed", rover.execute('M'));
        Assert.assertTrue("Command 5 should not have failed", rover.execute('M'));
        Assert.assertTrue("Command 6 should not have failed", rover.execute('R'));
        Assert.assertTrue("Command 7 should not have failed", rover.execute('M'));
        Assert.assertTrue("Command 8 should not have failed", rover.execute('R'));
        Assert.assertTrue("Command 9 should not have failed", rover.execute('R'));
        Assert.assertTrue("Command 10 should not have failed", rover.execute('M'));

        Assert.assertEquals("Position should have been 5 1 E", rover.getCurrentPosition().toString(), "5 1 E");

        Assert.assertFalse("Empty command should be rejected", rover.execute(' '));
        Assert.assertFalse("Unknown command should be rejected", rover.execute('X'));
    }
}
