package algrithm;

/**
 * Created by Alina on 2019/10/11.
 */
public class SaleStock {
  public static void main(String[] args) {
    int[] prices = {7,1,5,3,6,4};
    int profit = maxProfit(prices);
    System.out.println(profit);
  }

  public static int maxProfit(int[] prices) {
    int sum = 0;
    int invalue = 0;

    for (int j =0; j < prices.length-1; j++) {
      if ((invalue == 0) && (prices[j] < prices[j+1])) {
        invalue = prices[j];
      }
      if ((invalue != 0) && (prices[j] > prices[j+1])) {
        sum += prices[j] - invalue;
        invalue = 0;

      }
    }

    return sum;
  }
}
