import java.util.Scanner;

public class RestaurantBillGenerator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Parallel arrays for menu
        String[] codes = {"P1", "P2", "P3", "P4"};
        String[] items = {"Paneer Tikka", "Veg Biryani", "Butter Naan", "Cold Coffee"};
        double[] prices = {180, 150, 40, 90};

        double subtotal = 0;

        // StringBuilder for creating the final bill
        StringBuilder bill = new StringBuilder();

        System.out.println("===== Restaurant Bill Generator =====");

        while (true) {

            System.out.print("Enter item code (or DONE): ");
            String code = sc.nextLine();

            // Stop ordering when DONE is entered
            if (code.equalsIgnoreCase("DONE")) {
                break;
            }

            int index = -1;

            // Search for the item code
            for (int i = 0; i < codes.length; i++) {
                if (codes[i].equalsIgnoreCase(code)) {
                    index = i;
                    break;
                }
            }

            // Check if code is valid
            if (index == -1) {
                System.out.println("Invalid item code. Please try again.");
                continue;
            }

            System.out.print("Quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();

            // Calculate item total
            double itemTotal = quantity * prices[index];

            // Add to subtotal
            subtotal += itemTotal;

            // Add item details to bill
            bill.append(String.format(
                    "%s x%d = ₹%.2f%n",
                    items[index], quantity, itemTotal
            ));
        }

        // Calculate GST and grand total
        double gst = subtotal * 0.05;
        double grandTotal = subtotal + gst;

        // Print final bill
        System.out.println("-------- Final Bill --------");
        System.out.print(bill);

        System.out.println("-----------------------------");
        System.out.printf("Subtotal : ₹%.2f%n", subtotal);
        System.out.printf("GST (5%%) : ₹%.2f%n", gst);
        System.out.printf("Grand Total : ₹%.2f%n", grandTotal);

        sc.close();
    }
}
// O