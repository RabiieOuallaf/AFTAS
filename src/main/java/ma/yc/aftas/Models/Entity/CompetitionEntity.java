package ma.yc.aftas.Models.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Entity(name = "CompetitionEntity")
@Table(name = "competitions")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompetitionEntity {
    @Id
    @Column(name = "code", columnDefinition = "VARCHAR(255)")
    private String code;

    @Basic
    @Column(name = "date")
    private LocalDate date;

    @Basic
    @Column(name = "startTime")
    @JsonFormat(pattern = "HH:mm:ss")

    private LocalTime startTime;

    @Basic
    @Column(name = "endTime")
    @JsonFormat(pattern = "HH:mm:ss")

    private LocalTime endTime;

    @Basic
    @Column(name = "numberOfParticipants")
    private Integer numberOfParticipants;

    @Basic
    @Column(name = "location")
    private String location;

    @Basic
    @Column(name = "amount")
    private Integer amount;

    @ManyToMany(mappedBy = "competitions")
    private Set<MemberEntity> members;

    @OneToMany(mappedBy = "competition")
    private List<HuntingEntity> hunting;


}
