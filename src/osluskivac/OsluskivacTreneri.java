/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osluskivac;

import domen.Trener;
import java.io.Serializable;

/**
 *
 * @author Milan
 */
public interface OsluskivacTreneri extends Serializable{
    public void oDodajTrenera(Trener trener);

    public void oObrisiTrenera(Trener trener);
}
