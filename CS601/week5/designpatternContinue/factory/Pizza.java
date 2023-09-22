package week5.designpatternContinue.factory;

import java.util.ArrayList;
import java.util.List;

abstract public class Pizza {
    private String name;
    private String dough;
    private String sauce;
    private List<String> toppings = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDough(String dough) {
        this.dough = dough;
    }

    public void addTopping(String topping) {
        this.toppings.add(topping);
    }

    public String getDough() {
        return dough;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public void prepare() {
        System.out.println("Preparing " + name);
    }

    public void bake() {
        System.out.println("Baking " + name);
    }

    public void cut() {
        System.out.println("Cutting " + name);
    }

    public void box() {
        System.out.println("Boxing " + name);
    }

    public String toString() {
        // code to display pizza name and ingredients
        StringBuffer display = new StringBuffer();
        display.append("---- " + name + " ----" + System.lineSeparator());
        display.append(dough + System.lineSeparator());
        display.append(sauce + System.lineSeparator());
        for (int i = 0; i < toppings.size(); i++) {
            display.append(toppings.get(i) + System.lineSeparator());
        }
        return display.toString();
    }
}
