package code.app.NewsFeed.repository;

import code.app.NewsFeed.modal.KeysModal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KeyRepository extends JpaRepository<KeysModal,Long> {

    Optional<KeysModal> findById(Long keyId);
}
