package ma.yc.aftas.Mappers;

import ma.yc.aftas.Models.DTO.Impl.HuntingDTO;
import ma.yc.aftas.Models.DTO.Impl.HuntingReqDTO;
import ma.yc.aftas.Models.Entity.HuntingEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface HuntingMapper {
    HuntingMapper huntingMapper = Mappers.getMapper(HuntingMapper.class);

    HuntingDTO toDTO(HuntingEntity huntingEntity);
    HuntingEntity toEntity(HuntingDTO huntingDTO);
}
