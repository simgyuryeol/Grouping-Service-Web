package grouping.grouping_project.controller;

import grouping.grouping_project.Dto.MemberForm;
import grouping.grouping_project.Dto.MemberloginForm;
import grouping.grouping_project.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping()
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    //회원가입
    @PostMapping("/users")
    public ResponseEntity singup(@RequestBody MemberForm request){
        log.info("userId = {}, password = {}, userName = {}", request.getName(), request.getId(),request.getAge());
        if(memberService.save(request).equals("Success")){
            return new ResponseEntity(HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody MemberloginForm request){
        if(memberService.login(request).equals("Success")){
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}
