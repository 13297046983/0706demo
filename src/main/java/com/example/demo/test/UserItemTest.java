package com.example.demo.test;

import com.example.demo.recommender.UserItem;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;

import java.util.List;

public class UserItemTest {
    public static void main(String[] args) {
        UserItem userItem=new UserItem();
        List<RecommendedItem> recommendedItems = userItem.userRecommender(1, 5);
        for (RecommendedItem recommendation : recommendedItems) {
            // 输出推荐结果
            System.out.println("推荐的结果"+recommendation);
        }

    }
}
