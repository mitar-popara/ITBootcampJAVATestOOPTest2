package mitarPopara;

import java.util.ArrayList;

public abstract class Planinar implements Comparable<Planinar>{
    private int id;
    private String ime, prezime;
    private ArrayList<Planina> planine;
    private double maxUspon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Planinar(int id, String ime, String prezime, ArrayList<Planina> planine, double maxUspon) {
        this.ime = ime;
        this.prezime = prezime;
        this.planine = planine;
        this.maxUspon = maxUspon;
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public ArrayList<Planina> getPlanine() {
        return planine;
    }

    public void setPlanine(ArrayList<Planina> planine) {
        this.planine = planine;
    }

    public double getMaxUspon() {
        return maxUspon;
    }

    public void setMaxUspon(double maxUspon) {
        this.maxUspon = maxUspon;
    }
    public int compareTo(Planinar o) {
        return Double.compare(o.clanarina(), this.clanarina());
    }

    @Override
    public String toString() {
        return "Planinar{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", planine=" + planine +
                ", maxUspon=" + maxUspon +
                '}';
    }

    public abstract boolean uspesanUspon(Planina p);

    public abstract double clanarina();



}


