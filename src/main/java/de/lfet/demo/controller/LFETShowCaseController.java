package de.lfet.demo.controller;

import de.lfet.demo.application.LFETShowCaseUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class LFETShowCaseController {

    final LFETShowCaseUseCase lfetDemoUseCase;

    @GetMapping
    public String get(Model model) {
        model.addAttribute("input", new LFETShowCaseFormData());
        return "index";
    }

    @ModelAttribute("tarife")
    public List<String> getTarife() {
        return Arrays.asList("ZE", "ZB", "Sonst");
    }

    @PostMapping
    public String post(@Valid @ModelAttribute("input") LFETShowCaseFormData input, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            LFETShowCaseUseCase.LFETDemoUseCaseResultModel useCaseResultModel = lfetDemoUseCase.execute(new LFETShowCaseUseCase.LFETDemoUseCaseCommand(input.getAlter(), input.getTarif()));
            model.addAttribute("input", input);
            model.addAttribute("result", useCaseResultModel);
        }
        return "index";
    }

}
