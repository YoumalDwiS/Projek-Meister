package com.astratech.meister.service;

import com.astratech.meister.model.Materi;
import com.astratech.meister.repository.MateriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MateriService {
    @Autowired
    MateriRepository materiRepository;

    public List<Materi> getAllData(){
        List<Materi> materiList = (List<Materi>) materiRepository.findMateriByStatus("Aktif");
        return materiList;
    }

    public void save(Materi materi){
        materi.setStatus("Aktif");
        materiRepository.save(materi);
    }

    public Materi findById(int id){
        Materi materi = materiRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid Id : "+id));
        return materi;
    }

    public void delete(int id){
        Materi tempmt = materiRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid Id : "+id));
        tempmt.setStatus("Tidak Aktif");
        materiRepository.save(tempmt);
    }

    public void update(int id,Materi materi){
        Materi tempMateri = materiRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid Id : "+id));
        tempMateri.setNama_materi(materi.getNama_materi());
        tempMateri.setId_section(materi.getId_section());
        tempMateri.setDeskripsi(materi.getDeskripsi());
        materiRepository.save(tempMateri);
    }
}
