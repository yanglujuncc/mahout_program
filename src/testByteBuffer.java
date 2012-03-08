import java.nio.ByteBuffer;


public class testByteBuffer {
	public static void main(String[] argvs)
	{
		ByteBuffer bf=ByteBuffer.allocate(10);
		
		byte[] byteArrry=new byte[100];
		byteArrry[0]=1;
		byteArrry[1]=1;
		byteArrry[2]=1;
		byteArrry[3]=1;
		byteArrry[4]=2;
		byteArrry[5]=2;
		byteArrry[6]=2;
		byteArrry[7]=2;
		
		
		ByteBuffer bf2=ByteBuffer.wrap(byteArrry);
		System.out.println(bf2.position());
		System.out.println(bf2.getInt());
		System.out.println(bf2.getInt());
		System.out.println(bf2.getInt());
		bf2.position(4);
		System.out.println(bf2.getInt());
		System.out.println(bf2.isDirect());
		
		System.out.println(bf.array().length);
		System.out.println(bf.capacity());
		System.out.println(bf2.capacity());
		System.out.println(bf2.limit());
		
		bf2.limit(20);
		System.out.println("*******************");
		System.out.println(bf2.capacity());
		System.out.println(bf2.limit());
		System.out.println(bf2.position());
		System.out.println(bf2.remaining());
		/*
		 * ������ʲ���Ӱ�� current ָ��
		 */
		bf2.putInt(2, 12);
		System.out.println(bf2.capacity());
		System.out.println(bf2.limit());
		System.out.println(bf2.position());
		System.out.println(bf2.remaining());
		/*
		 * ������ʲ���Ӱ�� current ָ��
		 */
		byte[] bytes2=new byte[3];
		bf2.get(bytes2,0,3);
		System.out.println(bf2.position());
	}
}
