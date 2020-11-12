package task520;

import java.util.Scanner;

public class ApplyDrPicture {
    enum position {left, right}

    ;

    public static void main(String[] args) {
        int height = getHeight();
        int width = getWidth();
        
        drawPicture(height, width);
    }

    public static void drawPicture(int height, int width) {
        if (height == 2) {
            drawATopLine(width);
            drawALowerLine(width);
            return;
        } else {
            drawATopLine(width);
            drawABody(height, width);
            drawALowerLine(width);
        }
    }

    public static void drawATopLine(int width) {
        System.out.print('+');
        for (int x = 0; x < width - 2; x++) {
            System.out.print('-');
        }
        System.out.println('+');
    }

    public static void drawABody(int height, int width) {
        int necessaryCounter = 1;//Need
        int deducedCounter = 0;//Output
        int stringCounter = 0;//Output in string;
        int b = (width - 2) / 2;
        position posit = position.left;

        for (int x = 0; x < height - 2; x++) {
            if (deducedCounter == finishCounter && posit == position.left) {
                deducedCounter = 0;
                posit = position.right;
            }
            if (deducedCounter == finishCounter && posit == position.right) {
                deducedCounter = 0;
                finishCounter++;
                posit = position.left;
            }
            for (int y = 0; y < width; y++) {
                if (y == 0) {
                    System.out.print('|');
                    continue;
                }
                if (y == width - 1) {
                    System.out.print('|');
                    break;
                }
                if ((deducedCounter != finishCounter) && deducedCounter == 0) {
                    if (posit == position.left) {
                        for (int j = y; j <= b; j++) {
                            System.out.print('*');
                            y++;
                        }
                        deducedCounter++;
                        stringCounter++;
                    }
                    if (posit == position.right) {
                        for (int j = y; j <= b; j++) {
                            System.out.print(' ');
                            y++;
                        }
                        for (int z = y; z < width - 1; z++) {
                            System.out.print('*');
                            y++;
                        }
                        deducedCounter++;
                        stringCounter++;
                        y--;
                        continue;
                    }
                }
                System.out.print(' ');
            }
            stringCounter = 0;
            System.out.println();
        }
    }

    public static void drawALowerLine(int width) {
        System.out.print('*');
        for (int x = 0; x < width - 2; x++) {
            System.out.print('-');
        }
        System.out.println('*');
    }

    public static int getHeight() {
        Scanner s1 = new Scanner(System.in);

        while (true) {
            System.out.print("Input Height: ");
            int height = s1.nextInt();
            if (height < 2) {
                System.out.println("Input ERROR! height >= 2");
            } else
                break;
        }
        
        return height;
    }

    public static int getWidth() {
        Scanner s1 = new Scanner(System.in);

        while (true) {
            System.out.print("Input Width: ");
            int width = s1.nextInt();
            if (width < 2 || width % 2 != 0) {
                System.out.println("Input ERROR! width >= 2, width - is even integer");
            } else
                break;
        }
        
        return width;
    }
}
