package klasslista;

import java.io.*;

public class Elev implements Serializable {
    private String name, mob, pnr;
    
    //konstuktor samma namn som klassen saknar returtyp körs bara en gång per objekt
    public Elev(String pnr, String name, String mob) {
        this.name = name;
        this.mob = mob;
        this.pnr = pnr;
    }
    
    public void setName(String theName) {
        name = theName;
    }
    
    public String getName() {
        return name;
    }
    
    public void setMob(String theMob) {
        mob = theMob;
    }
    
    public String getMob() {
        return mob;
    }
    
    public String getPnr() {
        return pnr;
    }
    
}
