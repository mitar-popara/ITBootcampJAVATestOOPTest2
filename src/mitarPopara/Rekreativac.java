package mitarPopara;

import java.util.ArrayList;

public class Rekreativac extends Planinar{
    private double tezinaOpreme;

    public Rekreativac(int id, String ime, String prezime, ArrayList<Planina> planine, double maxUspon, double tezinaOpreme) {
        super(id, ime, prezime, planine, maxUspon);
        this.tezinaOpreme = tezinaOpreme;
    }


    @Override
    public String toString() {
        return "\n Rekreativac{" + super.toString() +
                "tezinaOpreme=" + tezinaOpreme +
                '}';
    }

    public double getTezinaOpreme() {
        return tezinaOpreme;
    }

    public void setTezinaOpreme(double tezinaOpreme) {
        this.tezinaOpreme = tezinaOpreme;
    }

    @Override
    public boolean uspesanUspon(Planina p) {
        /**Implementiraj metodu uspesanUspon tako da vraća true i
         * dodaje planinu u listu planine ukoliko je maxUspon* veci ili jednak* vrednosti
         polja visina Planine, uz to da svaki kilogram opreme
         umanjuje maxUspon za 50, a inače vraca false i ne
         dodaje planinu u listu.*/
        double visina = p.getVisina();
        for (int i = 0; i < this.getTezinaOpreme(); i++){
            visina = visina-50;
        }
        if (this.getMaxUspon()>=visina){
            return true;
        }
        else {
            return false;
        }


    }

    @Override
    public double clanarina() {
        /**Implementiraj metodu clanarina tako da vraća fiksnu
         vrednost od 1000 umanjenu za 2% za svaku planinu u listi planine.*/
        int pocetnaClanarina = 1000;
        int clanarina = 1000;
        for (int i = 0; i < this.getPlanine().size(); i++){
            clanarina -= pocetnaClanarina*0.02;
        }
        return clanarina;
    }

    @Override
    public int compareTo(Planinar o) {
        return super.compareTo(o);

    }


}
