package net.pis.demo.anton.dao;


import org.springframework.data.repository.PagingAndSortingRepository;

import net.pis.demo.anton.entity.Berita;

public interface BeritaDao extends PagingAndSortingRepository<Berita, Integer> {

}