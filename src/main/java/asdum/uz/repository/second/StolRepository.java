package asdum.uz.repository.second;

import asdum.uz.entity.secoud.Stol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StolRepository extends JpaRepository<Stol, Long> {
}
