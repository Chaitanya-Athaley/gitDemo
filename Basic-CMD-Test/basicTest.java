import java.io.BufferedReader;
import java.io.InputStreamReader;

public class basicTest {
    public static void main(String[] args) {
        try {
            Process process = Runtime.getRuntime().exec("git init");
            process.waitFor();
            System.out.println("Initialized a git repository");

            process = Runtime.getRuntime().exec("git add .");
            process.waitFor();
            System.out.println("Added all changes to be committed");

            process = Runtime.getRuntime().exec("git commit -m \"Initial commit\"");
            process.waitFor();
            System.out.println("Committed the changes");

            process = Runtime.getRuntime().exec("git log");
            process.waitFor();
            System.out.println("Committed logs:");

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}