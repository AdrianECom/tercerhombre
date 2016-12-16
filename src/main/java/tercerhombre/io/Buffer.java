package tercerhombre.io;

public class Buffer {
	private StringBuffer buffer;
	
	public Buffer() {
		buffer = new StringBuffer("");
	}
	
	public Buffer append(String str){
		buffer.append(str+"\n");
		return this;
	}
	
	@Override
	public String toString() {
		return buffer.toString();
	}
}
