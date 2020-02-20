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
import java.util.Arrays;
import java.util.Date;
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

    public boolean checkDate(String date){
        String[] dateSplit = new Date().toString().split(" ");
        String formatedDate = String.format("%s %s %s %s",
                dateSplit[0], dateSplit[1], dateSplit[2], dateSplit[dateSplit.length-1]);
        String[] comparrisonDateArray = formatedDate.split(" ");
        String[] reportDateArray = date.split(" ");
        List<String> months = getMonthsArray();
        List<String> days = getDateArray();
        String year = "2020";

        if(!reportDateArray[reportDateArray.length-1].equals(year))
            return false;
        if(months.indexOf(comparrisonDateArray[1]) != months.indexOf(reportDateArray[1])) return false;

        int differenceInDays = (days.indexOf(reportDateArray[2]) - days.indexOf(comparrisonDateArray[2]));
        System.out.println(differenceInDays);

        if((differenceInDays*-1) > 3) return false;

        else return true;
    }


    private List<String> getMonthsArray(){
        return new ArrayList<>(){{
            add("Jan");
            add("Feb");
            add("Mar");
            add("Apr");
            add("May");
            add("Jun");
            add("Jul");
            add("Aug");
            add("Sep");
            add("Oct");
            add("Nov");
            add("Dec");
        }};
    }

    private List<String> getDateArray(){
        return new ArrayList<String>(){{
            add("1");
            add("2");
            add("3");
            add("4");
            add("5");
            add("6");
            add("7");
            add("8");
            add("9");
            add("10");
            add("11");
            add("12");
            add("13");
            add("14");
            add("15");
            add("16");
            add("17");
            add("18");
            add("19");
            add("20");
            add("21");
            add("22");
            add("23");
            add("24");
            add("25");
            add("26");
            add("27");
            add("28");
            add("29");
            add("30");
        }};
    }



}
