package com.alticci;

import com.alticci.domain.Sequence;
import com.alticci.exception.BadRequestException;
import com.alticci.service.SequenceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SequenceServiceTest {

    @Test
    public void getSequenceNumberZero(){
        Sequence sequence = new Sequence(0);
        assertEquals(0, sequence.getNumberCalculated());
    }

    @Test
    public void getSequenceNumberOne(){
        Sequence sequence = new Sequence(1);
        assertEquals(1, sequence.getNumberCalculated());
    }

    @Test
    public void getSequenceNumberTwo(){
        Sequence sequence = new Sequence(2);
        assertEquals(1, sequence.getNumberCalculated());
    }

    @Test
    public void getSequenceNumberTen(){
        Sequence sequence = new Sequence(10);
        assertEquals(9, sequence.getNumberCalculated());
    }

    @Test
    public void showMessage_whenNumberIsBiggerSeventyEight_thenBadRequestException(){
        assertThrows(BadRequestException.class,
                () -> new Sequence(79));
    }

    @Test
    public void showMessage_whenNumberIsLowerZero_thenBadRequestException(){
        assertThrows(BadRequestException.class,
                () -> new Sequence(-1));
    }

}
