import java.util.*;
import java.text.DecimalFormat;
   class Product{
      private String name;
      private double price;
      private int quantity;
      
      public Product(String name,double price, int quantity){
         this.name = name;
         this.price = price;
         this.quantity = quantity;
      }
      
      public String getName(){
         return name;
      }
      public double getPrice(){
         return price * quantity;
      }
      public int getQuantity() {
         return quantity;
      }
      @Override
      public String toString(){
         return name + "|" + "pcs. ";
      }
   }
   
   class Order{
      private List<Product> products;
      private double totalAmount;
      public Order(){
         this.products = new ArrayList<>();
         this.totalAmount = 0.0;
      }
      public void addProduct(Product product){
         products.add(product);
      }
      public void calculateTotalAmount(){
         totalAmount = 0;
         
         for(Product product : products) {
            totalAmount += product.getPrice();
         }
       }
      public double convertToUSDollar(double conversionRate){
         return totalAmount / conversionRate; 
      }
      @ Override
      public String toString() {
        String result = "Products:/n ";
        DecimalFormat df = new DecimalFormat("0.00");
        for (Product product : products) {
            result += product.toString()+ "/n ";
        }
        if(!products.isEmpty()){
         result = result.substring(0, result.length() - 2);
        }
        double dollarAmount = convertToUSDollar(56.80);
        result += "\nTotal Amount: PHp " + totalAmount + " ($ " + df.format(dollarAmount) + ")\n";
        
        return result;
    }
   }
   
   public class ActivityThreeAlino{
      public static void main(String[] args){
         Scanner scanner = new Scanner(System.in);
         Order order = new Order();
         System.out.println("Jollibot Fast Food");
         
         System.out.println("Menu: ");
         System.out.println("1. C1 = Php 100.00");
         System.out.println("2. C2 = Php 150.00");
         System.out.println("3. C3= Php 200.00");
         System.out.println("Add Ons: ");
         System.out.println("4. R1 = Php 35.00");
         System.out.println("5. R2 = Php 50.oo");
         System.out.println("6. Finish Order: ");
         while(true) {
            System.out.print("Select an Option (1-5) or 0 to finish order: ");
            int productChoice = scanner.nextInt();
            scanner.nextLine();
            
            if (productChoice == 0) {
               order.calculateTotalAmount();
               System.out.println(order.toString());
               break;
            }
            if (productChoice >=1 && productChoice <=5) {
            System.out.print("Enter Quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            if (quantity > 0){
            switch(productChoice) {
               case 1: 
                  order.addProduct(new Product("C1",100.00,quantity));
                  break;
               case 2:
                  order.addProduct(new Product("C2",150.00,quantity));
                  break;
               case 3:
                  order.addProduct(new Product("C3",200.00,quantity));
                  break;   
               case 4:
                  order.addProduct(new Product("R1",35.00,quantity));
                  break;
               case 5:
                  order.addProduct(new Product("R2",40.00,quantity));
                  break;
            }
          } else {
               System.out.println("Invalid Option. Please Enter A Valid Option.");          
         }
         } else {
               System.out.println("Invalid Option. Please Try Again!");         
         }
      }
   }
}