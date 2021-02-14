package asdum.uz.repository.third;

import asdum.uz.entity.third.BugList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BugListRepository extends JpaRepository<BugList, Long> {
}
