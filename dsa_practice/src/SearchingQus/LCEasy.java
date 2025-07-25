package SearchingQus;

public class LCEasy {

    public static void main(String[] args) {
//        System.out.println(squareRoot(8));

        System.out.println(firstBadVersion(10));


    }
//    278. First Bad Version

    static int firstBadVersion(int n) {
        if(n <= 1){
            return n;
        }
        int left = 1;
        int right = n;
        int mid = 0;
        while(left < right){
            mid = left + (right - left)/2;
            boolean midVer = isBadVersion(mid);
            if(midVer){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
    static boolean isBadVersion(int x){
        return x >= 3;
    }

//374. Guess Number Higher or Lower
    static int GuessTheNum(int x){
        int left = 1;
        int right = x;
        while(left <= right){
            int mid = left + (right - left )/ 2;
            int pick = guess(mid);// returns only 0, 1, -1 for match, lower, higher pick
            if(pick == 0){
                return mid;
            } else if (pick == 1) {
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }
    private static int guess(int s){
        return 1;
    }


//    LC 69
    static int squareRoot(int x ){
        if(x == 0){
            return 0;
        }
        int left = 1;
        int right = x;
        int ans = 0;

        while(left <= right){
            int mid = left + (right - left)/2;
            int sq = mid * mid;

            if (sq == x) {
                return mid; // perfect square
            } else if (sq < x) {
                ans = mid; // store as possible answer
                left = mid + 1; // look for bigger
            } else {
                right = mid - 1; // look for smaller
            }

        }

        return ans;
    }
}
