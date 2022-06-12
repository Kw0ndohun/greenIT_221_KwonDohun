package rpg;


public class Player {
	public static Player pl=new Player();
	
	private int money=100000;
	private int damage;
	
	public int setDamage() {
		for(int n=0; n<Guild.gl.getPartyList().length; n++) {
			this.damage+=Guild.gl.getPartyList()[n].getAtt();
			if(Guild.gl.getPartyList()[n].getWeapon()!=null) {
				this.damage+=Guild.gl.getPartyList()[n].getWeapon().getPower();
			}
		}
		
		return this.damage;
	}
	
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	
	
}
