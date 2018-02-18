package app.flashcard.presentation;

import app.flashcard.application.SettingsApplication;
import app.flashcard.domain.Card;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/settings")
public class SettingsController {

    private final SettingsApplication application;

    public SettingsController(SettingsApplication application) {
        this.application = application;
    }

    @GetMapping("/cards")
    public String index(@RequestParam(defaultValue = "0") Integer page,
                        @RequestParam(defaultValue = "20") Integer size,
                        Model model) {
        Page<Card> cards = application.findCards(PageRequest.of(page, size));
        model.addAttribute("cards", cards);
        return "index";
    }
}
