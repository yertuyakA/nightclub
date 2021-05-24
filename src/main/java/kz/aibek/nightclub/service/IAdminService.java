package kz.aibek.nightclub.service;

import kz.aibek.nightclub.model.dto.ClubDto;
import kz.aibek.nightclub.model.dto.GuestAndClubDto;
import kz.aibek.nightclub.model.dto.GuestDto;

import java.util.List;

public interface IAdminService {
    ClubDto createClub(ClubDto clubDto);
    GuestDto createGuest(GuestDto guestDto);
    List<GuestDto> getListGuestByClubName(String clubName);
    GuestAndClubDto getNonAttendanceOfClubByGuestName(String guestName);
    GuestAndClubDto getAttendanceOfClubByGuestName(String guestName);
}
