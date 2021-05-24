package kz.aibek.nightclub.repository;

import kz.aibek.nightclub.model.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IGuestRepository extends JpaRepository<Guest, Long> {
    Optional<Guest> findByName(String name);
}
