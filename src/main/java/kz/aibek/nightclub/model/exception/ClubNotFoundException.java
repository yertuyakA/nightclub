package kz.aibek.nightclub.model.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ClubNotFoundException extends RuntimeException{
    private final String clubName;
    private final String message;
}
