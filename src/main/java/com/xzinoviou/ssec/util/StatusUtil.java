package com.xzinoviou.ssec.util;

import com.xzinoviou.ssec.dto.StatusDto;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@Component
public class StatusUtil {

    private List<StatusDto> statuses;

    public StatusUtil() {
        this.statuses = listOfStatusDto();
    }

    public List<StatusDto> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<StatusDto> statuses) {
        this.statuses = statuses;
    }

    private List<StatusDto> listOfStatusDto() {
        return Arrays.asList(
                new StatusDto(1, OK.value(), OK.getReasonPhrase()),
                new StatusDto(2, CREATED.value(), CREATED.getReasonPhrase()),
                new StatusDto(3, ACCEPTED.value(), ACCEPTED.getReasonPhrase()),
                new StatusDto(4, BAD_GATEWAY.value(), BAD_GATEWAY.getReasonPhrase()),
                new StatusDto(5, BAD_REQUEST.value(), BAD_REQUEST.getReasonPhrase()),
                new StatusDto(6, INTERNAL_SERVER_ERROR.value(), INTERNAL_SERVER_ERROR.getReasonPhrase()),
                new StatusDto(7, FORBIDDEN.value(), FORBIDDEN.getReasonPhrase()),
                new StatusDto(8, UNAUTHORIZED.value(), UNAUTHORIZED.getReasonPhrase()));
    }
}
