package person;

import bomb.Bomb;
import types.AbstractItem;
import weapon.Weapon;

public class Person {
	
	public Weapon mWeapon;
	public Bomb mBomb;
	
	public void create(AbstractItem item) {
		
		mWeapon = item.createWeapon();
		mBomb = item.createBomb();
				
	}
}
