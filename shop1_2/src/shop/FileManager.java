package shop;

import java.io.File;

public class FileManager {
	ItemManager im=new ItemManager();
	UserManager um=new UserManager();
	String fileName="shopData.txt";
	File file=new File(fileName);
	
	void save() {
		String data="";
		data+=um.user.size()+"\n";
		for(int n=0; n<um.user.size(); n++) {
			data+=um.user.get(n).id;
			data+="/";
			data+=um.user.get(n).money;
			data+="\n";
		}
		data+=im.
		
	}
	void load() {
		
	}
}
