import java.nio.ByteBuffer;

public class testMath {
	
	public void test_subBytes() {
		byte[] bytes_temp = new byte[4];

		bytes_temp[0] = 1;
		bytes_temp[1] = 2;
		bytes_temp[2] = 3;
		bytes_temp[3] = 4;
		
		byte[] sub_bytes=Math.subBytes(bytes_temp, 1, 2);
		
		System.out.println(sub_bytes[0]);
		System.out.println(sub_bytes[1]);
		
	}
	public static void main(String [] argvs)
	{
		testMath tm=new testMath();
		ByteBuffer bf=ByteBuffer.allocate(10);
		
		tm.test_subBytes();
	}
}
