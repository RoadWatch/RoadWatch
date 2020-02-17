package com.codeup.demo.services;

import com.codeup.demo.Repos.Categories;
import com.codeup.demo.Repos.Reports;
import com.codeup.demo.Repos.Users;
import com.codeup.demo.models.Category;
import com.codeup.demo.models.Report;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReportSvc {
    private Users usersDao;
    private Reports reportsDao;
    private Categories categoriesDao;

    @Value("${file-upload-path}")
    private String uploadPath;

    public ReportSvc(Users usersDao, Reports reportsDao, Categories categoriesDao) {
        this.usersDao = usersDao;
        this.reportsDao = reportsDao;
        this.categoriesDao = categoriesDao;
    }

    public boolean saveFile(
            MultipartFile uploadedFile,
            Report report
    ){
        boolean successfulUpload = true;
        String filename = uploadedFile.getOriginalFilename();
        String filepath = Paths.get(uploadPath, filename).toString();
        File destinationFile = new File(filepath);
        System.out.println("FILE NAME: "+ filename);
        System.out.println("FILE PATH: "+ filepath);
        System.out.println("destination path: "+ destinationFile);
        try {
            uploadedFile.transferTo(destinationFile);
            String pathWithImage = "images/"+filename;
            System.out.println("SAVING PATH: "+pathWithImage);
            //! FOR DEV
            report.setFilePath(pathWithImage);

            //! FOR PRODUCTION
//            report.setFilePath(filepath);

        } catch(IOException ex) {
            System.out.printf("ERROR: %s\n", ex);
            System.out.println("File NOT uploaded");
            successfulUpload = false;
        }
        return successfulUpload;
    }

    public String makeCategoriesOneLongString(List<Category> categoryList){
        StringBuilder categoryString = new StringBuilder();
        for (Category category : categoryList) {
            categoryString.append(category.getName());
        }
        return categoryString.toString();
    }

    public List<Report> getQueriedList(String query){
        List<Report> qList = new ArrayList<>();

        return qList;
    }



}
