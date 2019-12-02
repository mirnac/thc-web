package com.treshermanas.thcweb.controllers;

import com.treshermanas.thcweb.backingbeans.StockVerification;
import com.treshermanas.thcweb.beans.products.VerificationStatus;
import com.treshermanas.thcweb.beans.products.Warehouse;
import com.treshermanas.thcweb.exception.DataNotFoundException;
import com.treshermanas.thcweb.model.StockVerificationModel;
import com.treshermanas.thcweb.services.stock.StockVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Controller
public class StockVerificationController {

    @Autowired
    private StockVerificationService stockVerificationService;

    @RequestMapping(path = {"","/", "index", "index.html", "stock_verification.html", "/stock/stock_verification", "/stock/stock_verification.html"},
    method = RequestMethod.GET)
    public String showStockVerificationPage(Model model, @RequestParam(required = false) String product){

        try{

            StockVerification formBean = new StockVerification();
            formBean.setStartDate(Calendar.getInstance().getTime());
            formBean.setUserName(getUserName());
            model.addAttribute("stockVerification",formBean);

            //TODO: Hacer la consulta de depósitos por entidad y utilizar el primero en este punto.
            formBean.setPendingVerificationCount(stockVerificationService.getPendingVerificationCount(1));
            formBean.setItems(stockVerificationService.pendingVerificationProducts(1,product));

        }catch (DataNotFoundException e){
            e.printStackTrace();
            model.addAttribute("errorMessage", "No se encontraron datos. "+ e.getLocalizedMessage());
        }

        return "stock/stock_verification.html";
    }

    private String getUserName(){

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails)
           return ((UserDetails)principal).getUsername();
         else
            return principal.toString();

    }
    @RequestMapping(value = "/stock/start_verification", method = RequestMethod.POST)
    public String startVerification(@ModelAttribute StockVerification stockVerification, Model model){

        try{
            StockVerificationModel svModel =  stockVerificationService.startVerification(stockVerification.getWarehouse(),
                    stockVerification.getUserName(),
                    stockVerification.getProduct());
            stockVerification.setUuid(svModel.getUuid());
            stockVerification.setStatus(VerificationStatus.STARTED);
            stockVerification.setItems(svModel.getItems());

        }catch (DataNotFoundException e){

            model.addAttribute("errorMessage", "No se encontraron datos. "+ e.getLocalizedMessage());
        }
        return "stock/stock_verification.html";
    }

    @RequestMapping(value = "/stock/cancel_verification", method = RequestMethod.POST)
    public RedirectView cancelVerification(@ModelAttribute StockVerification stockVerification, Model model){

        stockVerificationService.cancelVerification(stockVerification.getUuid());
        model.addAttribute("stockVerification",new StockVerification());

        return new RedirectView("/stock/stock_verification");
    }
    @RequestMapping(value = "/stock/save_verification", method = RequestMethod.POST)
    public String saveVerification(@ModelAttribute StockVerification stockVerification, Model model){

        stockVerificationService.saveVerification(stockVerification.getUuid(), stockVerification.getItems());
        stockVerification.setStatus(VerificationStatus.SAVED);
        return "stock/stock_verification.html";
    }

    @ModelAttribute("warehousesList")
    public List<Warehouse> populateWarehouses(){
        List<Warehouse> list = new ArrayList<>();
        list.add(new Warehouse(1,"DepositoProductos"));
        return  list;
    }
}
