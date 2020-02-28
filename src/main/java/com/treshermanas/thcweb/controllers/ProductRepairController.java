package com.treshermanas.thcweb.controllers;

import com.treshermanas.thcweb.beans.trello.BoardList;
import com.treshermanas.thcweb.services.trello.TrelloBridgeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ProductRepairController {

    @Value("${trello.repairBoard.id}")
    private String trelloRepairBoardId;

    private final TrelloBridgeService trelloBridgeService;

    public ProductRepairController(TrelloBridgeService trelloBridgeService) {
        this.trelloBridgeService = trelloBridgeService;
    }

    @RequestMapping(value = "/reparacion/tablero", method = RequestMethod.GET)
    public String gotoRepairSummary(Model model) {

        List<BoardList> boardLists = trelloBridgeService.getTrelloBoardsLists(trelloRepairBoardId);
        model.addAttribute("boardLists", boardLists);

        return "/products/reparacion";
    }

}
