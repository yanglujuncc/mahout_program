import java.io.File;
import java.util.List;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.UncenteredCosineSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;


public class Recommender_ItemBased {
	
	public static void main(String[] args) throws Exception {

		long time_call_cost = 0;
		long bulid_model_cost = 0;
		long make_recommendtion_cost = 0;
		
		String file_str="E:\\DataSet\\testDataSet\\100K\\100K.base";
		System.out.println("***** juts test time function cost   ********");
	
		
		long lastTime = System.currentTimeMillis();
		long curTime=System.currentTimeMillis();
		time_call_cost=curTime-lastTime;
		
		System.out.println(curTime);
		System.out.println(lastTime);
		System.out.println("cost=" + time_call_cost + "'ms");

		System.out.println("***** test time function end  ********\n");

		System.currentTimeMillis();
	
		
		System.out.println("args.length=" + args.length);
		int userId = Integer.parseInt("1");

		int recommend_n = Integer.parseInt("10");
		
		
		
		userId=1;
		recommend_n=10;
		
		DataModel model = new FileDataModel(new File(file_str));	
		ItemSimilarity similarity = new UncenteredCosineSimilarity(model);
		
	
		
		System.out.println("***** bulid model *******");
		
		lastTime = System.currentTimeMillis();
		
		Recommender recommender = new GenericItemBasedRecommender(model, similarity);
		
		
		curTime=System.currentTimeMillis();
		
		
		// int YY = Cld.get(Calendar.YEAR) ;
		// int MM = Cld.get(Calendar.MONTH)+1;
		// int DD = Cld.get(Calendar.DATE);

	

		System.out.println(curTime);
		System.out.println(lastTime);
		bulid_model_cost=curTime-lastTime;
		
		System.out.println("cost=" + bulid_model_cost + "'ms");

		System.out.println("***** bulid model  end*******\n");
		
		
		System.out.println("***** make  recommand  *******");
	
		System.out.println("user_id=" + userId + "   " + "recommend_n="
				+ recommend_n);

		lastTime = System.currentTimeMillis();
		List<RecommendedItem> recommendations = recommender.recommend(userId,
				recommend_n);
		curTime=System.currentTimeMillis();

		// int YY = Cld.get(Calendar.YEAR) ;
		// int MM = Cld.get(Calendar.MONTH)+1;
		// int DD = Cld.get(Calendar.DATE);
		
		make_recommendtion_cost=curTime-lastTime;
		System.out.println("cost="
				+ make_recommendtion_cost + "'ms");

		System.out.println("output: recommendations.size = " + recommendations.size());

		for (RecommendedItem recommendation : recommendations) {
			System.out.println(recommendation);
		}
		System.out.println("***** make  recommand  end*******");
		
		System.out.println("***** cost list *******");
		System.out.println("users=" +model.getNumUsers());
		System.out.println("items=" +model.getNumItems());
	
		System.out.println("time_call_cost=" + time_call_cost + "'ms");
		System.out.println("bulid_model_cost="
				+ bulid_model_cost + "'ms");

		System.out.println("make_recommendtion_cost="
				+ make_recommendtion_cost + "'ms");

	}
}
