/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Milan
 */
public class TT implements OpstiDomenskiObjekat {

    private Trener trener;
    private Trening trening;

    public TT(Trener trener, Trening trening) {
        this.trener = trener;
        this.trening = trening;
    }

    public Trener getTrener() {
        return trener;
    }

    public void setTrener(Trener trener) {
        this.trener = trener;
    }

    public Trening getTrening() {
        return trening;
    }

    public void setTrening(Trening trening) {
        this.trening = trening;
    }

    @Override
    public String vratiNazivTabele() {
        return "tt";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return " VALUES("+trener.getTrenerID()+ ", " + trening.getTreningId();
    }

    @Override
    public List napuni(ResultSet rs) throws Exception {
        return null;
    }

    @Override
    public String vratiUslovSaIdentifikatorom() {
        return "WHERE trenerId = " + trener.getTrenerID();
    }

    @Override
    public String vratiIdentifikator() {
        return "trenerId";
    }

    @Override
    public Object get(String nazivAtributa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void set(String nazivAtributa, Object vrednostAtributa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiTabeluSaUslovomSpajanja() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
