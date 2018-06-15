package kr.co.sist.chat.server;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class ChatServerDTO implements Serializable {
private List<String> list;

public List<String> getList() {
	return list;
}

public void setList(List<String> list) {
	this.list = list;
}

public ChatServerDTO(List<String> list) {
	super();
	this.list = list;
}

public ChatServerDTO() {
	super();
	// TODO Auto-generated constructor stub
}

}
