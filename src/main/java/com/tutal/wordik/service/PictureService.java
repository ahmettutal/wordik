package com.tutal.wordik.service;

import com.tutal.wordik.model.AuditModel;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Objects;

@Service
public class PictureService {

    public <T extends AuditModel> String saveImages(HttpServletRequest request, T model, MultipartFile[] images, String uploadDir) {

        for (MultipartFile image : images) {

            if (image.isEmpty() || Objects.isNull(model)) continue;

            try {
                String fileName = StringUtils.cleanPath(image.getOriginalFilename());

                String realPathToUploads = request.getServletContext().getRealPath(uploadDir);
                if (!new File(realPathToUploads).exists()) {
                    new File(realPathToUploads).mkdir();
                }

                realPathToUploads += model.getId();

                if (!new File(realPathToUploads).exists()) {
                    new File(realPathToUploads).mkdir();
                }

                String filePath = realPathToUploads + File.separator + fileName;
                File dest = new File(filePath);
                image.transferTo(dest);

                return filePath;

            } catch (Exception e) {
                System.out.printf("saveImages e:" + e.getMessage(), e);
            }
        }

        return "";
    }

    public void delete(String fileName) {
        try {
            new File(fileName).delete();
        } catch (Exception e) {
            System.out.printf("deletePic e:" + e.getMessage(), e);
        }
    }

}
