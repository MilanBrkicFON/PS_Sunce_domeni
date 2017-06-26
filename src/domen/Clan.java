/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Milan
 */
public class Clan implements Serializable, OpstiDomenskiObjekat {

    private int clanID;
    private String ime;
    private String prezime;
    private String imeRoditelja;
    private char pol;

    private LocalDate datumRodjenja;
    private int godinaUpisa;

    private Mesto mesto;

    private boolean promenjen = false;

    public Clan() {
    }

    public boolean isPromenjen() {
        return promenjen;
    }

    public void setPromenjen(boolean promenjen) {
        this.promenjen = promenjen;
    }

    public Clan(int clanID) {
        this.clanID = clanID;
    }

    public Clan(String ime, String prezime, String imeRoditelja, char pol, LocalDate datumRodjenja, int godinaUpisa, Mesto mesto) {

        this.ime = ime;
        this.prezime = prezime;
        this.imeRoditelja = imeRoditelja;
        this.pol = pol;
        this.datumRodjenja = datumRodjenja;
        this.godinaUpisa = godinaUpisa;
        this.mesto = mesto;
    }

    public Clan(int clanID, String ime, String prezime, String imeRoditelja, char pol, LocalDate datumRodjenja, int godinaUpisa, Mesto mesto) {
        this(ime, prezime, imeRoditelja, pol, datumRodjenja, godinaUpisa, mesto);
        this.clanID = clanID;
    }

    @Override
    public String toString() {
        return clanID + " " + ime + " " + prezime + " " + pol;
    }

    public int getClanID() {
        return clanID;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.clanID;
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
        final Clan other = (Clan) obj;
        return this.ime.equals(other.ime) && this.prezime.equals(other.prezime) && this.imeRoditelja.equals(other.imeRoditelja)
                && this.datumRodjenja.equals(other.datumRodjenja) && this.mesto.equals(other.mesto);
    }

    public void setClanID(int clanID) {
        this.clanID = clanID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getImeRoditelja() {
        return imeRoditelja;
    }

    public void setImeRoditelja(String imeRoditelja) {
        this.imeRoditelja = imeRoditelja;
    }

    public char getPol() {
        return pol;
    }

    public void setPol(char pol) {
        this.pol = pol;
    }

    public LocalDate getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(LocalDate datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public int getGodinaUpisa() {
        return godinaUpisa;
    }

    public void setGodinaUpisa(int godinaUpisa) {
        this.godinaUpisa = godinaUpisa;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    public String getAttributes() {
        return clanID + " " + ime + " " + prezime + " " + datumRodjenja + " " + godinaUpisa + " " + getMesto().getNaziv();
    }

    @Override
    public String vratiNazivTabele() {
        return "clan";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return " (imeClana, prezimeClana, imeRoditelja, datumRodjenjaClana, pol,godinaUpisa, ptt) VALUES("+String.format("'%s','%s','%s','%s','%s',%s,%s", ime, prezime, imeRoditelja, datumRodjenja, String.valueOf(pol), godinaUpisa, mesto.getPtt());
    }

    @Override
    public List napuni(ResultSet rs) throws Exception {
        try {
            List<Clan> clanovi = new ArrayList<>();
            while (rs.next()) {
                int clanId = rs.getInt("clanId");
                String ime = rs.getString("imeClana");
                String prezime = rs.getString("prezimeClana");
                String imeRod = rs.getString("imeRoditelja");
                LocalDate date = rs.getDate("datumRodjenjaClana").toLocalDate();
                char pol = rs.getString("pol").charAt(0);
                int godinaUpisa = rs.getInt("godinaUpisa");

                Mesto m = new Mesto();
                m.setPtt(rs.getInt("ptt"));
                m.setNaziv(rs.getString("nazivMesta"));

                Clan c = new Clan(clanId, ime, prezime, imeRod, pol, date, godinaUpisa, m);
                clanovi.add(c);

            }
            rs.close();
            return clanovi;
        } catch (SQLException ex) {
            throw new Exception("Neuspesno ucitavanje clanova!", ex);
        }
    }

    @Override
    public String vratiUslovSaIdentifikatorom() {
        return "WHERE clanid = " + this.clanID;
    }

    @Override
    public String vratiIdentifikator() {
        return "clanId";
    }

    @Override
    public Object get(String nazivAtributa) {
        switch (nazivAtributa) {
            case "clanId": {
                return clanID;
            }
            case "ime": {
                return ime;
            }
            case "prezime": {
                return clanID;
            }
            case "imeRoditelja": {
                return imeRoditelja;
            }
            case "datumRodjenja": {
                return datumRodjenja;
            }
            case "pol": {
                return pol;
            }
            case "godinaUpisa": {
                return godinaUpisa;
            }
            case "mestoId": {
                return mesto.getPtt();
            }
            default:
                return "greska";
        }
    }

    @Override
    public void set(String nazivAtributa, Object vrednostAtributa) {
        switch (nazivAtributa) {
            case "clanId": {
                setClanID((int) vrednostAtributa);
                break;
            }
            case "ime": {
                setIme((String) vrednostAtributa);
                break;
            }
            case "prezime": {
                setPrezime((String) vrednostAtributa);
                break;
            }
            case "imeRoditelja": {
                setImeRoditelja((String) vrednostAtributa);
                break;
            }
            case "datumRodjenja": {
                setDatumRodjenja((LocalDate) vrednostAtributa);
                break;
            }
            case "pol": {
                setPol((char) vrednostAtributa);
                break;
            }
            case "godinaUpisa": {
                setGodinaUpisa((int) vrednostAtributa);
                break;
            }
            case "mestoId": {
                setMesto((Mesto) vrednostAtributa);
                break;
            }

        }
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "imeClana = '"
                + this.ime + "', prezimeClana = '"
                + this.prezime + "', imeRoditelja = '"
                + this.imeRoditelja + "', datumRodjenjaClana = '"
                + this.datumRodjenja + "', pol = '"
                + this.pol + "', godinaUpisa = "
                + this.godinaUpisa + ", ptt = "
                + this.mesto.getPtt();
    }

    @Override
    public String vratiTabeluSaUslovomSpajanja() {
        return " JOIN mesto ON (clan.ptt = mesto.ptt)";
    }
}
