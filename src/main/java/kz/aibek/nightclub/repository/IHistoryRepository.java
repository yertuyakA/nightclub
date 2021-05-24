package kz.aibek.nightclub.repository;

import kz.aibek.nightclub.model.entity.Club;
import kz.aibek.nightclub.model.entity.Guest;
import kz.aibek.nightclub.model.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHistoryRepository extends JpaRepository<History, Long> {
    List<History> findByGuest(Guest guest);
    List<History> findByClub(Club club);
}
