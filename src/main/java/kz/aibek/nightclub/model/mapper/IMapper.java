package kz.aibek.nightclub.model.mapper;

import kz.aibek.nightclub.model.dto.ClubDto;
import kz.aibek.nightclub.model.dto.GuestDto;
import kz.aibek.nightclub.model.dto.HistoryDto;
import kz.aibek.nightclub.model.dto.RegisterDto;
import kz.aibek.nightclub.model.entity.Club;
import kz.aibek.nightclub.model.entity.Guest;
import kz.aibek.nightclub.model.entity.History;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IMapper {
    GuestDto fromEntityToDto(Guest guest);
    Guest fromDtoToEntity(GuestDto guestDto);

    Club fromDtoToEntity(ClubDto clubDto);
    @Mapping(target = "clubName", source = "name")
    ClubDto fromEntityToDto(Club club);

    @Mappings({
            @Mapping(target = "clubName", source = "club.name"),
            @Mapping(target = "address", source = "club.address")
    })
    HistoryDto fromEntityToDto(History history);


}
