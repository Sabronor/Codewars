package Kata.Six;

public class EqualSides {
    public static int findEvenIndex(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            if(compareSidesFrom(arr, i)) return i;
        }
        return -1;
    }

    private static boolean compareSidesFrom(int[] arr, int index){
        int firstSide = 0, secondSide = 0;

        for(int i = index - 1; i >= 0; i--){
            firstSide += arr[i];
        }

        for(int i = index += 1; i < arr.length; i++){
            secondSide += arr[i];
        }

        return firstSide == secondSide;
    }
}
