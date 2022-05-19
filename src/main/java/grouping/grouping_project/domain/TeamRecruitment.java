package grouping.grouping_project.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class TeamRecruitment { //팀원 모집

    @Id @GeneratedValue
    private int team_id; //글 번호

    private String id; //작성자 아이디
    private String contents; //글 내용
    private String createdtime; //글 작성 일자
}
