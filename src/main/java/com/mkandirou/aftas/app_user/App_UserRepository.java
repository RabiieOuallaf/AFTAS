package com.mkandirou.aftas.app_user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface App_UserRepository extends JpaRepository<App_user,Integer> {

    Optional<App_user> findByEmail(String email);
    @Query("SELECT m FROM App_user m WHERE m NOT IN " +
            "(SELECT r.rankingId.member FROM Ranking r WHERE r.rankingId.competition.code = :competitionCode)")
    List<App_user> findMembersNotInCompetition(@Param("competitionCode") String competitionCode);

    @Query("SELECT m FROM App_user m WHERE (m.name = :index OR m.familyName = :index) AND m NOT IN " +
            "(SELECT r.rankingId.member FROM Ranking r WHERE r.rankingId.competition.code = :competitionCode)")
    List<App_user> findByNumOrNameOrFamilyName(@Param("competitionCode") String competitionCode, @Param("index") String index);


}
