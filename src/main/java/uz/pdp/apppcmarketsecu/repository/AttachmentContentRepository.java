package uz.pdp.apppcmarketsecu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.apppcmarketsecu.entity.AttachmentContent;

import java.util.Optional;

public interface AttachmentContentRepository extends JpaRepository<AttachmentContent,Integer> {

    Optional<AttachmentContent> findByAttachmentId(Integer id);


}
