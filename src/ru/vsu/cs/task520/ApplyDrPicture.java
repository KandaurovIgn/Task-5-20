package task520;

import java.util.Scanner;

public class ApplyDrPicture {
    enum Position {left, right}
    ;

    public static void main(String[] args) {
        int height = getData("Height", 2);
        int width = getData("Width", 2, 2);

        drawPicture(height, width);
    }

    public static void drawPicture(int height, int width) {
        drawEnding(width, '+');
        drawABody(height, width);
        drawEnding(width, '*');
    }

    public static void drawEnding(int width, char symbol) {
        System.out.print(symbol);
        for (int x = 0; x < width - 2; x++) {
            System.out.print('-');
        }
        System.out.println(symbol);
    }

    public static void drawABody(int height, int width) {

        int necessaryCounter = 1;//Need *
        int deducedCounter = 0;//Output *
        Position posit = Position.left;

        for (int x = 0; x < height - 2; x++) {
            if (deducedCounter < necessaryCounter) {
                drawAPieceOfTheBody(posit, width);
                deducedCounter++;
                System.out.println();
            }
            if (posit == Position.left && deducedCounter == necessaryCounter) {
                posit = Position.right;
                deducedCounter = 0;
            }
            if (posit == Position.right && deducedCounter == necessaryCounter) {
                posit = Position.left;
                deducedCounter = 0;
                necessaryCounter++;
            }
        }
    }

    public static void drawAPieceOfTheBody(Position posit, int width) {

        System.out.print("|");
        if (posit == posit.left) {
            drawHalfAPieceOfTheBody(width, '*');
            drawHalfAPieceOfTheBody(width, ' ');
        }
        if (posit == posit.right) {
            drawHalfAPieceOfTheBody(width, ' ');
            drawHalfAPieceOfTheBody(width, '*');
        }
        System.out.print("|");
    }

    public static void drawHalfAPieceOfTheBody(int width, char symbol) {
        for (int x = 0; x < (width - 2) / 2; x++)
            System.out.print(symbol);
    }

    public static int getData(String valueName, int lowerLimit) {
        while (true) {
            int tempVar = getIntValue(valueName);
            if (!isValueMeetTheRequirements(tempVar, lowerLimit))
                System.out.println("Input ERROR!  " + valueName + " >= " + lowerLimit);
            else
                return tempVar;
        }
    }

    public static int getData(String valueName, int lowerLimit, int divisibility) {
        while (true) {
            int tempVar = getIntValue(valueName);
            if (!isValueMeetTheRequirements(tempVar, lowerLimit, divisibility))
                System.out.println("Input ERROR!  " + valueName + " >= " + lowerLimit + " && " + valueName + " % " + divisibility + " = 0");
            else
                return tempVar;
        }
    }

    public static int getIntValue(String valueName) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input " + valueName + ":");

        return scanner.nextInt();
    }

    public static boolean isValueMeetTheRequirements(int value, int lowerLimit, int divisibility) {
        return (value >= lowerLimit) && (value % divisibility == 0);
    }

    public static boolean isValueMeetTheRequirements(int value, int lowerLimit) {
        return value >= lowerLimit;
    }

}
