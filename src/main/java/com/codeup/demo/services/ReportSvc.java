package com.codeup.demo.services;

import com.codeup.demo.Repos.Reports;
import com.codeup.demo.Repos.Users;
import com.codeup.demo.models.Report;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@Service
public class ReportSvc {
    private Users usersDao;
    private Reports reportsDao;

    @Value("${file-upload-path}")
    private String uploadPath;

    public ReportSvc(Users usersDao, Reports reportsDao) {
        this.usersDao = usersDao;
        this.reportsDao = reportsDao;
    }

    public void saveFile(
            MultipartFile uploadedFile,
            Report report
    ){
        if(uploadedFile != null)
            saveFileHelper(uploadedFile, report);
        else             report.setFilePath("https://www.asphaltplanet.ca/TX/I/410/I410_TX_cl_16_east_w_lg.jpg");
    }

    public void saveFileHelper(
            MultipartFile uploadedFile,
            Report report
    ){
        String filename = uploadedFile.getOriginalFilename();
        String filepath = Paths.get(uploadPath, filename).toString();
        File destinationFile = new File(filepath);

        try {
            uploadedFile.transferTo(destinationFile);
            report.setFilePath(destinationFile.toString());
            System.out.println("upload successful");

        } catch(IOException ex) {
            System.out.printf("ERROR: %s\n", ex);
            System.out.println("File NOT uploaded");
            System.out.println("upload fail");
        }
    }


}
