package com.bekirkocadag.crud.repositories;

import com.bekirkocadag.crud.models.LibraryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author H.Bekir Kocadag
 */
@Repository
public interface LibraryRepository extends JpaRepository<LibraryModel, Long> {
}
