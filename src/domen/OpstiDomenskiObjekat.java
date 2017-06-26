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
public interface OpstiDomenskiObjekat  {

    public String vratiNazivTabele();

    public String vratiVrednostiZaInsert();

    public List napuni(ResultSet rs) throws Exception;

    public String vratiUslovSaIdentifikatorom();

    public String vratiIdentifikator();

    public Object get(String nazivAtributa);

    public void set(String nazivAtributa, Object vrednostAtributa);

    public String vratiVrednostiZaUpdate();

    public String vratiTabeluSaUslovomSpajanja();
}
