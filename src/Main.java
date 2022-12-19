import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
            //-------------------------------------------------------------------

            System.out.print("4. feladat: ");
            System.out.print("A versenytávot nem teljesítők: ");
            double kivont = 691 - emberek.size();
            double osszesen = kivont / emberek.size();
            System.out.println(osszesen * 100 + "%");
            //----------------------------------------------------------------------

            System.out.print("5. feladat: ");
            int szamlalo = 0;
            for (versenyzo i : emberek) {
                Versenytav t = new Versenytav(i.rajtszam);
                char utolso = i.kategoria.charAt(i.kategoria.length() - 1);
                if (utolso == 'n' && Objects.equals(t.getTav(), "Rövid")) {
                    szamlalo++;
                }
            }
            System.out.println("A női versenyzők száma rövid távon: " + szamlalo + "fő");
            //------------------------------------------------------------------------------

            System.out.print("6. feladat: ");
            boolean bool = false;
            for (versenyzo a:emberek)
            {
                String[] sor = a.ido.split(":");
                int o = Integer.parseInt(sor[0]);
                if (o >= 6)
                {
                    bool = true;
                }
            }
            if (bool)
            {
                System.out.println("Volt ilyen versenyző");
            }
            else
            {
                System.out.println("Nem volt ilyen versenyző");
            }
            //-----------------------------------------------------------------------

        } catch (IOException e) {
            e.printStackTrace();}
    }
}
