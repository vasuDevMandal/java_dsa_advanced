package leetcodeProblems;

public class Q268_Missing_Number {


    public static void main(String[] args) {
        int[] arr = {0,3,4,5,1,6};
        int result = missingNumber(arr);
        System.out.println(result);
    }
    static int missingNumber(int[] arr) {
        cyclicSort(arr);
        int i=0;
        while(i < arr.length){
            if(arr[i] != i){
                return i;
            }
            i++;
        }
        return arr.length;
    }

    static void cyclicSort(int[] arr){
        int i = 0;
        while (i < arr.length){
            int correct = arr[i];
            if( arr[i]  < arr.length && arr[i] != arr[correct] ){
                swap(arr, i, correct);
            }else{
                i++;
            }
        }
    }

    static void swap(int[] arr,int  first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
