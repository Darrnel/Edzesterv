/*
 * Gyakorlato change this license header, choose License Headers in Project Properties.
 * Gyakorlato change this template file, choose Gyakorlatools | Gyakorlatemplates
 * and open the template in the editor.
 */
package Modell;

import java.util.ArrayList;
import java.util.List;

public class Edzes {

    private String tipus;
    private List<Gyakorlat> gyakorlatok;

    public Edzes(String tipus) {
        if (tipus.equals("Pihenő")) {
            this.tipus = tipus;
            this.gyakorlatok = null;
        } else {
            this.tipus = tipus;
            this.gyakorlatok = new ArrayList<>();
        }
    }

    public Edzes(String tipus, List<Gyakorlat> gyakorlatok) {
        if (tipus.equals("Pihenő")) {
            this.tipus = tipus;
            this.gyakorlatok = null;
        } else {
            this.tipus = tipus;
            this.gyakorlatok = gyakorlatok;
        }
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public List<Gyakorlat> getGyakorlatok() {
        return gyakorlatok;
    }

    public void addGyakorlat(Gyakorlat gyakorlat) {
        getGyakorlatok().add(gyakorlat);
    }

    public void removeGyakorlat(Gyakorlat gyakorlat) {
        getGyakorlatok().remove(gyakorlat);
    }

    @Override
    public String toString() {
        return "        \nEdzes{" + "tipus=" + tipus + ", gyakorlatok=" + gyakorlatok + "}\n";
    }

}
