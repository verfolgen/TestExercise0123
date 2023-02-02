package org.sbitnev.part2.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sbitnev.part2.entity.OneTask;
import org.sbitnev.part2.entity.ThirdTask;
import org.sbitnev.part2.service.ArraySubstringerService;
import org.sbitnev.part2.service.MagicSquareService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class WebController {
    private final ArraySubstringerService arraySubstringerService;
    private final MagicSquareService magicSquareService;

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

    @GetMapping("export_one")
    public String exportOne(HttpServletResponse servletResponse) throws IOException {
        servletResponse.setContentType("/application/csv");
        servletResponse.addHeader("Content-Disposition","attachment; filename=\"onetasks.csv\"");
        arraySubstringerService.exportOne(servletResponse.getWriter());
        return "start";
    }

    @GetMapping("/download_one")
    public String downloadOne(Model model) {
        List<OneTask> tasks = arraySubstringerService.downloadOne();
        model.addAttribute("tasks", tasks);
        return "list_one";
    }

    @PostMapping("/calculate_three")
    public String CalculateThree(@RequestParam String one, @RequestParam String two, @RequestParam String three,
                                 @RequestParam String four, @RequestParam String five, @RequestParam String six,
                                 @RequestParam String seven, @RequestParam String eight, @RequestParam String nine,
                                 Model model) {

        String [] result = magicSquareService.calculateMagicSquare(one, two, three, four, five, six, seven, eight, nine);
        String cost = result[0];
        String magic = result[1];
        String initialArray = result[2];
        ThirdTask thirdTask = new ThirdTask(
                initialArray, magic, Integer.parseInt(cost), 2
        );
        String [] magicArray = magic.split(", ");

        model.addAttribute("thirdTasks", thirdTask);
        model.addAttribute("magicArrays", magicArray);

        return "start";
    }

    @PostMapping("/save_three")
    public String saveThird(@RequestParam String one, @RequestParam String two, @RequestParam String three,
                            @RequestParam String four, @RequestParam String five, @RequestParam String six,
                            @RequestParam String seven, @RequestParam String eight, @RequestParam String nine) {
        magicSquareService.saveThirdTask(one, two, three, four, five, six, seven, eight, nine);
        return "start";
    }

    @GetMapping("/download_three")
    public String downloadThree(Model model) {
        List<ThirdTask> tasks = magicSquareService.downloadThird();
        model.addAttribute("tasksThird", tasks);
        return "list_three";
    }

    @GetMapping("export_three")
    public String exportThree(HttpServletResponse servletResponse) throws IOException {
        servletResponse.setContentType("/application/csv");
        servletResponse.addHeader("Content-Disposition","attachment; filename=\"threetasks.csv\"");
        magicSquareService.exportThree(servletResponse.getWriter());
        return "start";
    }

}
