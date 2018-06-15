/* Customizable RPG Hero class
 * Purpose: Defines a Hero in various ways
 * 
 */

public class Hero {

/*******************************************************************************	
    VARIABLES                                                      	
*******************************************************************************/

/*= Main =====================================================================*/
	private String hero_Name;
	private int hero_ID;
	private Job hero_Job;
	private int hero_HP;
	private int hero_MP;
	
/*= Level and EXP ============================================================*/
	private int hero_Level;
	private int hero_EXP;
	private int hero_EXPToNext;
	
/*= Equipment ================================================================*/
	private Weapon hero_Weapon;
	private Armor hero_Armor;
	private Accessory hero_Accessory;
	
/*= Abilities ================================================================*/
	private Talisman[] hero_Talisman; //Items that contain magic spells
	private Spell[] hero_Magic;
	private Summon[] hero_Summon;
	private Ability[] hero_Abilities;
	
/*= Extended stats ===========================================================*/
	private XStats hero_XStats;
	
	
/*******************************************************************************	
    METHODS                                                      	
*******************************************************************************/

	// Constructor 1: Creates a character with base stats
	// MUST INCLUDE: Name, characterID, Job, and Weapon (furthermore, weapon
	//               must be a valid weapon for the Job).
	public Hero (String name, int characterID, Job characterJob, Weapon characterWeapon) {
		hero_Name = name;
		hero_ID = characterID;
		hero_Job = characterJob;
		hero_HP = 100;
		hero_MP = 10;
		
		hero_Level = 1;
		hero_EXP = 0;
		hero_EXPToNext = 100;
		
		if (Job.isValidWeapon(characterWeapon)) {
			heroWeapon = characterWeapon;
		}
		else {
			System.err.println("Weapon does not match Job requirements. Now exiting."); 
			Thread.currentThread().dumpStack();
			exit(1);
		}
	}

	// Constructor 2: Creates a character with set level (extrapolated base stats)
	// MUST INCLUDE: Name, characterID, Job, and Weapon (furthermore, weapon
	//               must be a valid weapon for the Job).
	public Hero (String name, int characterID, Job characterJob, int characterLevel, Weapon characterWeapon) {
		hero_Name = name;
		hero_ID = characterID;
		hero_Job = characterJob;
		
		if (Job.isValidWeapon(characterWeapon)) {
			heroWeapon = characterWeapon;
		}
		else {
			System.err.println("Weapon does not match Job requirements. Now exiting."); 
			Thread.currentThread().dumpStack();
			exit(1);
		}
	}
	
	public int getLevelUpEXPNeeded (int char_level) {
		int l = char_level;
		if (l<1) l=1;
		if (l>=99) l=98;
		
		switch(l+1) {
			case 1: return 100;
				break;
			case 2: return 225;
				break;
			case 3: return 375;
				break;
			case 4: return 575;
				break;
			case 5: return 825;
				break;
			case 6: return 1125;
				break;
			case 7: return 1500;
				break;
			case 8: return 1950;
				break;
			case 9: return 2525;
				break;
			case 10: return 3225;
				break;
			case 11: return 4075;
				break;
			case 12: return 5125;
				break;
			case 13: return 6400;
				break;
			case 14: return 7900;
				break;
			case 15: return 9650;
				break;
			case 16: return 11750;
				break;
			case 17: return 14200;
				break;
			case 18: return 17025;
				break;
			case 19: return 20300;
				break;
			case 20: return 24050;
				break;
			case 21: return 28325;
				break;
			case 22: return 33200;
				break;
			case 23: return 38700;
				break;
			case 24: return 44900;
				break;
			case 25: return 51825;
				break;
			case 26: return 59575;
				break;
			case 27: return 68200;
				break;
			case 28: return 77775;
				break;
			case 29: return 88325;
				break;
			case 30: return 99975;
				break;
			case 31: return 112775;
				break;
			case 32: return 126775;
				break;
			case 33: return 142075;
				break;
			case 34: return 158775;
				break;
			case 35: return 176925;
				break;
			case 36: return 196625;
				break;
			case 37: return 217975;
				break;
			case 38: return 241025;
				break;
			case 39: return 265900;
				break;
			case 40: return 292675;
				break;
			case 41: return 321475;
				break;
			case 42: return 352375;
				break;
			case 43: return 385475;
				break;
			case 44: return 420900;
				break;
			case 45: return 458725;
				break;
			case 46: return 499075;
				break;
			case 47: return 542075;
				break;
			case 48: return 587850;
				break;
			case 49: return 636450;
				break;
			case 50: return 688075;
				break;
			case 51: return 742775;
				break;
			case 52: return 800725;
				break;
			case 53: return 862025;
				break;
			case 54: return 926825;
				break;
			case 55: return 995225;
				break;
			case 56: return 1067375;
				break;
			case 57: return 1143400;
				break;
			case 58: return 1223475;
				break;
			case 59: return 1307700;
				break;
			case 60: return 1396225;
				break;
			case 61: return 1489200;
				break;
			case 62: return 1586775;
				break;
			case 63: return 1689100;
				break;
			case 64: return 1796300;
				break;
			case 65: return 1908600;
				break;
			case 66: return 2026075;
				break;
			case 67: return 2148950;
				break;
			case 68: return 2277325;
				break;
			case 69: return 2411425;
				break;
			case 70: return 2551375;
				break;
			case 71: return 2697375;
				break;
			case 72: return 2849575;
				break;
			case 73: return 3008175;
				break;
			case 74: return 3173300;
				break;
			case 75: return 3345175;
				break;
			case 76: return 3523975;
				break;
			case 77: return 3709875;
				break;
			case 78: return 3903075;
				break;
			case 79: return 4103725;
				break;
			case 80: return 4312050;
				break;
			case 81: return 4528250;
				break;
			case 82: return 4752500;
				break;
			case 83: return 4985000;
				break;
			case 84: return 5225975;
				break;
			case 85: return 5475600;
				break;
			case 86: return 5734100;
				break;
			case 87: return 6001650;
				break;
			case 88: return 6278500;
				break;
			case 89: return 6564850;
				break;
			case 90: return 6860900;
				break;
			case 91: return 7166900;
				break;
			case 92: return 7483050;
				break;
			case 93: return 7809550;
				break;
			case 94: return 8146675;
				break;
			case 95: return 8494625;
				break;
			case 96: return 8853600;
				break;
			case 97: return 9223900;
				break;
			case 98: return 9605900;
				break;
			case 99: return 10000000;
				break;
			default: return false;
				break;
		}
		
		return false;
	}
	
	//Returns HP
	public int getHP() {
		return hero_HP;
	}
	
	//Returns MP
	public int getMP() {
		return hero_MP;
	}
	
	//Returns level
	public int getLevel() {
		return hero_Level;
	}
	
	//Returns EXP
	public int getEXP() {
		return hero_Level;
	}

}