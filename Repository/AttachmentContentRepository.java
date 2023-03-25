package com.example.pcmarket.Repository;


import com.example.pcmarket.Model.AttachmentContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentContentRepository extends JpaRepository<AttachmentContent,Integer> {

    AttachmentContent findAttachmentContentByAttachmentId(Integer id);
}
