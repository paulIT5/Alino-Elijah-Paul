import java.util.Scanner;

class Routes {
    public void defRoute() {
        System.out.println("Default Route: ");
        System.out.println("Minglanilla (Route 1)");
        System.out.println("San Fernando (Route 2)");
        System.out.println("Carcar (Route 3)");
        System.out.println("Barili (Route 4.1)");
        System.out.println("Dumanjug (Route 4.1.1)");
        System.out.println("Alcantara (Route 4.1.2)");
        System.out.println("You Finally Arrived at Moalboal!");
    }

    public void recRoute() {
        System.out.println("Recommended Route: ");
        System.out.println("Minglanilla (Route 1)");
        System.out.println("San Fernando (Route 2)");
        System.out.println("Carcar (Route 3)");
        System.out.println("Sibonga (Route 4.2)");
        System.out.println("Dumanjug (Route 4.2)");
        System.out.println("Alcantara (Route 4.1.2)");
        System.out.println("You Finally Arrived at Moalboal!");
    }

    public void altRoute() {
        System.out.println("Alternative Route: ");
        System.out.println("Minglanilla (Route 1)");
        System.out.println("San Fernando (Route 2)");
        System.out.println("Carcar (Route 3)");
        System.out.println("Sibonga (Route 4.2)");
        System.out.println("Argao (Route 5)");
        System.out.println("Ronda (Route 5.1)");
        System.out.println("Alcantara (Route 5.2)");
        System.out.println("You Finally Arrived at Moalboal!");
    }
}

public class activityOneAlino {
    public static void main(String[] args) {
        Routes routes = new Routes();
        Scanner sc = new Scanner(System.in);

        System.out.println("Cebu City to Moalboal Route");
        System.out.println("Welcome to Cebu City");
         System.out.println("Minglanilla (Route 1)");
        System.out.println("San Fernando (Route 2)");
        System.out.println("Carcar (Route 3)");

        System.out.print("Is the road obstructed?(Yes/No): ");
        String obstructed = sc.nextLine();

        if (obstructed.equalsIgnoreCase("no")) {
            routes.defRoute();
        } else if (obstructed.equalsIgnoreCase("yes")) {
            System.out.println("Heading to Sibonga(Route 4.2)");
            System.out.print("Is the road obstructed?(Yes/No): ");
            String obstructed1 = sc.nextLine();

            if (obstructed1.equalsIgnoreCase("no")) {
                routes.recRoute();
            } else if (obstructed1.equalsIgnoreCase("yes")) {
                routes.altRoute();
            } else {
                System.out.println("Invalid input. Please try again!");
            }
        } else {
            System.out.println("Invalid input. Please try again!");
        }
        sc.close();
    }
}
