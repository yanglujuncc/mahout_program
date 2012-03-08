import java.nio.ByteBuffer;


public class packet {
	
	final public static int HEAD_SIZE=12;
	final public static int ID_CODE_OFFSET=0;
	final public static int PACKETSIZE_OFFSET=4;
	final public static int VAL_COUNT_OFFSET=8;
	
	final public static int VAL_LENGTH_SIZE=4;
	
	ByteBuffer packetHead=ByteBuffer.allocate(HEAD_SIZE);
	ByteBuffer packetContent=null;
	
	int packetContent_room_size=0;
	int packetContent_data_size=0;
	
	int curVarOffset=0;
	int curVarSize=0;
	
	public int getIDCode(){
		
		return packetHead.getInt(ID_CODE_OFFSET);
	}
	public int getValCount(){
		
		return packetHead.getInt(VAL_COUNT_OFFSET);
	}
	public int getPacketSize(){
	
		return packetHead.getInt(PACKETSIZE_OFFSET);
	}
	public int getHeadSize(){
		return HEAD_SIZE;
	
	}
	
	
	
	
	public int getCoententSize(){
		return getPacketSize()-getHeadSize();
	}
	/**
	 * 
	 * @return
	 */
	
	private void readCurValSize(){
		
		if(packetContent==null)
		{
			curVarSize=0; 
		}
		curVarSize=packetContent.getInt(curVarOffset);
		if(curVarSize<0)
		{
			
		}
	}
	
	/**
	 * 
	 */
	
	public int getNextValOffset()
	{
		if(curVarOffset==0&&curVarSize==0)
			return 0;
		else{
			return VAL_LENGTH_SIZE+curVarOffset+curVarSize;
		}
		
	}
	
	
	public byte[] getNextVal()
	{
		byte[] bytes=null;
	
		//check 	
		if(packetContent==null)
			return null;
		
		if(VAL_LENGTH_SIZE>packetContent.remaining())
		{
			return null;
		}	
		int nextValSize=packetContent.getInt();		
		bytes=new byte[nextValSize];
	
		if(nextValSize>packetContent.remaining())
		{
			return null;
		}
		
		packetContent.get(bytes, 0, nextValSize);
		
		return bytes;
		
	}
	
	/**
	 * get N-th variable,begin at 1,
	 * if the N-th variable not existence then return null
	 *  
	 */
	
	public byte[] getNthVal(int N)
	{
		if(packetContent==null)
			return null;
		
		packetContent.position(0);
		byte[] bytes=null;
		for(int i=0;i<N;i++)
		{
			bytes=getNextVal();
			if(bytes==null)
				return null;
		}
		
		packetContent.position(0);
		return bytes;
	}
	
}
