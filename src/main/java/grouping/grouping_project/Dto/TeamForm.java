package grouping.grouping_project.Dto;

import grouping.grouping_project.domain.Member;
import grouping.grouping_project.domain.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TeamForm {

    private String id; //작성 사용자 아이디
    private String team_name; //팀이름
    private String contents; //모집 내용
    private String created_time; //작성 일자

    public void updateEntity(Team team){
        team.setTeam_name(this.team_name);
        team.setContents(this.contents);
    }


//    @Id
//    @GeneratedValue
//    private long seq;
//
//    @Column(name="team_name")
//    private String team_name;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Member id;
//
//
//    private String contents;
//    private String created_time;
}
