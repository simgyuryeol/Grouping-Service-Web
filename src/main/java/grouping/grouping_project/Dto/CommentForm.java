package grouping.grouping_project.Dto;

import grouping.grouping_project.domain.Member;
import grouping.grouping_project.domain.Team;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
public class CommentForm {
    private Member id;
    private Team team;
    private String content;

}
