public class maxProfit {

    public static int MaxProfit(int [] prices){

        int minPrice = Integer.MAX_VALUE;
        int maxProfit=0;

        for(int price:prices){

            if(price<minPrice)
                minPrice=price;
            else if (price-minPrice>maxProfit)
                maxProfit=price-minPrice;
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        //Best Time to Buy/Sell Stock
        //Track min price + profit
       /* Input:
        prices = [7,1,5,3,6,4]
        Output:
        5

        Explanation:
        Buy on day 2 (price=1), sell on day 5 (price=6), profit = 6 - 1 = 5.*/
        int [] prices={7,1,5,3,6,4};

        System.out.print(MaxProfit(prices));
    }
}
