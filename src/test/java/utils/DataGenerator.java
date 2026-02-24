package utils;

import java.util.Random;
import java.util.UUID;

public class DataGenerator {

    static Random random = new Random();

    // Random First Name
    public static String getFirstName() {
        String[] firstNames = {"Liam", "Noah", "Emma", "Olivia", "Ava", "Sophia", "James", "Lucas"};
        return firstNames[random.nextInt(firstNames.length)];
    }

    // Random Last Name
    public static String getLastName() {
        String[] lastNames = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia"};
        return lastNames[random.nextInt(lastNames.length)];
    }

    // Random Email
    public static String getEmail() {
        return "testuser_" + UUID.randomUUID().toString().substring(0, 4) + "@mail.com";
    }

}
