package coding_platform.repository;

import coding_platform.model.PanicEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PanicEventRepository
        extends JpaRepository<PanicEvent, Long> {

    List<PanicEvent> findByProblemId(Long problemId);

    @Transactional
    void deleteByProblemId(Long problemId);
}