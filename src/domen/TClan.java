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
public class TClan implements OpstiDomenskiObjekat{

    private Clan clan;
    private Trening trening;

    public TClan(Clan clan, Trening trening) {
        this.clan = clan;
        this.trening = trening;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public Trening getTrening() {
        return trening;
    }

    public void setTrening(Trening trening) {
        this.trening = trening;
    }

    @Override
    public String vratiNazivTabele() {
        return "tclan";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return  " VALUES("+clan.getClanID() + ", " + trening.getTreningId();
    }

    @Override
    public List napuni(ResultSet rs) throws Exception {
        return null;
    }

    @Override
    public String vratiUslovSaIdentifikatorom() {
        return "WHERE clanId = " + clan.getClanID();
    }

    @Override
    public String vratiIdentifikator() {
        return "clanId";
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
