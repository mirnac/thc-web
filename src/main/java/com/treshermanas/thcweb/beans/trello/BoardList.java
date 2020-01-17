package com.treshermanas.thcweb.beans.trello;

import java.util.List;

public class BoardList {

    private String id;
    private String name;
    private Boolean closed;
    private String idBoard;
    private Float pos;
    private Boolean subscribed;
    private Integer softLimit;
    private List<Card> cards;

    private BoardList() {

    }

    public BoardList(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public String getIdBoard() {
        return idBoard;
    }

    public void setIdBoard(String idBoard) {
        this.idBoard = idBoard;
    }

    public Float getPos() {
        return pos;
    }

    public void setPos(Float pos) {
        this.pos = pos;
    }

    public Boolean getSubscribed() {
        return subscribed;
    }

    public void setSubscribed(Boolean subscribed) {
        this.subscribed = subscribed;
    }

    public Integer getSoftLimit() {
        return softLimit;
    }

    public void setSoftLimit(Integer softLimit) {
        this.softLimit = softLimit;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
