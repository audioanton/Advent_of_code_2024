package day_6.part_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PatrolAnalyzer {
    String[][] map;
    Position guardPosition;
    Direction guardDirection;
    Position obstaclePosition;
    int sum;


    public void setGuardPosition() {

        switch (guardDirection) {
            case Direction.NORTH: {
                drawSteps();
                if (obstaclePosition.row() >= 0) {
                    guardPosition = new Position(obstaclePosition.row() + 1, obstaclePosition.column());
                    rotateGuard();
                }
                break;
            }
            case SOUTH: {
                drawSteps();
                if (obstaclePosition.row() >= 0) {
                    guardPosition = new Position(obstaclePosition.row() - 1, obstaclePosition.column());
                    rotateGuard();
                }
                break;
            }
            case EAST: {
                drawSteps();
                if (obstaclePosition.row() >= 0) {
                    guardPosition = new Position(obstaclePosition.row(), obstaclePosition.column() - 1);
                    rotateGuard();
                }
                break;
            }
            case WEST: {
                drawSteps();
                if (obstaclePosition.row() >= 0) {
                    guardPosition = new Position(obstaclePosition.row(), obstaclePosition.column() + 1);
                    rotateGuard();
                }
                break;
            }
        }

    }

    public void drawSteps() {
        boolean end = obstaclePosition.row() == -1;

        switch (guardDirection) {
            case Direction.NORTH: {
                if (end) {
                    for (int i = guardPosition.row(); i >= 0; i--)
                        map[i][guardPosition.column()] = "X";
                }
                else {
                    for (int i = guardPosition.row(); i > obstaclePosition.row(); i--)
                        map[i][guardPosition.column()] = "X";
                }
                break;
            }
            case SOUTH: {
                if (end) {
                    for (int i = guardPosition.row(); i < map.length; i++)
                        map[i][guardPosition.column()] = "X";
                }
                else {
                    for (int i = guardPosition.row(); i < obstaclePosition.row(); i++)
                        map[i][guardPosition.column()] = "X";
                }
                break;
            }
            case EAST: {
                if (end) {
                    for (int i = guardPosition.column(); i < map[0].length; i++)
                        map[guardPosition.row()][i] = "X";
                }
                else {
                    for (int i = guardPosition.column(); i < obstaclePosition.column(); i++)
                        map[guardPosition.row()][i] = "X";
                }
                break;
            }
            case WEST: {
                if (end) {
                    for (int i = guardPosition.column(); i >= 0; i--)
                        map[guardPosition.row()][i] = "X";
                }
                else {
                    for (int i = guardPosition.column(); i > obstaclePosition.column(); i--)
                        map[guardPosition.row()][i] = "X";
                }
                break;
            }
        }
    }

    public void rotateGuard() {
        switch (guardDirection) {
            case NORTH: guardDirection = Direction.EAST; break;
            case EAST: guardDirection = Direction.SOUTH; break;
            case SOUTH: guardDirection = Direction.WEST; break;
            case WEST: guardDirection = Direction.NORTH; break;
        }
    }

    public void findGuard() {
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                if (map[row][col].equals("^")) {
                    this.guardPosition = new Position(row, col);
                    this.guardDirection = Direction.NORTH;
                    return;
                }
            }
        }
    }

    public void findObstacle() {
        switch (guardDirection) {
            case NORTH -> {
                for (int row = guardPosition.row()-1; row >= 0; row--) {
                    if (map[row][guardPosition.column()].equals("#")) {
                        obstaclePosition = new Position(row, guardPosition.column());
                        return;
                    }
                }
            }
            case EAST -> {
                for (int col = guardPosition.column()+1; col < map[0].length; col++) {
                    if (map[guardPosition.row()][col].equals("#")) {
                        obstaclePosition = new Position(guardPosition.row(), col);
                        return;
                    }
                }
            }
            case SOUTH -> {
                for (int row = guardPosition.row()+1; row < map.length; row++) {
                    if (map[row][guardPosition.column()].equals("#")) {
                        obstaclePosition = new Position(row, guardPosition.column());
                        return;
                    }
                }
            }
            case WEST -> {
                for (int col = guardPosition.column()-1; col >= 0; col--) {
                    if (map[guardPosition.row()][col].equals("#")) {
                        obstaclePosition = new Position(guardPosition.row(), col);
                        return;
                    }
                }
            }
        }
        obstaclePosition = new Position(-1, -1);
    }

    public int sumAllSteps(String s) {
        createMap(s);
        findGuard();
        obstaclePosition = new Position(0, 0);
        sum = 0;

        while(obstaclePosition.row() >= 0) {
            findObstacle();
            setGuardPosition();
        }

        for (String[] strings : map) {
            for (String string : strings) {
                if (string.equals("X")) {
                    sum++;
                }
            }
        }
        return sum;
    }

    public void createMap(String input) {
        List<String> strings = new ArrayList<>();

        try (Scanner scanner = new Scanner(input)) {
            while (scanner.hasNextLine()) {
                strings.add(scanner.nextLine());
            }
        }
        this.map = new String[strings.size()][strings.getFirst().length()];
        for (int i = 0; i < strings.size(); i++) {
            for (int j = 0; j < strings.get(i).length(); j++) {
                map[i][j] = String.valueOf(strings.get(i).charAt(j));
            }
        }
    }
}

