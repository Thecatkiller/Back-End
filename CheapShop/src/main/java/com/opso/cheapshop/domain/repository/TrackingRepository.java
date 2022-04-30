package com.opso.cheapshop.domain.repository;
import com.opso.cheapshop.domain.model.Tracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackingRepository extends JpaRepository<Tracking, Long> {

}