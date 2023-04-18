package hello.hellospring.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ObjectNode;
import hello.hellospring.DTO.HelloDTO;
import hello.hellospring.service.HelloService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@RestController
public class HelloController {

    HelloService service = new HelloService();

    @GetMapping("ReadAll")
    @ResponseBody
    public String hello() throws JsonProcessingException {
        return service.getAllData();
    }

    @GetMapping("Read")
    @ResponseBody
    public String Read(@RequestParam("table") String table, @RequestParam("num") int num) throws JsonProcessingException {
        return service.getData(table, num);
    }

    @PostMapping("AddMemo")
    public ResponseEntity<Void> AddMemo(@RequestBody HelloDTO.MemoDTO memoDTO)
    {
        service.addMemo_delete(memoDTO.getNum(), memoDTO.getDate());
        service.addMemo_insert(memoDTO.getNum(), memoDTO.getDate(), memoDTO.getMemo());
        return ResponseEntity.ok().build();
    }



    @GetMapping("Add")
    @ResponseBody
    public ResponseEntity<Void> Add(@RequestParam("table") String table ,@RequestParam("data") String data){
        service.createData(table, data);
        return ResponseEntity.ok().build();
    }

    @GetMapping("Update")
    @ResponseBody
    public ResponseEntity<Void>  Update(@RequestParam("table") String table ,@RequestParam("column") String column, @RequestParam("data") String data, @RequestParam("num") int num){
        service.updateData(table, column, data, num);
        return ResponseEntity.ok().build();
    }

    @GetMapping("Delete")
    @ResponseBody
    public ResponseEntity<Void> Delete(@RequestParam("table") String table, @RequestParam("num") int num){
        service.deleteData(table,num);
        return ResponseEntity.ok().build();
    }

    @PostMapping("UpdateImage")
    public ResponseEntity<String> addImage(@RequestBody HelloDTO.ImageDTO imageDTO) {
        service.UpdateImage(imageDTO.getTable(),imageDTO.getColumn() ,imageDTO.getNum(),imageDTO.getImg());
        return ResponseEntity.ok("Image added successfully");
    }

    @GetMapping("ReadImage")
    public ResponseEntity<ObjectNode> ReadImage(@RequestParam("table") String table, @RequestParam("num") int num) throws JsonProcessingException {
        ObjectNode json = service.ReadImage(table, num);
        return ResponseEntity.ok(json);
    }
}

