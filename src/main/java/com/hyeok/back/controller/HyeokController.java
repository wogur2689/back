package com.hyeok.back.controller;

import com.hyeok.back.board.heartEnum.HeartType;
import com.hyeok.back.board.param.HeartReq;
import com.hyeok.back.board.param.WriteReq;
import com.hyeok.back.board.service.BoardService;
import com.hyeok.back.member.param.LoginReq;
import com.hyeok.back.member.param.SignUpReq;
import com.hyeok.back.member.service.MemberService;
import com.hyeok.back.common.CommonResult;
import com.hyeok.back.common.HyeokApi;
import com.hyeok.back.enums.ApiCode;
import com.hyeok.back.hyeokException.HyeokException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin(origins="*", allowedHeaders = "*")
@Tag(name = "로그인 / 회원가입")
@Slf4j
@RestController
@RequestMapping(path = "/member", method = RequestMethod.POST)
public class HyeokController {

    @Resource
    private MemberService memberService;

    @Resource
    private BoardService boardService;

    @Operation(summary = "로그인", description = "아이디, 비밀번호 입력")
    @PostMapping(path = "/login")
    public HyeokApi memberLogin(@RequestBody LoginReq loginReq) {
        if(memberService.selectJoin(loginReq.getUserId(), loginReq.getPassword())) {
            log.info(ApiCode.API_0000.getMsg());
            return new HyeokApi(new CommonResult(ApiCode.API_0000.getCode(), ApiCode.API_0000.getMsg()));
        }
        else {
            log.error(ApiCode.API_5000.getMsg());
            throw new HyeokException(ApiCode.API_5000);
        }
    }

    //회원가입
    @Operation(summary = "회원가입", description = "아이디, 비밀번호, 이름 입력")
    @PostMapping(path = "/signup")
    public HyeokApi memberJoin(@RequestBody SignUpReq signUpReq) {
        if(memberService.saveJoin(signUpReq)) {
            log.info(ApiCode.API_0000.getMsg());
            return new HyeokApi(new CommonResult(ApiCode.API_0000.getCode(), ApiCode.API_0000.getMsg()));
        }
        else {
            log.error(ApiCode.API_5000.getMsg());
            throw new HyeokException(ApiCode.API_5000);
        }
    }

    //게시물 추가
    @Operation(summary = "게시물 추가", description = "화면에서 제목, 컨텐츠 입력")
    @PostMapping("/write")
    public HyeokApi saveBoard(@RequestBody WriteReq writeReq) {
        if(boardService.saveBoard(writeReq)) {
            log.info(ApiCode.API_0000.getMsg());
            return new HyeokApi(new CommonResult(ApiCode.API_0000.getCode(), ApiCode.API_0000.getMsg()));
        }
        else {
            log.error(ApiCode.API_5000.getMsg());
            return new HyeokApi(new CommonResult(ApiCode.API_5000.getCode(), ApiCode.API_5000.getMsg()));
        }
    }
    //게시물 반환
    @Operation(summary = "게시물 반환", description = "화면에 접속시 바로 반환")
    @GetMapping("/board")
    public HyeokApi listBoard(Model model) {
        model.addAttribute("boardList", boardService.getBoardList());
        return new HyeokApi(new CommonResult(ApiCode.API_0000.getCode(), ApiCode.API_0000.getMsg()), model);
    }

    //좋아요 이벤트
    @Operation(summary = "좋아요 관리", description = "게시물에 좋아요 클릭시 이벤트 처리")
    @PostMapping("/heart")
    public HyeokApi heartControl(@RequestBody HeartReq heartReq) {
        if(boardService.heartControl(heartReq)) {
            log.info(ApiCode.API_0000.getMsg());
            return new HyeokApi(new CommonResult(ApiCode.API_1000.getCode(), ApiCode.API_0000.getMsg()));
        } else {
            log.error(ApiCode.API_5000.getMsg());
            return new HyeokApi(new CommonResult(ApiCode.API_5000.getCode(), ApiCode.API_5000.getMsg()));
        }
    }
}
