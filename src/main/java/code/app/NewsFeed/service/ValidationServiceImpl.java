package code.app.NewsFeed.service;

import code.app.NewsFeed.modal.KeysModal;
import code.app.NewsFeed.repository.KeyRepository;
import code.app.NewsFeed.utils.ValidationException;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ValidationServiceImpl implements ValidationService {
    @Autowired
    private KeyRepository keyRepository;

    @Override
    public void validateKey(String key)  {
        KeysModal keysModal = keyRepository.findByKey(key);
        if (ObjectUtils.isNotEmpty(keysModal)) {
            throw new ValidationException("Policy rules violation :  Key already exists");
        }
    }
}
