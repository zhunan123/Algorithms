package week4.designPattern.CreationalPattern.builderPattern;

public class NutritionBuilder {
    private final int servingSize; //required
    private final int serving; //required
    private final int calories;
    private final int fat;
    private final int sodium;

    public NutritionBuilder(Builder b) {
        this.servingSize = b.servingSize;
        this.serving = b.serving;
        this.calories = b.calories;
        this.fat = b.fat;
        this.sodium = b.sodium;
    }


    // why use this Builder inner class?
    //-> immutable
    //-> use build() method
    // when is static nested class, is very independent and cannot access outside class member variables
    // if without static, nested inner class can access outer class data
    public static class Builder {
        private int servingSize; //required
        private int serving; //required
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;

        public Builder(int serveSize, int serving) {
            this.servingSize = serveSize;
            this.serving = serving;
        }

        public Builder calories(int cal) {
            this.calories = cal;
            return this;
        }
        public Builder fat(int fat) {
            this.fat = fat;
            return this;
        }
        public Builder sodium(int sodium) {
            this.sodium = sodium;
            return this;
        }

        // chain inner builder with outer nutritionBuilder class and do validation checks

        public NutritionBuilder build() {
            return new NutritionBuilder(this);
        }
    }

    @Override
    public String toString() {
        return "NutritionBuilder{" +
            "servingSize=" + servingSize +
            ", serving=" + serving +
            ", calories=" + calories +
            ", fat=" + fat +
            ", sodium=" + sodium +
            '}';
    }
}
