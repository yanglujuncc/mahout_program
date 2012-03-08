import org.apache.mahout.cf.taste.impl.model.file.*;
import org.apache.mahout.cf.taste.impl.recommender.slopeone.SlopeOneRecommender;
import org.apache.mahout.cf.taste.model.*;
import org.apache.mahout.cf.taste.recommender.*;
import java.io.*;
import java.util.*;

class Recommender_SlopeOne{

	public static void main(String[] args) throws Exception {
	

		if(args.length!=3)
		{
			System.out.println("input(3): rating_file  userId  recommend_n");
			
			return ;	
		}
		System.out.println("args.length="+args.length);
			
		DataModel model = new FileDataModel(new File(args[0]));
		Recommender recommender = new SlopeOneRecommender(model);	
		

		int userId=Integer.parseInt(args[1]);
		int recommend_n=Integer.parseInt(args[2]);
		System.out.println("user_id="+userId+"   "+"recommend_n="+recommend_n);
		
	
		List<RecommendedItem> recommendations =recommender.recommend(userId, recommend_n); 

		
		System.out.println("output: recommend_n = "+recommendations.size());

		for (RecommendedItem recommendation : recommendations) {
			System.out.println(recommendation);
		}
	}
}
