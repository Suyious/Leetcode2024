public class Main {

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int min = Integer.MAX_VALUE;
        for(int price: prices) {
            if(price < min) {
                min = price;
            } else {
                int nprofit = price - min;
                if(nprofit > profit) profit = nprofit;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
       System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
       System.out.println(maxProfit(new int[]{7,6,4,3,1}));
       System.out.println(maxProfit(new int[]{1}));
       System.out.println(maxProfit(new int[]{1,5,7,2,10}));
       System.out.println(maxProfit(new int[]{10,4,12,15,6,7}));
    }
}
