package kz.aibek.nightclub.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class GuestAndClubDto {
    private GuestDto guest;
    private List<ClubDto> club;
}
