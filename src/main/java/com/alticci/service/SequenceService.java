package com.alticci.service;

import com.alticci.domain.Sequence;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SequenceService {
    public Integer getSequenceByNumber(Integer number) {
        Sequence sequence = new Sequence(number);
        return sequence.getNumberCalculated();
    }

    public List<Integer> getListDescSequence(Integer beginNumber, Integer endNumber) {
        List<Integer> list = new ArrayList<>();
        for (int i = beginNumber; i <= endNumber; i++){
            Sequence sequence = new Sequence(i);
            list.add(sequence.getNumberCalculated());
        }
        return list;
    }
}
