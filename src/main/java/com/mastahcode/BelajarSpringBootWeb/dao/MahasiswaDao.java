package com.mastahcode.BelajarSpringBootWeb.dao;

import com.mastahcode.BelajarSpringBootWeb.model.Mahasiswa;
import com.mastahcode.BelajarSpringBootWeb.services.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;


@Service
public class MahasiswaDao implements MahasiswaService {

    private EntityManagerFactory entityManagerFactory;

    @Autowired
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public List<Mahasiswa> MAHASISWA_LIST() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery("from Mahasiswa", Mahasiswa.class).getResultList();
    }

    @Override
    public Mahasiswa saveOrUpdate(Mahasiswa mahasiswa) {
       EntityManager entityManager = entityManagerFactory.createEntityManager();
       entityManager.getTransaction().begin();
       Mahasiswa saved = entityManager.merge(mahasiswa);
       entityManager.getTransaction().commit();
       return saved;
    }

    @Override
    public Mahasiswa getIdMahasiswa(Integer id) {
       EntityManager entityManager = entityManagerFactory.createEntityManager();
       return entityManager.find(Mahasiswa.class, id);
    }

    @Override
    public void deleteMahasiswa(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Mahasiswa.class, id));
        entityManager.getTransaction().commit();
    }
}
