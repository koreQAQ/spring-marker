package org.example.spring.marker.web.controller;

import org.example.spring.marker.web.annotation.LogTrace;
import org.example.spring.marker.web.exception.DuplicateNoteException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by lishubin on 2020/8/22 6:21 下午
 *
 * @author lishubin
 */
@Controller
public class GreetingController {

    @LogTrace
    @RequestMapping(value = "greeting", method = RequestMethod.GET)
    public String greeting(@RequestParam String message, Model model) {

        model.addAttribute("message", message);
        return "greeting";

    }

    @LogTrace
    @RequestMapping(value = "exception", method = RequestMethod.GET)
    public String exception() throws DuplicateNoteException {
        DuplicateNoteException exception = new DuplicateNoteException();
        exception.setMessage("重复错误！");
        throw exception;
    }

}
