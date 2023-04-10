package slaughterhouse.example.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ProductController {
    private static final String[] BODY_PARTS = {"head", "leg", "chest", "back"};
    private static final double[] BODY_PART_WEIGHTS = {0.1, 0.25, 0.4, 0.25};

    public static double calculateTotalWeight(Map<String, Integer> bodyParts, Map<String, Double> weights) {
        double totalWeight = 0.0;
        for (String part : bodyParts.keySet()) {
            int quantity = bodyParts.get(part);
            double weight = weights.get(part);
            totalWeight += quantity * weight;
        }
        return totalWeight;
    }

    public static void generateRandomProduct() {
        Random random = new Random();

        Map<String, Integer> bodyParts = new HashMap<>();
        for (String part : BODY_PARTS) {
            int quantity = random.nextInt(5) + 1;
            bodyParts.put(part, quantity);
        }

        Map<String, Double> weights = new HashMap<>();
        for (int i = 0; i < BODY_PARTS.length; i++) {
            weights.put(BODY_PARTS[i], BODY_PART_WEIGHTS[i]);
        }

        double totalWeight = calculateTotalWeight(bodyParts, weights);
        System.out.println("Total weight: " + totalWeight);
        System.out.println("Body parts:");
        for (String part : bodyParts.keySet()) {
            System.out.println(part + ": " + bodyParts.get(part));
        }
    }
}
