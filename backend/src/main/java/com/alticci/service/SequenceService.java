package com.alticci.service;

import com.alticci.domain.Sequence;
import com.alticci.dto.SequenceDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SequenceService {
    public SequenceDto getSequenceByNumber(Integer number) {
        Sequence sequence = new Sequence(number);

        SequenceDto sequenceDto = new SequenceDto();
        sequenceDto.setNumber(sequence.getNumberCalculated());
        return sequenceDto;
    }

    public List<SequenceDto> getListDescSequence(Integer beginNumber, Integer endNumber) {
        List<SequenceDto> list = new ArrayList<>();
        for (int i = beginNumber; i <= endNumber; i++){
            Sequence sequence = new Sequence(i);
            SequenceDto sequenceDto = new SequenceDto();
            sequenceDto.setNumber(sequence.getNumberCalculated());
            list.add(sequenceDto);
        }
        return list;
    }
}
