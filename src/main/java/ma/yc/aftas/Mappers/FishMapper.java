package ma.yc.aftas.Mappers;

import ma.yc.aftas.Models.DTO.Impl.FishDTO;
import ma.yc.aftas.Models.Entity.FishEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FishMapper {
    FishMapper fishMapper = Mappers.getMapper(FishMapper.class);

    FishDTO toDTO(FishEntity fishEntity);
    FishEntity toEntity(FishDTO fishDTO);
}
