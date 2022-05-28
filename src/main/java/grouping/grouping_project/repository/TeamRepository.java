package grouping.grouping_project.repository;

import grouping.grouping_project.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
