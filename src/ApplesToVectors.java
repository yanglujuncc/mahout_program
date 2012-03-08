import java.util.List;
import java.util.ArrayList;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.SequenceFile;


import org.apache.mahout.math.VectorWritable;
import org.apache.mahout.math.DenseVector;



class ApplesToVectors{

	public	static void main(String args[]) throws Exception {
		List<DenseVector> apples = new ArrayList<DenseVector>();
		DenseVector apple;

		apple =new DenseVector(new double[] {0.11, 510, 1});
		apples.add(apple);
		apple = new DenseVector(new double[] {0.23, 650, 3});
		apples.add(apple);
		apple = new DenseVector(new double[] {0.09, 630, 1});
		apples.add(apple);
		apple = new DenseVector(new double[] {0.25, 590, 3});
		apples.add(apple);
		apple = new DenseVector(new double[] {0.18, 520, 2});

		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(conf);
		Path path = new Path("appledata/apples/");
		SequenceFile.Writer writer = new SequenceFile.Writer(fs, conf,
				path, LongWritable.class, VectorWritable.class);

		VectorWritable vec = new VectorWritable();
		int recNum=0;
		for (DenseVector vector : apples) {
			vec.set(vector);
			writer.append(new LongWritable(recNum++), vec);
		}
		writer.close();

		SequenceFile.Reader reader = new SequenceFile.Reader(fs,
				new Path("appledata/apples/"), conf);
		LongWritable key = new LongWritable();
		VectorWritable value = new VectorWritable(); 
		while (reader.next(key, value)) {
			System.out.println(key.toString() + " "
					+ value.get().asFormatString());
		}
		reader.close();


	}
}
