package DSA.DynamicProgramming.ShoppingOffers;

import java.util.ArrayList;
import java.util.List;

/*
 * In LeetCode Store, there are some kinds of items to sell. Each item has a price.

However, there are some special offers, and a special offer consists of one or more different kinds of items with a sale price.

You are given the each item's price, a set of special offers, and the number we need to buy for each item. The job is to output the lowest price you have to pay for exactly certain items as given, where you could make optimal use of the special offers.

Each special offer is represented in the form of an array, the last number represents the price you need to pay for this special offer, other numbers represents how many specific items you could get if you buy this offer.

You could use any of special offers as many times as you want.

Example 1:

Input: [2,5], [[3,0,5],[1,2,10]], [3,2]
Output: 14
Explanation: 
There are two kinds of items, A and B. Their prices are $2 and $5 respectively. 
In special offer 1, you can pay $5 for 3A and 0B
In special offer 2, you can pay $10 for 1A and 2B. 
You need to buy 3A and 2B, so you may pay $10 for 1A and 2B (special offer #2), and $4 for 2A.
 

Example 2:

Input: [2,3,4], [[1,1,0,4],[2,2,1,9]], [1,2,1]
Output: 11
Explanation: 
The price of A is $2, and $3 for B, $4 for C. 
You may pay $4 for 1A and 1B, and $9 for 2A ,2B and 1C. 
You need to buy 1A ,2B and 1C, so you may pay $4 for 1A and 1B (special offer #1), and $3 for 1B, $4 for 1C. 
You cannot add more items, though only $9 for 2A ,2B and 1C.
 

Note:

There are at most 6 kinds of items, 100 special offers.
For each item, you need to buy at most 6 of them.
You are not allowed to buy more items than you want, even if that would lower the overall price.


DP: for the subproblem, the result of it is the state
那么我们可以先求出不使用任何商品需要花的钱数作为结果res的初始值，然后我们遍历每一个coupon，
定义一个变量isValid表示当前coupon可以使用，然后遍历每一个商品，如果某个商品需要的个数小于coupon中提供的个数
，说明当前coupon不可用，isValid标记为false。如果遍历完了发现isValid还为true的话，表明该coupon可用，
我们可以更新结果res，对剩余的needs调用递归并且加上使用该coupon需要付的钱数。最后别忘了恢复needs的状态

基本的思路就是采用DFS的递归算法，尝试用总需求减去 special 的供应量，如果新的需求不为负，深度优先递归，之后再加回减去的量。最后，需要对剩余需求量(没有匹配到合适的special)计算按单件采购的总金额，取较小的数返回。

 */
public class Solution {
    public int shoppingOffers(List<Integer> price,
            List<List<Integer>> special,
            List<Integer> needs) {
        return shopping(price, special, needs);
    }

    public int shopping(List<Integer> price,
            List<List<Integer>> special,
            List<Integer> needs) {
        int j = 0, res = dot(needs, price);
        for (List<Integer> s : special) {
            ArrayList<Integer> clone = new ArrayList<>(
                    needs);
            for (j = 0; j < needs.size(); j++) {
                int diff = clone.get(j) - s.get(j);
                if (diff < 0)
                    break;
                clone.set(j, diff);
            }
            if (j == needs.size())
                res = Math.min(res, s.get(j)
                        + shopping(price, special, clone));
        }
        return res;
    }

    // 求出不用coupon的钱
    public int dot(List<Integer> a, List<Integer> b) {
        int sum = 0;
        for (int i = 0; i < a.size(); i++) {
            sum += a.get(i) * b.get(i);
        }
        return sum;
    }

}