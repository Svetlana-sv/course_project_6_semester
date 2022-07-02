package db.service;

import db.UserParameters;
import db.repo.UserRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Transactional
    public void editCard(UserParameters userParameters) {
//        UserParameters userParameters = cardRepository.findById(card.getId()).orElseThrow(() -> new NotFoundException("No such card"));
//
//        cardToEdit.setPillar(card.getPillar());
//        cardToEdit.setDescription(card.getDescription());
//        cardToEdit.setShortDescription(card.getShortDescription());
//        cardToEdit.setTitle(card.getTitle());
//
//        cardRepository.save(cardToEdit);
    }
}
