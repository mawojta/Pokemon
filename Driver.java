
import java.util.Scanner;

public class Driver {
	
	public static void main(String[] args) {
		Pokemon[] arrOfPokemons = new Pokemon[4];
		Scanner stdIn = new Scanner(System.in);

		Pokemon pokemon = null;
		
		//DONE
		//Read user input - Create pokemon & add to array if not duplicate.
		for(int i = 0; i < arrOfPokemons.length; i++) {
			String[] userArray = null;
			do {
				System.out.print("Enter name, health, power, and level for Pokemon#" + i + ": ");
				userArray = stdIn.nextLine().split(" ");
				
				pokemon = makePokemon(userArray[0], Integer.parseInt(userArray[1]), Integer.parseInt(userArray[2]), Integer.parseInt(userArray[3]));
				if(contains(pokemon, arrOfPokemons) == true) {
					pokemon = null;
				}
			}while(pokemon == null);	
			
			arrOfPokemons[i] = pokemon;
		}


		System.out.println();

		System.out.println("Pokemons before playing");
		print(arrOfPokemons);

		System.out.println();
		for(int i=0; i<3; i++){
			play(arrOfPokemons, stdIn, i);
		}


		System.out.println();
		System.out.println("Pokemons After playing");
		print(arrOfPokemons);

		stdIn.close();
	}

	private static void print(Pokemon[] arrOfPokemons){

		//Print the pokemons in the arrOfPokemons array 
		for (int index = 0; index < arrOfPokemons.length; index++) {
			System.out.printf("%d: %s\n", index, arrOfPokemons[index].toString());
		}

	}

	private static void play(Pokemon[] arrOfPokemons, Scanner stdIn, int numberOfPlay) {
		int firstPokemon=0;
		int secondPokemon=0;
		do{
			System.out.printf("# %d Please enter the pokemons you want to play 0 to 3: ",numberOfPlay);
			firstPokemon = stdIn.nextInt();
			secondPokemon = stdIn.nextInt();

		}while(firstPokemon<0 ||firstPokemon>4 ||secondPokemon<0 ||secondPokemon>4 );

		arrOfPokemons[firstPokemon].specialAttack(arrOfPokemons[secondPokemon]);

		//think of this part as a counterattack
		arrOfPokemons[secondPokemon].physicalAttack(arrOfPokemons[firstPokemon]);

	}

	//DONE
	/**
	 * Creates a pokemon based on name passed to method.
	 * 
	 * @param name
	 * @param health
	 * @param power
	 * @param level
	 * @return Pokemon (Charmander or Pikachu)
	 */
	static Pokemon makePokemon(String name, int health, int power, int level) {		
		name = name.toLowerCase();
		if(name.contains("pikachu")) {
			Pokemon Pikachu = new Pikachu(health, power, level);
			return Pikachu;
		} else if(name.contains("charmander")) {
			Pokemon Charmander = new Charmander(health, power, level);
			return Charmander;
		} else {
			return null;
		}		
	}

	/**
	 * Tells if array contains a pokemon already.
	 * 
	 * @param pok
	 * @param arrOfPokemons
	 * @return boolean
	 */
	
	//DONE
	protected static boolean contains(Pokemon pok, Pokemon[] arrOfPokemons) {
		for(int j = 0; j < arrOfPokemons.length; j++) {
			if(arrOfPokemons[j] == null) {
				break;
			} else if(pok.equals(arrOfPokemons[j]) == true) {
				return true;
			}
		}
		return false;
	}
}
