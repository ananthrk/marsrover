package com.thoughtworks.marsrover;

public class Main {
    public static void main(String[] args) throws Exception {
        Plateau plateau = new Plateau(5, 5);
        Rover rover = new Rover();
        rover.land(plateau, 1, 2, Direction.NORTH);
        rover.execute('L');
        rover.execute('M');
        rover.execute('L');
        rover.execute('M');
        rover.execute('L');
        rover.execute('M');
        rover.execute('L');
        rover.execute('M');
        rover.execute('M');

        System.out.println("---------");

        rover = new Rover();
        rover.land(plateau, 3, 3, Direction.EAST);
        rover.execute('M');
        rover.execute('M');
        rover.execute('R');
        rover.execute('M');
        rover.execute('M');
        rover.execute('R');
        rover.execute('M');
        rover.execute('R');
        rover.execute('R');
        rover.execute('M');
    }
}
