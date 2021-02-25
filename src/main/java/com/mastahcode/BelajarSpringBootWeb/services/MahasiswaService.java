package com.mastahcode.BelajarSpringBootWeb.services;

import com.mastahcode.BelajarSpringBootWeb.model.Mahasiswa;

import java.util.List;

public interface MahasiswaService {

    List <Mahasiswa> MAHASISWA_LIST();

    Mahasiswa saveOrUpdate(Mahasiswa mahasiswa);

    Mahasiswa getIdMahasiswa(Integer id);

    void deleteMahasiswa(Integer id);
}
