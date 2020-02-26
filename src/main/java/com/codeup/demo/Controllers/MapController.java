package com.codeup.demo.Controllers;

import com.codeup.demo.Repos.Categories;
import com.codeup.demo.Repos.Endorsements;
import com.codeup.demo.Repos.Reports;
import com.codeup.demo.models.Category;
import com.codeup.demo.models.Endorsement;
import com.codeup.demo.models.Report;
import com.codeup.demo.models.User;
import com.codeup.demo.services.EnviromentSvc;
import com.codeup.demo.services.GeocodeSvc;
import com.codeup.demo.services.ReportSvc;
import com.codeup.demo.services.UserSvc;
import com.fasterxml.jackson.annotation.JsonBackReference;
import okhttp3.MultipartBody;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Controller
public class MapController {
    private EnviromentSvc enviromentSvc;
    private Reports reportsDao;
    private ReportSvc reportSvc;
    private GeocodeSvc geocodeSvc;
    private UserSvc userSvc;
    private Categories categoriesDao;
    private Endorsements endorsementsDoa;

    private List<Report> queriedList = new ArrayList<>();

    public MapController(EnviromentSvc enviromentSvc, Reports reportsDao, GeocodeSvc geocodeSvc, UserSvc userSvc, Categories categoriesDao, ReportSvc reportSvc, Endorsements endorsementsDoa) {
        this.enviromentSvc = enviromentSvc;
        this.reportsDao = reportsDao;
        this.geocodeSvc = geocodeSvc;
        this.userSvc = userSvc;
        this.categoriesDao = categoriesDao;
        this.reportSvc = reportSvc;
        this.endorsementsDoa = endorsementsDoa;
    }

    //! DO NOT REMOVE!!! We need this for the user-submitted reports to show on the map!
    @GetMapping("/map/json")
    public @ResponseBody List<Report> mapJSON(){
        List<Report> all = reportsDao.findAll();
        List<Report> temp = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            if(reportSvc.checkDate(all.get(i).getDateEntered()) && all.get(i).getRating() > -3){
                all.get(i).makeJsonCats();
                temp.add(all.get(i));
            }
        }


//        List<Report> temp = reportsDao.findAll();
//        for (Report rep : temp) {
//            rep.makeJsonCats();
//        }
        return temp;
    }


    //! GET
    @GetMapping("/map")
    public String showMapPage(Model model){

        List<Category> categories = categoriesDao.findAll();
        List<Report> reports = reportsDao.findAll();


        model.addAttribute("categories", categories);
        List<Report> activeReports = new ArrayList<>();
        for (Report report : reports) {
            if(reportSvc.checkDate(report.getDateEntered()) && report.getRating() > -3){
                activeReports.add(report);
            }
        }

        model.addAttribute("queriedList", queriedList);
        System.out.println("queridLIST: "+queriedList.size());
        model.addAttribute("reports", activeReports);

        return "map/index";
    }



    @PostMapping("/report/add")
    public String addReport(
            @RequestParam String query,
            @RequestParam int waterLevel,
            @RequestParam String description,
            @RequestParam String[] primitiveCategories,
            @RequestParam(name = "file") MultipartFile uploadedFile
    ){

        if(userSvc.isUserLoggedIn()){
            User user = userSvc.getAuthUser();
            Report report = new Report(waterLevel, description);

            //add categories to report
            List<Category> categories = categoriesDao.findAll();
            List<String> primitive = Arrays.asList(primitiveCategories);
            List<Category> join = new ArrayList<>();
            for (int i = 0; i < categories.size(); i++) {
                String catName = categories.get(i).getName();
                if(primitive.contains(catName)){
                    join.add(categories.get(i));
                }
            }


            report.setCategories(join);
            report.setUser(user);

            //!test
            report.setQuery(query);
            System.out.println("filepath: "+ report.getFilePath());
            //! FILE FUNCTION
            if (report.getFilePath() == null) {
                System.out.println("UPLOADED FILE: " + uploadedFile);
                reportSvc.saveFile(uploadedFile, report);
            }

            reportsDao.save(report);
            return "redirect:/map";
        }
        return "redirect:/map";

    }

    //! CARDS SEARCH CONTROLLER
    @PostMapping("/report/search/{searchQuery}")
    public String searchCards(
            @PathVariable String searchQuery,
            Model model
    ){
        this.queriedList.clear();
        searchQuery = searchQuery.toLowerCase();
        System.out.println("quer: "+searchQuery);
        List<Report> reports = reportsDao.findAll();
        List<Report> queried = new ArrayList<>();
        for (Report report : reports) {
            String categoryString = reportSvc.makeCategoriesOneLongString(report.getCategories()).toLowerCase();
            String description = report.getDescription().toLowerCase();
            String query = report.getQuery().toLowerCase();

            if(
                    description.matches("(.*)"+searchQuery+"(.*)") ||
                            query.matches("(.*)"+searchQuery+"(.*)") ||
                            categoryString.matches("(.*)"+searchQuery+"(.*)")
            )
            {
                this.queriedList.add(report);
                queried.add(report);
            }
        }


        return "redirect:/map?search=true";
    }


    @GetMapping("/test")
    @ResponseBody
    public String testing(){
        Report report = new Report();
        report.setWaterInches(0);
        report.setDescription("test desc");
        report.setZipcode(12345);
        report.setLatitude("lat");
        report.setLongitude("long");
        report.setCategories(categoriesDao.findAll());

        User user = userSvc.getAuthUser();
        report.setUser(user);
        reportsDao.save(report);
        return "test";

    }
}

