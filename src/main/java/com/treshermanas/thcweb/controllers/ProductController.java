package com.treshermanas.thcweb.controllers;

import com.treshermanas.thcweb.backingbeans.SearchProductDetailsFilter;
import com.treshermanas.thcweb.beans.products.ProductDetail;
import com.treshermanas.thcweb.beans.thirdperson.Supplier;
import com.treshermanas.thcweb.services.dto.PageDto;
import com.treshermanas.thcweb.services.dto.Resource;
import com.treshermanas.thcweb.services.products.ProductService;
import com.treshermanas.thcweb.services.thirdparty.ThirdPartyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class ProductController {

    private final ThirdPartyService thirdPartyService;
    private final ProductService productService;

    public ProductController(ThirdPartyService thirdPartyService, ProductService productService) {
        this.thirdPartyService = thirdPartyService;
        this.productService = productService;
    }

    @RequestMapping(value = "/products/details/search/init",method = RequestMethod.GET)
    public String gotoSearchProductsDetail(Model model){

        SearchProductDetailsFilter filter = new SearchProductDetailsFilter();
        model.addAttribute("searchProductsFilter",filter);

        return "products/search";
    }

    @RequestMapping(value = "/products/details/search",method = RequestMethod.GET)
    public String searchProductsDetail(Model model, SearchProductDetailsFilter filter){

        PageDto<ProductDetail> productsPage = productService.searchProductsDetails(filter);
        List<Integer> pageNumbers = IntStream.rangeClosed(1, productsPage.getTotalPagesCount())
                .boxed()
                .collect(Collectors.toList());
        model.addAttribute("products", productsPage.getData());
        model.addAttribute("productsPage", productsPage);
        model.addAttribute("searchProductsFilter",filter);
        model.addAttribute("pageNumbers",pageNumbers);

        return "products/search";
    }

    @RequestMapping(value = "/products/details/barcodes/report", method = RequestMethod.GET, produces="application/pdf")
    @ResponseBody
    public byte[] barcodesReport(SearchProductDetailsFilter filter) {

        Resource recurso =  productService.getBarcodesReport(filter);
        return Base64.getDecoder().decode(recurso.getData());
    }

    @ModelAttribute("suppliers")
    public List<Supplier> populateSuppliers() {
        return thirdPartyService.getAllSuppliers();
    }

}
