package rpg;

import java.util.ArrayList;

public class Guild {
	public static Guild gl=new Guild();
	private ArrayList<Unit> guildList=new ArrayList<Unit>();
	private Unit partyList[]=new Unit[4];
	public ArrayList<Unit> getGuildList() {
		return guildList;
	}
	public void setGuildList(ArrayList<Unit> guildList) {
		this.guildList = guildList;
	}
	public Unit[] getPartyList() {
		return partyList;
	}
	public void setPartyList(Unit[] partyList) {
		this.partyList = partyList;
	}
	//길드생성자
	public Guild() {
		setGuild();
		setParty();
	}
	//길드세팅
	public void setGuild() {
		for(int n=0; n<7; n++) {
			String name="";
			String n1[]= {"김","강","주","권","박","진"}; 
			String n2[]= {"한","수","민","도","미","금"}; 
			String n3[]= {"지","문","시","훈","진","명"};
			name+=n1[Game.ran.nextInt(n1.length)];
			name+=n2[Game.ran.nextInt(n2.length)];
			name+=n3[Game.ran.nextInt(n3.length)];
			int hp=3+Game.ran.nextInt(8);
			int att=1+Game.ran.nextInt(5);
			int def=(1+Game.ran.nextInt(5))/2;
			//랜덤유닛 생성
			guildList.add(new Unit(name,1,hp,att,def,0));
		}
	}
	
	public void setParty() {
		for(int n=0; n<4; n++) {
			guildList.get(n).setParty(true);
		}
		int n=0;
		for(Unit u:guildList) {
			if(u.isParty()) {
				partyList[n]=u;
			}
			n++;
		}
	}
	
	public void guildMenu() {
		while(true) {
			System.out.println("=========== [길드메뉴] ============");
			System.out.print("[1.길드목록][2.길드원추가][3.길드원제거][4.파티원교체][5.파티원레벨업][6.뒤로가기]");
			int sel=Game.scan.nextInt();
			if(sel==1) {
				printAllGuild();
			}
			else if(sel==2) {
				buyUnit();
			}
			else if(sel==3) {
				delUnit();
			}
			else if(sel==4) {
				changeParty();
			}
			else if(sel==5) {
				levelUp();
			}
			else {
				break;
			}
		}
	}
	
	//유닛구매
	public void buyUnit() {
		//플레이어 소지금이 유닛가격 이상일때만 구입가능
		if(Player.pl.getMoney()>=5000) {
			String name="";
			String n1[]= {"김","강","주","권","박","진"}; 
			String n2[]= {"한","수","민","도","미","금"}; 
			String n3[]= {"지","문","시","훈","진","명"};
			name+=n1[Game.ran.nextInt(n1.length)];
			name+=n2[Game.ran.nextInt(n2.length)];
			name+=n3[Game.ran.nextInt(n3.length)];
			int hp=3+Game.ran.nextInt(8);
			int att=1+Game.ran.nextInt(5);
			int def=(1+Game.ran.nextInt(5))/2;
			//랜덤유닛 생성
			guildList.add(new Unit(name,1,hp,att,def,0));
		}
		else {
			System.out.println("소지금 부족.");
		}
	}
	
	//길드원 전원 출력
	public void printAllGuild() {
		for(int n=0; n<guildList.size(); n++) {
			System.out.print("["+(n+1)+"]");
			guildList.get(n).printUnit();
		}
	}
	//길드원삭제
	public void delUnit() {
		printAllGuild();
		System.out.println("삭제할 유닛:");
		int selUnit=Game.scan.nextInt()-1;
		guildList.remove(selUnit);
	}
	//파티원 출력
	public void printParty() {
		System.out.println("==========유닛=========");
		for(int n=0; n<partyList.length; n++) {
			//파티리스트에 번호매겨줌
			System.out.print("["+(n+1)+"]");
			//파티리스트의 해당 유닛의 프린트매소드를 이용해서 출력
			partyList[n].printUnit();
		}
	}
	
	//파티원교체
	public void changeParty() {
		//프린트 모든 파티원
		printParty();
		System.out.println("교체할 파티원을 선택해주세요:");
		int selUnit=Game.scan.nextInt()-1;
		if(selUnit>-1&&selUnit<partyList.length) {
			//프린트 모든 길드원
			printAllGuild();
			System.out.println("참가할 길드원을 선택해주세요:");
			int selGuildMember=Game.scan.nextInt()-1;
			
			
			//참가할 길드원을 선택해 해당 길드원의 길드리스트 주소를 가져와서 파티리스트에 넣어줌. /어차피 둘은
			// 스텟 등의 해당 유닛의 정보 변경을 똑같이 공유해야함.
//			partyList[selUnit]=guildList.get(selGuildMember);
			//하지만 파티원 
			
			//바꿀 파티원의 파티여부를 퍼스로 바꾸어 파티를 해제시키고
			partyList[selUnit].setParty(false);
			//참가시킬 길드원의 파티여부를 트루로 바꾸어 파티에 가입된 상태로 바꾸어준다.
			guildList.get(selGuildMember).setParty(true);
			
			// 길드리스트를 돌면서 파티여부가 트루인 유닛을 찾아, 찾으면 파티리스트에 넣고 n을 증가시켜 파티리스트를
			// 채워준다. / 만약 파티원이 4명보다 많으면 오류가 발생하게 되는데, 파티여부를 private으로 해놨고
			// 파티여부를 건드는 권한은 해당 매소드에만 있기때문에 따로 예외처리를 하지 않아도 될까?
			int n=0;
			for(Unit u:guildList) {
				if(u.isParty()) {
					partyList[n]=u;
				}
				n++;
			}
		}
		else {
			System.out.println("잘못된 입력입니다.");
		}
	}
	
	public void levelUp() {
		printParty();
		System.out.println("[레벨업 비용:현재레벨x1000]");
		System.out.println("[현재 소지금:"+Player.pl.getMoney()+"]");
		System.out.println("[레벨업 할 파티원: ");
		int upUnit=Game.scan.nextInt()-1;
		if(partyList[upUnit].getLevel()*1000<=Player.pl.getMoney()) {
			partyList[upUnit].setLevel(partyList[upUnit].getLevel()+1);
			partyList[upUnit].setAtt(partyList[upUnit].getAtt()+partyList[upUnit].getLevel());
			System.out.println("레벨업!!!");
		}
		
	}
	
}
