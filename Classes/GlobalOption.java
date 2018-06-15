/* Customizable RPG GlobalOption class
 * Purpose: Stores the global options for the game
 * 
 */

public class GlobalOption {

/*******************************************************************************	
    VARIABLES                                                      	
*******************************************************************************/

//Options truth table
//-------------------
/*	hasJobs	isEvolving	jobsChangeable	hasTalismans	hasKarma	||	Result
	----------------------------------------------------------------||----------------------------
1.		0		0			0				0				0		||	RESTRICTION 1
2.		0		0			0				0				1		||	RESTRICTION 1, 5
3.		0		0			0				1				0		||	System 4
4.		0		0			0				1				1		||	RESTRICTION 5, 6
5.		0		0			1				0				0		||	RESTRICTION 1, 4
6.		0		0			1				0				1		||	RESTRICTION 1, 4, 5
7.		0		0			1				1				0		||	RESTRICTION 4
8.		0		0			1				1				1		||	RESTRICTION 1, 4, 5, 6
9.		0		1			0				0				0		||	RESTRICTION 1, 2, 4
10.		0		1			0				0				1		||	RESTRICTION 1, 2, 4, 5
11.		0		1			0				1				0		||	RESTRICTION 2, 4
12.		0		1			0				1				1		||	RESTRICTION 2, 4, 5, 6
13.		0		1			1				0				0		||	RESTRICTION 1, 2, 3, 4
14.		0		1			1				0				1		||	RESTRICTION 1, 2, 3, 4, 5
15.		0		1			1				1				0		||	RESTRICTION 2, 3, 4
16.		0		1			1				1				1		||	RESTRICTION 2, 3, 4, 5, 6
17.		1		0			0				0				0		||	System 1
18.		1		0			0				0				1		||	System 8
19.		1		0			0				1				0		||	System 5
20.		1		0			0				1				1		||	RESTRICTION 6
21.		1		0			1				0				0		||	System 3
22.		1		0			1				0				1		||	System 10
23.		1		0			1				1				0		||	System 7
24.		1		0			1				1				1		||	RESTRICTION 6
25.		1		1			0				0				0		||	System 2
26.		1		1			0				0				1		||	System 9
27.		1		1			0				1				0		||	System 6
28.		1		1			0				1				1		||	RESTRICTION 6
29.		1		1			1				0				0		||	RESTRICTION 3
30.		1		1			1				0				1		||	RESTRICTION 3
31.		1		1			1				1				0		||	RESTRICTION 3
32.		1		1			1				1				1		||	RESTRICTION 3, 6
*/
	
/*= Magic System ==============================================================/
/   Options Array: {bool hasJobs, bool isEvolving, bool jobsChangeable,        /
/                   bool hasTalismans, bool hasKarma} 						   /
/   Conditionals: 1. !hasJobs -> hasTalismans;                                 /
/                 2. isEvolving -> hasJobs;                                    /
/                 3. isEvolving -> !jobsChangeable;                            /
/                 4. jobsChangeable -> hasJobs;                                /
/                 5. !hasJobs -> !hasKarma;       		                       /
/                 6. hasKarma -> !hasTalismans;   		                       /
/                 															   /
/   1: Classic System                                                          /
/      Jobs are selected at the beginning of the game, Jobs cannot be changed  /
/      once the game begins, only magical Job types can use magic, spells sold /
/      at magic stores                                                         /
/      Options Array: {TRUE, FALSE, FALSE, FALSE, FALSE}                       /
/   2: Evolving System                                                         /
/      Jobs are selected at the beginning of the game, Jobs can be evolved to  /
/      stronger classes as game progresses, only magical Job types can use     /
/      magic, spells sold at magic stores                                      /
/      Options Array: {TRUE, TRUE, FALSE, FALSE, FALSE}                        /
/   3: Job-changing System                                                     /
/      Characters start as default Job, characters can change Jobs throughout  /
/      the game, only magical Jobs can use magic, spells sold at magic stores  /
/      Options Array: {TRUE, FALSE, TRUE, FALSE, FALSE}                        /
/   4: Talisman System                                                         /
/      No Jobs, Characters can equip Talismans that contain magic spells and   /
/      abilities to slots in weapons and armor, anyone can use magic,          /
/      Talismans sold at magic stores                                          /
/      Options Array: {FALSE, FALSE, FALSE, TRUE, FALSE}                       /
/   5: Hybrid System                                                           /
/      Jobs are selected at the beginning of the game, Characters can equip    /
/      Talismans that contain magic spells and abilities to slots in weapons   /
/      and armor, Talismans can only be used by the Job they are intended for, /
/      Talismans sold at magic stores                                          /
/      Options Array: {TRUE, FALSE, FALSE, TRUE, FALSE}                        /
/   6: Hybrid Evolving System                                                  /
/      Jobs are selected at the beginning of the game, Jobs can be evolved to  /
/      stronger classes as game progresses, Characters can equip Talismans     /
/      that contain magic spells and abilities to slots in weapons and armor,  /
/      Talismans can only be used by the Job they are intended for, Talismans  /
/      sold at magic stores                                                    /
/      Options Array: {TRUE, TRUE, TRUE, FALSE, FALSE}                         /
/   7: Hybrid Changing System                                                  /
/      Characters start as default Job, characters can change Jobs throughout  /
/      the game, Talismans can only be used by the Job they are intended for,  /
/      Talismans sold at magic stores                                          /
/   8: Classic System with Karma                                               /
/      Jobs are selected at the beginning of the game, Jobs cannot be changed  /
/      once the game begins, only magical Job types can use magic, spells sold /
/      at magic stores, characters can karma-convert light or dark             /
/      Options Array: {TRUE, FALSE, FALSE, FALSE, TRUE}                        /
/   9: Evolving System with Karma                                              /
/      Jobs are selected at the beginning of the game, Jobs can be evolved to  /
/      stronger classes as game progresses, only magical Job types can use     /
/      magic, spells sold at magic stores, characters can karma-convert light  /
/      or dark                                                                 /
/      Options Array: {TRUE, TRUE, FALSE, FALSE, TRUE}                         /
/  10: Job-changing System with Karma                                          /
/      Characters start as default Job, characters can change Jobs throughout  /
/      the game, only magical Jobs can use magic, spells sold at magic stores, /
/      characters can karma-convert light or dark                              /
/      Options Array: {TRUE, FALSE, TRUE, FALSE, TRUE}                         /
/=============================================================================*/
	private int magicSystem;
	private boolean[] systemOptions;
	
/*= Job Set ===================================================================/
/   0: Custom Jobs                                                             /
/      Jobs are defined by the user, but will conform to rules of selected 	   /
/	   magic system										                       /
/      Job Array: {}                                                           /
/   1: No Jobs                                                                 /
/      The only Job a character can use is the default Mercenary Job.          /
/      Job Array: {MERCENARY}                                                  /
/   2. 4 Jobs                                                                  /
/      Job Array: {FIGHTER, MAGE, MONK, SUMMONER}                              /
/   3: 6 Jobs                                                                  /
/      Job Array: {FIGHTER, DARK_MAGE, LIGHT_MAGE, GRAY_MAGE, MONK, THIEF}	   /
/   4: 8 Jobs (Set 2 with evolving)                                            /
/      Job Array: {FIGHTER, MAGE, MONK, SUMMONER, KNIGHT, WIZARD, BLACK_BELT,  /
/				   MASTER_SUMMONER}	   										   /
/   5: 8 Jobs (Karma Set 1)                        		               		   /
/      Job Array: {FIGHTER, MONK, LIGHT_MAGE, PALADIN,     					   /
/				   DARK_WARRIOR, THIEF, DARK_MAGE, DRAGOON}					   /
/   6: 10 Jobs (Karma Set 2)                        		               	   /
/      Job Array: {FIGHTER, MONK, LIGHT_MAGE, PALADIN, SAMURAI,     		   /
/				   DARK_WARRIOR, THIEF, DARK_MAGE, DRAGOON, VIKING}			   /
/   7: 12 Jobs (Set 3 with evolving)                                           /
/      Job Array: {FIGHTER, DARK_MAGE, LIGHT_MAGE, GRAY_MAGE, MONK, THIEF,     /
/				   KNIGHT, DARK_WIZARD, LIGHT_WIZARD, GRAY_WIZARD, BLACK_BELT, /
/				   NINJA}	   												   /
/   5: 12 Jobs (Karma Set 3)                        		               	   /
/      Job Array: {FIGHTER, MONK, LIGHT_MAGE, PALADIN, SAMURAI, BARD,		   /
/				 DARK_WARRIOR, THIEF, DARK_MAGE, DRAGOON, VIKING, NECROMANCER} /
/=============================================================================*/
	private int jobSet;
	private boolean allowAccessories;
	
