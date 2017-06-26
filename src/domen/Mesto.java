/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Milan
 */
public class Mesto implements Serializable, OpstiDomenskiObjekat {

    private int ptt;
    private String naziv;

    public Mesto() {
    }

    public Mesto(int ptt) {
        this.ptt = ptt;
    }

    public Mesto(int ptt, String naziv) {
        this.ptt = ptt;
        this.naziv = naziv;
    }

    public int getPtt() {
        return ptt;
    }

    public void setPtt(int ptt) {
        this.ptt = ptt;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return getNaziv();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.ptt;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mesto other = (Mesto) obj;
        return this.ptt == other.ptt;
    }

    @Override
    public String vratiNazivTabele() {
        return "mesto";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return this.ptt + "'" + this.naziv + "'";
    }

    @Override
    public List napuni(ResultSet rs) throws Exception {
        try {
            List<OpstiDomenskiObjekat> lm = new LinkedList<>();
            while (rs.next()) {
                int lptt = rs.getInt("ptt");
                String lnaziv = rs.getString("nazivMesta");
                Mesto m = new Mesto(lptt, lnaziv);
                lm.add(m);
            }
            rs.close();
            return lm;
        } catch (SQLException ex) {
            throw new Exception("Neuspesno ucitavanje mesta!", ex);
        }
    }

    @Override
    public String vratiUslovSaIdentifikatorom() {
        return "WHERE ptt = " + this.ptt;
    }

    @Override
    public String vratiIdentifikator() {
        return "ptt";
    }

    @Override
    public Object get(String nazivAtributa) {
        switch (nazivAtributa) {
            case "ptt":
                return ptt;
            case "nazivMesta":
                return naziv;
            default:
                return "greska";
        }
    }

    @Override
    public void set(String nazivAtributa, Object vrednostAtributa) {
        switch (nazivAtributa) {
            case "ptt":
                setPtt((int) vrednostAtributa);
                break;
            case "nazivMesta":
                setNaziv((String) vrednostAtributa);
                break;
        }
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "ptt = " + ptt + ", nazivMesta = '" + naziv + "'";
    }

    @Override
    public String vratiTabeluSaUslovomSpajanja() {
        return "";
    }

}
