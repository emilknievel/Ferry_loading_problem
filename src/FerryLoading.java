import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class FerryLoading {
    public static void main(String[] args) throws IOException {
        int testCases   = 0;    // Can be any number 1 <= c <= 20
        int boatLength  = 0;    // Can be any number 1 <= l <= 500 (meters)
        int carCount    = 0;    // Can be any number 1 <= m <= 10000
        int carLength   = 0;    // 1 <= cl <= 100000 (centimeters)
        int transfers = 0;      // The number of transfers required
        String bank;

        Queue<Car> leftBank = new LinkedList<Car>();
        Queue<Car> rightBank = new LinkedList<Car>();

        // Reads the input
        BufferedReader input = new BufferedReader(new InputStreamReader(
                System.in));

        String caseString = input.readLine();
        testCases = Integer.valueOf(caseString);
        for (int i = 0; i < testCases; i++) {
            String line1 = input.readLine();
            boatLength  = Integer.valueOf(line1.split(" ")[0]) * 100; // (to cm)
            carCount    = Integer.valueOf(line1.split(" ")[1]);
            System.out.println(boatLength + " " + carCount);

            for (int j = 0; j < carCount; j++) {
                String line2 = input.readLine();
                carLength = Integer.valueOf(line2.split(" ")[0]);
                bank = line2.split(" ")[1];

                Car[] cars = new Car[carCount];
                cars[j] = new Car(carLength, bank);

                if (cars[j].getBank().equals("left")) {
                    leftBank.add(cars[j]);
                    System.out.println(leftBank.element().getLength() + " " + leftBank.element().getBank());
                    leftBank.remove();
                } else {
                    rightBank.add(cars[j]);
                    System.out.println(rightBank.element().getLength() + " " + rightBank.element().getBank());
                    rightBank.remove();
                }
            }

            // =================
            // Output goes here!
            // =================
        }
    }
}
