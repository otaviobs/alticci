package com.alticci;

import com.alticci.exception.BadRequestException;
import com.alticci.service.SequenceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SequenceServiceTest {

    private SequenceService sequenceService;

    @BeforeEach
    public void initial(){
        this.sequenceService = new SequenceService();
    }

    @Test
    public void getSequenceNumberZero(){
        assertEquals(0, sequenceService.getSequenceByNumber(0));
    }

    @Test
    public void getSequenceNumberOne(){
        assertEquals(1, sequenceService.getSequenceByNumber(1));
    }

    @Test
    public void getSequenceNumberTwo(){
        assertEquals(1, sequenceService.getSequenceByNumber(2));
    }

    @Test
    public void showThrowWhenNumberIsBiggerSeventyEight(){
        assertThrows(BadRequestException.class,
                () -> sequenceService.getSequenceByNumber(79));
    }

    @Test
    public void showThrowWhenNumberIsLowerZero(){
        assertThrows(BadRequestException.class,
                () -> sequenceService.getSequenceByNumber(-1));
    }

}
