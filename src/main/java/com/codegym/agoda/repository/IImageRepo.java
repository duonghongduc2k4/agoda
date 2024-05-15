package com.codegym.agoda.repository;

import com.codegym.agoda.model.Image;
import com.codegym.agoda.model.TypeRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IImageRepo extends JpaRepository<Image,Integer>, JpaSpecificationExecutor<Image> {

    @Query("SELECT i FROM Image as i WHERE i.house.id = ?1")
     List<Image> findImageById(int id);

 }
