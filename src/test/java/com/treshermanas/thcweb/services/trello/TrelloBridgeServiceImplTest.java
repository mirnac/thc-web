package com.treshermanas.thcweb.services.trello;

import com.treshermanas.thcweb.beans.trello.BoardList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TrelloBridgeServiceImplTest {

    @Value("${trello.repairBoard.id}")
    private String repairBoardId;

    @Autowired
    private TrelloBridgeService trelloBridgeService;

    void getTrelloBoardsLists() {

        List<BoardList> boardLists = trelloBridgeService.getTrelloBoardsLists(repairBoardId);
        assertNotNull(boardLists);
        assertTrue(boardLists.size() > 0);
    }
}