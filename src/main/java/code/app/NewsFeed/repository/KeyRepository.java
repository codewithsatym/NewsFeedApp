package code.app.NewsFeed.repository;

import code.app.NewsFeed.modal.KeysModal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KeyRepository extends JpaRepository<KeysModal,Long> {

    String findKeyById(Long keyId);
}
