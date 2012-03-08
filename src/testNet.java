import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class testNet {
	public static void main(String[] argvs) {
		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;

		// ��������IP��ַ
		String serverIP = "127.0.0.1";
		// �������˶˿ں�
		int port = 10000;
		// ��������
		String data = "Hello";
		try {
			// ��������
			socket = new Socket(serverIP, port);
			// ��������
			os = socket.getOutputStream();
			os.write(data.getBytes());
			// ��������
			is = socket.getInputStream();
			byte[] b = new byte[1024];
			int n = is.read(b);
			// �����������
			System.out.println("������������" + new String(b, 0, n));

		} catch (Exception e) {
			e.printStackTrace(); // ��ӡ�쳣��Ϣ
		} finally {
			try {
				// �ر���������
				is.close();
				os.close();
				socket.close();
			} catch (Exception e2) {
			}
		}
	}
}
