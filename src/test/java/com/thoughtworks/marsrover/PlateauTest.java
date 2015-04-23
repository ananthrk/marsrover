package com.thoughtworks.marsrover;

import org.junit.Test;
import org.junit.Assert;

public class PlateauTest {

    @Test
    public void testValidInit() {
        try {
            new Plateau(1, 1);
        }
        catch (IllegalArgumentException ex) {
            Assert.fail("IllegalArgumentException should not be thrown");
        }

        try {
            new Plateau(0, 0, 1, 1);
        }
        catch (IllegalArgumentException ex) {
            Assert.fail("IllegalArgumentException should not be thrown");
        }

        try {
            new Plateau(1, 1, 2, 2);
        }
        catch (IllegalArgumentException ex) {
            Assert.fail("IllegalArgumentException should not be thrown");
        }
    }

    @Test
    public void testInvalidInit() {
        try {
            new Plateau(0, 0);
            Assert.fail("Expected IllegalArgumentException not thrown");
        }
        catch (IllegalArgumentException ex) {
            Assert.assertEquals(ex.getMessage(), "Invalid co-ordinates");
        }

        try {
            new Plateau(0, 0, -1, -1);
            Assert.fail("Expected IllegalArgumentException not thrown");
        }
        catch (IllegalArgumentException ex) {
            Assert.assertEquals(ex.getMessage(), "Invalid co-ordinates");
        }

        try {
            new Plateau(2, 2, 1, 1);
            Assert.fail("Expected IllegalArgumentException not thrown");
        }
        catch (IllegalArgumentException ex) {
            Assert.assertEquals(ex.getMessage(), "Invalid co-ordinates");
        }
    }

    @Test
    public void testContains() {
        Plateau plateau = new Plateau(0, 0, 5, 5);
        Assert.assertTrue(plateau.contains(0, 0));
        Assert.assertTrue(plateau.contains(0, 2));
        Assert.assertTrue(plateau.contains(2, 2));
        Assert.assertTrue(plateau.contains(4, 5));
        Assert.assertTrue(plateau.contains(5, 5));

        Assert.assertFalse(plateau.contains(1, 6));
        Assert.assertFalse(plateau.contains(6, 1));

        Assert.assertTrue(plateau.contains(Position.Default()));
        Assert.assertFalse(plateau.contains(new Position(1, 6, Direction.NORTH)));
        Assert.assertFalse(plateau.contains(null));
    }
}
