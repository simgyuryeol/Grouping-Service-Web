package grouping.grouping_project.Dto;

import grouping.grouping_project.domain.Team;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberUpdateForm {
    private String name; //이름
    private int age; //나이
    private String email;//email
    private String img; //사진


}
