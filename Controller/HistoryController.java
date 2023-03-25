package com.example.pcmarket.Controller;

import com.example.pcmarket.Model.History;
import com.example.pcmarket.Result;
import com.example.pcmarket.Service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @GetMapping
    public List<History> getHistory() {
        List<History> historyList = historyService.getAllHistory();
        return historyList;
    }

    @PostMapping
    public ResponseEntity<Result> create(@RequestBody History history) {
        Result createdHistory = historyService.create(history);
        return new ResponseEntity<>(createdHistory, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<History> findById(@PathVariable Integer id) {
        History history = historyService.findById(id);
        if (history == null)
            return new ResponseEntity<>(history, HttpStatus.CONFLICT);
        return new ResponseEntity<>(history, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        Result result = historyService.deleteById(id);
        return new ResponseEntity<>(result.getSuccess()?HttpStatus.NO_CONTENT:HttpStatus.CONFLICT);
    }

}
