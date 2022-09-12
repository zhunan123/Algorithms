public class Rectangle {
    /*
     * Define two public attributes width and height of type int.
     */
    // write your code here
    public int width;
    public int height;


    /*
     * Define a constructor which expects two parameters width and height here.
     */
    // write your code here
     public Rectangle(int w, int h) {
        this.width = w;
        this.height = h;
    }

    /*
     * Define a public method `getArea` which can calculate the area of the
     * rectangle and return.
     */
    // write your code here
    public int getArea(){
        return width * height;
    }

    public static void main(String[] args){
        Rectangle rec = new Rectangle(3, 4);
        rec.getArea();
    }
}
