package week4.designPattern.CreationalPattern.builderPattern;

public class Drive {

    public static void main(String[] args) {
        // another way to use design pattern instead of using constructor
        NutritionBuilder.Builder builder = new NutritionBuilder.Builder(20, 8);
        NutritionBuilder nb = builder.calories(10).fat(20).sodium(22).build();
        System.out.println(nb.toString());
    }
}
