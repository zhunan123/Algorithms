package week5.nestedClass.staticNestedClass;

public class Driver {

    public static void main(String[] args) {
        MyMap map = new MyMap(10);
        MyMap.MyEntry entry = new MyMap.MyEntry("jack", 10); //since the inner class myEntry is static, way of deal with innerclass

//        MyMap.MyEntry entry1 = map.new MyEntry("jack", 10); // this way need to make inner class not static inner class
    }
}
