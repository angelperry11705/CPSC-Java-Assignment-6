import java.util.Scanner;

public class WeeklySpending {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

        System.out.println("How much did you spend on each day this week?");
        double[] spending = readSpending(console, days);
        printSpending(days, spending);

        double total = sum(spending);
        int highest = indexOfMax(spending);
        double average = total / spending.length;

        System.out.printf("Total spent: $%.2f%n", total);
        System.out.printf("Daily average: $%.2f%n", average);
        System.out.println("Highest day: " + days[highest]
                + " ($" + String.format("%.2f", spending[highest]) + ")");

        console.close();
    }

    public static double[] readSpending(Scanner console, String[] days) {
        double[] spending = new double[days.length];

        for (int i = 0; i < days.length; i++) {
            System.out.print("Amount spent on " + days[i] + ": $");
            spending[i] = console.nextDouble();
        }

        return spending;
    }

    public static void printSpending(String[] days, double[] spending) {
        System.out.println("\nDay\tAmount");

        for (int i = 0; i < days.length; i++) {
            System.out.printf("%s\t$%.2f%n", days[i], spending[i]);
        }
    }

    public static double sum(double[] list) {
        double total = 0;

        for (double amount : list) {
            total += amount;
        }

        return total;
    }

    public static int indexOfMax(double[] list) {
        int maxIndex = 0;

        for (int i = 1; i < list.length; i++) {
            if (list[i] > list[maxIndex]) {
                maxIndex = i;
            }
        }

        return maxIndex;
    }
}