	public enum heroJob {
		
	  //--CLASS NAME--------||-RANK-||--KARMA CONVERTS TO---//
	  //                    ||      ||						//
	  //_PHYSICAL NEUTRAL___________________________________//
		MERCENARY,		    //	jr	||	--					//
		GLADIATOR,			//	sr	||	--					//
		RANGER,				//	--	||	--					//
	  //                    ||      ||						//
	  //_PHYSICAL LIGHT_____________________________________//
		FIGHTER,			//  jr	||	DARK_WARRIOR		//
		KNIGHT,				//  sr  ||  DARK_KNIGHT			//
	  //--------------------||------||----------------------//
		SAMURAI,			//  --  ||  VIKING				//
	  //--------------------||------||----------------------//
		MONK,				//  jr	||  THIEF				//
		BLACK_BELT,			//  sr	||	NINJA				//
	  //                    ||      ||						//
	  //_PHYSICAL DARK______________________________________//
		DARK_WARRIOR,		//  jr	||	FIGHTER				//
		DARK_KNIGHT,		//  sr	||	KNIGHT				//
	  //--------------------||------||----------------------//
		THIEF,				//	jr	||	MONK				//
		NINJA,				//	sr	||	BLACK_BELT			//
	  //--------------------||------||----------------------//
		VIKING,				//  --  ||  SAMURAI				//
	  //                    ||      ||						//
      //_PHYSICAL W/ NEUTRAL MAGIC__________________________//
		ENGINEER,			//  --  ||  --					//
	  //                    ||      ||						//
      //_PHYSICAL W/ LIGHT MAGIC____________________________//
		PALADIN,			//	--	||	DRAGOON				//
	  //                    ||      ||						//
      //_PHYSICAL W/ DARK MAGIC_____________________________//
		DRAGOON,			//	--	||	PALADIN				//
	  //                    ||      ||						//
	  //_MAGICAL NEUTRAL____________________________________//
		MAGE,				//	jr	||	--					//
		WIZARD,				//	sr	||	--					//
	  //--------------------||------||----------------------//
		BLUE_MAGE,			//	jr	||	--					//
		BLUE_WIZARD,		//	sr	||	--					//
	  //--------------------||------||----------------------//
		SUMMONER,			//	jr	||	--					//
		MASTER_SUMMONER,	//	sr	||	--					//
	  //--------------------||------||----------------------//
		TIME_MAGE,			//	jr	||	--					//
		TIME_WIZARD,		//	sr	||	--					//
	  //                    ||      ||						//
	  //_MAGICAL DARK_______________________________________//
		DARK_MAGE,			//	jr	||	LIGHT_MAGE			//
		DARK_WIZARD,		//	sr	||	LIGHT_WIZARD		//
	  //--------------------||------||----------------------//
		NECROMANCER,		//	--	||	BARD				//
	  //                    ||      ||						//
	  //_MAGICAL LIGHT______________________________________//
		LIGHT_MAGE,			//	jr	||	DARK_MAGE			//
		LIGHT_WIZARD,		//	sr	||	DARK_WIZARD			//
	  //--------------------||------||----------------------//
		BARD,				//	--	||	NECROMANCER			//
	  //                    ||      ||						//
	  //_MIXED______________________________________________//
		GRAY_MAGE,			//	jr	||	--					//
		GRAY_WIZARD			//	sr	||	--					//
	  //                    ||      ||						//
	  //----------------------------------------------------//
	}
	
	private Job[] jobArray;
	
	
/*******************************************************************************	
    METHODS                                                      	
*******************************************************************************/

	// Constructor 1: Default Global Options
	// Creates a GlobalOption object with the following options:
	// MagicSystem: Classic
	public GlobalOption () {
		
	}

}