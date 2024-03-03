package w1c2;

public class lsr2 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int shiftAmount = 2; // 要右移的位置数

        System.out.println("原始数组:");
        printArray(array);

        rotateRight(array, shiftAmount);

        System.out.println("\n右移后的数组:");
        printArray(array);
    }

    // 数组循环右移函数
    public static void rotateRight(int[] arr, int shiftAmount) {
        int length = arr.length;
        // 处理负数的情况
        shiftAmount = shiftAmount % length;
        if (shiftAmount < 0)
            shiftAmount = length + shiftAmount;

        int[] temp = new int[length];

        // 将数组右移shiftAmount个位置
        for (int i = 0; i < length; i++) {
            temp[(i + shiftAmount) % length] = arr[i];
        }

        // 将临时数组中的值复制回原数组
        for (int i = 0; i < length; i++) {
            arr[i] = temp[i];
        }
    }

    // 打印数组函数
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
