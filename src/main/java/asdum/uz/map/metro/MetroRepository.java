/*
package asdum.uz.map.metro;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MetroRepository extends JpaRepository<MetroStop, Integer> {
    @Query(value = "select * from metro_stop where route=:route", nativeQuery = true)
    List<MetroStop> findAllByRoute(@Value("route") String route);

    @Query(value = "select * from metro_stop where route=:route order by id desc", nativeQuery = true)
    List<MetroStop> findAllByRoute2(@Value("route") String route);

    @Query(value = "select * from metro_stop m where m.name=:name limit 1", nativeQuery = true)
    Optional<MetroStop> selectStations(@Value("name") String name);
}
*/
