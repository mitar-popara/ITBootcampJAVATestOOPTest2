package mitarPopara;

import java.util.ArrayList;
import java.util.Collections;

public class PlaninarskoDrustvo {
    private ArrayList<Planinar> planinari;

    public PlaninarskoDrustvo(ArrayList<Planinar> planinari) {
        this.planinari = planinari;
    }

    public ArrayList<Planinar> getPlaninari() {
        return planinari;
    }

    public void setPlaninari(ArrayList<Planinar> planinari) {
        this.planinari = planinari;
    }

    @Override
    public String toString() {
        return "PlaninarskoDrustvo{" +
                "planinari=" + planinari +
                '}';
    }

    public void izbaciPlaninara(int id) {
        /**izbacuje planinara iz liste planinari po id*/
        int id2 = 0;
        for (int i = 0; i < planinari.size(); i ++){
            if (planinari.get(i).getId() == id){
                id2 = i;
            }
        }
        planinari.remove(id2);


    }

    public int najuspesnijiPlaninar() {
        /**vraća id planinara iz liste planinari koji je prešao najviše metara penjući se na
         planine ili 0 ako je lista planinara prazna. Ukoliko dva ili više planinara dele
         mesto najuspešnijeg, vratiti bilo kojeg od njih.*/
        double najviseMetara = 0;
        int id = 0;
        for (Planinar p : planinari) {
            double presao = 0;
            for (int i = 0; i < p.getPlanine().size(); i++) {
                presao = presao + p.getPlanine().get(i).getVisina();
            }
            if (najviseMetara < presao) {
                najviseMetara = presao;
                id = p.getId();
            }
        }
        return id;
    }

    public double prosecnaClanarinaPlaninara() {
        /**vratiti prosečnu članarinu svih planinara u listi planinari*/
        double suma = 0;
        for (Planinar p : planinari) {
            suma = suma + p.clanarina();
        }
        return suma / planinari.size();
    }

    public boolean popniSeNaPlaninu(Planina planina) {
        /**proveriti da li tim planinara iz liste planinari moze da se popnu na zadatu
         planinu. Uslovi su da lista bude neprazna, da je u njoj barem 1 alpinista sa
         više od 5 godina iskustva i da barem 2/3 planinara može da se popne na
         planinu. Da bismo videli da li planinar može da se popne, iskoristiti metodu
         uspesanUspon(Planina planina)*/
        boolean boo = false;
        int brojac = 0;
        if (getPlaninari().size() > 0) {
            for (Planinar p : planinari) {
                if (p instanceof Alpinista && ((Alpinista) p).getGodineIskustva() > 5) {
                    boo = true;

                }
                if(p.uspesanUspon(planina) == true){
                    brojac++;
                }
            }
        }
        if (boo = true && brojac >= (planinari.size()*2/3)){
            return true;
        }
        else {
            return false;
        }
    }

    public void sortPlaninariPoClanarini() {
        /**sortirati listu planinari po članarini i to pocev od planinara sa najvećom
         članarinom do planinara sa najmanjom članarinom.*/
        Collections.sort(planinari);

    }

    public static void main(String[] args) {


        Planina kopaonik = new Planina("kopaonik", 1980);
        Planina staraPlanina = new Planina("staraPlanina", 2010);
        Planina medvednik = new Planina("medvednik", 980);
        Planina rtanj = new Planina("rtanj", 1800);
        Planina suvaPlanina = new Planina("suvaPlanina", 2050);

        ArrayList<Planina> osvojenePlanine1 = new ArrayList<>();
        osvojenePlanine1.add(kopaonik);
        osvojenePlanine1.add(staraPlanina);
        osvojenePlanine1.add(medvednik);
        osvojenePlanine1.add(rtanj);
        osvojenePlanine1.add(suvaPlanina);

        ArrayList<Planina> osvojenePlanine2 = new ArrayList<>();
        osvojenePlanine2.add(medvednik);
        osvojenePlanine2.add(rtanj);
        osvojenePlanine2.add(suvaPlanina);

        ArrayList<Planina> osvojenePlanine3 = new ArrayList<>();
        osvojenePlanine3.add(medvednik);




        Planinar alpinista1 = new Alpinista(1, "Petar", "Petrovic",osvojenePlanine1,
                2050, 5);
        Planinar rekreativac1 = new Rekreativac(2,"Marko", "Markovic", osvojenePlanine2,
                1800, 20);
        Planinar rekreativac2 = new Rekreativac(2,"Marko2", "Markovic2", osvojenePlanine3,
                1800, 10);

        ArrayList<Planinar> p1 = new ArrayList<>();
        p1.add(alpinista1);
        p1.add(rekreativac1);
        p1.add(rekreativac2);

        PlaninarskoDrustvo drustvo = new PlaninarskoDrustvo(p1);
        drustvo.najuspesnijiPlaninar();
        System.out.println("najuspesnijiPlaninar " + drustvo.najuspesnijiPlaninar());
        drustvo.popniSeNaPlaninu(kopaonik);
        System.out.println("popniSeNaPlaninu " + drustvo.popniSeNaPlaninu(medvednik));
        drustvo.prosecnaClanarinaPlaninara();
        System.out.println("prosecnaClanarinaPlaninara " + drustvo.prosecnaClanarinaPlaninara());
        drustvo.sortPlaninariPoClanarini();
        System.out.println("sortPlaninariPoClanarini " + drustvo.toString());


        drustvo.izbaciPlaninara(2);

        System.out.println(drustvo.toString());







    }
}

