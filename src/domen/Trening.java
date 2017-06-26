/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Milan
 */
public class Trening implements Serializable, OpstiDomenskiObjekat {

    private int treningId;

    private List<Clan> clanovi;

    private List<Trener> treneri;

    private LocalTime vremeOd;

    private LocalTime vremeDo;

    private LocalDate datum;

    public Trening() {
    }

    public Trening(LocalTime vremeOd, LocalTime vremeDo, LocalDate datum) {
        this.vremeOd = vremeOd;
        this.vremeDo = vremeDo;
        this.datum = datum;
        clanovi = new ArrayList<>();
        treneri = new ArrayList<>();

    }

    @Override
    public String toString() {
        return "Trening{" + treningId + ":" + "vremeOd=" + vremeOd + ", vremeDo=" + vremeDo + ", datum=" + datum + '}';
    }

    public int getTreningId() {
        return treningId;
    }

    public void setTreningId(int treningId) {
        this.treningId = treningId;
    }

    public List<Clan> getClanovi() {
        return clanovi;
    }

    public void setClanovi(List<Clan> clanovi) {
        this.clanovi = clanovi;
    }

    public List<Trener> getTreneri() {
        return treneri;
    }

    public void setTreneri(List<Trener> treneri) {
        this.treneri = treneri;
    }

    public LocalTime getVremeOd() {
        return vremeOd;
    }

    public void setVremeOd(LocalTime vremeOd) {
        this.vremeOd = vremeOd;
    }

    public LocalTime getVremeDo() {
        return vremeDo;
    }

    public void setVremeDo(LocalTime vremeDo) {
        this.vremeDo = vremeDo;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
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
        final Trening other = (Trening) obj;
        if (this.treningId != other.treningId) {
            return false;
        }
        return true;
    }

    @Override
    public String vratiNazivTabele() {
        return "trening";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return " (datum, vremeOd, vremeDo) VALUES('" + datum + "'" + ",'" + vremeOd + "','" + vremeDo + "'";
    }

    @Override
    public List napuni(ResultSet rs) throws Exception {
        List<Trening> treninzi = new ArrayList<>();
        while (rs.next()) {
            int trId = rs.getInt("treningId");
            LocalDate d = rs.getDate("datum").toLocalDate();
            LocalTime vOd = rs.getTime("vremeOd").toLocalTime();
            LocalTime vDo = rs.getTime("vremeDo").toLocalTime();
            Trening t = new Trening(vOd, vDo, d);
            t.setTreningId(trId);
            int clanId = rs.getInt("clanId");
            Clan c = new Clan();
            if (clanId != 0) {
                c = new Clan(clanId, rs.getString("imeClana"), rs.getString("PrezimeClana"), rs.getString("imeRoditelja"), rs.getString("pol").charAt(0), rs.getDate("datumRodjenjaClana").toLocalDate(), rs.getInt("godinaUpisa"),
                        new Mesto(rs.getInt("ptt"), rs.getString("nazivMesta")));
            }
            int treId = rs.getInt("trenerId");
            Trener trener = new Trener(treId);
            if (treId != 0) {
                trener = new Trener(treId, rs.getString("imeTrenera"), rs.getString("PrezimeTrenera"), rs.getDate("datumRodjenjaTrenera").toLocalDate(), rs.getInt("godinerada"), rs.getString("kratakCV"),
                        new Sport(rs.getInt("sportId"), rs.getString("nazivSporta"), rs.getInt("maxBrClanova")));
            }
            if (!treninzi.contains(t)) {
                treninzi.add(t);
                if (clanId != 0 && !t.getClanovi().contains(c)) {
                    t.getClanovi().add(c);
                }
                if (treId != 0 && !t.getTreneri().contains(trener)) {
                    t.getTreneri().add(trener);
                }
            } else {
                if (clanId != 0 && !t.getClanovi().contains(c)) {
                    treninzi.get(treninzi.indexOf(t)).getClanovi().add(c);
                }
                if (treId != 0 && !t.getTreneri().contains(trener)) {
                    treninzi.get(treninzi.indexOf(t)).getTreneri().add(trener);
                }
            }

        }
        rs.close();
        return treninzi;
    }

    @Override
    public String vratiUslovSaIdentifikatorom() {
        return "WHERE treningId = " + treningId;
    }

    @Override
    public String vratiIdentifikator() {
        return "treningId";
    }

    @Override
    public Object get(String nazivAtributa) {
        switch (nazivAtributa) {
            case "datum": {
                return datum;
            }
            case "vremeOd": {
                return vremeOd;
            }
            case "vremeDo": {
                return vremeDo;
            }
            case "clanovi": {
                return clanovi;
            }
            case "treneri": {
                return treneri;
            }
            default:
                return "greska";
        }
    }

    @Override
    public void set(String nazivAtributa, Object vrednostAtributa) {
        switch (nazivAtributa) {
            case "datum": {
                setDatum((LocalDate) vrednostAtributa);
                break;
            }
            case "vremeOd": {
                setVremeOd((LocalTime) vrednostAtributa);
                break;
            }
            case "vremeDo": {
                setVremeDo((LocalTime) vrednostAtributa);
                break;
            }
            case "clanovi": {
                setClanovi((List<Clan>) vrednostAtributa);
                break;
            }
            case "treneri": {
                setTreneri((List<Trener>) vrednostAtributa);
                break;
            }
        }
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "datum='" + datum + "', vremeOd='" + vremeOd + "'";
    }

    @Override
    public String vratiTabeluSaUslovomSpajanja() {
        return "LEFT JOIN tclan USING(treningId) LEFT JOIN clan USING(clanId) LEFT JOIN mesto USING(ptt) "
                + "LEFT JOIN tt USING(treningId) LEFT JOIN trener USING(trenerId) LEFT JOIN sport USING(sportId)";
    }

}
