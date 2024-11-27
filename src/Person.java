public class Person {

    // Private member variables for storing person's details
    private String name;
    private String surname;
    private String email;

    /**
     * Setter method for name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter method for surname
     * @param surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Setter method for email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter method for name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for surname
     * @return
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Getter method for email
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * Constructor to initialize the person's details
     * @param name
     * @param surname
     * @param email
     */
    public Person(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    /**
     * Method to print the person's information
     */
    public void print_information() {
        System.out.println("Name  : " + name);
        System.out.println("Surname : " + surname);
        System.out.println("Email : " + email);
    }
}

