package kz.aibek.nightclub.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import kz.aibek.nightclub.model.dto.GuestAndClubDto;
import kz.aibek.nightclub.model.dto.GuestDto;
import kz.aibek.nightclub.service.IAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/club")
@RequiredArgsConstructor
public class AdminController {

    private final IAdminService adminService;

    @ApiOperation(value = "Functionality for providing information about all visitors of some night-club  (i.e. visitors of ${nightClubName})")
    @GetMapping("/listGuest/{nightClubName}")
    public ResponseEntity<List<GuestDto>> getListOfGuestsByClubName(@PathVariable String nightClubName) {
        return ResponseEntity.ok().body(adminService.getListGuestByClubName(nightClubName));
    }

    @ApiOperation(value = "Provision information of all night clubs which user with username=${username}  with has visited already")
    @GetMapping("/history/attendance/{username}")
    public ResponseEntity<GuestAndClubDto> getGuestInfoAboutAttendance(@PathVariable String username) {
        return ResponseEntity.ok().body(adminService.getAttendanceOfClubByGuestName(username));
    }
    @ApiOperation(value = "Provision information of all night clubs which user HASN'T visited yet")
    @GetMapping("/history/noVisit/{username}")
    public ResponseEntity<GuestAndClubDto> getGuestInfoAboutNotVisitedClubs(@PathVariable String username) {
        return ResponseEntity.ok().body(adminService.getNonAttendanceOfClubByGuestName(username));
    }
}
