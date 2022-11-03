package com.alticci.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

public class Sequence {
    @Getter
    @Min(0)
    @Max(2147483647)
    private Integer number;

    public Sequence(Integer number) {
        this.number = number;
    }

    public int getNumberCalculated (){
        return this.calculateSequence(this.number);
    }

    private int calculateSequence(int number){
        int res;
        if(number > 2)
            res = calculateSequence((number - 3)) + calculateSequence((number - 2));
        else if (number == 0)
            res = 0;
        else
            res = 1;

        return res;
    }

}
