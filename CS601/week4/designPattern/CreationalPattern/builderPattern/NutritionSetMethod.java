package week4.designPattern.CreationalPattern.builderPattern;

public class NutritionSetMethod {
    private int servingSize = -1;
    private int serving = -1;
    private int calories = 0;
    private int fat = 0;
    private int sodium = 0;
    private int carbohydrate = 0;

    public NutritionSetMethod() {

    }

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public void setServing(int serving) {
        this.serving = serving;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    @Override
    public String toString() {
        return "NutritionSetMethod{" +
            "servingSize=" + servingSize +
            ", serving=" + serving +
            ", calories=" + calories +
            ", fat=" + fat +
            ", sodium=" + sodium +
            ", carbohydrate=" + carbohydrate +
            '}';
    }

    public static void main(String[] args) {
        NutritionSetMethod n = new NutritionSetMethod();
        n.setFat(3);
        n.setServingSize(10);
        System.out.println(n.toString());
    }
}
