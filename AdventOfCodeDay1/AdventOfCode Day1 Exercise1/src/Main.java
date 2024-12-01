import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        List<Integer> firstRow = new ArrayList<>();
        List<Integer> secondRow = new ArrayList<>();
        int result = 0;

        File file = new File("AdventOfCodeDay1/data.txt");
        Scanner scanner = new Scanner(file);
        ArrayList<Integer> temporalVessel = new ArrayList<>();
        while (scanner.hasNextLine()) {
            var values = scanner.nextLine();
            var valuesSplitted = values.trim().split("\\s+");

            for (String string : valuesSplitted) {
                if (!string.isEmpty()) {
                    temporalVessel.add(Integer.parseInt(string));
                }
            }
        }
        for (int i = 0; i < temporalVessel.size(); i++) {
            if ((i % 2 == 0)) {
                firstRow.add(temporalVessel.get(i));
            } else {
                secondRow.add(temporalVessel.get(i));
            }
        }

        Collections.sort(firstRow);
        Collections.sort(secondRow);

        for (int i = 0; i < firstRow.size(); i++) {
            var temporalResult = firstRow.get(i) - secondRow.get(i);
            if (temporalResult < 0) {
                temporalResult *= -1;
            }
            result += temporalResult;

        }
        System.out.println("Result: " + result);
    }
}

