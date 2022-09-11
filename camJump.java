public class camJump {

    public boolean canJump(int[] a){
        //2 2 0 1 4
        //2 1 0 1 4
        int length = a.length;
        int rightMostPlace = 0;
        for(int i = 0;i<length;i++){
            if(i <= rightMostPlace){
                rightMostPlace = Math.max(rightMostPlace, i + a[i]);
                if(rightMostPlace >= length -1){
                    return true;
                }
            }else {
                return false;
            }
        }
        return false;
    }
}
