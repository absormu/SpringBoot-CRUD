package com.mastahcode.BelajarSpringBootWeb.controller;


import com.mastahcode.BelajarSpringBootWeb.model.Mahasiswa;
import com.mastahcode.BelajarSpringBootWeb.services.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MahasiswaContorller {

    private MahasiswaService mahasiswaService;

    @Autowired
    public void setMahasiswaService(MahasiswaService mahasiswaService) {
        this.mahasiswaService = mahasiswaService;
    }

    @RequestMapping("/mahasiswa")
    public String MahasiswaList(Model model){
        model.addAttribute("mahasiswa", mahasiswaService.MAHASISWA_LIST());
        return "mahasiswa";
    }

    @RequestMapping(value = "/mahasiswa/create", method = RequestMethod.GET)
    public String showForm(Model model){
        model.addAttribute("mahasiswa", new Mahasiswa());
        return "formMahasiswa";
    }

    @RequestMapping(value = "/mahasiswa/create", method = RequestMethod.POST)
    public String saveDataMahasiswa(Model model, Mahasiswa mahasiswa){
        model.addAttribute("mahasiswa", mahasiswaService.saveOrUpdate(mahasiswa));
        return "redirect:/mahasiswa";
    }

    @RequestMapping(value = "/mahasiswa/edit/{id}", method = RequestMethod.GET)
    public String editDataMahasiswa(@PathVariable Integer id, Model model){
    model.addAttribute("mahasiswa", mahasiswaService.getIdMahasiswa(id));
    return "formMahasiswa";
    }

    @RequestMapping(value = "/mahasiswa/delete/{id}")
    public String deleteDataMahasiswa(@PathVariable Integer id){
        mahasiswaService.deleteMahasiswa(id);
        return "redirect:/mahasiswa";
    }
}
