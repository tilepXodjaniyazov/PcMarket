package com.example.pcmarket.Service;

import com.example.pcmarket.Model.Attachment;
import com.example.pcmarket.Model.AttachmentContent;
import com.example.pcmarket.Repository.AttachmentContentRepository;
import com.example.pcmarket.Repository.AttachmentRepository;
import com.example.pcmarket.Result;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class AttachmentService {
    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    AttachmentContentRepository attachmentContentRepository;

    @SneakyThrows
    public Result uploadFile(MultipartHttpServletRequest request) throws IOException {
        Iterator<String> fileNames = request.getFileNames();
        MultipartFile file = request.getFile(fileNames.next());
        String originalFilename = null;
        if (file != null) {
            originalFilename = file.getOriginalFilename();
            long size = file.getSize();
            String contentType = file.getContentType();
            Attachment saveAttachment = attachmentRepository.save(new Attachment(null, originalFilename, size, contentType));
            attachmentContentRepository.save(new AttachmentContent(null, file.getBytes(), saveAttachment));
            return new Result("attachment qoshildi", true, saveAttachment.getId());
        }
        return new Result("faile qoshilmadi!!", false);
    }


    public void downladeFile(Integer id, HttpServletResponse response) throws IOException {
        Optional<Attachment> byId = attachmentRepository.findById(id);
        if (byId.isPresent()) {
            Attachment attachment = byId.get();
            AttachmentContent attachmentContent = attachmentContentRepository.findAttachmentContentByAttachmentId(id);
            response.setHeader("Content-Disposition", "attachment; filename = \"" + attachment.getName() + "\"");
            response.setContentType(attachment.getContent_type());
            FileCopyUtils.copy(attachmentContent.getBytes(), response.getOutputStream());
        }
    }

    public List<Attachment> getInfo(HttpServletResponse response) {
        List<Attachment> all = attachmentRepository.findAll();
        return all;
    }

    public Attachment getFileById(Integer id) {
        if (attachmentContentRepository.existsById(id)) {
            Optional<Attachment> byId = attachmentRepository.findById(id);
            return byId.get();
        }
        return null;
    }
}
