package com.alticci.controller;

import com.alticci.domain.Sequence;
import com.alticci.service.SequenceService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Tag(name = "Alticci", description = "" +
        "API calculates Alticci's sequence." +
        "Uses a range of numbers because I am working with Ingeter type then is a limit number. So you can input number between 0 and 78.")
@RestController
@RequestMapping("/alticci")
public class SequenceController {

    @Autowired
    private SequenceService sequenceService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return Alticci sequence number as you input index number."),
            @ApiResponse(responseCode = "400", description = "Case input number upper than 78 or lower than zero show the message with BAD REQUEST code."),
    })
    @GetMapping("/{number}")
    @Cacheable(value = "numberCalculated")
    public int getSequence(@PathVariable Integer number) {
        return sequenceService.getSequenceByNumber(number);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return Alticci sequence number as you input index number."),
            @ApiResponse(responseCode = "400", description = "Case input number upper than 78 or lower than zero show the message with BAD REQUEST code."),
    })
    @GetMapping("/between/{beginNumber}/{endNumber}")
    @Cacheable(value = "numberCalculated")
    public List<Integer> getListSequence(@PathVariable Integer beginNumber, @PathVariable Integer endNumber) {
        return sequenceService.getListDescSequence(beginNumber, endNumber);
    }

}
