public class GradeLevel {
    /**
     * Declare two public attributes name(string) and score(int).
     */
    String name;
    int score;

    /**
     * Declare a constructor expect a name as a parameter.
     */
    public GradeLevel(String name) {
        this.name = name;
    }

    /**
     * Declare a public method `getLevel` to get the level(char) of this student.
     */
    public char getLevel() {
        if(this.score >= 90){
            return 'A';
        } else if (this.score < 90 && this.score >= 80){
            return 'B';
        } else if (this.score < 80 && this.score >= 60) {
            return 'C';
        } else {
            return 'D';
        }
    }
}
