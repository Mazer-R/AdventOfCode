import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        List<Integer> firstRow = new ArrayList<>();
        List<Integer> secondRow = new ArrayList<>();
        int[] result = {0};

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
            Map<Integer, Long> similarityMap = firstRow.stream().collect(Collectors.toMap(number-> number, element-> secondRow.stream().filter(times -> times.equals(element)).count()));
            similarityMap.forEach((number, times)->{
                if (times!=0){
                    System.out.println("Number "+ number + " appears "+ times+ " times on the list");
                    result[0] += number * times;
                }
            });
            System.out.println("Result: " + result[0]);


    }
}
