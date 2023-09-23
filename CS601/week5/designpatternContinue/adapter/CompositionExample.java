package week5.designpatternContinue.adapter;

public class CompositionExample {
    static class Engine {
        void start() {
            System.out.println("Engine starting...");
        }
    }

    static class Car {
        // Composition - Car has-a Engine
        private Engine engine;

        Car() {
            engine = new Engine();
        }

        void start() {
            engine.start();
            System.out.println("Car starting...");
        }
    }

}
