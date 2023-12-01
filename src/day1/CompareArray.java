package day1;

public class CompareArray {
    public static void main(String[] args) {
        int[] com = {1,3,8,3};
        int[] printArray = new int[4];
        int position = 0;
        for(int i = 0;i < com.length-1; i++) {
            for (int j = i + 1; j < com.length; j++) {
                if (com[i] < com[j]) {
                    printArray[i] = printArray[i] +1;
                }
                if(com[i] > com[j]){
                    printArray[j] = printArray[j] +1;
                }
            }
        }
        for(int i : printArray) {
            System.out.println(i);
        }
    }
}
