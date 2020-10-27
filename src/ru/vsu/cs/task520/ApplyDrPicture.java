package task520;

public class ApplyDrPicture {
    enum position {left, right};

    public static void main(String[] args) {
        drawPicture(12, 23);
    }

    public static void drawPicture(int width, int height) {
        int finishCounter = 1;//Need
        int startCounter = 0;//Output
        int stringCounter = 0;//Output in string;
        int b = (width - 2) / 2;
        position posit = position.left;

        for (int x = 0; x < height; x++) {
            if (startCounter == finishCounter && posit == position.left) {
                startCounter = 0;
                posit = position.right;
            }
            if (startCounter == finishCounter && posit == position.right) {
                startCounter = 0;
                finishCounter++;
                posit = position.left;
            }
            for (int y = 0; y < width; y++) {
                if (x == 0 && y == 0) {
                    System.out.print('+');
                    continue;
                }
                if (x == 0 && y == width - 1) {
                    System.out.print('+');
                    break;
                }
                if (x == height - 1 && y == 0) {
                    System.out.print('*');
                    continue;
                }
                if (x == height - 1 && y == width - 1) {
                    System.out.print('*');
                    break;
                }
                if (x == 0 || x == height - 1) {
                    System.out.print('-');
                    continue;
                }
                if (y == 0) {
                    System.out.print('|');
                    continue;
                }
                if (y == width - 1) {
                    System.out.print('|');
                    break;
                }
                if ((startCounter != finishCounter) && stringCounter == 0) {
                    if (posit == position.left) {
                        for (int j = y; j <= b; j++) {
                            System.out.print('*');
                            y++;
                        }
                        startCounter++;
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
                        startCounter++;
                        stringCounter++;
                        y--;
                        continue;
                    }
                }
                System.out.print(" ");
            }
            stringCounter = 0;
            System.out.println();
        }
    }
}
