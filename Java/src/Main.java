import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.IOException;
public class Main {
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static PrintStream out = System.out;

    public static void main(String[] arguments) throws IOException {

        String[] students;
        int[] scores;
        out.println("Cantidad de estudiantes:");

        int students_amount = Integer.parseInt(in.readLine());
        students = new String[students_amount];
        scores = new int[students_amount];

        int score;
        for(int index = 0; index < students.length; index++){
            out.println("Nombre del estudiante " + (index +1));
            String studentName = in.readLine();
            students[index] = studentName;
            out.println("Nota del estudiante " + studentName);
            int studentScore = Integer.parseInt(in.readLine());
            scores[index] = studentScore;
        }

        for(int index = 0; index < students.length; index++){
            out.println("La nota del estudiante " + students[index] + " es " +  scores[index]);
        }
        //Request user for array length

    }
}
