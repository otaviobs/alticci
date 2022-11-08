package com.alticci.domain;

import com.alticci.exception.BadRequestException;
import lombok.Getter;

public class Sequence {
    @Getter
    private Integer number;

    public Sequence(Integer number) {
        this.number = number;
        validation();
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

    public void validation(){
        if(number < 0)
            throw new BadRequestException("Input number is upper than zero");
        if(number > 78)
            throw new BadRequestException("Input number is lower or equals than 78");

    }

}
