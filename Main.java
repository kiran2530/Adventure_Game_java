import java.util.Random;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        // System objects...
        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        // Game variables
        String[] enemies = {"Skeleton","Zombie","Warrior","Assassin"};
        int maxEnemyHealth = 75;
        int enemyAttackDamage = 25;

        // Player variables
        int healt = 100;
        int attackDamage = 50;
        int numHealtPotions = 3;
        int healthPotionHealAmount = 30;
        int healthPotionDropChance = 50;

        boolean running = true;

        System.out.println("\n\n\t Welcome to the new Game...");
        
        GAME:
        while(running) {
            System.out.println("----------------------------------------------------");

            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t# " + enemy + " appeared! #\n");
            
            while (enemyHealth > 0) {
                System.out.println("\tYour HP : " + healt);
                System.out.println("\t" + enemy + "'s HP : " + enemyHealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink healt potion");
                System.out.println("\t3. Run!");

                String input = in.nextLine();
                if(input.equals("1")) {
                    int damageDealt = rand.nextInt(attackDamage);
                    int damageTaken = rand.nextInt(enemyAttackDamage);

                    enemyHealth -= damageDealt;
                    healt -= damageTaken;
                    System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage.");
                    System.out.println("\t> You recieve " + damageTaken + " in retaliation!");

                    if(healt < 1) {
                        System.out.println("\t> You have take to much damage, you are too weak to go on!");
                        break;
                    }
                }
                else if(input.equals("2")) {
                    if(numHealtPotions > 0) {
                        healt += healthPotionHealAmount;
                        numHealtPotions-- ;
                        System.out.println("\t> You drink a health potion, healing yourself for " + healthPotionHealAmount + " . " 
                                + "\n\t> You noe have " + healt + " HP." 
                                + "\n\t> You have " + numHealtPotions + " health potions left. \n");
                    }
                    else {
                        System.out.println("\t> You have no health potions left! Defeat enemies for a chance to get one!\n");
                    }
                }
                else if(input.equals("3")) {
                    System.out.println("\t> You run away from the " + enemy + "!");
                    continue GAME;
                }
                else {
                    System.out.println("\tInvalid choice!...");
                }
            }

            if(healt < 1) {
                System.out.println("You limp out of the game, weak from battle.");
                break;
            }

            System.out.println("----------------------------------------------------");
            System.out.println(" # " + enemy + " was defeated! # ");
            System.out.println(" # You have " + healt + " HP left. #");
            if(rand.nextInt(100) < healthPotionDropChance) {
                numHealtPotions++;
                System.out.println(" # The " + enemy + " dropped a health potion! # ");
                System.out.println(" # You now have " + numHealtPotions + " health potion(s). # ");
            }
            System.out.println("----------------------------------------------------");
            System.out.println("What would you like to do now?");
            System.out.println("1. Continue fighting");
            System.out.println("2. Exit game");

            String input = in.nextLine();

            while(!input.equals("1") && input.equals("2")) {
                System.out.println("Invalid choice!...");
                input = in.nextLine();
            }
            
            if(input.equals("1")) {
                System.out.println("You continue on your adventure!");
            }
            else if(input.equals("2")) {
                System.out.println("You exit game, successful from your adventures!");
                break;
            }
        }

        System.out.println("#######################");
        System.out.println("# THANKS FOR PLAYING! #");
        System.out.println("#######################");
    }
}