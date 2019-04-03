package util;

public class ParOrdenado {
    private String m1, m2;
    private boolean checked;

    public ParOrdenado(String m1, String m2) {
        this.m1 = m1;
        this.m2 = m2;
        this.checked = false;
    }

    public String getM1() {
        return m1;
    }

    public void setM1(String m1) {
        this.m1 = m1;
    }

    public String getM2() {
        return m2;
    }

    public void setM2(String m2) {
        this.m2 = m2;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
    
    
    
    public boolean compararPar(ParOrdenado par){
        boolean comp = false;
        if(this.m1.equals(par.getM1()) && this.m2.equals(par.getM2()))
            comp = true;
        return comp;
    }
    
    @Override
    public String toString(){
        return "("+m1+", "+m2+"')";
    }
}
