package com.treshermanas.thcweb.beans.trello;

import java.util.Date;

public class Card {

    public enum CardPosition {
        TOP, BOTTOM
    }

    private String id;
    private String name;
    private String desc;
    private CardPosition pos;
    private Date due;
    private Boolean dueComplete;
    private String idList;

    private Card() {

    }

    public Card(String id, String name) {
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public CardPosition getPos() {
        return pos;
    }

    public void setPos(CardPosition pos) {
        this.pos = pos;
    }

    public Date getDue() {
        return due;
    }

    public void setDue(Date due) {
        this.due = due;
    }

    public Boolean getDueComplete() {
        return dueComplete;
    }

    public void setDueComplete(Boolean dueComplete) {
        this.dueComplete = dueComplete;
    }

    public String getIdList() {
        return idList;
    }

    public void setIdList(String idList) {
        this.idList = idList;
    }

    public static final class Builder {

        private String id;
        private String name;
        private String desc;
        private CardPosition pos;
        private Date due;
        private Boolean dueComplete;
        private String idList;

        private Builder(String name, String desc) {
            this.name = name;
            this.desc = desc;

        }

        public static Builder getBuilder(String name, String desc) {
            return new Builder(name, desc);
        }

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withPos(CardPosition pos) {
            this.pos = pos;
            return this;
        }

        public Builder withDue(Date due) {
            this.due = due;
            return this;
        }

        public Builder withDueComplete(Boolean dueComplete) {
            this.dueComplete = dueComplete;
            return this;
        }

        public Builder withIdList(String listId) {
            this.idList = listId;
            return this;
        }

        public Card build() {

            Card card = new Card(id, name);

            card.setId(id);
            card.setPos(pos);
            card.setDesc(desc);
            card.setDue(due);
            card.setDueComplete(dueComplete);
            card.setIdList(idList);
            return card;
        }
    }
}
