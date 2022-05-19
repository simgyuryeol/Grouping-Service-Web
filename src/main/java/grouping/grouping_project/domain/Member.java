package grouping.grouping_project.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Member {

    @Id
    private String id; // 아이디

    private String name; //이름
    private int age; //나이
    private String email;//email
    private String img; //사진

    @Embedded
    private Portfolio portfolio; //포트폴리오


}
