package grouping.grouping_project.repository;

import grouping.grouping_project.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    //Optional<Member> findAllBy(String id);
    Optional<Member> findById(String id);
}
