package kz.aibek.nightclub.model.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GuestNotFoundException extends RuntimeException{
    private final String guestName;
    private final String message;
}
