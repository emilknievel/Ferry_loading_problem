import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FerryLoading {
    public static void main(String[] args) throws IOException {
        int testCases   = 0;  // Can be any number 1 <= c <= 20
        int boatLength  = 0; // Can be any number 1 <= l <= 500 (meters)
        int carCount    = 0;   // Can be any number 1 <= m <= 10000
        int carLength   = 0;  // 1 <= cl <= 100000 (centimeters)
        String bank;

        // Reads the input
        BufferedReader input = new BufferedReader(new InputStreamReader(
                System.in));

        String caseString = input.readLine();
        testCases = Integer.valueOf(caseString);
        for (int i = 0; i < testCases; i++) {
            String line1 = input.readLine();
            boatLength  = Integer.valueOf(line1.split(" ")[0]);
            carCount    = Integer.valueOf(line1.split(" ")[1]);
            System.out.println(boatLength + " " + carCount);

            for (int j = 0; j < carCount; j++) {
                String line2 = input.readLine();
                carLength = Integer.valueOf(line2.split(" ")[0]);
                bank = line2.split(" ")[1];

                System.out.println(carLength + " " + bank);
            }
        }
    }
}
