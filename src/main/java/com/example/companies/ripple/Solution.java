package com.example.companies.ripple;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


// Pad for Shailesh Munot - Senior Software Engineer, Orchestration

// XRP Quote

// In this exercise, we will be writing a quote function for purchasing XRP with USD.
// A limit order has two components –  a limit price in USD and a quantity to sell in XRP.   Given list of these sell orders, create a function that calculates the amount of XRP you can purchase with a given amount of USD.


// Function Signature
// double calculateXrpQuote(LimitOrders[] orders, double usdAmount);


// Input
// sellOrders = [
// LimitOrder(0.25, 10.00), // (unit price, quantity),
// LimitOrder(0.75, 5.00),
// LimitOrder(0.50, 20.00),
// ];
// calculateXrpQuote(sellOrders, 1.25);  // 5.0



// Input
// sellOrders = [
// LimitOrder(0.25, 4.00), // (unit price, quantity),
// LimitOrder(0.50, 20.00),
// LimitOrder(0.75, 5.00)
// ];

// 0.25*10 = 2.50

// 1.25/0.25 = 5

// Note the Following Requirements:
// The function should raise an error or an exception if there is insufficient XRP for sale for the USD amount provided.
// The function should not accept zero or negative amounts.
// You may purchase all or a portion of the XRP for sale in a given order.
// You must purchase all of the XRP for a given order before moving on to the next.

public class Solution {
    static class LimitOrders{
        double value;
        double unit;
        public LimitOrders(double value, double unit){
            this.value = value;
            this.unit = unit;
        }
        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }

        public double getUnit() {
            return unit;
        }

        public void setUnit(double unit) {
            this.unit = unit;
        }
    }

    double calculateXrpQuote(LimitOrders[] orders, double usdAmount) throws Exception {
        if(null == orders && orders.length == 0)
            throw new Exception("amount should non-zero");


        List<LimitOrders> sortedOrder = Arrays.stream(orders).sorted((o1,o2) -> Double.compare(o1.getValue(),o2.getValue())).collect(Collectors.toList());

        double sellOrder = 0.0;
        double result = 0.0;
        for(LimitOrders lo:sortedOrder){
            sellOrder = (usdAmount/lo.value)>lo.unit?lo.unit:(usdAmount/lo.value);
            usdAmount -= sellOrder*lo.value;
            result = result + sellOrder;
            if(usdAmount<=0){
                break;
            }
        }
        if(usdAmount>0){
            throw new Exception("insufficient XRP for sale for the USD amount provided");
        }
        return result;
}

    public static void main(String[] args) throws Exception {
        Solution test = new Solution();
//         LimitOrders[] sellOrders = {new LimitOrders(0.25, 10.00), new LimitOrders(0.75, 5.00), new LimitOrders(0.50, 20.00)};
        LimitOrders[] sellOrders = {new LimitOrders(0.25, 10.00), new LimitOrders(0.75, 5.00), new LimitOrders(0.50, 20.00)};
        System.out.println(test.calculateXrpQuote(sellOrders,1.25));
        System.out.println(test.calculateXrpQuote(sellOrders,3.25));
//        System.out.println(test.calculateXrpQuote(sellOrders,0.00));
        System.out.println(test.calculateXrpQuote(sellOrders,20.00));
    }
}
