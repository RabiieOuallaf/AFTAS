package ma.yc.aftas.Mappers;

import ma.yc.aftas.Models.DTO.Impl.CompetitionDTO;
import ma.yc.aftas.Models.Entity.CompetitionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CompetitionMapper {
    CompetitionMapper competitionMapper = Mappers.getMapper(CompetitionMapper.class);

    CompetitionDTO toDTO(CompetitionEntity competitionEntity);

    CompetitionEntity toEntity(CompetitionDTO competitionDTO);
}
