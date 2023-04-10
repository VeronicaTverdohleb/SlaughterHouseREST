package slaughterhouse.example.controller;

public class AnimalPartController {
    private static final int ONE_HEAD = 1;
    private static final int TWO_LEGS = 2;
    private static final int FOUR_LEGS = 4;
    private static final int ONE_CHEST = 1;
    private static final int ONE_BACK = 1;

    /**
     * Sets the number of heads, legs, chests, and backs for the given animal type.
     *
     * @param animalType The type of animal to set the attributes for.
     * @param animalPart     The animal object to set the attributes on.
     */
  /*  public static void setAnimalAttributes(String animalType, Part animalPart, double weight) {
        switch (animalType) {
            case "Cow":
                animalPart.setHeads(ONE_HEAD, weight * 0.1);
                animalPart.setLegs(FOUR_LEGS, weight * 0.25);
                animalPart.setChests(ONE_CHEST, weight * 0.4);
                animalPart.setBacks(ONE_BACK, weight * 0.25);
                break;
            case "Pig":
                animalPart.setHeads(ONE_HEAD, weight * 0.1);
                animalPart.setLegs(FOUR_LEGS, weight * 0.24);
                animalPart.setChests(ONE_CHEST, weight * 0.4);
                animalPart.setBacks(ONE_BACK, weight * 0.26);
                break;
            case "Chicken":
                animalPart.setHeads(ONE_HEAD, weight * 0.1);
                animalPart.setLegs(TWO_LEGS, weight * 0.1);
                animalPart.setChests(ONE_CHEST, weight * 0.4);
                animalPart.setBacks(ONE_BACK, weight * 0.4);
                break;
            default:
                // Handle unsupported animal types
                throw new IllegalArgumentException("Unsupported animal type: " + animalType);
        }
    }*/
}
