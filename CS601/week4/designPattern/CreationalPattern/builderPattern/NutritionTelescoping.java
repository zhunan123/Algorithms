package week4.designPattern.CreationalPattern.builderPattern;

public class NutritionTelescoping {
    private final int servingSize;
    private final int serving;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    // In the context of the NutritionTelescoping class and its overloaded constructors, the this keyword is used for constructor chaining. Let's understand its usage:



    // overloading the constructor
    // those overloading constructor is like constructor chain method, each one constructor has to be chained to the next constructor
    public NutritionTelescoping(int servingSize, int serving) {
//        this.servingSize = servingSize;
//        this.serving = serving;
//        this.fat = 0;

//        this(servingSize, serving); - this is constructor chaining syntax
        this(servingSize, serving, 0); // question: why you need to add 0 in the end? otherwise will give you error?
        // this constructor only have 2 params, but why are we passing a extra params?
    }

    public NutritionTelescoping(int servingSize, int serving, int calories) {
        this(servingSize, serving, calories, 0);
    }

    public NutritionTelescoping(int servingSize, int serving, int calories, int fat) {
        this(servingSize, serving, calories, fat, 0, 0);
    }

    public NutritionTelescoping(int servingSize, int serving, int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize = servingSize;
        this.serving = serving;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }


    @Override
    public String toString() {
        return "NutritionTelescoping{" +
            "servingSize=" + servingSize +
            ", serving=" + serving +
            ", calories=" + calories +
            ", fat=" + fat +
            ", sodium=" + sodium +
            ", carbohydrate=" + carbohydrate +
            '}';
    }

    public static void main(String[] args) {
        NutritionTelescoping nt = new NutritionTelescoping(240, 8);
        System.out.println(nt.toString());
    }
}
