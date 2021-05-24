package kz.aibek.nightclub.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class GuestAndHistoryDto {
    private GuestDto guest;
    private List<HistoryDto> history;
}
