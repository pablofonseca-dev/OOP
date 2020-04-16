package cr.ac.ucenfotec;

import cr.ac.ucenfotec.BL.Tiquete;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    public static void main(String[] args) {


        ArrayList<Tiquete> tiquetes = new ArrayList<>();

        Tiquete t = new Tiquete(150000, "2F", "125A-2");
        tiquetes.add(t);
        t = new Tiquete(50000000, "3F", "AA-2");
        tiquetes.add(t);
        for(Tiquete e: tiquetes){
            out.println(e.toString());
        }

    }
}
