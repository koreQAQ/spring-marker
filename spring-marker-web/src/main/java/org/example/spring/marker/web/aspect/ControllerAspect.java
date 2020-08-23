package org.example.spring.marker.web.aspect;

import org.example.spring.marker.web.exception.DuplicateNoteException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by lishubin on 2020/8/22 9:58 下午
 * @author lishubin
 */
@ControllerAdvice
public class ControllerAspect {

    private static Logger logger = LoggerFactory.getLogger(ControllerAspect.class);

    @ExceptionHandler(value = DuplicateNoteException.class)
    public String duplicateNote(DuplicateNoteException duplicateNoteException) {
        logger.error("发生错误 - {}",duplicateNoteException.getMessage());
        return "error/duplicate";
    }

}
