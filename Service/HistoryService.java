package com.example.pcmarket.Service;

import com.example.pcmarket.Model.History;
import com.example.pcmarket.Repository.HistoryRepository;
import com.example.pcmarket.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoryService {
    @Autowired
    HistoryRepository historyRepository;

    public Result create(History history) {
        History history1 = new History();
        history1.setOrders(history.getOrders());
        History save = historyRepository.save(history1);
        return new Result("saqlandi " + save, true);
    }

    public History findById(Integer id) {
        Optional<History> byId = historyRepository.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        }
        return null;
    }

    public Result deleteById(Integer id) {
        try {
            if (historyRepository.existsById(id)) {
                historyRepository.deleteById(id);
                return new Result("ochdi", true);
            }
        } catch (Exception e) {
            return new Result("error", false);
        }
        return new Result("topilmadi",false);
    }

    public List<History> getAllHistory() {
        List<History> all = historyRepository.findAll();
        return all;
    }
}
