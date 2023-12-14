package ma.yc.aftas.Controller.Implementations;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.yc.aftas.Controller.Interfaces.MemberControllerInterface;
import ma.yc.aftas.Models.DTO.Impl.MemberDTO;
import ma.yc.aftas.Services.Impl.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
@Slf4j
public class MemberController implements MemberControllerInterface {
    @Autowired
    private MemberService memberService;

    /**
     *
     * @param memberDTO
     * @return ResponseEntity<String>
     * @description Create a member
     * @Endpoint: POST /api/v1/member/create
     *
     */

    @PostMapping("/create")
    @Override
    public ResponseEntity<String> create(@RequestBody MemberDTO memberDTO) {
        if(memberDTO == null){
            return ResponseEntity.badRequest().body("Invalid request");
        }
        MemberDTO foundMemberDTO = memberService.getByNum(memberDTO.getNum());
        if(foundMemberDTO != null){
            log.info("Member already exists");
            return ResponseEntity.badRequest().body("Member already exists");
        }
        MemberDTO createdMemberDTO = memberService.create(memberDTO);
        if(createdMemberDTO == null){
            return ResponseEntity.badRequest().body("Member can't be created check the logs");
        }
        return ResponseEntity.ok().body("Created member object :" + createdMemberDTO);
    }

    /**
     *
     * @param memberDTO
     * @return ResponseEntity<String>
     * @description Update a member
     * @Endpoint: POST /api/v1/member/update
     *
     */

    @PutMapping("/update")
    @Override
    public ResponseEntity<String> update(@RequestBody MemberDTO memberDTO) {
        if(memberDTO == null){
            return ResponseEntity.badRequest().body("Invalid request");
        }
        MemberDTO updatedMemberDTO = memberService.update(memberDTO);
        if(updatedMemberDTO == null){
            return ResponseEntity.badRequest().body("Member can't be updated check the logs");
        }
        return ResponseEntity.ok().body("Updated member object :" + updatedMemberDTO);
    }

    /**
     *
     * @param num
     * @return ResponseEntity<String>
     * @description Delete a member
     * @Endpoint: DELETE /api/v1/member/delete/{num}
     *
     */

    @DeleteMapping("/delete/{num}")
    @Override
    public ResponseEntity<String> delete(@PathVariable Integer num) {
        if(memberService.delete(num)) {
            return ResponseEntity.ok().body("Member deleted successfully");
        }else{
            return ResponseEntity.badRequest().body("Member not found");
        }
    }

    /**
     *
     * @return ResponseEntity<List<MemberDTO>>
     * @description Get all members
     * @Endpoint: GET /api/v1/member/getAll
     *
     */

    @GetMapping("/getAll")
    @Override
    public ResponseEntity<List<MemberDTO>> getAll() {
        return ResponseEntity.ok().body(memberService.getAll());
    }

    /**
     *
     * @param num
     * @return ResponseEntity<MemberDTO>
     * @description Get a member by num
     * @Endpoint GET /api/v1/get/{num}
     *
     */

    @GetMapping("/get/{num}")
    @Override
    public ResponseEntity<MemberDTO> getByNum(@PathVariable Integer num) {
        MemberDTO foundMemberDTO = memberService.getByNum(num);
        if(foundMemberDTO == null){
            log.info("Member not found");
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(foundMemberDTO);
    }
}
