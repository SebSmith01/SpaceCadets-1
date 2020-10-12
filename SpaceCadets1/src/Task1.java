import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) throws IOException {

        // finds the url of person from their initials
        Scanner scanner = new Scanner(System.in);
        String initials = scanner.nextLine();
        String urlString = "https://www.ecs.soton.ac.uk/people/"+initials;

        URL url = new URL(urlString);

        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        // reader allows us to go through the source code of the url website

        // skipping the first 7 lines in order to get to the 8th, where the name is stored
        String line;
        for (int i = 0; i < 7; i++) {
            reader.readLine();
        }
        // line = 8th line, where the name is stored.
        line = reader.readLine();

        int start = 11;
        int end = 0;

        // finds where the end of the name is
        for (int i=11; i<50; i++) {
            if (line.charAt(i) == '|') {
                end = i-1;
                break;
            }
        }

        // prints the name
        if (start != 0 && end != 0) {
            System.out.println(line.substring(start, end));
        }

    }
}