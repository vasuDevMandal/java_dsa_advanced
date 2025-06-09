package arraysQus;

class Q27_Remove_Element {
    static int removeElement(int[] nums, int val) {
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
    public static void main(String[] args) {

        int[] nums = {4, 5, 6, 8, 9,5};

        int val = removeElement(nums, 5);

        System.out.println(val);
    }

}
