package app.flashcard.application;

import app.flashcard.domain.Card;
import app.flashcard.domain.CardRepository;
import app.flashcard.domain.Tag;
import app.flashcard.domain.TagRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
public class SettingsApplication {

    private final CardRepository cardRepository;

    private final TagRepository tagRepository;

    public SettingsApplication(CardRepository cardRepository,
                               TagRepository tagRepository) {
        this.cardRepository = cardRepository;
        this.tagRepository = tagRepository;
    }

    public Page<Card> findCards(Pageable page) {
        return cardRepository.findAll(page);
    }

    public Optional<Card> findCard(long id) {
        return cardRepository.findById(id);
    }

    @Transactional
    public Card save(Card card) {
        return cardRepository.save(card);
    }

    public Page<Tag> findTags(Pageable page) {
        return tagRepository.findAll(page);
    }

    public Optional<Tag> findTag(long id) {
        return tagRepository.findById(id);
    }

    @Transactional
    public Tag save(Tag tag) {
        return tagRepository.save(tag);
    }
}
