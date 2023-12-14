package ma.yc.aftas.Mappers;


import ma.yc.aftas.Models.DTO.Impl.LevelDTO;
import ma.yc.aftas.Models.Entity.LevelEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
public interface LevelMapper {
    LevelMapper levelMapper = Mappers.getMapper(LevelMapper.class);

    LevelDTO toDTO(LevelEntity levelEntity);
    LevelEntity toEntity(LevelDTO levelDTO);

}
