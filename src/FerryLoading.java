import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class FerryLoading {
    public static void main(String[] args) throws IOException {
        int testCases       = 0;    // Can be any number 1 <= c <= 20
        int boatLength      = 0;    // Can be any number 1 <= l <= 500 (meters)
        int carCount        = 0;    // Can be any number 1 <= m <= 10000
        int carLength       = 0;    // 1 <= cl <= 100000 (centimeters)
        int caseCount       = 0;    //number of cases
        String bank;
        boolean emptyFerry = true;

        Queue<Car> leftBank = new LinkedList<Car>();
        Queue<Car> rightBank = new LinkedList<Car>();

        // Reads the input
        BufferedReader input = new BufferedReader(new InputStreamReader(
                System.in));

        String caseString = input.readLine();
        testCases = Integer.valueOf(caseString);
        int crossCount[]    = new int[testCases]; // The number of transfers required
        for (int i = 0; i < testCases; i++) {
            String line1 = input.readLine();
            boatLength  = Integer.valueOf(line1.split(" ")[0]) * 100; // (to cm)
            carCount    = Integer.valueOf(line1.split(" ")[1]);
            crossCount[i] = 0;

            for (int j = 0; j < carCount; j++) {
                String line2 = input.readLine();
                carLength = Integer.valueOf(line2.split(" ")[0]);
                bank = line2.split(" ")[1];

                Car[] cars = new Car[carCount];
                cars[j] = new Car(carLength, bank);

                if (cars[j].getBank().equals("left")) {
                    leftBank.add(cars[j]);
                } else {
                    rightBank.add(cars[j]);
                }
            }

            int roomLeft = boatLength;
            while (!leftBank.isEmpty() || !rightBank.isEmpty()) {
                while (!leftBank.isEmpty() &&
                        ((roomLeft - leftBank.element().getLength()) >= 0)) {
                    roomLeft -= leftBank.element().getLength();
                    leftBank.remove();
                    emptyFerry = false;
                }
                if (!rightBank.isEmpty() || !emptyFerry) {
                    crossCount[i] += 1;
                }
                roomLeft = boatLength;
                emptyFerry = true;

                while (!rightBank.isEmpty() &&
                        ((roomLeft - rightBank.element().getLength()) >= 0)) {
                    roomLeft -= rightBank.element().getLength();
                    rightBank.remove();
                    emptyFerry = false;
                }
                if (!leftBank.isEmpty() || !emptyFerry) {
                    crossCount[i] += 1;
                }
                roomLeft = boatLength;
                emptyFerry = true;
            }

            caseCount += 1;
        }

        // =================
        // Output goes here!
        // =================
        for (int i = 0; i < caseCount; i++) {
            System.out.println(crossCount[i]);
        }
    }
}
