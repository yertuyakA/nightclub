package kz.aibek.nightclub.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import kz.aibek.nightclub.model.dto.GuestAndHistoryDto;
import kz.aibek.nightclub.model.dto.RegisterDto;
import kz.aibek.nightclub.service.IGuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/guest/")
@RequiredArgsConstructor
public class GuestController {

    private final IGuestService guestService;

    @ApiOperation(value = "Ability to register attendance of user with username=${username} night club with name=${nightClubName}")
    @PostMapping("/register")
    public ResponseEntity<GuestAndHistoryDto> register(@RequestBody RegisterDto registerDto) {
        return ResponseEntity.ok().body(guestService.registerGuestToClub(registerDto));
    }

}
