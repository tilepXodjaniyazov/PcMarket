package com.example.pcmarket.Controller;

import com.example.pcmarket.Result;
import com.example.pcmarket.Model.Attachment;
import com.example.pcmarket.Service.AttachmentService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/attachment")
public class AttachmentController {
    @Autowired
    AttachmentService attachmentService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(MultipartHttpServletRequest request) throws IOException {
        Result result = attachmentService.uploadFile(request);
        return ResponseEntity.status(result.getSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(result);
    }

    @GetMapping("/{id}")
    public void downlodeFile(@PathVariable Integer id, HttpServletResponse response) throws IOException {
        attachmentService.downladeFile(id, response);
    }

    @GetMapping("/info")
    public ResponseEntity<?> info(HttpServletResponse response) {
        List<Attachment> info = attachmentService.getInfo(response);
        return ResponseEntity.status(info!=null? HttpStatusCode.valueOf(200) :HttpStatus.NO_CONTENT).body(info);
    }

}
