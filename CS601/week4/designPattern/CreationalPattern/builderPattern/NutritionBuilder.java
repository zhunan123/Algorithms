package week4.designPattern.CreationalPattern.builderPattern;

public class NutritionBuilder {
    private final int servingSize;
    private final int serving;
    private final int calories;
    private final int fat;
    private final int sodium;

    public static class Builder {
        private int servingSize;
        private int serving;
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

    public NutritionBuilder(Builder b) {
        this.servingSize = b.servingSize;
        this.serving = b.serving;
        this.calories = b.calories;
        this.fat = b.fat;
        this.sodium = b.sodium;
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
