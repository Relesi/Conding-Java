package com.conding.controller;

import com.conding.domain.Conta;
import com.conding.service.ContaService;
import com.conding.util.DataUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("coding")
@RequiredArgsConstructor
@Log4j2
public class ContaController {

    private final ContaService contaService;

    private final DataUtil dataUtil;

    @GetMapping("list-all")
    public ResponseEntity<List<Conta>> list() {
        log.info(dataUtil.formatarDataLocal(LocalDateTime.now()));
        return new ResponseEntity<>(contaService.listAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Conta> findByid(@PathVariable long id) {
        log.info(dataUtil.formatarDataLocal(LocalDateTime.now()));
        return ResponseEntity.ok(contaService.findById(id));
    }

    @PostMapping("insert")
    public ResponseEntity<Conta> save(@RequestBody Conta conta) {
        log.info(dataUtil.formatarDataLocal(LocalDateTime.now()));
        return new ResponseEntity<>(contaService.save(conta), HttpStatus.CREATED);
    }

    @PutMapping("/replace/{id}")
    public ResponseEntity<Conta> replace(@RequestBody Conta conta) {
        log.info(dataUtil.formatarDataLocal(LocalDateTime.now()));
        contaService.replace(conta);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Conta> delete(@PathVariable long id) {
        log.info(dataUtil.formatarDataLocal(LocalDateTime.now()));
        contaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }






}
