/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Milan
 */
public class Sport implements Serializable, OpstiDomenskiObjekat {

    private int sportID;
    private String naziv;
    private int maxBrClanova;

    public Sport() {
    }

    public Sport(int sportID) {
        this.sportID = sportID;
    }

    public Sport(int sportID, String naziv, int maxBrClanova) {
        this.sportID = sportID;
        this.naziv = naziv;
        this.maxBrClanova = maxBrClanova;
    }

    public int getSportID() {
        return sportID;
    }

    public void setSportID(int sportID) {
        this.sportID = sportID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getMaxBrClanova() {
        return maxBrClanova;
    }

    public void setMaxBrClanova(int maxBrClanova) {
        this.maxBrClanova = maxBrClanova;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Sport other = (Sport) obj;
        return this.sportID == other.sportID;
    }

    @Override
    public String vratiNazivTabele() {
        return "sport";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "'" + this.naziv + "'," + this.maxBrClanova;
    }

    @Override
    public List napuni(ResultSet rs) throws Exception {
        List<Sport> sport = new ArrayList<>();
        while (rs.next()) {
            Sport s = new Sport();
            s.setSportID(rs.getInt("sportId"));
            s.setNaziv(rs.getString("nazivSporta"));
            s.setMaxBrClanova(rs.getInt("maxBrClanova"));
            sport.add(s);
        }
        return sport;
    }

    @Override
    public String vratiUslovSaIdentifikatorom() {
        return "WHERE sportId = " + this.sportID;
    }

    @Override
    public String vratiIdentifikator() {
        return "sportID";
    }

    @Override
    public Object get(String nazivAtributa) {
        switch (nazivAtributa) {
            case "sportId": {
                return getSportID();
            }
            case "naziv": {
                return getNaziv();
            }
            case "maxBrClanova": {
                return getMaxBrClanova();
            }
            default:
                return "greska";
        }
    }

    @Override
    public void set(String nazivAtributa, Object vrednostAtributa) {
        switch (nazivAtributa) {
            case "sportId": {
                setSportID((int) vrednostAtributa);
                break;
            }
            case "naziv": {
                setNaziv((String) vrednostAtributa);
                break;
            }
            case "maxBrClanova": {
                setMaxBrClanova((int) vrednostAtributa);
                break;
            }

        }
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "";
    }

    @Override
    public String vratiTabeluSaUslovomSpajanja() {
        return "";
    }

}
