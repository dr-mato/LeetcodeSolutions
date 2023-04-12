import java.util.ArrayList;
import java.util.List;

class Solution extends ListNode{
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i <= nums.length; i++) {
            for (int k = 0; k <= nums.length; k++) {
                if (nums[i] + nums[k] == target && i != k) {
                    return new int[]{i, k};
                }
            }
        }
        return new int[]{};
    }
    public static boolean isValid(String s) {
        List<Character> list = new ArrayList<Character>();
        if(s.charAt(0)=='}' || s.charAt(0)==']' || s.charAt(0)==')'){
            return false;
        }
        for(int i=0; i<(s.length()); i++){
            if (s.charAt(i)=='{' || s.charAt(i)=='(' || s.charAt(i)=='['){
                list.add(s.charAt(i));
                System.out.println(s.charAt(i));
            }
            else if (!list.isEmpty() && ((s.charAt(i)=='}' && list.get(list.size()-1).charValue()=='{') || (s.charAt(i)==']' && list.get(list.size()-1).charValue()=='[') || (s.charAt(i)==')' && list.get(list.size()-1).charValue()=='('))){
                list.remove(list.size()-1);
                System.out.println(list.get(list.size()-1));
            }
            else{
                return false;
            }
        }
        return list.isEmpty();
    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2){
        ListNode reList= new ListNode();
        if(list1==null) {
            reList=list2;
            return reList;
        }
        if(list2==null) {
            reList=list1;
            return reList;
        }
        if(list1.val>list2.val){
            reList.val=list2.val;
            reList.next=mergeTwoLists(list1, list2.next);
        }
        else{
            reList.val=list1.val;
            reList.next=mergeTwoLists(list1.next, list2);
        }
        return reList;
    }

    public static int searchInsert(int[] nums, int target) {
        int low=0;
        int high=nums.length;
        while(high>low){
            int middle=low+(high+low)/2;
            if(nums[middle]<target){
                low=middle+1;
            }
            else{
                high=middle;
            }
        }
        return high;
    }
    
    public static int maxSubArrayUnfinished(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int neededSum=nums[0];
        while(high!=low && (helpSum(nums, low, high)<helpSum(nums, (low+high)/2+1, high) || helpSum(nums, low, high) <helpSum(nums, low, (low+high)/2))){
            if(helpSum(nums,(low+high)/2+1, high)>helpSum(nums, low, (low+high)/2)){
                neededSum=helpSum(nums,(low+high)/2+1, high);
                low=(low+high)/2+1;
            }
            else if (helpSum(nums,(low+high)/2+1, high)<helpSum(nums, low, (low+high)/2)){
                neededSum=helpSum(nums, low, (low+high)/2);
                high=(low+high)/2;
            }
        }
        if(low==0 && high==nums.length-1){
            return helpSum(nums, low, high);
        }
        int reSum=neededSum;
        for(int i=low-1; i>=0; i--){
            reSum+=nums[i];
            if(reSum>neededSum){
                neededSum=reSum;
            }
        }
        int rereSum=neededSum;
        for(int i=high+1; i<=nums.length-1; i++){
            rereSum+=nums[i];
            if(rereSum>neededSum){
                neededSum=rereSum;
            }
        }
        return neededSum;
    }
    public static int helpSum (int[] arr, int start, int end){
        int sum=0;
        for(int i=start; i<=end; i++){
            sum+=arr[i];
        }
        return sum;
    }

    public static int maxSubArray(int[] nums){
        int size = nums.length;
        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0;

        for (int i = 0; i < size; i++) {
            max_ending_here += nums[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }

    public static int climbStairs(int n) {
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }

    public static int climbStairsShitVersion(int n) {
        int first=0;
        int second=1;
        int third=1;
        for(int i=1; i<=n; i++){
            third=first+second;
            first=second;
            second=third;
        }
        return third;
    }

    List<Integer> lst= new ArrayList<>();
    public  void traversal(TreeNode node){
        if(node!=null){
            traversal(node.left);
            lst.add(node.val);
            traversal(node.right);
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
         traversal(root);
         return lst;
    }

    public int maxProfit(int[] prices) {
        int min=prices[0];
        int profit=0;
        for(int price: prices){
            if((price-min)>profit){
                profit=(price-min);
            } else if(price<min){
                min=price;
            }
        }
        return profit;
    }

    public static boolean isSymmetric(TreeNode root) {
        return ishelper(root.left,root.right);
    }
    public static boolean ishelper(TreeNode left, TreeNode right){
        if(left==null && right==null) return true;
        else if(left==null||right==null||left.val!=right.val) return false;
        return ishelper(left.left, right.right) && ishelper(left.right, right.left);
    }

    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        if(root.left!=null && root.right==null) return 1+maxDepth(root.left);
        else if(root.right!=null && root.left==null) return 1+maxDepth(root.right);
        else return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }

    public int singleNumber(int[] nums) {
        List<Integer> lst=new ArrayList<>();
        lst.add(nums[0]);
        for(int i=1; i<nums.length; i++){
            if (lst.contains(Integer.valueOf(nums[i]))) lst.remove(Integer.valueOf(nums[i]));
            else lst.add(nums[i]);
        }
        return lst.get(0);
    }

            public boolean hasCycle(ListNode1 head) {
                ListNode1 slow = head, fast = head;
                while (fast != null && fast.next != null) {
                    slow = slow.next;
                    fast = fast.next.next;
                    if (slow == fast)
                        return true;
                }
                return false;
            }



    public static void main(String[] args) {

    }
}
