package kz.aibek.nightclub.service.impl;

import kz.aibek.nightclub.model.dto.ClubDto;
import kz.aibek.nightclub.model.dto.GuestAndClubDto;
import kz.aibek.nightclub.model.dto.GuestDto;
import kz.aibek.nightclub.model.entity.Club;
import kz.aibek.nightclub.model.entity.Guest;
import kz.aibek.nightclub.model.entity.History;
import kz.aibek.nightclub.model.exception.ClubNotFoundException;
import kz.aibek.nightclub.model.exception.GuestNotFoundException;
import kz.aibek.nightclub.model.mapper.IMapper;
import kz.aibek.nightclub.repository.IClubRepository;
import kz.aibek.nightclub.repository.IGuestRepository;
import kz.aibek.nightclub.repository.IHistoryRepository;
import kz.aibek.nightclub.service.IAdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdminServiceImpl implements IAdminService {

    private final IHistoryRepository historyRepository;
    private final IClubRepository clubRepository;
    private final IGuestRepository guestRepository;
    private final IMapper mapper;

    @Override
    public ClubDto createClub(ClubDto clubDto) {
        clubRepository.save(mapper.fromDtoToEntity(clubDto));
        return clubDto;
    }

    @Override
    public GuestDto createGuest(GuestDto guestDto) {
        guestRepository.save(mapper.fromDtoToEntity(guestDto));
        return guestDto;
    }

    @Override
    public List<GuestDto> getListGuestByClubName(String clubName) {
        Club club = clubRepository.findByName(clubName)
                .orElseThrow(() -> new ClubNotFoundException(clubName, "not found"));

        return historyRepository.findByClub(club).stream().map(History::getGuest)
                .map(mapper::fromEntityToDto).collect(Collectors.toList());
    }

    @Override
    public GuestAndClubDto getNonAttendanceOfClubByGuestName(String guestName) {
        Guest guest = guestRepository.findByName(guestName)
                .orElseThrow(() -> new GuestNotFoundException(guestName, "not found"));

        List<ClubDto> clubs = clubRepository.findNonAttendanceClubByGuest(guest)
                .stream().map(mapper::fromEntityToDto).collect(Collectors.toList());

        GuestAndClubDto guestAndClubDto = new GuestAndClubDto();
        guestAndClubDto.setGuest(mapper.fromEntityToDto(guest));
        guestAndClubDto.setClub(clubs);

        return guestAndClubDto;
    }

    @Override
    public GuestAndClubDto getAttendanceOfClubByGuestName(String guestName) {
        Guest guest = guestRepository.findByName(guestName)
                .orElseThrow(() -> new GuestNotFoundException(guestName, "not found"));

        GuestAndClubDto guestAndClubDto = new GuestAndClubDto();
        guestAndClubDto.setGuest(mapper.fromEntityToDto(guest));
        guestAndClubDto.setClub(historyRepository.findByGuest(guest)
                .stream()
                .map(History::getClub)
                .map(mapper::fromEntityToDto)
                .collect(Collectors.toList()));

        return guestAndClubDto;
    }

}
