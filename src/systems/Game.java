package systems;

import java.util.List;
import java.util.Scanner;

import entities.champion.*;
import entities.items.Item;
import entities.items.equipments.armor.Armor;
import entities.items.equipments.weapon.Weapon;

public class Game {
    private static Scanner myScanner = new Scanner(System.in);
    private static Champion player = null;
    public Game() {}

    public void run() {
        boolean gameRunning = true;
        String playerInput = "";
        while (gameRunning) {
            System.out.println("Welcome to RPGCharacters!");
            while (player == null) {
                player = createPlayerCharacter();
            }

            playerInTown();

            System.out.println("Would you like to start a new game?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            playerInput = myScanner.nextLine();
            if (playerInput.equals("1")){
                player = null;
            }
            else if (playerInput.equals("2")) {
                gameRunning = false;
            }
            else {
                System.out.println("Invalid input.");
            }
        }
    }

    private Champion createPlayerCharacter() {
        Champion newCharacter = null;
        System.out.println("1. Warrior");
        System.out.println("2. Ranger");
        System.out.println("3. Mage");
        System.out.print("Please select your class: ");
        String playerChoice = myScanner.nextLine();
        System.out.print("Please enter a name: ");
        String playerName = myScanner.nextLine();
        switch (playerChoice) 
        {
            case "1":
            {   
                newCharacter = ChampionGenerator.generateChampion(ClassType.Warrior, playerName);
                break;
            }
            case "2":
            {
                newCharacter = ChampionGenerator.generateChampion(ClassType.Ranger, playerName);
                break;
            }
            case "3":
            {
                newCharacter = ChampionGenerator.generateChampion(ClassType.Mage, playerName);
                break;
            }
            default:
            {
                System.out.println("Invalid choice. Try again.");
            }
        }   
        return newCharacter;  
    }

    private void playerInTown() {
        String playerInput = "";
        boolean waitingForChoice = true;
        while (waitingForChoice) {
            System.out.println("\nYou are in town. What would you like to do?");
            System.out.println("1. Hunt Monsters");
            System.out.println("2. Check my stats");
            System.out.println("3. Check my inventory");
            System.out.println("4. Exit Game");
            System.out.print("Input: ");
            playerInput = myScanner.nextLine();
            switch (playerInput) 
            {
                case "1":
                {
                    CombatSystem.doCombat(player, myScanner);
                    break;
                }
                case "2":
                {
                    ChampionInfoPrinter.printChampionInfo(player);
                    break;
                }
                case "3":
                {
                    playerInventory();
                    break;
                }
                case "4":
                {
                    System.out.println("Game should end.");
                    waitingForChoice = false;
                    break;
                }
                default:
                {
                    System.out.println("Invalid choice. Try again.");
                    break;
                }
            }
        }
    }

    public void playerInventory() {
        String playerInput = "";
        boolean playerUsingInventory = true;
        while (playerUsingInventory) {
            System.out.println("-------------------------");
            System.out.println("|       Inventory       |");
            System.out.println("-------------------------");
            System.out.println("1. Weapons");
            System.out.println("2. Armor");
            System.out.println("3. Return");
            System.out.print("Your choice: ");
            playerInput = myScanner.nextLine();
            switch (playerInput) 
            {
                case "1":
                {
                    List<Item> weapons = player.getBaggedWeapons();
                    System.out.println("Should print weapons. " + weapons.size() + " weapons in bag.");
                    int index = 0;
                    Weapon currentWeapon;
                    for (Item i : weapons) {
                        currentWeapon = (Weapon)(i);
                        System.out.println(index + ". " + currentWeapon.getName() + " (Level " + currentWeapon.getLevelRequirement() + ")");
                        index++;
                    }
                    System.out.println("Would you like to equip something?");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    System.out.print("Input: ");
                    playerInput = myScanner.nextLine();
                    switch (playerInput) 
                    {
                        case "1":
                        {  
                            System.out.print("\nEnter the index of the item you want to equip: ");
                            playerInput = myScanner.nextLine();
                            index = -1;
                            try {
                                index = Integer.parseInt(playerInput);
                                player.equipWeaponFromBag(index);
                            } catch (NumberFormatException e) {
                                System.out.println("Input was not a number.");
                                break;
                            } catch (IndexOutOfBoundsException e) {
                                System.out.println("Index out of bounds.");
                            }
                            catch (Exception e) {
                                System.out.println("Exception: Invalid input.");
                                break;
                            }           
                            break;
                        }
                        default:
                        {
                            System.out.println("Invalid input.");
                        }
                    }
                    break;
                }
                case "2":
                {
                    List<Item> armor = player.getBaggedArmor();
                    int index = 0;
                    Armor currentArmor;
                    for (Item i : armor) {
                        currentArmor = (Armor)i;
                        System.out.println(index + ". " + i.getName() + " (Level " + currentArmor.getLevelRequirement() + ")");
                        index++;
                    }
                    System.out.println("Would you like to equip something?");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    System.out.print("Input: ");
                    playerInput = myScanner.nextLine();
                    switch (playerInput) 
                    {
                        case "1":
                        {  
                            System.out.print("\nEnter the index of the item you want to equip: ");
                            playerInput = myScanner.nextLine();
                            index = -1;
                            try {
                                index = Integer.parseInt(playerInput);
                                player.equipArmorFromBag(index);
                            } catch (NumberFormatException e) {
                                System.out.println("Input was not a number.");
                                break;
                            } catch (IndexOutOfBoundsException e) {
                                System.out.println("Index out of bounds.");
                            }
                            catch (Exception e) {
                                System.out.println("Invalid input.");
                                break;
                            }           
                            break;
                        }
                        default:
                        {
                            System.out.println("Invalid input.");
                        }
                    }
                    break;
                }
                case "3":
                {
                    playerUsingInventory = false;
                    break;
                }
            }
        } 
    }
}
