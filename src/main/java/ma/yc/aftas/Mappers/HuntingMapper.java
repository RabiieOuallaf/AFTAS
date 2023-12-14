package ma.yc.aftas.Mappers;

import ma.yc.aftas.Models.DTO.Impl.HuntingDTO;
import ma.yc.aftas.Models.Entity.HuntingEntity;
import org.mapstruct.factory.Mappers;

public interface HuntingMapper {
    HuntingMapper huntingMapper = Mappers.getMapper(HuntingMapper.class);

    HuntingDTO toDTO(HuntingEntity huntingEntity);
    HuntingEntity toEntity(HuntingDTO huntingDTO);
}
