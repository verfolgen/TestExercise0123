package org.sbitnev.part2.controller;

import lombok.RequiredArgsConstructor;
import org.sbitnev.part2.service.ArraySubstringerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class WebController {
    private final ArraySubstringerService arraySubstringerService;

    @GetMapping("/start")
    public String start(Model model) {
        return "start";
    }

    @PostMapping("/calculate_one")
    public String calculateOne(@RequestParam String initialArray, @RequestParam String array, Model model) {
        String [] resultArray = arraySubstringerService.arraySubstringerCalculate(initialArray, array);
        model.addAttribute("resultArray", resultArray);
        return "start";
    }

    @PostMapping("/save_one")
    public String saveOne(@RequestParam String initialArray, @RequestParam String array, Model model) {
        arraySubstringerService.saveOneTask(initialArray, array);
        return "start";
    }

    @PostMapping("/calculate_three")
    public String CalculateThree() {
        return "start";
    }

}
