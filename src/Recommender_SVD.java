import org.apache.mahout.cf.taste.impl.model.file.*;
import org.apache.mahout.cf.taste.model.*;
import org.apache.mahout.cf.taste.recommender.*;
import org.apache.mahout.cf.taste.impl.recommender.svd.Factorizer;
import org.apache.mahout.cf.taste.impl.recommender.svd.SVDRecommender;
import org.apache.mahout.cf.taste.impl.recommender.svd.ALSWRFactorizer;

import java.io.*;
import java.util.*;

class Recommender_SVD{

	public static void main(String[] args) throws Exception {
	

		if(args.length!=3)
		{
			System.out.println("input(3): rating_file  userId  recommend_n");
			
			return ;	
		}
		System.out.println("args.length="+args.length);
			
		DataModel model = new FileDataModel(new File(args[0]));
		
		Factorizer factorizer = new ALSWRFactorizer(model,10,1.0,10);
		Recommender recommender = new SVDRecommender(model,factorizer);

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
