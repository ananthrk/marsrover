package com.thoughtworks.marsrover;

/**
 * Represents the possible directions. For each possible direction, it also
 * provides its left and right side
 */
public enum Direction {
    NORTH {
        @Override
        public Direction left() {
            return Direction.WEST;
        }

        @Override
        public Direction right() {
            return Direction.EAST;
        }
    },
    EAST{
        @Override
        public Direction left() {
            return Direction.NORTH;
        }

        @Override
        public Direction right() {
            return Direction.SOUTH;
        }
    },
    SOUTH{
        @Override
        public Direction left() {
            return Direction.EAST;
        }

        @Override
        public Direction right() {
            return Direction.WEST;
        }
    },
    WEST{
        @Override
        public Direction left() {
            return Direction.SOUTH;
        }

        @Override
        public Direction right() {
            return Direction.NORTH;
        }
    };

    @Override
    public String toString() {
        switch (this) {
            case NORTH:
                return "N";
            case EAST:
                return "E";
            case SOUTH:
                return "S";
            case WEST:
                return "W";
            default:
                return "N";
        }
    }

    public static Direction fromString(String direction) {
        if (direction == "N")
            return Direction.NORTH;
        else if (direction == "E")
            return Direction.EAST;
        else if (direction == "S")
            return Direction.SOUTH;
        else if (direction == "W")
            return Direction.WEST;
        else
            return Direction.NORTH;
    }

    public abstract Direction left();
    public abstract Direction right();
}
