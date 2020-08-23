package org.example.spring.marker.web.controller;

import org.example.spring.marker.domain.Note;
import org.example.spring.marker.web.constant.SpringMarkerUri;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * Created by lishubin on 2020/8/22 10:26 下午
 * @author lishubin
 */
@Controller
@RequestMapping("note")
public class NoteController {


    @PostMapping(SpringMarkerUri.CREATE)
    public String create(@Valid Note note) {
        //todo create
        return "redirect:home";

    }

    @PostMapping(SpringMarkerUri.UPDATE)
    public String update(@Valid Note note){
        //todo update
        return "redirect:home";
    }

    @PostMapping(SpringMarkerUri.SEARCH)
    public String search(@Valid Note note) {
        //todo search
        return "redirect:note/search-result";
    }

    @PostMapping(SpringMarkerUri.DELETE)
    public String delete(@Valid Note note) {
        //todo delete
        return "redirect:home";
    }

}
