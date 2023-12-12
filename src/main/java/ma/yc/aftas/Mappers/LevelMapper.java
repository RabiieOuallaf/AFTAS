package ma.yc.aftas.Mappers;


import ma.yc.aftas.DTO.Impl.LevelDTO;
import ma.yc.aftas.Entity.LevelEntity;
import org.mapstruct.factory.Mappers;

public interface LevelMapper {
    LevelMapper levelMapper = Mappers.getMapper(LevelMapper.class);

    LevelDTO toDTO(LevelEntity levelEntity);
    LevelEntity toEntity(LevelDTO levelDTO);

}
