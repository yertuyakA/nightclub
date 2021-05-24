package kz.aibek.nightclub.repository;

import kz.aibek.nightclub.model.entity.Club;
import kz.aibek.nightclub.model.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IClubRepository extends JpaRepository<Club, Long> {
    Optional<Club> findByName(String name);
    @Query(value = "from Club c where c.name not in (select distinct h.club.name from History h where h.guest=:guest)")
    List<Club> findNonAttendanceClubByGuest(Guest guest);
}

