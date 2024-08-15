
import java.util.Scanner;


class Main {
    public static void main(String[] args) {
        Polynomial firstPolynomial = new Polynomial();
        Polynomial secondPolynomial = new Polynomial();

        Scanner scanner = new Scanner(System.in);
        int choice;

        printHeader();

       do {
           printMenu();

           System.out.print("\nEnter your choice: ");
           choice = scanner.nextInt();

           switch (choice) {
               case 1:
                   editPolynomial(firstPolynomial, "first");
                   break;
               case 2:
                   editPolynomial(secondPolynomial, "second");
                   break;
               case 3:
                   displayAdditionResult(firstPolynomial,secondPolynomial);
                   break;
               case 4:
                   System.out.println("Exiting...");
                   break;
               default:
                   System.out.println("Invalid choice. Try again.");
           }

       } while (choice != 4);

       scanner.close();
   } 

    public static void printHeader() {
        System.out.println("********************************");
        System.out.println("**                            **");
        System.out.println("**     POLYNOMIAL EDITOR      **");
        System.out.println("**                            **");
        System.out.println("********************************");
    }

    public static void printMenu() {
        System.out.println("\n-----------Menu-------------");
        System.out.println("|                           |");
        System.out.println("| 1. Add first polynomial   |");
        System.out.println("| 2. Add second polynomial  |");
        System.out.println("| 3. Display added result   |");
        System.out.println("| 4. Exit                   |");
        System.out.println("-----------------------------");
    }

    public static void editPolynomial(Polynomial polynomial, String name) {
        //
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n[Editing " + name + " polynomial]");
        
        // Clear the polynomial
        polynomial.clear();
        
        System.out.print("Enter the number of terms you want to add: ");
        int numTerms = scanner.nextInt();
        
        for (int i = 0; i < numTerms; i++) {
           System.out.print("Enter coefficient for term " + (i + 1) + ": ");
           int coef = scanner.nextInt();
        
           System.out.print("Enter exponent for term " + (i + 1) + ": ");
           int expo = scanner.nextInt();
        
           polynomial.addTerm(new Term(coef, expo));
        }
        
        System.out.println("\n" + name + " polynomial set to: " + polynomial);
    }

    public static void displayAdditionResult(Polynomial firstPolymial, Polynomial secondPolynomial) {
        // Remove the assignment to result
        firstPolymial.add(secondPolynomial);
        
        // If you want to create a new Polynomial object with the result, you can do:
        Polynomial result = new Polynomial(firstPolymial);
        //result.addPolynomial(secondPolynomial);
        
        //Polynomial result = new Polynomial(firstPolymial);
        //result.addPolynomial(secondPolynomial);
        System.out.println("\n===== Result of addition =====");
        System.out.println(result);
        System.out.println("==============================");
       }
}