public class Ticket {
    // Private member variables for storing ticket details
    private int row;
    private int seat;
    private int price;
    private Person person;

    /**
     * Constructor to initialize the ticket details
     * @param row
     * @param seat
     * @param price
     * @param person
     */
    public Ticket(int row, int seat, int price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    /**
     * Method to print the ticket details
     */
    public void printTicket() {
        System.out.println("\nRow : " + row);
        System.out.println("Seat: " + seat);
        System.out.println("Price : £" + price);
        person.print_information();
    }

    /**
     * Getter method for row
     * @return
     */
    public int getRow() {
        return row;
    }

    /**
     * Setter method for row
     * @param row
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     *  Getter method for seat
     * @return
     */
    public int getSeat() {
        return seat;
    }

    /**
     * Setter method for seat
     * @param seat
     */
    public void setSeat(int seat) {
        this.seat = seat;
    }

    /**
     *  Getter method for price
     * @return
     */
    public int getPrice() {
        return price;
    }

    /**
     * Setter method for price
     * @param price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Getter method for person
     * @return
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Setter method for person
     * @param person
     */
    public void setPerson(Person person) {
        this.person = person;
    }
}
