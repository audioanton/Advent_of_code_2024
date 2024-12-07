package day_6.part_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatrolAnalyzerTest {
    PatrolAnalyzer  patrolAnalyzer = new PatrolAnalyzer();

    String test = """
            ....#.....
            .........#
            ..........
            ..#.......
            .......#..
            ..........
            .#..^.....
            ........#.
            #.........
            ......#...
            """;

    int expected = 41;

    @Test
    void rotateGuard() {
        patrolAnalyzer.guardDirection = Direction.NORTH;
        patrolAnalyzer.rotateGuard();
        assertEquals(Direction.EAST, patrolAnalyzer.guardDirection);
        patrolAnalyzer.rotateGuard();
        assertEquals(Direction.SOUTH, patrolAnalyzer.guardDirection);
        patrolAnalyzer.rotateGuard();
        assertEquals(Direction.WEST, patrolAnalyzer.guardDirection);
        patrolAnalyzer.rotateGuard();
        assertEquals(Direction.NORTH, patrolAnalyzer.guardDirection);
    }

    @Test
    void findGuard() {
        patrolAnalyzer.createMap(test);
        patrolAnalyzer.findGuard();
        assertEquals(new Position(6, 4), patrolAnalyzer.guardPosition);
        assertEquals(Direction.NORTH, patrolAnalyzer.guardDirection);
    }

    @Test
    void findObstacle() {
        patrolAnalyzer.createMap(test);
        patrolAnalyzer.guardDirection = Direction.NORTH;
        patrolAnalyzer.guardPosition = new Position(6, 4);
        patrolAnalyzer.findObstacle();
        assertEquals(new Position(0, 4), patrolAnalyzer.obstaclePosition);
        patrolAnalyzer.guardPosition = new Position(1,4);
        patrolAnalyzer.guardDirection = Direction.EAST;
        patrolAnalyzer.findObstacle();
        assertEquals(new Position(1, 9), patrolAnalyzer.obstaclePosition);
        patrolAnalyzer.guardPosition = new Position(7,7);
        patrolAnalyzer.guardDirection = Direction.SOUTH;
        patrolAnalyzer.findObstacle();
        assertEquals(new Position(-1, -1), patrolAnalyzer.obstaclePosition);
    }

    @Test
    void sumAllSteps() {
        int res = patrolAnalyzer.sumAllSteps(test);
        assertEquals(expected, res);
    }

    @Test
    void createMap() {
        patrolAnalyzer.createMap(test);
        assertEquals(10, patrolAnalyzer.map.length);
        assertEquals(10, patrolAnalyzer.map[0].length);
        assertEquals(10, patrolAnalyzer.map[9].length);
        assertEquals("#", patrolAnalyzer.map[0][4]);
        assertEquals("^", patrolAnalyzer.map[6][4]);
    }

    @Test
    void setGuardPosition() {
        patrolAnalyzer.createMap(test);
        patrolAnalyzer.findGuard();
        patrolAnalyzer.findObstacle();
        patrolAnalyzer.setGuardPosition();

        assertEquals(new Position(1, 4), patrolAnalyzer.guardPosition);
        assertEquals(Direction.EAST, patrolAnalyzer.guardDirection);
        assertEquals("X", patrolAnalyzer.map[1][4]);
        assertEquals("X", patrolAnalyzer.map[5][4]);

        patrolAnalyzer.findObstacle();
        patrolAnalyzer.setGuardPosition();
        assertEquals(new Position(1, 8), patrolAnalyzer.guardPosition);
        assertEquals(Direction.SOUTH, patrolAnalyzer.guardDirection);
        assertEquals("X", patrolAnalyzer.map[1][5]);
        assertEquals("X", patrolAnalyzer.map[1][8]);

        patrolAnalyzer.guardPosition = new Position(7,7);
        patrolAnalyzer.guardDirection = Direction.SOUTH;
        patrolAnalyzer.findObstacle();
        patrolAnalyzer.setGuardPosition();
        assertEquals(new Position(-1, -1), patrolAnalyzer.obstaclePosition);
        assertEquals("X", patrolAnalyzer.map[9][7]);


        patrolAnalyzer.guardPosition = new Position(6, 2);
        patrolAnalyzer.guardDirection = Direction.NORTH;
        patrolAnalyzer.findObstacle();
        assertEquals(new Position(3, 2), patrolAnalyzer.obstaclePosition);
    }
}