package attachedfile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import attachedfile.model.AttachedFile;

@Repository
public interface AttachedFileRepository extends JpaRepository<AttachedFile, Long>{

}
