import java.util.*;

class CinemaManagement {
    // Seat plan for the cinema, initialized to 0 (empty)
    static int[][] seat_plan = new int[3][16];
    // Tracker for ticket details, corresponding to the seats
    static Ticket[][] detail_tracker = new Ticket[3][16];

    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner input = new Scanner(System.in);

        System.out.println("\nWelcome to the London Lumiere");

        while (true) {
            // Display the menu options
            System.out.println("\n------------------------------------------------");
            System.out.println("Please select an option:");
            System.out.println("  1) Buy a ticket");
            System.out.println("  2) Cancel ticket");
            System.out.println("  3) See seating plan");
            System.out.println("  4) Find first seat available");
            System.out.println("  5) Print tickets information and total price");
            System.out.println("  6) Search ticket");
            System.out.println("  7) Sort tickets by price");
            System.out.println("  8) Exit");
            System.out.println("------------------------------------------------");

            boolean isValidInput = false ;
            int option = -1 ;

            while (!isValidInput) {
                try {
                    System.out.print("\nPlease select an option : ");
                    option = input.nextInt();
                    input.nextLine(); // Consume newline character

                    if (option >= 1  && option <= 8) {
                        isValidInput = true;
                    } else {
                        System.out.println("\nInvalid option Please Try Again !");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("\nInvalid input. Please enter a valid integer.");
                    input.nextLine(); // Clear invalid input
                }
            }

            //Handle the user's menu choice

            switch (option) {
                case 1:
                    buy_ticket(input);
                    break;
                case 2:
                    cancel_ticket(input);
                    break;
                case 3:
                    print_seating_area();
                    break;
                case 4:
                    find_first_available();
                    break;
                case 5:
                    print_tickets_info();
                    break;
                case 6:
                    search_ticket(input);
                    break;
                case 7:
                    sort_tickets();
                    break;
                case 8:
                    System.out.println("\nExiting...Thank You\n");
                    System.exit(0); // Exit the program
            }
        }
    }
    /**
     * Prints the current seating area with booked (X) and available (O) seats.
     */
    public static void  print_seating_area() {
        System.out.println("\n*******************************");
        System.out.println("*            SCREEN           *");
        System.out.println("*******************************");
        for (int i = 0; i < seat_plan.length; i++) {
            for (int j = 0; j < seat_plan[i].length; j++) {
                if (seat_plan[i][j] == 0) {
                    System.out.print("O ");
                } else if (seat_plan[i][j] == 1) {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Function to buy a ticket
     * @param input
     */
    public static void buy_ticket(Scanner input) {
        while (true) {
            System.out.print("\nEnter row you want :");
            int row;
            while (true) {
                try {
                    row = input.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.print("Invalid input. Please enter a number between 1 and 3: ");
                    input.nextLine(); // Clear invalid input
                }
            }
            if (row <= 3 && row > 0) {
                System.out.print("Enter seat number you number :");
                int seat_number;
                while (true) {
                    try {
                        seat_number = input.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.print("Invalid input. Please enter a number between 1 and 16: ");
                        input.nextLine();
                    }
                }
                if (seat_number <= 16 && seat_number > 0) {
                    if (seat_plan[row - 1][seat_number - 1] == 0) {
                        seat_plan[row-1][seat_number-1] = 1;
                        boolean inputs = true;
                        while (inputs) {
                            System.out.print("\nEnter your name:");
                            String name = input.next();
                            if (name.matches("[a-zA-Z]+")) {
                                System.out.print("Enter your surname:");
                                String surname = input.next();
                                if (surname.matches("[a-zA-Z]+")) {
                                    System.out.print("Enter your email:");
                                    String email = input.next();
                                    if (email.contains("@") && email.contains(".")) {
                                        Person person_details = new Person(name, surname, email);
                                        int TicketPrice = ticket_price(row-1);
                                        Ticket ticket_details = new Ticket(row, seat_number,TicketPrice, person_details);
                                        detail_tracker[row-1][seat_number-1] = ticket_details;
                                        ticket_details.printTicket();
                                        System.out.println("\nTicket booked successfully ");
                                        return;
                                    } else {
                                        System.out.println("\nInvalid email");
                                    }
                                } else {
                                    System.out.println("\nInvalid surname letters only ");
                                }
                            } else {
                                System.out.println("\nInvalid name letters only");
                            }
                        }
                    } else {
                        System.out.println("\nSeat is already booked ..");
                    }
                } else {
                    System.out.println("\nInvalid seat number try again ..");
                }
            } else {
                System.out.println("\nInvalid row try again..");
            }
        }
    }


    /**
     *   Function to cancel a ticket
     * @param input
     */

    public static void cancel_ticket(Scanner input) {
        while (true) {
            System.out.print("\nEnter row you want :");
            int row;
            while (true) {
                try {
                    row = input.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.print("Invalid input. Please enter a number between 1 and 3: ");
                    input.nextLine(); // Clear invalid input
                }
            }
            if (row <= 3 && row > 0) {
                System.out.print("Enter seat number :");

                int seat_number;
                while (true) {
                    try {
                        seat_number = input.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.print("Invalid input. Please enter a number between 1 and 16: ");
                        input.nextLine();
                    }
                }
                if (seat_number <= 16 && seat_number > 0) {
                    if (seat_plan[row-1][seat_number-1] == 1) {
                        seat_plan[row-1][seat_number-1] = 0;
                        System.out.println("\nThe seat has been cancelled");
                        detail_tracker[row-1][seat_number-1] = null;
                        return;
                    } else {
                        System.out.println("\nSeat is already available .");
                        return;
                    }
                } else {
                    System.out.println("\nInvalid seat number");
                }
            } else {
                System.out.println("\nInvalid row..");
            }
        }
    }

    /**
     * Find the first available seat
     */
    public static void find_first_available() {
        for (int i = 0; i < seat_plan.length; i++) {
            for (int j = 0; j < seat_plan[i].length; j++) {
                if (seat_plan[i][j] == 0) {
                    System.out.println("\nFirst available seat is row = " + (i + 1) + ", seat number = " + (j+1));
                    return;
                }
            }
            System.out.println();
        }
    }

    /**
     *     Print ticket information and the total price of all sold tickets
     */

    public static void print_tickets_info() {
        int total = 0;
        System.out.println("\nPrint ticket information");
        for (int i = 0; i < seat_plan.length; i++) {
            for (int j = 0; j < seat_plan[i].length; j++) {
                if (detail_tracker[i][j] != null) {
                    detail_tracker[i][j].printTicket();
                    if (i == 0) {
                        total = total + 12;
                    } else if (i == 1) {
                        total = total + 10;
                    } else if (i == 2) {
                        total = total + 8;
                    }
                }
            }
        }
        System.out.println("\nTickets total price: £" + total);
    }


    /**
     * Search for a ticket based on the seat number
     * @param input
     */
    public static void search_ticket(Scanner input) {
        while (true) {
            System.out.print("\nEnter row you want :");
            int row;
            while (true) {
                try {
                    row = input.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number between 1 and 3: ");
                    input.nextLine(); // Clear invalid input
                }
            }
            if (row <= 3 && row > 0) {
                System.out.print("Enter seat number you number :");
                int seat_number;
                while (true) {
                    try {
                        seat_number = input.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a number between 1 and 16: ");
                        input.nextLine();
                    }
                }
                if (seat_number <= 16 && seat_number > 0) {
                    if (seat_plan[row - 1][seat_number - 1] == 1) {
                        System.out.println();
                        System.out.println("user information");
                        System.out.println();
                        detail_tracker[row-1][seat_number-1].printTicket();
                        System.out.println();
                        System.out.println("\nSorry The seat is already booked,Try another seat");
                        return;
                    } else {
                        System.out.println("\nSeat is available .");
                        return;
                    }
                } else {
                    System.out.println("\nInvalid seat number");
                }
            } else {
                System.out.println("\nInvalid row..");
            }
        }
    }

    /**
     * Sort and print tickets by price
     */

    public static void sort_tickets() {
        int totalTicketsSold = 0; // Counter for total tickets sold

        for (int j = 0; j < seat_plan[0].length; j++) {
            if (detail_tracker[2][j] != null) {
                detail_tracker[2][j].printTicket();
                totalTicketsSold++;
            }
        }

        for (int j = 0; j < seat_plan[0].length; j++) {
            if (detail_tracker[1][j] != null) {
                detail_tracker[1][j].printTicket();
                totalTicketsSold++;
            }
        }

        for (int j = 0; j < seat_plan[0].length; j++) {
            if (detail_tracker[0][j] != null) {
                detail_tracker[0][j].printTicket();
                totalTicketsSold++;
            }
        }

        if (totalTicketsSold == 0) {
            System.out.println("\nThere are no tickets sold yet.");
        } else {
            System.out.println("\nTotal tickets sold: " + totalTicketsSold);
        }
    }

    /**
     * Determine ticket price based on the row
     * @param row
     * @return
     */
    public static int ticket_price(int row) {
        if (row == 0) {
            return 12;
        } else if (row == 1) {
            return 10;
        } else if (row == 2) {
            return 8;
        }
        return row;
    }
}
