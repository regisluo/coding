package com.ttf.A00_review;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 在Java中，PriorityQueue 默认就是 小根堆!
 */
public class TX036_LeastMoneySplittingGold {

    private int leastMoney(int[] gold) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int leastMoney = 0;
        // put the array into the queue
        Arrays.stream(gold).boxed().forEach(g -> priorityQueue.add(g));
        int cur = 0;
        while (priorityQueue.size()>1) {
            cur = priorityQueue.poll() + priorityQueue.poll();
            leastMoney += cur;
            priorityQueue.add(cur);
        }
        return leastMoney;
    }

    public static void main(String[] args) {
        // test case
        int[] gold = {10, 20, 30};
        TX036_LeastMoneySplittingGold tx036 = new TX036_LeastMoneySplittingGold();
        System.out.println(tx036.leastMoney(gold));


        int[] gold2 = {2,1,7,3,4,2,1};
        System.out.println(tx036.leastMoney(gold2));
    }
}
