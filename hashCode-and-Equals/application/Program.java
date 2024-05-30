package application;

import entities.Client;

public class Program {
    public static void main(String[] args) {

        Client c1 = new Client("Maria", "maria@gmail.com");
        Client c2 = new Client("Maria", "alex@gmail.com");

        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());

        // This compares two objects by Content, creating a mixed hashCode
        System.out.println(c1.equals(c2));
        // This compares two objects by the Position in the memory
        System.out.println(c1 == c2);
    }
}
