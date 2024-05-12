package code.app.NewsFeed.repository;

import code.app.NewsFeed.modal.KeysModal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeyRepository extends JpaRepository<KeysModal,Long> {

    KeysModal findByKey(String key);

    String findKeyByIf(Long keyId);
}
