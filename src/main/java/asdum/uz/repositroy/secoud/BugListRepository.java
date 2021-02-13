package asdum.uz.repositroy.secoud;

import asdum.uz.entity.secoud.BugList;
import asdum.uz.entity.secoud.Stol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BugListRepository extends JpaRepository<BugList, Long> {
}
