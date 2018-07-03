package wasExam;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WasMain {

	public static void main(String[] args) {
		try(ServerSocket listener = new ServerSocket(8888);){
			System.out.println("client를 기다림");
			Socket client = listener.accept();
			System.out.println(client);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		/*ServerSocket listener = null;
		try {
			listener = new ServerSocket(8888);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				listener.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}*/
		
	}

}
