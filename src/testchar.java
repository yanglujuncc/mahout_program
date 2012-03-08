import org.apache.hadoop.io.file.tfile.ByteArray;


public class testchar {
	

	public static void main(String [] argvs)
	{
		byte[] bytes=new byte[10];
	
		byte[] bytes_temp=new byte[4];
		
		bytes_temp[0]=1;
		bytes_temp[1]=2;
		bytes_temp[2]=3;
		bytes_temp[3]=4;
		
		System.out.println(bytes_temp.length);
		System.out.println(Math.bytesToInt(bytes_temp));
		
		//System.out.println(Integer.toBinaryString(8));
		
	}

}
