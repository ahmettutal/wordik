package com.tutal.wordik.service;

import com.tutal.wordik.model.PictureModel;
import com.tutal.wordik.repo.PictureRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Objects;

import static com.tutal.wordik.util.Constants.DOMAIN;

@Service
public class PictureService {

    private PictureRepository repository;

    public PictureService(PictureRepository repository) {
        this.repository = repository;
    }

    public PictureModel saveImages(HttpServletRequest request, Long id, String uploadDir, MultipartFile[] images) {

        for (MultipartFile image : images) {

            if (image.isEmpty()) continue;

            try {

                String fileName = StringUtils.cleanPath(image.getOriginalFilename());

                String uploadFolder = getUploadFolder(request, uploadDir, id);

                if (Objects.isNull(id)) {
                    return null;
                }

                String filePath = uploadFolder + File.separator + fileName;
                File dest = new File(filePath);
                image.transferTo(dest);

                PictureModel picture = new PictureModel();
                picture.setName(fileName);

                return repository.save(picture);

            } catch (Exception e) {
                System.out.printf("saveImages e:" + e.getMessage(), e);
            }
        }

        return null;
    }

    private String getUploadFolder(HttpServletRequest request, String uploadDirWordik, Long id) {

        String uploadFoler;

        uploadFoler = request.getServletContext().getRealPath(uploadDirWordik);

        if (!new File(uploadFoler).exists()) {
            new File(uploadFoler).mkdir();
        }

        uploadFoler += File.separator + id;

        if (!new File(uploadFoler).exists()) {
            new File(uploadFoler).mkdir();
        }

        return uploadFoler;
    }

    public void deletePic(HttpServletRequest request, Long id, PictureModel picture, String uploadDir) {
        try {
            if (picture == null) return;

            repository.delete(picture);

            String uploadFolder = request.getServletContext().getRealPath(uploadDir);

            String fileName = uploadFolder + File.separator + id + File.separator + picture.getName();

            File file = new File(fileName);
            file.delete();

        } catch (Exception e) {
            System.out.printf("deletePic e:" + e.getMessage(), e);
        }
    }

    public String getImageSrc(Long id, PictureModel picture, String uploadDir) {

        if (picture == null) return "";

        return DOMAIN + uploadDir + id + File.separator + picture.getName();
    }

}
