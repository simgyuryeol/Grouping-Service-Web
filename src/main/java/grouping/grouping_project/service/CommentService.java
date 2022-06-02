package grouping.grouping_project.service;

import grouping.grouping_project.Dto.CommentForm;
import grouping.grouping_project.domain.Comment;
import grouping.grouping_project.domain.Member;
import grouping.grouping_project.domain.Team;
import grouping.grouping_project.repository.CommentRepository;
import grouping.grouping_project.repository.MemberRepository;
import grouping.grouping_project.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentService {
    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;

    // 댓글 저장
    @Transactional
    public String save(CommentForm request,Long teamid){
        Optional<Member> memberid = memberRepository.findById(request.getId());
        Team team = teamRepository.getById(teamid);
        commentRepository.save(Comment.builder()
                .id(memberid.get())
                .team(team)
                .content(request.getContent())
                .build());

        return "Success";
    }

    //댓글 삭제
    @Transactional
    public String commentDelete(Long commentId){
        Optional<Comment> comment = commentRepository.findById(commentId);
        commentRepository.delete(comment.get());
        return "Success";
    }


}
