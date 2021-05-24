package kz.aibek.nightclub.service.impl;

import kz.aibek.nightclub.model.dto.GuestAndHistoryDto;
import kz.aibek.nightclub.model.dto.HistoryDto;
import kz.aibek.nightclub.model.dto.RegisterDto;
import kz.aibek.nightclub.model.entity.Club;
import kz.aibek.nightclub.model.entity.Guest;
import kz.aibek.nightclub.model.entity.History;
import kz.aibek.nightclub.model.exception.ClubNotFoundException;
import kz.aibek.nightclub.model.exception.GuestNotFoundException;
import kz.aibek.nightclub.model.mapper.IMapper;
import kz.aibek.nightclub.repository.IClubRepository;
import kz.aibek.nightclub.repository.IGuestRepository;
import kz.aibek.nightclub.repository.IHistoryRepository;
import kz.aibek.nightclub.service.IGuestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

/** Сервис для операции с гостем клуба
 * */

@Service
@Slf4j
@RequiredArgsConstructor
public class GuestServiceImpl implements IGuestService {

    private final IGuestRepository guestRepository;
    private final IClubRepository clubRepository;
    private final IHistoryRepository historyRepository;
    private final IMapper mapper;

    @Override
    @Transactional
    public GuestAndHistoryDto registerGuestToClub(RegisterDto registerDto) {
        Guest guest = guestRepository.findByName(registerDto.getUsername())
                .orElseThrow(() -> new GuestNotFoundException(registerDto.getUsername(), "not found"));
        Club club = clubRepository.findByName(registerDto.getName())
                .orElseThrow(() -> new ClubNotFoundException(registerDto.getName(), "not found"));

        History history = new History();
        history.setClub(club);
        history.setGuest(guest);
        history.setDate(Instant.now());
        historyRepository.save(history);

        return getGuestAndHistoryDto(guest);
    }

    private GuestAndHistoryDto getGuestAndHistoryDto(Guest guest) {
        List<HistoryDto> historyList = historyRepository.findByGuest(guest)
                .stream()
                .map(mapper::fromEntityToDto)
                .collect(Collectors.toList());

        final GuestAndHistoryDto guestAndHistoryDto = new GuestAndHistoryDto();
        guestAndHistoryDto.setGuest(mapper.fromEntityToDto(guest));
        guestAndHistoryDto.setHistory(historyList);

        return guestAndHistoryDto;
    }

}
