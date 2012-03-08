public class Math {

	public static int bytesToInt(byte[] bytes) {

		int addr = bytes[0] & 0x000000FF;
		// addr |= ((bytes[1] << 8) & 0x0000FF00);
		// addr |= ((bytes[2] << 16) & 0x00FF0000);
		// addr |= ((bytes[3] << 24) & 0xFF000000);
		addr |= (bytes[1] << 8);
		addr |= (bytes[2] << 16);
		addr |= (bytes[3] << 24);
		return addr;
		
	}

	public static byte[] intToBytes(int i) {

		byte[] bytes = new byte[4];

		// bytes[0]=(byte)(i & 0x000000FF);
		// bytes[1]=(byte)(i >> 8 & 0x000000FF);
		// bytes[2]=(byte)(i >> 16 & 0x000000FF);
		// bytes[3]=(byte)(i >> 24& 0x000000FF);

		bytes[0] = (byte) (i);
		bytes[1] = (byte) (i >> 8);
		bytes[2] = (byte) (i >> 16);
		bytes[3] = (byte) (i >> 24);

		return bytes;
	}
	/**
	 * 
	 * @param bytes 
	 * @param begin index 
	 * @param end  index
	 * @return
	 */
	public static byte[] subBytes(byte[] bytes,int begin,int end) {
		
		if(begin>end||end>=bytes.length)
		{
			return null;
		}
		
		int copy_bytes_count=end-begin+1;
		byte[] output_bytes=new byte[copy_bytes_count];
		
		for(int i=0;i<copy_bytes_count;i++)
		{
			output_bytes[i]=bytes[i+begin];
		}
		return output_bytes;
	}
}
