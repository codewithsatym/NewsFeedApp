package code.app.NewsFeed.service;

import code.app.NewsFeed.repository.KeyRepository;
import code.app.NewsFeed.modal.KeysModal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeyServiceImpl implements KeyService {
    @Autowired
    private KeyRepository keyRepository;

    @Override
    public Long saveKey(String key) {
        KeysModal keysModal = new KeysModal();
        keysModal.setKey(key);
        keyRepository.saveAndFlush(keysModal);
       return keysModal.getId();
    }
}
