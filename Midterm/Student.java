import java.util.*;
public class Student{
   String first_name;
   String middle_name; 
   String last_name; 
   String suffix;
   
     public Student(String first_name, String middle_name,String last_name, String suffix){
         this.first_name = first_name;
         this.middle_name = middle_name;
         this.last_name = last_name;
         this.suffix = suffix;   
         }
         
        public void setFirstName(String first_name){ 
         this.first_name = first_name;
         }
        public void setMiddleName(String middle_name){ 
         this.middle_name = middle_name;
         }
        public void setLastName(String last_name){ 
         this.last_name = last_name;
         }
         public void setSuffix(String suffix){
         this.suffix = suffix;
         }
         

     public String getFirstName(){
      return first_name;
     }
     public String getMiddleName(){
      return middle_name;
     }
     public String getLastName(){
      return last_name;
     }
     
     public String getSuffix(){
      return suffix;
     }
     
     public String getFullName(){
      String fullName = first_name;
      if(middle_name != null && !middle_name.isEmpty()){
         fullName += " " + middle_name;
      }
      fullName += " " +last_name;
      if (suffix !=null && !suffix.isEmpty()){
         fullName += " " + suffix;
      }
      return fullName;
         
     }
     
     
     public static void main(String[] args){
      Scanner scanner = new Scanner(System.in);
      
      System.out.println("Enter First Name: ");
      String first_name = scanner.nextLine();   
      System.out.println("Enter Middle Name: ");
      String middle_name = scanner.nextLine();
      System.out.println("Enter Last Name: ");
      String last_name = scanner.nextLine();
      System.out.println("Enter Suffix: ");
      String suffix = scanner.nextLine();
      Student student1 = new Student(first_name,middle_name,last_name,suffix);
      System.out.println("First Name: "  + student1.getFirstName());
      System.out.println("Middle Name: "  + student1.getMiddleName());
      System.out.println("Last Name: "  + student1.getLastName());
      System.out.println("Suffix: "  + student1.getSuffix());
      System.out.println("Full Name: "  + student1.getFullName());
     }
}