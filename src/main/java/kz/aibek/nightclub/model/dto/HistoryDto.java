package kz.aibek.nightclub.model.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class HistoryDto {
    private String clubName;
    private String address;
    private Instant date;
}


