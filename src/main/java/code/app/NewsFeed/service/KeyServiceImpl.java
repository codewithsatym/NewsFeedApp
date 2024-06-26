package code.app.NewsFeed.service;

import code.app.NewsFeed.repository.KeyRepository;
import code.app.NewsFeed.modal.KeysModal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;

@Service
public class KeyServiceImpl implements KeyService {
    @Autowired
    private KeyRepository keyRepository;

    @Override
    @Transactional
    public Long saveKey(String key) {
        KeysModal keysModal = new KeysModal();
        keysModal.setKey(key);
        keysModal.setCreatedDate(ZonedDateTime.now());
        keyRepository.saveAndFlush(keysModal);
        return keysModal.getId();
    }
}
