package CS514;

public String ReverseStringUsingRecursion(Sting s) {
    if (s.length() == 1){
        return s;
    } else {
        return ReverseStringUsingRevcursion(1, s.subString(s.length())) + s.charAt(0);
    }
}