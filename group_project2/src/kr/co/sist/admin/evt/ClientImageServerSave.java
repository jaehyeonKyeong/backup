package kr.co.sist.admin.evt;

import java.net.ServerSocket;

public class ClientImageServerSave {
	FileServer fileServer;

	public ClientImageServerSave(FileServer fileServer) {
		this.fileServer=fileServer;
		ServerSocket ss=fileServer.getServer();
		
	}
	
	
}
