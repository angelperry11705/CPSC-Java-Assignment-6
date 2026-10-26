import java.util.Scanner;

public class MovieSeats {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        boolean[][] theater = new boolean[4][6];
        int row;
        int seat;

        do {
            printSeatMap(theater);

            System.out.print("Enter row number (1-4, 0 to finish): ");
            row = console.nextInt();

            if (row == 0) {
                break;
            }

            System.out.print("Enter seat number (1-6): ");
            seat = console.nextInt();

            if (row < 1 || row > theater.length || seat < 1 || seat > theater[0].length) {
                System.out.println("That seat does not exist.");
            } else if (theater[row - 1][seat - 1]) {
                System.out.println("That seat is already taken.");
            } else {
                theater[row - 1][seat - 1] = true;
                System.out.println("Seat reserved.");
            }

            printSeatMap(theater);
        } while (row != 0);

        System.out.println("Seats taken: " + countTaken(theater));
        console.close();
    }

    public static void printSeatMap(boolean[][] theater) {
        System.out.println("\nSeat Map");
        System.out.print("    ");
        for (int seat = 1; seat <= theater[0].length; seat++) {
            System.out.printf("%2d ", seat);
        }
        System.out.println();

        for (int row = 0; row < theater.length; row++) {
            System.out.printf("%2d  ", row + 1);
            for (int seat = 0; seat < theater[row].length; seat++) {
                if (theater[row][seat]) {
                    System.out.print(" X ");
                } else {
                    System.out.print(" O ");
                }
            }
            System.out.println();
        }
    }

    public static int countTaken(boolean[][] theater) {
        int taken = 0;

        for (int row = 0; row < theater.length; row++) {
            for (int seat = 0; seat < theater[row].length; seat++) {
                if (theater[row][seat]) {
                    taken++;
                }
            }
        }

        return taken;
    }
}
