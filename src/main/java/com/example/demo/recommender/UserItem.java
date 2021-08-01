package com.example.demo.recommender;

import com.example.demo.utils.MyDataModel;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.CachingRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import java.util.List;

/**
 * @author Admin
 */
public class UserItem {
     /**
       * @Author: Pig_pi
       * @Description:
       * @DateTime: 2021/7/23 14:24
       * @Params: userId;size
       * @Return: List<RecommendedItem>
       */
    public List<RecommendedItem>userRecommender(long userId,int size){
        List<RecommendedItem>userListRem=null;
        //1.构建数据模型 连接数据库
        DataModel dataModel = MyDataModel.myDataModel();

        try {
            //2.计算相似度
            UserSimilarity userSimilarity=new PearsonCorrelationSimilarity(dataModel);
            //3.查找用户近邻，贴近用户喜好最相近的3个
            UserNeighborhood userNeighborhood=new NearestNUserNeighborhood(3, userSimilarity, dataModel);
            //4.构建推荐引擎  数据存储到缓存引擎
            Recommender recommender=new CachingRecommender(new GenericUserBasedRecommender(dataModel,userNeighborhood,userSimilarity));
            //得到推荐结果,userId用户id,size为推荐的数目    让用户id为1的推荐5条电影信息
            userListRem=recommender.recommend(userId,size);
        } catch (TasteException e) {
            e.printStackTrace();
        }
          return userListRem;
    }
}
