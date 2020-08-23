package org.example.spring.marker.web.controller;

import org.example.spring.marker.domain.Person;
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
@RequestMapping("person")
public class PersonController {
    @PostMapping(SpringMarkerUri.CREATE)
    public String create(@Valid Person person) {
        //todo create
        return "redirect:home";

    }

    @PostMapping(SpringMarkerUri.UPDATE)
    public String update(@Valid Person person){
        //todo update
        return "redirect:home";
    }

    @PostMapping(SpringMarkerUri.SEARCH)
    public String search(@Valid Person person) {
        //todo search
        return "redirect:person/search-result";
    }

    @PostMapping(SpringMarkerUri.DELETE)
    public String delete(@Valid Person person) {
        //todo delete
        return "redirect:home";
    }
}
