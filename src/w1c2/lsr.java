package w1c2;
//Loop shift right
import java.util.Arrays;

public class lsr {
    static int[] array = {1,2,3,4,5};
    public static void main(String[] args) {
        array = loopShiftRight(array, 2);
        System.out.println(Arrays.toString(array));
        }

    private static int[] reverse(int[] array, int start, int end){
        int[] reversedList = new int[end - start];
        for(int i = start; i < end; i++)
            reversedList[i - start] = array[i];
        for(int i = 0; i<reversedList.length/2; i++){
            int temp = reversedList[i];
            reversedList[i] = reversedList[reversedList.length - 1 - i];
            reversedList[reversedList.length - 1 - i] = temp;
        }
        return reversedList;
    }

    private static int[] loopShiftRight(int[] array, int sp) {
        array = reverse(array, 0, array.length);
        int[] former =  reverse(array, 0, sp);
        int[] latter = reverse(array, 0, sp);
        latter = reverse(array, sp, array.length);
        System.arraycopy(former, 0 ,array, 0, former.length);
        System.arraycopy(latter, 0, array, former.length, latter.length);

        return array;
    }

}

