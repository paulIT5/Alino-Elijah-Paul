import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.InputMismatchException;

public class Routes{
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
   
      System.out.println("Welcome to Cebu City\n");
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println("DEFAULT ROUTE:\n");
      animateDriving("Cebu City to Minglanilla");
      animateDriving("Minglanila to San Fernando");
      animateDriving("San Fernando to Car Car");
   
      String obstruction = getObstructionInput(scanner);
   
      if ("no".equalsIgnoreCase(obstruction)) {
         int speed = getSpeedInput(scanner);
         animateDriving("Car Car to Barili");
         animateDriving("Barili to Dumanjug");
         animateDriving("Dumanjug to Moalboal");
         calculateETA(84.5, speed);
         System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      } else {
         animateChangingRoute(" to Recommended Route Please Be Advised!");
         System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
         System.out.println("RECOMMENDED ROUTE:\n ");
         animateDriving("Car Car to Sibonga");
         String dumanjugObstruction = getDumanjugObstructionInput(scanner);
         int speed = getSpeedInput(scanner);
         if ("no".equalsIgnoreCase(dumanjugObstruction)) {
            animateDriving("Sibonga to Dumanjug");
            animateDriving("Dumanjug to Alcantara");
            animateDriving("Alcantara to Moalboal");
            calculateETA(94, speed);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
         } else {
            animateChangingRoute(" to Alternative Route Please Be Advised!");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("ALTERNATIVE ROUTE:\n ");
            animateDriving("Sibonga to Argao");
            animateDriving("Argao to Ronda");
            animateDriving("Ronda to Alcantara");
            animateDriving("Alcantara to Moalboal");
            calculateETA(93.3, speed);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
         }
      }
   
      scanner.close();
   }

   private static void animateDriving(String routeName) {
      System.out.print("              Driving " + routeName + " ");
      for (int i = 0; i < 3; i++) {
         System.out.print(".");
         try {
            TimeUnit.SECONDS.sleep(1); // Simulate driving delay
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
      System.out.println();
   }
   
   private static void animateChangingRoute(String notice) {
      System.out.print("Changing Route" + notice + " ");
      for (int i = 0; i < 5; i++) {
         System.out.print("-");
         try {
            TimeUnit.SECONDS.sleep(1); // Simulate driving delay
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
      System.out.println();
   }

   private static void calculateETA(double distance, int speed) {
      double time = distance / speed;
      int hours = (int) time;
      int minutes = (int) ((time - hours) * 60);
   
      String eta = formatETA(hours, minutes);
   
      System.out.print("              Driving to Moalboal ");
      for (int i = 0; i < 3; i++) {
         System.out.print(".");
         try {
            TimeUnit.SECONDS.sleep(1); // Simulate driving delay
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
      System.out.println();
      System.out.println("You finally arrived at Moalboal! Enjoy your safe vacation!\n");
      System.out.println("============================================================================");
      System.out.println("ADDITIONAL DATA:");
      System.out.println("                 DISTANCE: " + distance + " km");
      System.out.println("                 SPEED: " + speed + " kph");
      System.out.println("                 Estimated Time of Arrival (ETA): " + eta);
      System.out.println("============================================================================");
   }

   private static String formatETA(int hours, int minutes) {
      if (hours == 0 && minutes == 1) {
         return "1 minute";
      } else if (hours == 0) {
         return (minutes == 1) ? "1 minute" : minutes + " minutes";
      } else if (hours == 1 && minutes == 0) {
         return "1 hour";
      } else if (hours == 1) {
         return "1 hour and " + (minutes == 1 ? "1 minute" : minutes + " minutes");
      } else {
         return hours + " hours and " + (minutes == 1 ? "1 minute" : minutes + " minutes");
      }
   }

   private static String getObstructionInput(Scanner scanner) {
      String obstruction;
      while (true) {
         System.out.print("Is Barili obstructed (yes or no): ");
         try {
            obstruction = scanner.next();
            if ("yes".equalsIgnoreCase(obstruction) || "no".equalsIgnoreCase(obstruction)) {
               break;
            } else {
               System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
         } catch (InputMismatchException e) {
            scanner.next();
            System.out.println("Invalid input. Please enter 'yes' or 'no'.");
         }
      }
      return obstruction;
   }

   private static String getDumanjugObstructionInput(Scanner scanner) {
      String obstruction;
      while (true) {
         System.out.print("Is Dumanjug obstructed (yes or no): ");
         try {
            obstruction = scanner.next();
            if ("yes".equalsIgnoreCase(obstruction) || "no".equalsIgnoreCase(obstruction)) {
               break;
            } else {
               System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
         } catch (InputMismatchException e) {
            scanner.next();
            System.out.println("Invalid input. Please enter 'yes' or 'no'.");
         }
      }
      return obstruction;
   }

   private static int getSpeedInput(Scanner scanner) {
      int speed;
      while (true) {
         System.out.print("How fast are you going (in km/h)? ");
         try {
            speed = scanner.nextInt();
            break;
         } catch (InputMismatchException e) {
            scanner.next();
            System.out.println("Invalid input. Please enter valid speed(number).");
         }
      }
      return speed;
   }
}
