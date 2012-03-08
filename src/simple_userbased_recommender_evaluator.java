import java.io.File;

import org.apache.mahout.common.RandomUtils;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;

import org.apache.mahout.cf.taste.impl.eval.AverageAbsoluteDifferenceRecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;

import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;

import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;



class simple_userbased_recommender_evaluator {

	public static void main(String[] args)throws Exception
	{
		
		if(args.length!=3)
		{
			System.out.println("input(3): rating_file  userId  recommend_n");
			
			return ;	
		}
		
		System.out.println("args.length="+args.length);
			
		DataModel model = new FileDataModel(new File(args[0]));
		
		RandomUtils.useTestSeed(); 

		
	
		RecommenderEvaluator evaluator =new AverageAbsoluteDifferenceRecommenderEvaluator();
		RecommenderBuilder builder = new RecommenderBuilder() { 
			@Override
				public Recommender buildRecommender(DataModel model)
				
				throws TasteException {
					UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
					UserNeighborhood neighborhood = new NearestNUserNeighborhood(2, similarity, model);
					return new GenericUserBasedRecommender(model, neighborhood, similarity);
				}
		};
		double score = evaluator.evaluate(builder, null, model, 0.7, 1.0);
		System.out.println(score);
	}
}
