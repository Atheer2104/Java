package klasslista;

import java.util.*;
import javax.swing.*;
import java.io.*;

public class Elevregister implements Serializable {
    private HashMap<String, Elev> elever = new HashMap<String,Elev>();
    
    public void addElev(Elev e) {
        elever.put(e.getPnr(), e);
    }
    
    public Elev findElev(String pnr) {
        return elever.get(pnr);
  
    }
    
    
}

//private Elev[] elever = new Elev[32];
//private ArrayList<Elev> elever = new ArrayList<Elev>();
//private int counter = 0;

/*String pnr = e.getPnr();
Elev tmp = findElev(pnr);
if (tmp == null) {
    elever.add(e);
}else {
    JOptionPane.showMessageDialog(null, "Eleven finns redan");
}*/


/*for (int i = 0; i < elever.size(); i++) {
Elev tmp = elever.get(i);
if (tmp != null) {
    if (tmp.getPnr().equals(pnr)) {
        return tmp;
    }
}
}
return null;*/
