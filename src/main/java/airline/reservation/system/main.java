package airline.reservation.system;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.function.Supplier;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class main {
    public static void main(String args[]) {
        long start = System.nanoTime();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter date(Enter blank to search by airport): ");
        String date = sc.next();
        System.out.println("Enter Source Airport: ");
        String source = sc.next();
        System.out.println("Enter Destination Airport: ");
        String destination = sc.next();
        String file = "/home/lentraadmin/IdeaProjects/Airline Reservation/src/Flight Management Sheet - Sheet1.csv";
        BufferedReader reader = null;
        String line = "";
        List<String> list = new ArrayList<String>();
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                String[] print = line.split(",\n");
                String str1 = row[0];
                String str2 = row[1];
                String str3 = row[2];
                String str4 = print[0];
                String check1 = date;
                String check2 = source;
                String check3 = destination;
                if (str1.equals(check1) || check1.equals("blank")) {
                    if (str2.equals(check2)) {
                        if (str3.equals(check3)) {
                            list.add(str4);
                            //System.out.println("The details are: "+str4);
                        }
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        //Flight flight;
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            String[] list2 = s.split(",");
            System.out.println("Option: " + (i + 1));
            System.out.println("The date of flight is: " + list2[0]);
            System.out.println("The source airport details are: " + list2[1]);
            System.out.println("The destination details are: " + list2[2]);
            System.out.println("The departure time is: " + list2[3]);
            System.out.println("The arrival time is: " + list2[4]);
            System.out.println("The flight number is: " + list2[5]);
            //flight = new Flight(list2[1],list2[2],list2[3],list2[4], list2[5]);
        }
        Scanner sca = new Scanner(System.in);
        System.out.println("Enter Option number: ");
        int option = sca.nextInt();
        System.out.println("Select no of seats: ");
        int seats = sca.nextInt();
        System.out.println("You selected Option " + option + ". Please confirm(Y/N)");
        String strn = sca.next();
        if (strn.equals("Y")) {
            /*System.out.println("As per the instructions " + seats + " are booked in the flight with following details");
            System.out.println("Flight number " + flight.getFlight_number() + " departs at " + flight.getDeparture_time() + " from " + flight.getDeparture());
            System.out.println("The destination" + "(" + flight.getArrival() + ") will arrive at " + flight.getArrival_time()); */
            System.out.println("Booking confirmed for " + seats + " seats.SMS sent to your mobile number");
        } else {
            System.out.println("Booking failed");
        }
        long end = System.nanoTime();

        double durationInMilliseconds = 1.0 * (end - start) / 1000000;

        System.out.println("The code took " + durationInMilliseconds + " milliseconds.");
    }
}

