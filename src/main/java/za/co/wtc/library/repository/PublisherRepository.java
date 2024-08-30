package za.co.wtc.library.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import za.co.wtc.library.model.Publisher;


@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    boolean existsByIsni(String isni);

     @Query("select c from Publisher c "
      + "where c.isni = :isni")
  Publisher findByIsniNumber(String isni);

} 

