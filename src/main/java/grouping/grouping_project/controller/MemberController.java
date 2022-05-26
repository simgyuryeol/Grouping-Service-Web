package grouping.grouping_project.controller;

import grouping.grouping_project.Dto.MemberForm;
import grouping.grouping_project.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Slf4j
@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping()
    public ResponseEntity singup(@RequestBody MemberForm request){
        //log.info("userId = {}, password = {}, userName = {}", request.getName(), request.getId(),request.getAge());
        if(memberService.save(request).equals("Success")){
            return new ResponseEntity(HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}
