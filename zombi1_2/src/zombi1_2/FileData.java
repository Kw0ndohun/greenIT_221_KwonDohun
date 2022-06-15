package zombi1_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileData {
	static FileData fd=new FileData();
	File file=new File("zomgame.txt");
	
	//int h, String n, int p,int po
	public void save(String d){
		String data=d;
		try {
			FileWriter fw=new FileWriter(file);
			System.out.println("세이브완료");
			fw.write(data);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(data);
	}
	public void load() {
		String data="";
		boolean run=true;
		int cnt=1;
		try {
			FileReader fr=new FileReader(file);
			BufferedReader br=new BufferedReader(fr);
			Game.zomList.clear();
			Game.bossList.clear();
			data=br.readLine();
			Game.pos=Integer.parseInt(data);
			data=br.readLine();
			String[] temp=data.split("/");
			Game.hero.setHp(Integer.parseInt(temp[0]));
			Game.hero.setName(temp[1]);
			Game.hero.setPos(Integer.parseInt(temp[2]));
			Game.hero.setPower(Integer.parseInt(temp[3]));
			data=br.readLine();
			while(data!=null) {
				if(data.equals("boss")) {
					run=false;
					cnt=0;
				}
				if(run) {
					temp=data.split("/");
					int hp=Integer.parseInt(temp[0]);
					String name=temp[1];
					int pos=Integer.parseInt(temp[2]);
					int power=Integer.parseInt(temp[3]);
					Game.zomList.add(new Zombi(hp,name,pos,power));
					cnt++;
				}
				else {
					if(!data.equals("boss")) {
						temp=data.split("/");
						temp=data.split("/");
						int hp=Integer.parseInt(temp[0]);
						String name=temp[1];
						int pos=Integer.parseInt(temp[2]);
						int shield=Integer.parseInt(temp[3]);
						int power=Integer.parseInt(temp[4]);
						
						Game.bossList.add(new Boss(hp,name,pos,shield,power));
					}
				}
				
				data=br.readLine();
			}
			System.out.println("로드완료.");
			fr.close();
			br.close();
		} catch (Exception e) {
			System.out.println("로드실패");
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}
