package ma.yc.aftas.Models.DTO.Impl;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.yc.aftas.Models.Entity.HuntingEntity;
import ma.yc.aftas.Models.Entity.MemberEntity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompetitionDTO {
    String code;
    LocalDate date;
    @JsonFormat(pattern = "HH:mm:ss")
    LocalTime startTime;
    @JsonFormat(pattern = "HH:mm:ss")
    LocalTime endTime;
    Integer numberOfParticipants;
    String location;
    Integer amount;
}
