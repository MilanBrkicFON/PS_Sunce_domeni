/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import domen.Clan;
import domen.Korisnik;
import domen.Mesto;
import domen.Trener;
import domen.Trening;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Milan
 */
public class Kontroler {

    Session session;

    public static void main(String[] args) {
        Kontroler s  = new Kontroler();
//        Trening t = new Trening(LocalTime.of(20, 0, 0),LocalTime.of(22, 0, 0),LocalDate.now());
//        
//        
//        List<Clan> clanovi = new ArrayList<>();
//        clanovi.add(new Clan(1003));
//        clanovi.add(new Clan(1029));
//        clanovi.add(new Clan(1039));
//        
//        List<Trener> treneri = new ArrayList<>();
//        treneri.add(new Trener(1));
//        treneri.add(new Trener(2));
////        
//        t.setClanovi(clanovi);
//        t.setTreneri(treneri);
//        s.dodajTrening(t);
        
//        clanovi.add(new Clan(1036));
        
//        Mesto me = new Mesto(22000, "NOvo mesto");
//        s.kreirajIUbaciMesto(me);
//        System.out.println("Ubaceno mesto");
//        
//        List<Clan> clans = s.listClanovi();
//        System.out.println(clans);
        
        Korisnik k = new Korisnik("korisnik2", "korisnik2");
        k.setClan(new Clan(1004));
        s.ubaciKorisnika(k);
        
        Korisnik k1 = s.vratiKorisnika(k);
        System.out.println(k1);
        s.session.close();
    }


    public Kontroler() {
    }
    
    public void kreirajIUbaciMesto(Mesto m) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(m);
        session.getTransaction().commit();
    }

    public Korisnik vratiKorisnika(Korisnik k){
        String hql = "from Korisnik WHERE username = :username and password = :password";
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery(hql);
        query.setParameter("username", k.getUsername());
        query.setParameter("password", k.getPassword());

        Korisnik korisnik =(Korisnik) query.list().get(0);
        return korisnik;
    }
    
    public void ubaciKorisnika(Korisnik korisnik){
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(korisnik);
        session.getTransaction().commit();
    }
    public List listClanovi() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        TypedQuery<Clan> query;
        query = session.createQuery("from Clan");
        List lista = query.getResultList();
        session.getTransaction().commit();
        return lista;
    }

    private void dodajTrening(Trening t) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(t);
        session.getTransaction().commit();
    }

}
