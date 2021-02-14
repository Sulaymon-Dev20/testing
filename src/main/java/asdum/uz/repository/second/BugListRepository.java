package asdum.uz.repository.second;

import asdum.uz.entity.secoud.BugList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BugListRepository extends JpaRepository<BugList, Long> {
}
