package com.treshermanas.thcweb.services.trello;

import com.treshermanas.thcweb.beans.trello.BoardList;
import com.treshermanas.thcweb.beans.trello.Card;
import com.treshermanas.thcweb.exception.ThcServiceException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TrelloBridgeServiceImpl implements TrelloBridgeService {

    @Value("${trello.base.url}")
    private String TRELLO_BASE_URL;

    @Value("${trello.apikey}")
    private String trelloApiKey;

    @Value("${trello.apioauth}")
    private String trellopApiOauth;

    private final RestTemplate restTemplate;

    public TrelloBridgeServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<BoardList> getTrelloBoardsLists(String boardId) throws ThcServiceException {

        Map<String, String> params = createParametersMap();
        String url = String.format(TRELLO_BASE_URL + GET_BOARDS_LIST_PATH, boardId);

        BoardList[] boardLists = restTemplate.getForObject(url, BoardList[].class, params);

        return Arrays.asList(boardLists);
    }

    @Override
    public Card addCardToBoard(String idList, Card card) throws ThcServiceException {

        if (card.getIdList() == null)
            card.setIdList(idList);
        else if (!card.getIdList().equals(idList))
            throw new ThcServiceException("La tarjeta ya tiene un idList que no coincide con el enviado como parámetro");

        Map<String, String> params = createParametersMap();
        params.put("idList", idList);
        String url = String.format(TRELLO_BASE_URL + POST_CARD_PATH);
        restTemplate.postForObject(url, null, Card.class, params);
        return null;
    }

    private Map<String, String> createParametersMap() {

        Map<String, String> params = new HashMap<>();
        params.put("apiKey", trelloApiKey);
        params.put("authToken", trellopApiOauth);

        return params;
    }
}
