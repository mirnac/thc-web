package com.treshermanas.thcweb.services.trello;


import com.treshermanas.thcweb.beans.trello.BoardList;
import com.treshermanas.thcweb.beans.trello.Card;
import com.treshermanas.thcweb.exception.ThcServiceException;

import java.util.List;

public interface TrelloBridgeService {

    String GET_BOARDS_LIST_PATH = "/boards/%s/lists?cards=open&card_fields=name&filter=open&key={apiKey}&token={authToken}";
    String POST_CARD_PATH = "/cards?idList={idList}&keepFromSource=all&key={apiKey}&token={authToken}";

    List<BoardList> getTrelloBoardsLists(String boardId) throws ThcServiceException;

    Card addCardToBoard(String idList, Card card) throws ThcServiceException;
}
