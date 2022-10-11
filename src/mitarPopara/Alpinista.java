package mitarPopara;

import java.util.ArrayList;

public class Alpinista extends Planinar{
    private int godineIskustva;

    public Alpinista(int id, String ime, String prezime, ArrayList<Planina> planine, double maxUspon, int godineIskustva) {
        super(id, ime, prezime, planine, maxUspon);
        this.godineIskustva = godineIskustva;
    }


    @Override
    public String toString() {
        return "\n Alpinista{" + super.toString() +
                "godineIskustva=" + godineIskustva +
                '}';
    }

    @Override
    public boolean uspesanUspon(Planina p) {
        /**Implementiraj metodu uspesanUspon tako da vraća
         true i dodaje planinu u listu planine ukoliko je
         mmaxUspon* veci ili jednak* vrednosti
         polja visina Planine, a inače vraca false i ne dodaje
         planinu u listu.*/


        if (this.getMaxUspon()>=p.getVisina()){

            return true;
        }
        else {
            return false;
        }


    }

    @Override
    public double clanarina() {
        /**Implementiraj metodu clanarina tako da vraća fiksnu
         vrednost od 1500 umanjenu za 5% za svaku planinu
         višu od 2000 metara u listi planine.*/

        int pocetnaClanarina = 1500;
        int clanarina = 1500;
        for (int i = 0; i < this.getPlanine().size(); i++) {
            if (this.getPlanine().get(i).getVisina() > 2000) {
                clanarina -= pocetnaClanarina * 0.05;
            }
        }
        return clanarina;
    }

    @Override
    public int compareTo(Planinar o) {
        return super.compareTo(o);
    }

    public int getGodineIskustva() {

        return godineIskustva;
    }

    public void setGodineIskustva(int godineIskustva) {
        this.godineIskustva = godineIskustva;
    }



}
