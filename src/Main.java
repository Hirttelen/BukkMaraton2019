import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<versenyzo> emberek = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader("bukkm2019.txt"));
            reader.readLine();
            String Sor;
            while ((Sor = reader.readLine()) != null) {
                String[] sor = Sor.split(";");
                versenyzo versenyzo = new versenyzo();
                versenyzo.rajtszam = sor[0];
                versenyzo.kategoria = sor[1];
                versenyzo.nev = sor[2];
                versenyzo.egyesulet = sor[3];
                versenyzo.ido = sor[4];
                emberek.add(versenyzo);
            }

        } catch (IOException e) {
            e.printStackTrace();}
    }
}
