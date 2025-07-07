package leetcodeProblems;

public class Q744_Find_Smallest_Letter_Greater_Than_Target {

    public static void main(String[] args) {

        char[] charArr = {'c','f', 'j'};
        System.out.println(search(charArr,'c'));
        System.out.println(nextGreatestLetter(charArr,'c'));
    }

    static char search(char[] arr, char target){
        int start = 0;
        int end = arr.length - 1;
        while (start <= end){
           int mid = start + (end - start) /2;

            if(  arr[mid] > target){
               end = mid - 1;
            } else{
                start = mid + 1;
            }
        }
        return arr[start % arr.length];
    }
static char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length-1;
        while(left<=right){
            int mid = left +(right-left)/2;
            if(letters[mid]>target){
                right=mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return letters[left%letters.length];
    }
}
