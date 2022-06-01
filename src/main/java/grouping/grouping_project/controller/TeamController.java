package grouping.grouping_project.controller;

import grouping.grouping_project.Dto.TeamForm;
import grouping.grouping_project.domain.Member;
import grouping.grouping_project.service.MemberService;
import grouping.grouping_project.service.TeamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TeamController {
    private final MemberService memberService;
    private final TeamService teamService;
    //팀 새로만듬
    @PostMapping("/post")
    public ResponseEntity teamCreat(@RequestBody TeamForm request){
        //log.info("title = {}, contents = {}, userId = {}",request.getTeam_name(),request.getContents(),request.getId())
        Optional <Member> member = memberService.getMemberForm(request.getId());

        if(teamService.TeamCreate(request,member.get()).equals("Success")){
            return new ResponseEntity(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    // 팀 조회
    @GetMapping("/post")
    public ResponseEntity teamList(){
        return ResponseEntity.ok().body(teamService.TeamList());
    }

    // 팀 내용 수정
    @PatchMapping("/{seq}")
    public ResponseEntity teamUpdate(@PathVariable Long seq, @RequestBody TeamForm request){
        if(teamService.TeamUpdate(seq, request).equals("Success")){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    // 팀 내용 조회
    @GetMapping("/{seq}")
    public ResponseEntity teamContent(@PathVariable Long seq){
        return ResponseEntity.ok().body(teamService.teamContent(seq));
    }

    // 팀 삭제
    @DeleteMapping("/{seq}")
    public ResponseEntity teamDelete(@PathVariable Long seq){
        if(teamService.teamDelete(seq).equals("Success")){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


}
