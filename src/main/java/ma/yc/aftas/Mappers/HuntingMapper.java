package ma.yc.aftas.Mappers;

import ma.yc.aftas.DTO.Impl.HuntingDTO;
import ma.yc.aftas.Entity.HuntingEntity;
import org.mapstruct.factory.Mappers;

public interface HuntingMapper {
    HuntingMapper huntingMapper = Mappers.getMapper(HuntingMapper.class);

    HuntingDTO toDTO(HuntingEntity huntingEntity);
    HuntingEntity toEntity(HuntingDTO huntingDTO);
}
