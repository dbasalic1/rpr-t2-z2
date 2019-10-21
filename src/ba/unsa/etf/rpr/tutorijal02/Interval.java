package ba.unsa.etf.rpr.tutorijal02;

public class Interval {

    private double pocetna, krajnja;
    boolean poc, kraj;

    public Interval() {
        pocetna = 0;
        krajnja = 0;
        poc = false;
        kraj = false;
    }
    public Interval(double pocetna, double krajnja, boolean poc, boolean kraj) {
        if(pocetna > krajnja) throw new IllegalArgumentException();
        this.pocetna = pocetna;
        this.krajnja = krajnja;
        this.poc = poc;
        this.kraj = kraj;
    }

    public Interval intersect(Interval i) {
        Interval x = new Interval();
        if(i.isIn(this.pocetna) && i.isIn(this.krajnja)) x = this;
        if(this.isIn(i.pocetna) && this.isIn(i.krajnja)) x = i;
        if(this.pocetna < i.pocetna && (this.krajnja < i.krajnja && this.krajnja > i.pocetna)) x = new Interval(i.pocetna, this.krajnja, i.poc, this.kraj);
        if((this.pocetna > i.pocetna && this.pocetna < i.krajnja) && this.krajnja > i.krajnja) x = new Interval(this.pocetna, i.krajnja, this.poc, i.kraj);
        return x;
    }

    public static Interval intersect(Interval i, Interval i2) {
        Interval x = new Interval();
        if(i2.isIn(i.pocetna) && i2.isIn(i.krajnja)) x = i;
        if(i.isIn(i2.pocetna) && i.isIn(i2.krajnja)) x = i2;
        if(i.pocetna < i2.pocetna && (i.krajnja < i2.krajnja && i.krajnja > i2.pocetna)) x = new Interval(i2.pocetna, i.krajnja, i2.poc, i.kraj);
        if((i.pocetna > i2.pocetna && i.pocetna < i2.krajnja) && i.krajnja > i2.krajnja) x = new Interval(i.pocetna, i2.krajnja, i.poc, i2.kraj);
        return x;
    }

    public boolean isIn(double v) {
        if((v > pocetna && v < krajnja) || (v == this.pocetna && this.poc == true) || (v == this.krajnja && this.kraj == true)) return true;
        else return false;
    }

    public boolean isNull() {
        if(pocetna == 0 && krajnja == 0 && poc == false && kraj == false) return true;
        else return false;
    }

    @Override
    public String toString() {
        String s = new String();
        if(!this.isNull()) {
            if (poc == true) s += "[";
            else s += "(";
            s += pocetna + "," + krajnja;
            if (kraj == true) s += "]";
            else s += ")";
            return s;
        }
        else return "()";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Interval) {
            if(((Interval) obj).pocetna == this.pocetna && ((Interval) obj).krajnja == this.krajnja && ((Interval) obj).poc == this.poc && ((Interval) obj).kraj == this.kraj) return true;
            else return false;
        }
        else return false;
    }
}
