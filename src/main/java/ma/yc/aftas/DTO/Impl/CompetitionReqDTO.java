package ma.yc.aftas.DTO.Impl;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompetitionReqDTO {
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
