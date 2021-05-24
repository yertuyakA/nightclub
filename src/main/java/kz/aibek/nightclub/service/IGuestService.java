package kz.aibek.nightclub.service;

import kz.aibek.nightclub.model.dto.GuestAndHistoryDto;
import kz.aibek.nightclub.model.dto.RegisterDto;

public interface IGuestService {
    GuestAndHistoryDto registerGuestToClub(RegisterDto registerDto);
}
