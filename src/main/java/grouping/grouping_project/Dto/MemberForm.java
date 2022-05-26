package grouping.grouping_project.Dto;

import lombok.Getter;

import javax.persistence.Column;

@Getter
public class MemberForm {

    private String id; // 아이디
    private String name; //이름
    private int age; //나이
    private String email;//email
    private String img; //사진
}
