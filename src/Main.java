import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    private static void solveNecklace(String filename){
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        List<Integer> outputList = new ArrayList<>();
        int totalweight = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                int num = Integer.parseInt(line.trim());
                frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int largestKey = Collections.max(frequencyMap.keySet());
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int key = entry.getKey();
            int frequency = entry.getValue();

            if (key == largestKey) {
                outputList.add(key);
            } else if (frequency > 1) {
                outputList.add(key);
                outputList.add(key);
            }
        }

        int outputSize = outputList.size();
        for (int bead : outputList) {
            totalweight += bead;
        }
        System.out.println("NECKLACE: "+outputList);
        System.out.println("No. of beads: " + outputSize);
        System.out.println("weight: " + totalweight);
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        solveNecklace("C:\\Training\\test\\Necklace\\src\\masha_necklace_I_01.in");
        solveNecklace("C:\\Training\\test\\Necklace\\src\\masha_necklace_I_02.in");
        solveNecklace("C:\\Training\\test\\Necklace\\src\\masha_necklace_I_03.in");
        solveNecklace("C:\\Training\\test\\Necklace\\src\\masha_necklace_I_04.in");
        solveNecklace("C:\\Training\\test\\Necklace\\src\\masha_necklace_I_05.in");
        solveNecklace("C:\\Training\\test\\Necklace\\src\\masha_necklace_I_06.in");

        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        System.out.println("Total runtime: " + duration + " milliseconds");
}
}